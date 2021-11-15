package TestBoard;

import Board.SuperBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSuperBoard {

    SuperBoard sb;

    @Before
    public void before(){
        sb = new SuperBoard(13, 10);
    }

    @After
    public void after(){
        sb.reset();
    }

    @Test(timeout = 50)
    public void TestgetLandType(){
        assertEquals(sb.getLandType(0, 0), "ground");
    }

}
