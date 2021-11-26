package chessAI;

import BoardManager.BoardManager;

import java.awt.Point;

/**
 * The easiest algorithm
 *
 * AI will look for a move that maximize its score for the next state only, very greedy and shortsighted.
 */
public class GreedyButStupid extends Engine{

	public GreedyButStupid(BoardManager bm) {

		super(bm);
	}

	@Override
	public Point[] makeDecision() {
		search();
		return bestState.getPrevMove();
	}

	private void search() {
		searchingQueue.addAll(startingState.generateNextState());
		bestState = searchingQueue.peek();
	}

}
