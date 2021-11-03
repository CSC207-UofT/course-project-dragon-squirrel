import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

	public Rook(boolean color) {
		super(color);
		this.setValue(5);
	}
	
	public List<Move> GetValidMoves(Board b, int x, int y) {
		List<Move> moves = new ArrayList<Move>();
		//Rooks move up and down the rank and file of the chessboard, and can move any number of spaces
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x, y+i) == true) {
				if(b.isEmpty(x, y+i) == false) {
					if(b.getPiece(x, y+i).color != color)
						moves.add(new Move(x,y,x,y+i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x,y+i));	
			}
		}
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x, y-i)) {
				if(b.isEmpty(x, y-i) == false) {
					if(b.getPiece(x, y-i).color != color)
						moves.add(new Move(x,y,x,y-i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x,y-i));	
			}
		}
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x+i, y) == true) {
				if(b.isEmpty(x+i, y) == false) {
					if(b.getPiece(x+i, y).color != color)
						moves.add(new Move(x,y,x+i,y));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x+i,y));	
			}
		}
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x-i, y) == true) {
				if(b.isEmpty(x-i, y) == false) {
					if(b.getPiece(x-i, y).color != color)
						moves.add(new Move(x,y,x-i,y));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x-i,y));	
			}
		}
		
		return moves;
	}
	
	public String toString() {
		String piece = "rook";
		
		if(color == Piece.WHITE)
			return piece.toUpperCase();

		return piece;
	}
	
}