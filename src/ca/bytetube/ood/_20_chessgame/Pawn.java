package ca.bytetube.ood._20_chessgame;
//Pawn
//Moves forward only
//First move can be one or two squares
//Captures one square diagonally forward
//Promotes at the last rank (usually to a queen)
class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Square[][] board) {
        if (!isWithinGrid(endRow, endCol)) return false;

        int rowMovement = endRow - startRow;
        int colMovement = endCol - startCol;

        int direction = (this.getColor() == Color.WHITE) ? -1 : 1;

        if (colMovement != 0) return false;

        if (rowMovement == direction && board[endRow][endCol].getPiece() == null) {
            return true;
        }

        if (isFirstMove(startRow) && rowMovement == (2 * direction) && board[startRow + direction][startCol].getPiece() == null && board[endRow][endCol].getPiece() == null) {
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return (this.getColor() == Color.WHITE) ? "P" : "p";
    }

    private boolean isFirstMove(int startRow) {
        if (this.getColor() == Color.WHITE) {
            return startRow == 6;
        } else {
            return startRow == 1;
        }
    }

}
