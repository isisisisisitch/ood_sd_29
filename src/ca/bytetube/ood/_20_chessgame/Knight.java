package ca.bytetube.ood._20_chessgame;
//Knight
//Moves in an "L" shape
//The only piece that can jump over others
//Destination cannot contain a friendly piece
class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Square[][] board) {
        if (!isWithinGrid(endRow, endCol)) return false;

        int rowMovement = Math.abs(endRow - startRow);
        int colMovement = Math.abs(endCol - startCol);

        //Validate L-shaped movement
        if (rowMovement == 2 && colMovement == 1 || rowMovement == 1 && colMovement == 2) {
            //Two valid L-shape patterns:
            //Pattern 1: move 2 rows and 1 column
            //Pattern 2: move 1 row and 2 columns

            // Friendly piece at destination
            if (board[endRow][endCol].getPiece() != null && board[endRow][endCol].getPiece().getColor() == this.getColor()) {
                return false;
            }

            // Destination is empty or has an enemy piece
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return (this.getColor() == Color.WHITE) ? "N" : "n";
    }

}
