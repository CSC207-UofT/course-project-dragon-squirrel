import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
	public Queen(boolean color) {
		super(color);
		
		this.setValue(8);
	}

	public List<Move> GetValidMoves(Board b, int x, int y) {
		List<Move> moves = new ArrayList<Move>();
		
		//Queen can move in any direction any number of spaces
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x, y+i) == true) {

				if(b.isEmpty(x, y+i) == false) {
					if(b.getPiece(x, y+i).getColor() != color) {
						moves.add(new Move(x,y,x,y+i));		
					}
					
					break;
				}
				else {
					moves.add(new Move(x,y,x,y+i));	
				}

			}
		}
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x, y-i) == true) {

				if(b.isEmpty(x, y-i) == false) {
					if(b.getPiece(x, y-i).getColor() != color)
						moves.add(new Move(x,y,x,y-i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x,y-i));	
			}
		}
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x-i, y) == true) {
				
				if(b.isEmpty(x-i, y) == false) {
					if(b.getPiece(x-i, y).getColor() != color)
						moves.add(new Move(x,y,x-i,y));	
					
					break;
				}
				else

					moves.add(new Move(x,y,x-i,y));	
			}
		}
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x+i, y) == true) {
				if(b.isEmpty(x+i, y) == false) {
					if(b.getPiece(x+i, y).getColor() != color)
						moves.add(new Move(x,y,x+i,y));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x+i,y));	
			}
		}
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x+i, y+i) == true) {
				if(b.isEmpty(x+i, y+i) == false) {
					if(b.getPiece(x+i, y+i).getColor() != color)
						moves.add(new Move(x,y,x+i,y+i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x+i,y+i));	
			}
		}
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x-i, y+i) == true) {
				if(b.isEmpty(x-i, y+i) == false) {
					
					if(b.getPiece(x-i, y+i).getColor() != color)
						moves.add(new Move(x,y,x-i,y+i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x-i,y+i));	
			}
		}
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x+i, y-i) == true) {
				if(b.isEmpty(x+i, y-i) == false) {
					if(b.getPiece(x+i, y-i).getColor() != color)
						moves.add(new Move(x,y,x+i,y-i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x+i,y-i));	
			}
		}
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x-i, y-i) == true) {
				if(b.isEmpty(x-i, y-i) == false) {
					if(b.getPiece(x-i, y-i).getColor() != color)
						moves.add(new Move(x,y,x-i,y-i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x-i,y-i));	
			}
		}
		
		return moves;
	}
	
	public String toString() {
		String piece = "queen";
		
		if(color == Piece.WHITE)
			return piece.toUpperCase();

		return piece;
	}
	

}