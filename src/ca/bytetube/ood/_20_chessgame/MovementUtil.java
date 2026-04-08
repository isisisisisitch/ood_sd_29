package ca.bytetube.ood._20_chessgame;

class MovementUtil {

    public static boolean isValidStraightMove(int startRow, int startCol, int endRow, int endCol, Color color, Square[][] board) {
        if (!Piece.isWithinGrid(endRow, endCol)) return false;


        int rowMovement = Math.abs(endRow - startRow);
        int colMovement = Math.abs(endCol - startCol);


        if ((rowMovement != 0 && colMovement != 0) || (rowMovement == 0 && colMovement == 0)) {
            return false;
        } else {

            int rowIncrement = (endRow > startRow) ? 1 : -1;
            int colIncrement = (endCol > startCol) ? 1 : -1;

            if (rowMovement == 0) {
                int y = startCol + colIncrement;
                while (y != endCol) {
                    if (board[startRow][y].getPiece() != null) {
                        return false;
                    }
                    y += colIncrement;
                }
            } else {
                int x = startRow + rowIncrement;
                while (x != endRow) {
                    if (board[x][startCol].getPiece() != null) {
                        return false;
                    }
                    x += rowIncrement;
                }
            }

            if (board[endRow][endCol].getPiece() != null && board[endRow][endCol].getPiece().getColor() == color) {
                return false;
            }

            return true;
        }
    }

    public static boolean isValidDiagonalMove(int startRow, int startCol, int endRow, int endCol, Color color, Square[][] board) {
        if (!Piece.isWithinGrid(endRow, endCol)) return false;

        int rowMovement = Math.abs(endRow - startRow);
        int colMovement = Math.abs(endCol - startCol);

        if (rowMovement == 0 || colMovement == 0) return false;

        if (rowMovement == colMovement) {
            int rowIncrement = (endRow > startRow) ? 1 : -1;
            int colIncrement = (endCol > startCol) ? 1 : -1;

            int x = startRow + rowIncrement;
            int y = startCol + colIncrement;

            while (x != endRow && y != endCol) {

                if (board[x][y].getPiece() != null) {//a piece is blocking the path

                    if (board[x][y].getPiece().getColor() == color) {
                        return false;//friendly piece blocks the path
                    }
                    return false;//enemy piece blocks the path

                }

                x += rowIncrement;
                y += colIncrement;
            }

            if (board[endRow][endCol].getPiece() != null && board[endRow][endCol].getPiece().getColor() == color) {
                return false;
            }
            return true;

        } else {
            return false;
        }
    }

}
