package TestPieces;

import org.junit.Before;
import org.junit.Test;
import piece.Color;
import piece.Pawn;

import static org.junit.Assert.assertEquals;

public class TestPawn {
    Pawn p;

    @Before
    public void setup(){
        p = new Pawn("w_pawn", Color.WHITE);
    }

    @Test
    public void TestvalidMove(){
        assertEquals(true, p.validMove(6, 0, 4, 0));
        assertEquals(true, p.validMove(6, 0, 5, 0));
        assertEquals(false, p.validMove(6, 0, 3, 0));
    }

}
