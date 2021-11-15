package TestGameRule;

import Board.Board;
import Board.SuperBoard;
import Command.MoveRecord;
import GameRule.SuperGameRule;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import piece.PieceInterface;
import Command.MoveRecord;

import java.util.HashMap;
import java.util.Map;

public class TestSuperGameRule {

    Board superBoard;
    Map<String, PieceInterface> superPiecesDict;
    MoveRecord mr;
    SuperGameRule sgr;

    @Before
    public void before(){
        superBoard = new Board(13, 10);
        superPiecesDict = new HashMap<String, PieceInterface>();
        mr = new MoveRecord();
        sgr = new SuperGameRule(superBoard, superPiecesDict, mr);
    }

    @Test
    public void Test

}
