package TestPiece;

import org.junit.Before;
import org.junit.Test;
import piece.Color;
import piece.Pawn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestPawn {

    Pawn p;

    @Before
    public void before(){
        p = new Pawn("w_pawn", Color.WHITE);
    }

    @Test(timeout = 50)
    public void TestgetHasNotMovedDuringGame(){
        assertTrue(p.getHasNotMovedDuringGame());
    }

    @Test(timeout = 50)
    public void TestsetHasNotMovedDuringGame(){
        assertTrue(p.getHasNotMovedDuringGame());
        p.setHasNotMovedDuringGame(false);
        assertFalse(p.getHasNotMovedDuringGame());
    }

    @Test(timeout = 50)
    public void TestgetValue(){
        assertEquals(100, p.getValue());
    }

    @Test(timeout = 50)
    public void TestvalidMove(){
        assertEquals(true, p.validMove(6, 0, 4, 0));
        assertEquals(true, p.validMove(6, 0, 5, 0));
        assertEquals(false, p.validMove(6, 0, 3, 0));
    }

    @Test(timeout = 50)
    public void TestdeepCopy(){
        assertEquals(p.getName(), p.deepCopy().getName());
    }

}
