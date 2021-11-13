package TestPiece;

import org.junit.Before;
import org.junit.Test;
import piece.Color;
import piece.Pawn;
import piece.Rook;

import static org.junit.Assert.assertEquals;

public class TestPiece {
    Pawn p1;
    Pawn p2;
    Rook p3;

    @Before
    public void setup(){
        p1 = new Pawn("w_pawn_1", Color.WHITE);
        p2 = new Pawn("b_pawn_1", Color.BLACK);
        p3 = new Rook("w_rook_l", Color.WHITE);
    }

    @Test(timeout = 50)
    public void TestgetName(){
        assertEquals("w_pawn_1", p1.getName());
        assertEquals("b_pawn_1", p2.getName());
    }

    @Test(timeout = 50)
    public void TestgetColor(){
        assertEquals(Color.WHITE, p1.getColor());
        assertEquals(Color.BLACK, p2.getColor());
    }

    @Test(timeout = 50)
    public void TestgetStatus(){
        assertEquals(false, p1.getStatus());
    }

    @Test(timeout = 50)
    public void TesthasSameColor(){
        assertEquals(false, p1.hasSameColor(p2));
        assertEquals(true, p1.hasSameColor(p3));
    }

}
