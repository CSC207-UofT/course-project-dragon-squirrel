package chessAI;

import BoardManager.BoardManager;

import java.awt.Point;

/**
 * The easiest algorithm
 *
 * AI will look for a move that maximize its score for the next state only, very greedy and shortsighted.
 */
public class GreedyButDumb extends Engine{

	public GreedyButDumb(BoardManager bm) {
		super(bm);
	}

	@Override
	public Point[] makeDecision() {
		search();
		System.out.println("decision made");
		return bestState.getPrevMove();
	}

	private void search() {
		searchingQueue.addAll(startingState.generateNextState());
		bestState = searchingQueue.peek();
	}

}
