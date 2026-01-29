package ca.bytetube.ood._03_movierecommendation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingRegister {
    private List<User> users;
    private List<Movie> movies;
    private Map<Integer, List<Movie>> userMovies;
                //MovieId     UserId    ratingScore
    private Map<Integer, Map<Integer, MovieRating>> movieRatings;

    public RatingRegister() {
        users = new ArrayList<>();
        movies = new ArrayList<>();
        userMovies = new HashMap<>();
        movieRatings = new HashMap<>();
    }

    public List<Movie> getUserMovies(User user) {
        if (!userMovies.containsKey(user.getId())) return new ArrayList<>();
        return userMovies.get(user.getId());
    }

    public Map<Integer, MovieRating> getMovieRatings(Movie movie) {
        if (!movieRatings.containsKey(movie.getId())) return new HashMap<>();
        return movieRatings.get(movie.getId());
    }

    public void addRating(User user, Movie movie, MovieRating rating) {
        //movie not rated
        if (!movieRatings.containsKey(movie.getId())) {
            movieRatings.put(movie.getId(), new HashMap<>());
            movies.add(movie);
        }
        //new user
        if (!userMovies.containsKey(user.getId())) {
            userMovies.put(user.getId(), new ArrayList<>());
            users.add(user);
        }

        userMovies.get(user.getId()).add(movie);
        movieRatings.get(movie.getId()).put(user.getId(), rating);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public double getAverageScore(Movie movie) {
        //not rated movie
        if (!movieRatings.containsKey(movie.getId())) return MovieRating.NOT_RATED.ordinal();

        //rated movie
        Map<Integer, MovieRating> ratings = movieRatings.get(movie.getId());
        int sum = 0;
        for (MovieRating rating : ratings.values()) {
            sum += rating.ordinal();
        }
        return (double) sum / ratings.size();
    }
}
