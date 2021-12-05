package TestBoard;

import Board.Board;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import piece.Color;
import piece.Pawn;
import piece.Piece;
import piece.PieceInterface;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class TestBoard {

    int col;
    int row;
    Point boundaries;
    PieceInterface[][] board;
    Board b;

    @Before
    public void before(){
        int col = 8;
        int row = 8;
        boundaries = new Point(col, row);
        board = new PieceInterface[boundaries.x][boundaries.y];
        b = new Board(boundaries.x, boundaries.y);
    }

    @Test(timeout = 50)
    public void TestgetBoard(){
        PieceInterface[][] board = new PieceInterface[boundaries.x][boundaries.y];
        assertEquals(board, b.getBoard());
    }

    @Test(timeout = 50)
    public void TestgetBoundaries(){
        assertEquals(boundaries, b.getBoundaries());
    }

    @Test(timeout = 50)
    public void TestaddPiece(){
        assertEquals(null, b.getBoard()[5][0]);
        b.addPiece(new Pawn("pawn_0", Color.WHITE), 5, 0);
        assertEquals("pawn_0", b.getBoard()[5][0].getName());
    }

    @Test(timeout = 50)
    public void TestremovePiece(){
        b.addPiece(new Pawn("pawn_0", Color.WHITE), 6, 0);
        assertEquals("pawn_0", b.getBoard()[6][0].getName());
        b.removePiece(6, 0);
        assertEquals(null, b.getPiece(6, 0));
    }

    @Test(timeout = 50)
    public void TestisPositionVacant(){
        assertEquals(null, b.getPiece(5, 0));
        assertTrue(b.isPositionVacant(5, 0));
    }

    @Test(timeout = 50)
    public void TestgetPiece(){
        PieceInterface piece = new Pawn("w_pawn_0", Color.WHITE);
        b.addPiece(piece,6, 0);
        assertEquals(piece, b.getPiece(6, 0));
    }

    @Test(timeout = 50)
    public void Testreset(){
        b.reset(board);
        assertEquals(board, b.getBoard());
    }

    @Test(timeout = 50)
    public void Testto2dStringArray(){
        String[][] boardAsString = new String[boundaries.x][boundaries.y];

        for (int i = 0; i < boundaries.x; i++) {
            for (int j = 0; j < boundaries.y; j++) {
                try {
                    PieceInterface piece = board[i][j];
                    String color = piece.isBlack() ? "b_" : "w_";
                    String name = piece.getName();

                    boardAsString[i][j] = color + name;
                }
                catch (NullPointerException e){
                    boardAsString[i][j] = "vacant";
                }
            }
        }
        assertEquals(boardAsString, b.to2dStringArray());
    }

    @Test(timeout = 50)
    public void TestdeepCopy(){
        assertEquals(b.to2dStringArray(), b.deepCopy().to2dStringArray());
    }

}
