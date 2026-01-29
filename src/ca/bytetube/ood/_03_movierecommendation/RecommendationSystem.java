package ca.bytetube.ood._03_movierecommendation;

import java.util.Map;

public class RecommendationSystem {
    private RatingRegister ratingRegister;

    public RecommendationSystem(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }

    public String recommendMovie(User user) {
        if (ratingRegister.getUserMovies(user).isEmpty()) return recommendMovieNewUser();
        else return recommendMovieExistingUser(user);
    }

    private String recommendMovieNewUser() {
        Movie bestMovie = null;
        double bestRating = 0;
        for (Movie movie : ratingRegister.getMovies()) {
            double rating = ratingRegister.getAverageScore(movie);
            if (rating > bestRating) {
                bestRating = rating;
                bestMovie = movie;
            }
        }

        return bestMovie != null ? bestMovie.getTitle() : null;
    }


    private String recommendMovieExistingUser(User user) {
        Movie bestMovie = null;
        User bestReviewer = null;
        int similarityScore = Integer.MAX_VALUE;
        for (User reviewer : ratingRegister.getUsers()) {
            if (reviewer.getId() == user.getId()) continue;
            int similarity = getSimilarityScore(user, reviewer);
            if (similarity < similarityScore) {
                similarityScore = similarity;
                bestReviewer = reviewer;
            }
        }
        Movie movie = recommendUnWatchMovie(user, bestReviewer);
        bestMovie = movie != null ? movie : bestMovie;

        return bestMovie != null ? bestMovie.getTitle() : null;
    }


    private Movie recommendUnWatchMovie(User user, User bestReviewer) {
        Movie bestMovie = null;
        int bestRating = 0;
        for (Movie movie : ratingRegister.getUserMovies(bestReviewer)) {
            Map<Integer, MovieRating> ratings = ratingRegister.getMovieRatings(movie);
            //if user has not watched the movie,but bestReviewer gave it the highest score,recommend it to user
            if (!ratings.containsKey(user.getId()) && ratings.get(bestReviewer.getId()).ordinal() > bestRating) {
                bestMovie = movie;
                bestRating = ratings.get(bestReviewer.getId()).ordinal();
            }
        }

        return bestMovie;
    }

    private int getSimilarityScore(User user, User reviewer) {
        int score = Integer.MAX_VALUE;
        for (Movie movie : ratingRegister.getUserMovies(reviewer)) {
            Map<Integer, MovieRating> ratings = ratingRegister.getMovieRatings(movie);
            //if user also rated the movie, add the difference in ratings
            if (ratings.containsKey(user.getId())) {
                score = score == Integer.MAX_VALUE ? 0 : score;
                score += Math.abs(ratings.get(user.getId()).ordinal() - ratings.get(reviewer.getId()).ordinal());
            }
        }
        return score;
    }


}
