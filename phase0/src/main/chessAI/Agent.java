package chessAI;

import Controller.*;
import Command.*;

import java.awt.Point;

public class Agent {

	private Engine engine;
	private final CommandSender cs;

	public Agent(CommandSender cs, Engine engine) {
		this.cs = cs;
		this.engine = engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void makeMove() {
		Point[] decision = engine.makeDecision();
		ChessMove newChessMove = cs.creatNewChessMove(decision[0].x, decision[0].y, decision[1].x, decision[1].y);
		cs.pressMove(newChessMove);
	}
}
