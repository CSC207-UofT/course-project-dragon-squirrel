package TestGameRule;

import Board.Board;
import Command.ChessMove;
import Command.MoveRecord;
import GameRule.GameRule;
import org.junit.Before;
import org.junit.Test;
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

    Board board;
    Map<String, PieceInterface> piecesDict;
    MoveRecord MR;
    GameRule gr;

    @Before
    public void before(){
        board = new Board(8, 8);
        piecesDict = new HashMap<String, PieceInterface>();
        MR = new MoveRecord();
        gr = new GameRule(board, piecesDict, MR);
    }

    @Test(timeout = 50)
    public void TestisMoveValid(){
        assertFalse(gr.isMoveValid(0, 0, 0, -1));    // out of bounds
    }

    @Test(timeout = 50)
    public void TestisCoordinateValid(){
        assertTrue(gr.isCoordinateValid(0, 0, 7, 7));
    }

    @Test(timeout = 50)
    public void TestisPathClear(){
        assertTrue(gr.isPathClear(1, 0, 3, 0));
        assertFalse(gr.isPathClear(0, 0, 4, 0));
    }

    @Test(timeout = 50)
    public void TestpathCoordinates(){
        ArrayList<Point> coords = gr.pathCoordinates(0, 0, 2, 0);
        assertEquals(new Point(1, 0), coords.get(0));
    }

}
