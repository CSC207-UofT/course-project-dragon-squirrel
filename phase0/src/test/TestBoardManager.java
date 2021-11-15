import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TestBoardManager {
    BoardManager bm;
    Board b;

    @Before
    public void setup(){
        bm = new BoardManager();
        b = new Board();
    }

    @Test(timeout = 50)
    public void TestgetBoard(){
        assertEquals(b.getBoard(), bm.getBoard().getBoard());
    }

    @Test(timeout = 50)
    public void TestgetCurrentBoard(){
        assertEquals(b.getBoard(), bm.getCurrentBoard());
    }

    @Test(timeout = 50)
    public void TestgetPieces(){
        assertEquals(new HashMap<>(), bm.getPieces());
    }

//    @Test(timeout = 50)
//    public void TestgetActivePlayer(){
//        assertEquals(bm.getP1(), bm.getActivePlayer());
//    }

    @Test(timeout = 50)
    public void TestmovePiece(){
        assertEquals("vacant", bm.getBoard().getPiece(5, 0));
        bm.movePiece(6, 0, 5, 0);
        assertEquals("w_pawn", bm.getBoard().getPiece(5, 0));
    }

}
