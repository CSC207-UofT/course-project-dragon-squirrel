package TestGameRule;

import Board.Board;
import Board.SuperBoard;
import Command.MoveRecord;
import Command.MoveType;
import GameRule.SuperGameRule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import piece.*;
import Command.MoveRecord;

import java.util.HashMap;
import java.util.Map;

public class TestSuperGameRule {

    SuperBoard superBoard;
    MoveRecord mr;
    SuperGameRule sgr;

    @Before
    public void before(){
        superBoard = new SuperBoard(13, 10);
        mr = new MoveRecord();
        sgr = new SuperGameRule(superBoard, mr);
    }

    @Test(timeout = 50)
    public void TestisMoveValid(){
        superBoard.addPiece(new Pawn("pawn_0", Color.BLACK), 0, 0);
        assertEquals(MoveType.INVALID, sgr.isMoveValid(0, 0, 0, -1));    // out of bounds
        superBoard.addPiece(new Pawn("pawn_1", Color.WHITE), 8, 0);
        assertEquals(MoveType.REGULAR, sgr.isMoveValid(8, 0, 7, 0));
    }

}
