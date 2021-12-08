package TestBoardManager;

import Board.Board;
import BoardManager.BoardManager;
import Command.MoveRecord;
import BoardManager.GameStatus;
import org.junit.Before;
import org.junit.Test;
import piece.*;
import piece.Color;

import java.awt.*;

import static org.junit.Assert.*;

public class TestBoardManager {

    int col;
    int row;
    Point boundaries;
    Board board;
    Color activePlayer;
    GameStatus gameStatus;
    MoveRecord MR;
    BoardManager bm;

    @Before
    public void before(){
        col = 8;
        row = 8;
        boundaries = new Point(col, row);
        board = new Board(boundaries.x, boundaries.y);
        MR = new MoveRecord();
        bm = new BoardManager();
    }

    @Test(timeout = 50)
    public void TestgetBoard(){
        Piece[][] Piece2dArray = new Piece[8][8];

        // initialize white pieces
        Piece2dArray[7][0] = new Rook("rook_l", Color.WHITE);
        Piece2dArray[7][1] = new Knight("knight_l", Color.WHITE);
        Piece2dArray[7][2] = new Bishop("bishop_l", Color.WHITE);
        Piece2dArray[7][3] = new Queen("queen", Color.WHITE);
        Piece2dArray[7][4] = new King("king", Color.WHITE);
        Piece2dArray[7][5] = new Bishop("bishop_r", Color.WHITE);
        Piece2dArray[7][6] = new Knight("knight_r", Color.WHITE);
        Piece2dArray[7][7] = new Rook("rook_r", Color.WHITE);

        for (int i = 0; i < 8; i++) {
            String name = "pawn_" + i;
            Piece2dArray[6][i] = new Pawn(name, Color.WHITE);
        }

        // initialize black pieces
        Piece2dArray[0][0] = new Rook("rook_l", Color.BLACK);
        Piece2dArray[0][1] = new Knight("knight_l", Color.BLACK);
        Piece2dArray[0][2] = new Bishop("bishop_l", Color.BLACK);
        Piece2dArray[0][3] = new Queen("queen", Color.BLACK);
        Piece2dArray[0][4] = new King("king", Color.BLACK);
        Piece2dArray[0][5] = new Bishop("bishop_r", Color.BLACK);
        Piece2dArray[0][6] = new Knight("knight_r", Color.BLACK);
        Piece2dArray[0][7] = new Rook("rook_r", Color.BLACK);

        for (int i = 0; i < 8; i++) {
            String name = "pawn_" + i;
            Piece2dArray[1][i] = new Pawn(name, Color.BLACK);
        }

        // initialize remaining board with no pieces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                Piece2dArray[i][j] = null;
            }
        }
        board.reset(Piece2dArray);
        assertEquals(board.to2dStringArray(), bm.getBoard().to2dStringArray());
    }

    @Test(timeout = 50)
    public void TestgetBoardAsString(){
        Piece[][] Piece2dArray = new Piece[8][8];

        // initialize white pieces
        Piece2dArray[7][0] = new Rook("rook_l", Color.WHITE);
        Piece2dArray[7][1] = new Knight("knight_l", Color.WHITE);
        Piece2dArray[7][2] = new Bishop("bishop_l", Color.WHITE);
        Piece2dArray[7][3] = new Queen("queen", Color.WHITE);
        Piece2dArray[7][4] = new King("king", Color.WHITE);
        Piece2dArray[7][5] = new Bishop("bishop_r", Color.WHITE);
        Piece2dArray[7][6] = new Knight("knight_r", Color.WHITE);
        Piece2dArray[7][7] = new Rook("rook_r", Color.WHITE);

        for (int i = 0; i < 8; i++) {
            String name = "pawn_" + i;
            Piece2dArray[6][i] = new Pawn(name, Color.WHITE);
        }

        // initialize black pieces
        Piece2dArray[0][0] = new Rook("rook_l", Color.BLACK);
        Piece2dArray[0][1] = new Knight("knight_l", Color.BLACK);
        Piece2dArray[0][2] = new Bishop("bishop_l", Color.BLACK);
        Piece2dArray[0][3] = new Queen("queen", Color.BLACK);
        Piece2dArray[0][4] = new King("king", Color.BLACK);
        Piece2dArray[0][5] = new Bishop("bishop_r", Color.BLACK);
        Piece2dArray[0][6] = new Knight("knight_r", Color.BLACK);
        Piece2dArray[0][7] = new Rook("rook_r", Color.BLACK);

        for (int i = 0; i < 8; i++) {
            String name = "pawn_" + i;
            Piece2dArray[1][i] = new Pawn(name, Color.BLACK);
        }

        // initialize remaining board with no pieces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                Piece2dArray[i][j] = null;
            }
        }
        board.reset(Piece2dArray);
        assertEquals(board.to2dStringArray(), bm.getBoardAsString());
    }

    @Test(timeout = 50)
    public void TestgetMR(){
        assertTrue(bm.getMR().isEmpty());
    }

    @Test(timeout = 50)
    public void TestgetPiece(){
        assertEquals("pawn_0", bm.getPiece(6, 0).getName());
    }

    @Test(timeout = 50)
    public void TestgetHasMovedStatus(){
        assertFalse(bm.getHasMovedStatus(bm.getPiece(0, 0)));
        assertFalse(bm.getHasMovedStatus(bm.getPiece(1, 0)));
        assertFalse(bm.getHasMovedStatus(bm.getPiece(0, 4)));
    }

    @Test(timeout = 50)
    public void TestmovePiece(){
        assertEquals("pawn_0", bm.getBoard().getPiece(1, 0).getName());
        assertNull(bm.getBoard().getPiece(3, 0));
        bm.movePiece(1, 0, 3, 0);
        assertEquals("pawn_0", bm.getBoard().getPiece(3, 0).getName());
    }

    @Test(timeout = 50)
    public void TestswitchPieceHasMovedStatus(){
        assertFalse(bm.getHasMovedStatus(bm.getPiece(0, 0)));
        assertFalse(bm.getHasMovedStatus(bm.getPiece(1, 0)));
        assertFalse(bm.getHasMovedStatus(bm.getPiece(0, 4)));
        bm.switchPieceHasMovedStatus(bm.getPiece(0, 0), true);
        bm.switchPieceHasMovedStatus(bm.getPiece(1, 0), true);
        bm.switchPieceHasMovedStatus(bm.getPiece(0, 4), true);
        assertTrue(bm.getHasMovedStatus(bm.getPiece(0, 0)));
        assertTrue(bm.getHasMovedStatus(bm.getPiece(1, 0)));
        assertTrue(bm.getHasMovedStatus(bm.getPiece(0, 4)));
    }

    @Test(timeout = 50)
    public void TestresetBoard(){
        Piece[][] Piece2dArray = new Piece[8][8];

        // initialize white pieces
        Piece2dArray[7][0] = new Rook("rook_l", Color.WHITE);
        Piece2dArray[7][1] = new Knight("knight_l", Color.WHITE);
        Piece2dArray[7][2] = new Bishop("bishop_l", Color.WHITE);
        Piece2dArray[7][3] = new Queen("queen", Color.WHITE);
        Piece2dArray[7][4] = new King("king", Color.WHITE);
        Piece2dArray[7][5] = new Bishop("bishop_r", Color.WHITE);
        Piece2dArray[7][6] = new Knight("knight_r", Color.WHITE);
        Piece2dArray[7][7] = new Rook("rook_r", Color.WHITE);

        for (int i = 0; i < 8; i++) {
            String name = "pawn_" + i;
            Piece2dArray[6][i] = new Pawn(name, Color.WHITE);
        }

        // initialize black pieces
        Piece2dArray[0][0] = new Rook("rook_l", Color.BLACK);
        Piece2dArray[0][1] = new Knight("knight_l", Color.BLACK);
        Piece2dArray[0][2] = new Bishop("bishop_l", Color.BLACK);
        Piece2dArray[0][3] = new Queen("queen", Color.BLACK);
        Piece2dArray[0][4] = new King("king", Color.BLACK);
        Piece2dArray[0][5] = new Bishop("bishop_r", Color.BLACK);
        Piece2dArray[0][6] = new Knight("knight_r", Color.BLACK);
        Piece2dArray[0][7] = new Rook("rook_r", Color.BLACK);

        for (int i = 0; i < 8; i++) {
            String name = "pawn_" + i;
            Piece2dArray[1][i] = new Pawn(name, Color.BLACK);
        }

        // initialize remaining board with no pieces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                Piece2dArray[i][j] = null;
            }
        }
        board.reset(Piece2dArray);
        assertEquals(board.to2dStringArray(), bm.getBoard().to2dStringArray());
    }

}
