package ca.bytetube.ood._20_chessgame;
//King
//Moves one square at a time
//Can move in 8 directions
//Cannot move into check
class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Square[][] board) {
        if (!isWithinGrid(endRow, endCol)) return false;

        int rowMovement = Math.abs(endRow - startRow);
        int colMovement = Math.abs(endCol - startCol);

        if (rowMovement > 1 || colMovement > 1) {
            return false;
        }

        if (board[endRow][endCol].getPiece() != null && board[endRow][endCol].getPiece().getColor() == this.getColor()) {
            return false;
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return (this.getColor() == Color.WHITE) ? "K" : "k";
    }

}
