package TestPiece;

import org.junit.Before;
import org.junit.Test;
import piece.Color;
import piece.Rook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestRook {

    Rook r;

    @Before
    public void before(){
        r = new Rook("w_rook", Color.WHITE);
    }

    @Test(timeout = 50)
    public void TestgetHasMovedDuringGame(){
        assertFalse(r.getHasMovedDuringGame());
    }

    @Test(timeout = 50)
    public void TestsetHasMovedDuringGame(){
        assertFalse(r.getHasMovedDuringGame());
        r.setHasMovedDuringGame(true);
        assertTrue(r.getHasMovedDuringGame());
    }

    @Test(timeout = 50)
    public void TestgetValue(){
        assertEquals(500, r.getValue());
    }

    @Test(timeout = 50)
    public void TestvalidMove(){
        assertTrue(r.validMove(7, 0, 0, 0));
        assertTrue(r.validMove(7, 0, 7, 7));
        assertFalse(r.validMove(7, 0, 0, 7));
    }

    @Test(timeout = 50)
    public void TestdeepCopy(){
        assertEquals(r.getName(), r.deepCopy().getName());
    }

}
