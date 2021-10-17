import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KingTest {
    King k;

    @Before
    public void setup(){
        k = new King("w_king", WHITE);
    }

    @Test(timeout = 50)
    public void TestvalidMove(){
        assertEquals(true, k.validMove(7, 4, 6, 5));
        asserEquals(false, k.validMove(7, 4, 5, 6));
    }

}
