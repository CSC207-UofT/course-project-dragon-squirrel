package chessAI;

import Board.Board;
import BoardManager.BoardManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import piece.Color;

public class StateTest {

	State newState;
	Board board;

	@Before
	public void before(){
		board = new BoardManager().getBoard();
		newState = new State(board, Color.WHITE, null);
	}

	@Test
	public void testGetScore() {
		Assert.assertEquals(newState.getScore(), 0);
	}

	@Test
	public void testGetPlayer() {
		Assert.assertEquals(newState.getPlayer(), Color.BLACK);
	}

	@Test
	public void testGetPrevMove() {
		Assert.assertNull(newState.getPrevMove());
	}

	@Test
	public void testGenerateNextState() {
		Assert.assertEquals(newState.generateNextState().size(), 20);
	}

	@Test
	public void testIsGameOver() {
		Assert.assertFalse(newState.isGameOver());

		board.removePiece(0, 3);
		Assert.assertFalse(newState.isGameOver());

		board.removePiece(0, 4);
		Assert.assertTrue(newState.isGameOver());

		board.removePiece(7, 4);
		Assert.assertTrue(newState.isGameOver());
	}
}