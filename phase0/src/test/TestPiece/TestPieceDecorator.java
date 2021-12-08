package TestPiece;

import org.junit.Before;
import org.junit.Test;
import piece.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestPieceDecorator {

    PieceInterface p;
    PieceInterface r1;
    PieceInterface r2;

    @Before
    public void before(){
        p = new Pawn("w_pawn_0", Color.WHITE);
        r1 = new Rook("w_rook_l", Color.WHITE);
        r2 = new Rook("b_rook_r", Color.BLACK);
    }

    @Test(timeout = 50)
    public void TestgetName(){
        assertEquals("w_pawn_0", p.getName());
    }

    @Test(timeout = 50)
    public void TestgetColor(){
        assertEquals(Color.WHITE, p.getColor());
    }

    @Test(timeout = 50)
    public void TestgetStatus(){
        assertFalse(p.getStatus());
    }

    @Test(timeout = 50)
    public void TestsetStatus(){
        p.setStatus(true);
        assertTrue(p.getStatus());
    }

    @Test(timeout = 50)
    public void TestgetValue(){
        assertEquals(100, p.getValue());
        assertEquals(500, r1.getValue());
    }

    @Test(timeout = 50)
    public void TestvalidMove(){
        assertTrue(p.validMove(6, 0, 4, 0));
        assertFalse(r1.validMove(0, 0, 7, 7));
    }

    @Test(timeout = 50)
    public void TestisBlack(){
        assertTrue(r2.isBlack());
        assertFalse(r1.isBlack());
    }

    @Test(timeout = 50)
    public void TestisWhite(){
        assertTrue(r1.isWhite());
        assertFalse(r2.isWhite());
    }

    @Test(timeout = 50)
    public void TesthasSameColor(){
        assertTrue(p.hasSameColor(r1));
        assertFalse(p.hasSameColor(r2));
    }

}
