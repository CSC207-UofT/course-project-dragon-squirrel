package TestPiece;

import org.junit.Before;
import org.junit.Test;
import piece.Color;
import piece.Knight;

import static org.junit.Assert.assertEquals;

public class TestKnight {

    Knight k;

    @Before
    public void before(){
        k = new Knight("w_knight", Color.WHITE);
    }

    @Test(timeout = 50)
    public void TestgetValue(){
        assertEquals(300, k.getValue());
    }

    @Test(timeout = 50)
    public void TestvalidMove(){
        assertEquals(true, k.validMove(7, 1, 5, 2));
        assertEquals(false, k.validMove(7, 1, 5, 3));
    }

    @Test(timeout = 50)
    public void TestdeepCopy(){
        assertEquals(k.getName(), k.deepCopy().getName());
    }

}
