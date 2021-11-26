package chessAI;

import BoardManager.BoardManager;

import java.awt.*;
import java.util.Comparator;

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
