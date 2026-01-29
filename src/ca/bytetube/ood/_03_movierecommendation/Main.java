package ca.bytetube.ood._03_movierecommendation;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "User1");
        User user2 = new User(2, "User2");
        User user3 = new User(3, "User3");

        Movie movie1 = new Movie(1, "Captain America");
        Movie movie2 = new Movie(2, "Iron Man");
        Movie movie3 = new Movie(3, "Spider Man");


        RatingRegister ratingRegister = new RatingRegister();
        RecommendationSystem system = new RecommendationSystem(ratingRegister);
        ratingRegister.addRating(user1, movie1, MovieRating.FIVE);
        ratingRegister.addRating(user1, movie2, MovieRating.FOUR);
        ratingRegister.addRating(user2, movie1, MovieRating.FIVE);
        ratingRegister.addRating(user2, movie3, MovieRating.THREE);
        ratingRegister.addRating(user3, movie2, MovieRating.TWO);
        ratingRegister.addRating(user3, movie3, MovieRating.FOUR);
        System.out.println(system.recommendMovie(user1));

    }
}
