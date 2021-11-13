package TestPiece;

import org.junit.Before;
import org.junit.Test;
import Piece.Color;
import Piece.King;

import static org.junit.Assert.assertEquals;

public class TestKing {
    King k;

    @Before
    public void setup(){
        k = new King("w_king", Color.WHITE);
    }

    @Test(timeout = 50)
    public void TestvalidMove(){
        assertEquals(true, k.validMove(7, 4, 6, 5));
        assertEquals(false, k.validMove(7, 4, 5, 6));
    }

}
