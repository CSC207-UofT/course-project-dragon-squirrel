package TestPiece;

import org.junit.Before;
import org.junit.Test;
import piece.Color;
import piece.Knight;

import static org.junit.Assert.assertEquals;

public class TestKnight {
    Knight k;

    @Before
    public void setup(){
        k = new Knight("w_knight", Color.WHITE);
    }

    @Test(timeout = 50)
    public void TestvalidMove(){
        assertEquals(true, k.validMove(7, 1, 5, 2));
        assertEquals(false, k.validMove(7, 1, 5, 3));
    }

}
