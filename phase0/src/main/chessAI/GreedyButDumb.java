package chessAI;

import BoardManager.BoardManager;

import java.awt.Point;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * The easiest algorithm
 * AI will look for a move that maximize its score for the next state only, very greedy and shortsighted.
 */
public class GreedyButDumb extends Engine{

	private final PriorityQueue<State> searchingQueue;

	public GreedyButDumb(BoardManager bm) {
		super(bm);
		searchingQueue = new PriorityQueue<>((o1, o2) -> o2.getScore() - o1.getScore());
	}

	@Override
	public Point[] makeDecision() {
		bestState = null;
		searchingQueue.clear();
		search();
		return bestState.getPrevMove();
	}

	/**
	 * Find a good move according to the starting state
	 */
	private void search() {
		ArrayList<State> candidates = new ArrayList<>();    // Candidates are the states with the highest score
		Random ranGenerator = new Random();
		int bestScore;

		// Record the best score in the queue
		searchingQueue.addAll(startingState.generateNextState());
		assert !searchingQueue.isEmpty();
		bestScore = searchingQueue.peek().getScore();

		// Find all candidates with the same high score (if there are multiple)
		while (!searchingQueue.isEmpty()) {
			State temp = searchingQueue.remove();

			if (temp.getScore() >= bestScore)
				candidates.add(temp);
			else
				break;
		}

		// Randomly choose one from candidates
		bestState = candidates.get(ranGenerator.nextInt(candidates.size()));
	}

}
