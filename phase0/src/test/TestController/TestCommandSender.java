package TestController;

import BoardManager.BoardManager;
import Command.ChessMove;
import Command.MoveType;
import Controller.BoardUpdater;
import Controller.CommandSender;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestCommandSender {

    BoardManager bm;
    BoardUpdater bu;
    CommandSender cs;

    @Before
    public void before(){
        bm = new BoardManager();
        bu = new BoardUpdater(bm);
        cs = new CommandSender(true);   //classic chess
    }

    @Test(timeout = 50)
    public void TestgetBoardUpdater(){
        assertEquals(bu.getBoardImageAsUnicode(), cs.getBoardUpdater().getBoardImageAsUnicode()); // TODO: fix the only slightly connected params
    }

    @Test(timeout = 50)
    public void TestgetBm(){
        assertEquals(bm.getBoardAsString(), cs.getBm().getBoardAsString());
    }

    @Test(timeout = 50)
    public void TestcreateNewChessMove(){
        ChessMove commandMove = cs.createNewChessMove(6, 0, 5, 0);
        ChessMove cm = new ChessMove(cs.getBm(),6, 0, 5, 0, true, MoveType.REGULAR);
        assertEquals(cm.getBM().getBoardAsString(), commandMove.getBM().getBoardAsString());
    }

    @Test(timeout = 50)
    public void TestpressMove(){
        assertTrue(cs.pressMove(6, 0, 5, 0));
    }

    @Test(timeout = 50)
    public void TestundoMove(){
        assertFalse(cs.undoMove());
        cs.pressMove(6, 0, 5, 0);
        assertTrue(cs.undoMove());
    }

    @Test(timeout = 50)
    public void TeststartNewGame(){
        cs.startNewGame(true);
        assertEquals(bm.getBoardAsString(), cs.getBm().getBoardAsString());
        assertEquals(bu.getBoardImageAsUnicode(), cs.getBoardUpdater().getBoardImageAsUnicode());
    }

    @Test(timeout = 50)
    public void TestpassValidMove(){
        List<Point> moves = new ArrayList<>();
        moves.add(new Point(2, 0));
        moves.add(new Point(3, 0));
        assertEquals(moves, cs.passValidMove(new Point(1, 0)));
    }

}
