import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BishopTest {
    Bishop b;

    @Before
    public void setup(){
        b = new Bishop("w_bishop", WHITE);
    }

    @Test(timeout = 50)
    public void TestvalidMove(){
        assertEquals(true, b.validMove(7, 2, 5, 4));
        assertEquals(false, b.validMove(7, 2, 5, 5));
    }

}
