package TestBoard;

import Board.Board;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import piece.Color;
import piece.Pawn;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class TestBoard {

    int col;
    int row;
    Board b;
    Point boundaries;

    @Before
    public void before(){
        int col = 8;
        int row = 8;
        b = new Board(col, row);
        boundaries = new Point(col, row);
    }

    @After
    public void after(){
        b.reset(b.getBoard());
    }

    @Test(timeout = 50)
    public void TestgetBoard(){

        String[][] board = new String[8][8];

        // initialize white pieces
        board[7][0] = "w_rook_l";
        board[7][1] = "w_knight_l";
        board[7][2] = "w_bishop_l";
        board[7][3] = "w_queen";
        board[7][4] = "w_king";
        board[7][5] = "w_bishop_r";
        board[7][6] = "w_knight_r";
        board[7][7] = "w_rook_r";
        board[6][0] = "w_pawn_0";
        board[6][1] = "w_pawn_1";
        board[6][2] = "w_pawn_2";
        board[6][3] = "w_pawn_3";
        board[6][4] = "w_pawn_4";
        board[6][5] = "w_pawn_5";
        board[6][6] = "w_pawn_6";
        board[6][7] = "w_pawn_7";

        // initialize black pieces
        board[0][0] = "b_rook_l";
        board[0][1] = "b_knight_l";
        board[0][2] = "b_bishop_l";
        board[0][3] = "b_queen";
        board[0][4] = "b_king";
        board[0][5] = "b_bishop_r";
        board[0][6] = "b_knight_r";
        board[0][7] = "b_rook_r";
        board[1][0] = "b_pawn_0";
        board[1][1] = "b_pawn_1";
        board[1][2] = "b_pawn_2";
        board[1][3] = "b_pawn_3";
        board[1][4] = "b_pawn_4";
        board[1][5] = "b_pawn_5";
        board[1][6] = "b_pawn_6";
        board[1][7] = "b_pawn_7";

        // initialize remaining board with no pieces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "vacant";
            }
        }
        assertEquals(board, b.to2dStringArray(col, row));
    }

    @Test(timeout = 50)
    public void TestgetBoundaries(){
        assertEquals(b.getBoundaries(), boundaries);
    }

    @Test(timeout = 50)
    public void TestaddPiece(){
        b.addPiece(new Pawn("pawn", Color.WHITE), 5, 0);
        assertEquals("pawn", b.getBoard()[5][0].getName());
    }

    @Test(timeout = 50)
    public void TestremovePiece(){
        b.removePiece(6, 0);
        assertEquals("vacant", b.getPiece(6, 0));
    }

    @Test(timeout = 50)
    public void TestisPositionVacant(){
        assertTrue(b.isPositionVacant(5, 0));
    }

    @Test(timeout = 50)
    public void TestgetPiece(){
        assertEquals("w_pawn_0", b.getPiece(6, 0));
    }

    @Test(timeout = 50)
    public void Testreset(){
        String[][] board = new String[8][8];

        // initialize white pieces
        board[7][0] = "w_rook_l";
        board[7][1] = "w_knight_l";
        board[7][2] = "w_bishop_l";
        board[7][3] = "w_queen";
        board[7][4] = "w_king";
        board[7][5] = "w_bishop_r";
        board[7][6] = "w_knight_r";
        board[7][7] = "w_rook_r";
        board[6][0] = "w_pawn_0";
        board[6][1] = "w_pawn_1";
        board[6][2] = "w_pawn_2";
        board[6][3] = "w_pawn_3";
        board[6][4] = "w_pawn_4";
        board[6][5] = "w_pawn_5";
        board[6][6] = "w_pawn_6";
        board[6][7] = "w_pawn_7";

        // initialize black pieces
        board[0][0] = "b_rook_l";
        board[0][1] = "b_knight_l";
        board[0][2] = "b_bishop_l";
        board[0][3] = "b_queen";
        board[0][4] = "b_king";
        board[0][5] = "b_bishop_r";
        board[0][6] = "b_knight_r";
        board[0][7] = "b_rook_r";
        board[1][0] = "b_pawn_0";
        board[1][1] = "b_pawn_1";
        board[1][2] = "b_pawn_2";
        board[1][3] = "b_pawn_3";
        board[1][4] = "b_pawn_4";
        board[1][5] = "b_pawn_5";
        board[1][6] = "b_pawn_6";
        board[1][7] = "b_pawn_7";

        // initialize remaining board with no pieces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "vacant";
            }
        }

        assertEquals(board, b.to2dStringArray(col, row));
    }

    @Test(timeout = 50)
    public void Testto2dStringArray(){

        String[][] board = new String[8][8];

        // initialize white pieces
        board[7][0] = "w_rook_l";
        board[7][1] = "w_knight_l";
        board[7][2] = "w_bishop_l";
        board[7][3] = "w_queen";
        board[7][4] = "w_king";
        board[7][5] = "w_bishop_r";
        board[7][6] = "w_knight_r";
        board[7][7] = "w_rook_r";
        board[6][0] = "w_pawn_0";
        board[6][1] = "w_pawn_1";
        board[6][2] = "w_pawn_2";
        board[6][3] = "w_pawn_3";
        board[6][4] = "w_pawn_4";
        board[6][5] = "w_pawn_5";
        board[6][6] = "w_pawn_6";
        board[6][7] = "w_pawn_7";

        // initialize black pieces
        board[0][0] = "b_rook_l";
        board[0][1] = "b_knight_l";
        board[0][2] = "b_bishop_l";
        board[0][3] = "b_queen";
        board[0][4] = "b_king";
        board[0][5] = "b_bishop_r";
        board[0][6] = "b_knight_r";
        board[0][7] = "b_rook_r";
        board[1][0] = "b_pawn_0";
        board[1][1] = "b_pawn_1";
        board[1][2] = "b_pawn_2";
        board[1][3] = "b_pawn_3";
        board[1][4] = "b_pawn_4";
        board[1][5] = "b_pawn_5";
        board[1][6] = "b_pawn_6";
        board[1][7] = "b_pawn_7";

        // initialize remaining board with no pieces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "vacant";
            }
        }

        assertEquals(board, b.to2dStringArray(col, row));
    }

}
