package TestBoard;

import Board.SuperBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSuperBoard {

    int col;
    int row;
    String[][] superBoardLand;
    SuperBoard sb;

    @Before
    public void before(){
        col = 13;
        row = 10;
        superBoardLand = new String[col][row];
        sb = new SuperBoard(col, row);
    }

    @Test(timeout = 50)
    public void TestgetLandType(){
        assertEquals(sb.getLandType(0, 0), "ground");
    }

}
