package TestPiece;

import org.junit.Before;
import org.junit.Test;
import piece.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestSuperPieceDecorator {

    SuperPieceDecorator p;
    SuperPieceDecorator r1;
    SuperPieceDecorator r2;

    @Before
    public void before(){
        p = new SuperPieceDecorator(new Pawn("pawn_0", Color.WHITE), 5, 6);
        r1 = new SuperPieceDecorator(new Rook("rook_l", Color.WHITE), 4, 1);
        r2 = new SuperPieceDecorator(new Rook("rook_r", Color.BLACK), 4, 1);
    }

    @Test(timeout = 50)
    public void TestgetHp(){
        assertEquals(5, p.getHp());
    }

    @Test(timeout = 50)
    public void TestgetAtk(){
        assertEquals(6, p.getAtk());
    }

    @Test(timeout = 50)
    public void TestgetHasNotMoved(){
        assertTrue(p.getHasNotMoved());
    }

    @Test(timeout = 50)
    public void TestgetHasNotAttacked(){
        assertTrue(p.getHasNotAttacked());
    }

    @Test(timeout = 50)
    public void TestsetHp(){
        assertEquals(5, p.getHp());
        p.setHp(10);
        assertEquals(10, p.getHp());
    }

    @Test(timeout = 50)
    public void TestmodifyHp(){
        assertEquals(5, p.getHp());
        p.modifyHp(3);
        assertEquals(8, p.getHp());
    }

    @Test(timeout = 50)
    public void TestdeepCopy(){
        assertEquals(p.getName(), p.deepCopy().getName());
    }

}
