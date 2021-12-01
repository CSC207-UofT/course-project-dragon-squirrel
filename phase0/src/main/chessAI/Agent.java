package chessAI;

import Controller.*;

import java.awt.Point;

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
				engine = new Minimax(cs.getBm(), 6);
		}
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void makeMove() {
		Point[] decision = engine.makeDecision();
		cs.pressMove(decision[0].x, decision[0].y, decision[1].x, decision[1].y);
	}
}
