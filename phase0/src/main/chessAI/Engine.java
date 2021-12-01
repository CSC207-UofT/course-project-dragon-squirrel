package chessAI;

import BoardManager.BoardManager;
import piece.Color;
import piece.PieceInterface;

import java.awt.Point;
import java.util.PriorityQueue;

/**
 * Search algorithm for AI goes here
 *
 * We will likely implement a few different algorithms, they change AI's chess skill
 */
public abstract class Engine {
	protected State startingState;
	protected State bestState;
	protected PriorityQueue<State> searchingQueue;

	protected int bestScore = -PieceInterface.KING_VALUE;
	protected int worstScore = PieceInterface.KING_VALUE;

	public Engine(BoardManager bm) {

		// assume AI is always black, so previous player for starting state is always white
		startingState = new State(bm.getBoard(), Color.WHITE, null);
		searchingQueue = new PriorityQueue<>((o1, o2) -> o2.getScore() - o1.getScore());
	}

	public abstract Point[] makeDecision();
}
