/**
 * This contains one set of game rules.
 * Since the game has two sets of rule, we can easily make subclass of it to describe the second rule
 */
public class GameRule {

	private Board board;
	// we can use board.getPiece() to access pieces

//	/**
//	 * Return 0 if the path is clear but the new coordinate is occupied with an opponent's piece
//	 * Return 1 if the path is clear and the new coordinate is vacant
//	 * Return 2 if the path is not clear
//	 * Return 3 if the path is not clear but the new coordinate is vacant (for knight)
//	 * Return -1 if there is some error
//	 */
//	public int clearValidPath(int oldX, int oldY, int newX, int newY) {
//		//uses the validMove() method in Piece
//		return -1;
//	}

	/**
	 * It might be a good idea to separate clearValidPath() into two methods
	 */
	public boolean isPathClear(int oldX, int oldY, int newX, int newY) {
		return false;
	}

	/**
	 * It might be a good idea to separate clearValidPath() into two methods
	 */
	public boolean isCoordinateVacant(int X, int Y) {
		return false;
	}

	/**
	 * The only pieces interaction scenario I can think of is that one attacks another
	 * Let's design some game rules together! (maybe after this phase)
	 */
	public void piecesInteraction(Piece attacker, Piece defender) {
		// Maybe use board.DeductPieceHp()
	}

	/**
	 * Check if the current player wins
	 * @return
	 */
	public boolean isPlayerWinning() {
		return false;
	}

	/**
	 * Get the next available moves of a piece
	 * This is VERY important if we want an AI player make thoughtful decisions (involves decision tree etc.)
	 * We don't need to worry about it now
	 *
	 * @param p The piece that moves (we want to know which kind of piece it is)
	 * @param X Current X coordinate
	 * @param Y Current Y coordinate
	 * @return  An array of coordinates, each is a valid position to move
	 */
	public int[][] getAvailableMoves(Piece p, int X, int Y) {
		return null;
	}
}
