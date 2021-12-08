package chessAI;

import Controller.*;
import java.awt.Point;
import java.io.Serializable;

/**
 * Represent an AI player, can make a chess move
 */
public class Agent implements Serializable {

	private Engine engine;
	private final CommandSender cs;
	private final Difficulty difficulty;

	public Agent(CommandSender cs, Difficulty difficulty) {
		this.cs = cs;
		this.difficulty = difficulty;
		reloadAI();
	}

	/**
	 * Send a make move command to controller
	 */
	public void makeMove() {
		Point[] decision = engine.makeDecision();
		System.out.println("AI decides to move from " + decision[0] + " to " + decision[1]);
		cs.pressMove(decision[0].x, decision[0].y, decision[1].x, decision[1].y);
	}

	/**
	 * Load the engine
	 */
	public void reloadAI() {
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
}
