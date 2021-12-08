package chessAI;

import BoardManager.BoardManager;
import piece.Color;
import piece.PieceInterface;

import java.awt.Point;
import java.io.Serializable;

/**
 * Search algorithm for AI goes here
 *
 * We will likely implement a few different algorithms, they change AI's chess skill
 */
public abstract class Engine implements Serializable {
	protected State startingState;  // The first (root) state to search with
	protected State bestState;  // The decision of engine, can only be one of the immediate next state

	public Engine(BoardManager bm) {
		// assume AI is always black, so previous player for starting state is always white
		startingState = new State(bm.getBoard(), Color.WHITE, null);
	}

	/**
	 * Return two points on the board
	 * Whoever calls this method will later move the piece at point[0] to point[1]
	 */
	public abstract Point[] makeDecision();
}
