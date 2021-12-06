package chessAI;

import Board.Board;
import BoardManager.BoardManager;
import junit.framework.TestCase;
import org.junit.Before;
import piece.Color;
import piece.PieceInterface;

import java.awt.*;

public class StateTest extends TestCase {

	@Before
	public void before(){

		BoardManager bm = new BoardManager();

		State newState = new State(bm.getBoard(), Color.WHITE, null);
	}

	public void testGetScore() {
	}

	public void testGetPlayer() {
	}

	public void testGetPrevMove() {
	}

	public void testGenerateNextState() {
	}

	public void testIsGameOver() {
	}
}