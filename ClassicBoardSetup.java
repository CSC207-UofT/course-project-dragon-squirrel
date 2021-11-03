
public class Board {
	private boolean[][] board = new boolean[8][8];
	private Piece[][] pieces = new Piece[8][8];
	public static final int n = 8;
	
	public boolean isEmpty(int x, int y) {
		if(board[x][y] == false) {
			return true;
		}
		return false;
	}
	
	
	public void place_piece(int x, int y, Piece p) {
		if(isEmpty(x, y)) {
			pieces[x][y] = p;
			board[x][y] = true;
		}
	}
	
	public Piece getPiece(int x, int y) {
		return pieces[x][y];
	}
	
	public static boolean valid(int x, int y) {				//validating the co-ordinates the board
		if(x < 0 || x > 7 || y < 0 || y > 7)
			return false;
		else
			return true;
	}
}
