package TestPieces;

import org.junit.Before;
import org.junit.Test;
import piece.Color;
import piece.Rook;

import static org.junit.Assert.assertEquals;

public class TestRook {
    Rook r;

    @Before
    public void setup(){
        r = new Rook("w_rook", Color.WHITE);
    }

    @Test
    public void TestvalidMove(){
        assertEquals(true, r.validMove(7, 0, 0, 0));
        assertEquals(true, r.validMove(7, 0, 7, 7));
        assertEquals(false, r.validMove(7, 0, 0, 7));
    }

}
