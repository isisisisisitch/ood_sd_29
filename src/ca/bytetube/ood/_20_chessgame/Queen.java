package ca.bytetube.ood._20_chessgame;
//Queen
//Combines rook and bishop movement abilities
//Can move any distance in straight lines
//Can move any distance diagonally
//Cannot jump over other pieces
class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Square[][] board) {
        return MovementUtil.isValidStraightMove(startRow, startCol, endRow, endCol, this.getColor(), board) || MovementUtil.isValidDiagonalMove(startRow, startCol, endRow, endCol, this.color, board);
    }

    @Override
    public String getSymbol() {
        return (this.getColor() == Color.WHITE) ? "Q" : "q";
    }

}
