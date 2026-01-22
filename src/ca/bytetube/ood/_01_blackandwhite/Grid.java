package ca.bytetube.ood._01_blackandwhite;

public class Grid {
    private int[][] grids;
    private int rows;
    private int cols;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        initGrids();
    }


    public void initGrids() {
        grids = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grids[r][c] = GridPosition.EMPTY.ordinal();
            }
        }
    }


    /**
     * place one piece in the specified col, automatically falling to the lowest row
     *
     * @return piece row
     */
    public int placePiece(int col, GridPosition piece) {
        if (col < 0 || col > cols) throw new IndexOutOfBoundsException("invalid col");
        if (piece == GridPosition.EMPTY) throw new RuntimeException("invalid piece");

        //place piece in the lowest empty  grid
        for (int r = rows - 1; r >= 0; r--) {
            if (grids[r][col] == GridPosition.EMPTY.ordinal()) {
                grids[r][col] = piece.ordinal();
                return r;
            }
        }

        return -1;
    }


    public int[][] getGrids() {
        return grids;
    }

    public void setGrids(int[][] grids) {
        this.grids = grids;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public boolean checkWinCondition(int connectN, int row, int col, GridPosition piece) {
        //1.row
        int count = 0;
        for (int c = 0; c < cols; c++) {
            if (grids[row][c] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }

        //2.col
        count = 0;
        for (int r = 0; r < rows; r++) {
            if (grids[r][col] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }

        //3.diagonal
        count = 0;
        for (int r = 0; r < rows; r++) {
            //row + col = r + c => c = row+ col - r
            int c = row + col - r;
            if (c >= 0 && c < cols && grids[r][c] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }

        count = 0;
        for (int r = 0; r < rows; r++) {
            //row-col = r - c => c = col - row + r;
            int c = col - row + r;
            if (c >= 0 && c < cols && grids[r][c] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }


        return false;
    }
}
