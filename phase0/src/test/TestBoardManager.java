import Board.Board;
import BoardManager.BoardManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestBoardManager {
    BoardManager bm;
    Board b;

    @Before
    public void setup(){
        bm = new BoardManager();
        b = new Board(8, 8);
    }

    @Test(timeout = 50)
    public void TestgetBoard(){

        assertTrue(Arrays.equals(b.getBoard(), bm.getCurrentBoard()));
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
        assertEquals("w_pawn_0", bm.getBoard().getPiece(5, 0));
    }

}
