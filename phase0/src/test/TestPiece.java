import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PieceTest {
    Piece p1;
    Piece p2;
    Piece p3;
    Piece p4;

    @Before
    public void before(){
        p1 = new Piece(true, true);
        p2 = new Piece(true, false);
        p3 = new Piece(false, true);
        p4 = new Piece(false, false);
    }

    @Test(timeout = 50)
    public void testIsWhite(){
        assertEquals(true, p1.isWhite);
        assertEquals(true, p2.isWhite);
        assertEquals(false, p3.isWhite);
        assertEquals(false, p4.isWhite);

    }

    @Test(timeout = 50)
    public void testIsAlive(){
        assertEquals(true, p1.isAlive);
        assertEquals(false, p2.isAlive);
        assertEquals(true, p3.isAlive);
        assertEquals(false, p4.isAlive);
    }
}