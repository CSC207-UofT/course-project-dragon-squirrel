import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    Board b;

    @Before
    private void setup(){
        b = new Board();
    }

    @After
    private void after(){
        b.reset();
    }

    @Test(timeout = 50)
    public void TestgetBoard(){
        String[][] board = new String[8][8];

        // initialize white pieces
        board[7][0] = "w_rook";
        board[7][1] = "w_knight";
        board[7][2] = "w_bishop";
        board[7][3] = "w_queen";
        board[7][4] = "w_king";
        board[7][5] = "w_bishop";
        board[7][6] = "w_knight";
        board[7][7] = "w_rook";
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

        assertEquals(board, b.getBoard());
    }

    @Test(timeout = 50)
    public void TestaddPiece(){
        assertEquals("vacant", b[5][0]);
        b.addPiece("w_pawn", 5, 0);
        assertEquals("w_pawn", b[5][0]);
    }

    @Test(timeout = 50)
    public void TestremovePiece(){
        assertEquals("w_pawn", 6, 0);
        b.removePiece(6, 0);
        assertEquals("vacant", 6, 0);
    }

    @Test(timeout = 50)
    public void TestisPostionVacant(){
        assertEquals(true, isPostitionVacant(5, 0));
        assertEquals(false, isPositionVacant(6, 0));
    }

    @Test(timeout = 50)
    public void TestgetPiece(){
        assertEquals("w_pawn", getPiece(6, 0));
    }

    @Test(timeout = 50)
    public void Testreset(){
        String[][] board = new String[8][8];

        // initialize white pieces
        board[7][0] = "w_rook";
        board[7][1] = "w_knight";
        board[7][2] = "w_bishop";
        board[7][3] = "w_queen";
        board[7][4] = "w_king";
        board[7][5] = "w_bishop";
        board[7][6] = "w_knight";
        board[7][7] = "w_rook";
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

        assertEquals(board, b.reset());
    }

}
