package ca.bytetube.ood._01_blackandwhite;

public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid(15,15);
        GameSystem game = new GameSystem(grid,5,3);
        game.play();

    }
}
