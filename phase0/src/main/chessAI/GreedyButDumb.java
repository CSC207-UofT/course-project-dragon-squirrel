package chessAI;

import BoardManager.BoardManager;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

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
		return bestState.getPrevMove();
	}

	/**
	 * Find a good move
	 */
	private void search() {
		ArrayList<State> candidates = new ArrayList<>();    // Candidates are the states with the highest score
		int bestScore;
		Random ranGenerator = new Random();

		searchingQueue.addAll(startingState.generateNextState());
		assert !searchingQueue.isEmpty();
		bestScore = searchingQueue.peek().getScore();

		while (!searchingQueue.isEmpty()) {
			State temp = searchingQueue.remove();

			if (temp.getScore() >= bestScore)
				candidates.add(temp);
			else
				break;
		}

		// Randomly select one from candidates
		bestState = candidates.get(ranGenerator.nextInt(candidates.size()));
		searchingQueue.clear();
	}

}