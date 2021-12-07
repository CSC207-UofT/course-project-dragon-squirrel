package chessAI;

import Controller.*;
import java.awt.Point;

/**
 * Represent an AI player, can make a chess move
 */
public class Agent {

	private Engine engine;
	private final CommandSender cs;

	public Agent(CommandSender cs, Difficulty difficulty) {
		this.cs = cs;

		switch (difficulty) {
			case EASY:
				engine = new GreedyButDumb(cs.getBm());
				break;
			case MEDIUM:
				engine = new Minimax(cs.getBm(), 4);
				break;
			case HARD:
				engine = new Minimax(cs.getBm(), 5);
		}
	}

	/**
	 * Send a make move command to controller
	 */
	public void makeMove() {
		Point[] decision = engine.makeDecision();
		System.out.println("AI decides to move from " + decision[0] + " to " + decision[1]);
		cs.pressMove(decision[0].x, decision[0].y, decision[1].x, decision[1].y);
	}
}
