package TestPiece;

import org.junit.Before;
import org.junit.Test;
import piece.Color;
import piece.King;

import static org.junit.Assert.*;

public class TestKing {

    King k;

    @Before
    public void before(){
        k = new King("w_king", Color.WHITE);
    }

    @Test(timeout = 50)
    public void TestgetHasMovedDuringGame(){
        assertFalse(k.getHasMovedDuringGame());
    }

    @Test(timeout = 50)
    public void TestsetHasMovedDuringGame(){
        assertFalse(k.getHasMovedDuringGame());
        k.setHasMovedDuringGame(true);
        assertTrue(k.getHasMovedDuringGame());
    }

    @Test(timeout = 50)
    public void TestgetValue(){
        assertEquals(99999, k.getValue());
    }

    @Test(timeout = 50)
    public void TestvalidMove(){
        assertTrue(k.validMove(7, 4, 6, 5));
        assertFalse(k.validMove(7, 4, 5, 6));
    }

    @Test(timeout = 50)
    public void TestdeepCopy(){
        assertEquals(k.getName(), k.deepCopy().getName());
    }

}
