package ca.bytetube.ood._20_chessgame;
//Rook
//Moves only horizontally or vertically
//Can move any number of squares
//Cannot jump over other pieces
//Can participate in castling
class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Square[][] board) {
        return MovementUtil.isValidStraightMove(startRow, startCol, endRow, endCol, this.getColor(), board);
    }


    @Override
    public String getSymbol() {
        return (this.getColor() == Color.WHITE) ? "R" : "r";
    }

}
