import java.util.ArrayList;

/**
 * Guess this is a use case class
 */
public class Board {

    private String[][] board;   // Each cell can be the name/ID of a piece

    public Board() {
        // .....
    }

    public void addPiece(String pieceName, int X, int Y) {

    }

    public void removePiece(String pieceName, int X, int Y) {

    }

    public boolean isPositionVacant(int X, int Y) { return board[X][Y].equals("vacant"); }

    public String getPiece(int X, int Y) {
        return null;
    }

    public void reset()
    {
        // initialize white pieces
        board[7][0] = "w_rook";
        board[7][1] = "w_knight";
        board[7][2] = "w_bishop";
        board[7][3] = "w_queen";
        board[7][4] = "w_king";
        board[7][5] = "w_bishop";
        board[7][7] = "w_knight";
        board[7][6] = "w_rook";
        board[6][0] = "w_pawn";
        board[6][1] = "w_pawn";
        board[6][2] = "w_pawn";
        board[6][3] = "w_pawn";
        board[6][4] = "w_pawn";
        board[6][5] = "w_pawn";
        board[6][6] = "w_pawn";
        board[6][7] = "w_pawn";

        // initialize black pieces
        board[0][0] = "b_rook";
        board[0][1] = "b_knight";
        board[0][2] = "b_bishop";
        board[0][3] = "b_queen";
        board[0][4] = "b_king";
        board[0][5] = "b_bishop";
        board[0][6] = "b_knight";
        board[0][7] = "b_rook";
        board[1][0] = "b_pawn";
        board[1][1] = "b_pawn";
        board[1][2] = "b_pawn";
        board[1][3] = "b_pawn";
        board[1][4] = "b_pawn";
        board[1][5] = "b_pawn";
        board[1][6] = "b_pawn";
        board[1][7] = "b_pawn";

        // initialize remaining board with no pieces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "vacant";
            }
        }
    }


}
