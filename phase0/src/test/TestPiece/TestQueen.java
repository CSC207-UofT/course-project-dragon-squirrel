package TestPiece;

import org.junit.Before;
import org.junit.Test;
import piece.Color;
import piece.Queen;

import static org.junit.Assert.assertEquals;

public class TestQueen {
    Queen q;

    @Before
    public void setup(){
        q = new Queen("w_queen", Color.WHITE);
    }

    @Test(timeout = 50)
    public void TestvalidMove(){
        assertEquals(true, q.validMove(7, 3, 0, 3));
        assertEquals(true, q.validMove(7, 3, 7, 0));
        assertEquals(true, q.validMove(7, 3, 3, 7));
        assertEquals(false, q.validMove(7, 3, 0, 0));
    }

}
