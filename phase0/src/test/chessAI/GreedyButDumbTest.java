package chessAI;

import BoardManager.BoardManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import piece.Knight;
import piece.Pawn;
import piece.PieceInterface;

import java.awt.*;

public class GreedyButDumbTest {

	BoardManager bm;
	Engine engine;

	@Before
	public void before(){
		bm = new BoardManager();
		engine = new GreedyButDumb(bm);
	}

	@Test
	public void testMakeDecision() {
		Point[] p = engine.makeDecision();
		PieceInterface actionPiece = bm.getPiece(p[0].x, p[0].y);

		for (int i = 0; i < 10; i++) {
			Assert.assertTrue(actionPiece instanceof Knight || actionPiece instanceof Pawn);
			Assert.assertTrue(p[0].x != p[1].x || p[0].y != p[1].y);
		}
	}

}