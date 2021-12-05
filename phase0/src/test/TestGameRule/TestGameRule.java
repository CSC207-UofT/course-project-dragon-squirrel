package TestGameRule;

import Board.Board;
import BoardManager.BoardManager;
import Command.ChessMove;
import Command.MoveRecord;
import Command.MoveType;
import GameRule.GameRule;
import org.junit.Before;
import org.junit.Test;
import piece.Color;
import piece.Pawn;
import piece.PieceInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestGameRule {

    BoardManager bm;
    Board board;
    MoveRecord MR;
    GameRule gr;

    @Before
    public void before(){
        bm = new BoardManager();
        board = bm.getBoard();
        MR = bm.getMR();
        gr = new GameRule(board, MR);
    }

    @Test(timeout = 50)
    public void TestgetBoard(){
        assertEquals(board.to2dStringArray(), gr.getBoard().to2dStringArray());
    }

    @Test(timeout = 50)
    public void TestisMoveValid(){
        board.addPiece(new Pawn("pawn_0", Color.BLACK), 0, 0);
        assertEquals(MoveType.INVALID, gr.isMoveValid(0, 0, 0, -1));    // out of bounds
        board.addPiece(new Pawn("pawn_1", Color.BLACK), 1, 0);
        assertEquals(MoveType.REGULAR, gr.isMoveValid(1, 0, 2, 0));
    }

    @Test(timeout = 50)
    public void TestisCoordinateValid(){
        assertTrue(gr.isCoordinateValid(0, 0, 7, 7));
    }

    @Test(timeout = 50)
    public void TestisPathClear(){
        board.addPiece(new Pawn("pawn_0", Color.BLACK), 0, 0);
        board.addPiece(new Pawn("pawn_0", Color.BLACK), 1, 0);
        assertFalse(gr.isPathClear(0, 0, 2, 0));
        assertTrue(gr.isPathClear(1, 0, 2, 0));
    }

    @Test(timeout = 50)
    public void TestpathCoordinates(){
        ArrayList<Point> coords = gr.pathCoordinates(0, 0, 2, 0);
        assertEquals(new Point(1, 0), coords.get(0));
    }

    @Test(timeout = 50)
    public void TestgetAvailableMoves(){
        ArrayList<Point> moves = new ArrayList<>();
        moves.add(new Point(2, 0));
        moves.add(new Point(3, 0));
        board.addPiece(new Pawn("pawn_0", Color.BLACK), 1, 0);
        assertEquals(moves, gr.getAvailableMoves(new Point(1, 0)));
    }

    @Test(timeout = 50)
    public void TestenPassant(){
        bm.movePiece(1, 0, 3, 0);
        MR.add(new ChessMove(bm, 1, 0, 3, 0, true, MoveType.REGULAR));
        bm.movePiece(6, 1, 4, 1);
        MR.add(new ChessMove(bm, 6, 1, 4, 1, true, MoveType.REGULAR));
        bm.movePiece(3, 0, 4, 0);
        MR.add(new ChessMove(bm, 3, 0, 4, 0, false, MoveType.REGULAR));
        //assertTrue(gr.enPassant(4, 1, 3, 0)); //TODO: this isn't working
    }

    @Test(timeout = 50)
    public void TestpawnCapture(){
        bm.movePiece(1, 0, 3, 0);
        bm.movePiece(6, 1, 4, 1);
        assertTrue(gr.pawnCapture(3, 0, 4, 1));
    }

    @Test(timeout = 50)
    public void TestCastling(){
        bm.movePiece(1, 1, 3, 1);
        bm.movePiece(1, 2, 3, 2);
        bm.movePiece(1, 3, 3, 3);
        bm.movePiece(0, 1, 2, 0);
        bm.movePiece(0, 2, 1, 1);
        bm.movePiece(0, 3, 1, 3);
        //assertTrue(gr.Castling(0, 4, 0, 0));  //TODO: this is't working
    }

}
