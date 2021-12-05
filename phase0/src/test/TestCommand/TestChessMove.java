package TestCommand;

import BoardManager.BoardManager;
import Command.ChessMove;
import Command.MoveType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestChessMove {

    BoardManager bm;
    ChessMove cm;

    @Before
    public void before(){
        bm = new BoardManager();
        cm = new ChessMove(bm, 0, 0, 1, 1, false, MoveType.REGULAR);
    }

    @Test(timeout = 50)
    public void TestgetOldCoordX(){
        assertEquals(0, cm.getOldX());
    }

    @Test(timeout = 50)
    public void TestgetOldCoordY(){
        assertEquals(0, cm.getOldY());
    }

    @Test(timeout = 50)
    public void TestgetNewCoordX(){
        assertEquals(1, cm.getNewX());
    }

    @Test(timeout = 50)
    public void TestgetNewCoordY(){
        assertEquals(1, cm.getNewY());
    }

    @Test(timeout = 50)
    public void TestgetMoveType(){
        assertEquals(MoveType.REGULAR, cm.getMoveType());
    }

}
