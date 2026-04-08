package ca.bytetube.ood._20_chessgame;
//Bishop
//Moves only diagonally
//Cannot jump over other pieces
//Can capture enemy pieces on the diagonal
class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, Square[][] board) {
        return MovementUtil.isValidDiagonalMove(startRow, startCol, endRow, endCol, this.getColor(), board);
    }

    @Override
    public String getSymbol() {
        return (this.getColor() == Color.WHITE) ? "B" : "b";
    }

}
