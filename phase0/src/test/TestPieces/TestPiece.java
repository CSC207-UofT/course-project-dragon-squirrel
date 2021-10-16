import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PieceTest {
    Piece p1;
    Piece p2;
    Piece p3;

    @Before
    public void setup(){
        p1 = new Piece("w_pawn", WHITE);
        p2 = new Piece("b_pawn", BLACK);
        p3 = new Piece("w_rook", WHITE);
    }

    @Test(timeout = 50)
    public void TestgetName(){
        assertEquals("w_pawn", p1.getName());
        assertEquals("b_pawn", p2.getName());
    }

    @Test(timeout = 50)
    public void TestgetColor(){
        assertEquals(WHITE, p1.getColor());
        assertEquals(BLACK, p2.getColor());
    }

    @Test(timeout = 50)
    public void TestgetStatus(){
        assertEquals(false, p1.getStatus());
    }

    @Test(timeout = 50)
    public void TesthasSameColor(){
        assertEquals(false, p1.hasSameColor(p2));
        asserEquals(true, p1.hasSameColor(p3));
    }

}
