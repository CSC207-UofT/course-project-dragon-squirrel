package chessAI;

import Board.Board;
import Controller.CommandSender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AgentTest {
	CommandSender cs;
	Agent a;

	@Before
	public void before(){
		cs = new CommandSender(true);
		a = new Agent(cs, Difficulty.MEDIUM);
		cs.pressMove(6, 0, 5, 0);
	}

	@Test
	public void testMakeMove() {
		a.makeMove();
		Assert.assertTrue(blackHasMoved(cs.getBm().getBoard()));
	}

	private boolean blackHasMoved(Board b) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				if (b.getBoard()[i][j] == null)
					return true;
			}
		}
		return false;
	}
}