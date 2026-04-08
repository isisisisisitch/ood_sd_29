package ca.bytetube.ood._20_chessgame;

class Square {
    private Piece piece;
    private Color color;

    public Square(Color color) {
        this.color = color;
    }

    public Piece getPiece() {
        return piece;
    }

    public Color getColor() {
        return this.color;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

}
