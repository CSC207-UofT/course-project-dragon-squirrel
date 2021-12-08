package TestPiece;

import org.junit.Before;
import org.junit.Test;
import piece.Color;
import piece.Bishop;

import static org.junit.Assert.assertEquals;

public class TestBishop {

    Bishop b;

    @Before
    public void setup(){
        b = new Bishop("w_bishop", Color.WHITE);
    }

    @Test(timeout = 50)
    public void TestgetValue(){
        assertEquals(300, b.getValue());
    }

    @Test(timeout = 50)
    public void TestvalidMove(){
        assertEquals(true, b.validMove(7, 2, 5, 4));
        assertEquals(false, b.validMove(7, 2, 5, 5));
    }

    @Test(timeout = 50)
    public void TestdeepCopy(){
        assertEquals(b.getName(), b.deepCopy().getName());
    }

}
