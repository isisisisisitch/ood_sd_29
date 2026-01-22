package ca.bytetube.ood._01_blackandwhite;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameSystem {
    private Grid grid;
    private Player[] players;
    private Map<String, Integer> score;
    private int connectedN;
    private int targetScore;

    private Scanner input = new Scanner(System.in);

    public GameSystem(Grid grid, int connectedN, int targetScore) {
        this.grid = grid;
        this.connectedN = connectedN;
        this.targetScore = targetScore;
        players = new Player[]{new Player("Player1", GridPosition.BLACK), new Player("Player2", GridPosition.WHITE)};
        score = new HashMap<>();
        for (Player p : players) {
            score.put(p.getName(), 0);
        }
    }

    public void play() {
        int maxScore = 0;
        Player winner = null;
        while (maxScore < targetScore) {
            winner = playRound();
            System.out.println(winner.getName() + " won the round");
            maxScore = Math.max(score.get(winner.getName()), maxScore);
            grid.initGrids();
        }

        System.out.println("winner is " + winner.getName());

    }

    /**
     * Play one round: two players take turns until one wins.
     *
     * @return The player who wins the round
     */
    private Player playRound() {
        while (true) {
            for (Player player : players) {
                int[] pos = playMove(player);
                int row = pos[0];
                int col = pos[1];
                GridPosition pieceColor = player.getPiece();
                if (this.grid.checkWinCondition(connectedN, row, col, pieceColor)) {
                    score.put(player.getName(), this.score.get(player.getName()) + 1);
                    return player;
                }
            }
        }

    }

    /**
     * Let the specified player make a move and return the move position.
     *
     * @param player The player who is making the move
     * @return Array containing the row and column of the move
     */
    private int[] playMove(Player player) {
        printBoard();
        System.out.println(player.getName() + "'s turn");
        int colNum = grid.getCols();
        System.out.println("enter col 0 to " + (colNum - 1) + " to add piece:");
        int moveCol = input.nextInt();//player1:1
        int movRow = grid.placePiece(moveCol, player.getPiece());

        return new int[]{movRow, moveCol};
    }



    /**
     * Print the current board state to the console.
     */
    private void printBoard() {
        System.out.println("Board:");
        int[][] grid = this.grid.getGrids();
        for (int i = 0; i < grid.length; i++) {
            String row = "";
            for (int piece : grid[i]) {
                if (piece == GridPosition.EMPTY.ordinal()) {
                    row += "0 ";
                } else if (piece == GridPosition.BLACK.ordinal()) {
                    row += "B ";
                } else if (piece == GridPosition.WHITE.ordinal()) {
                    row += "W ";
                }
            }
            System.out.println(row);

        }
        System.out.println();
    }




}
