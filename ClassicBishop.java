import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

	public Bishop(boolean color) {
		super(color);

		this.setValue(3);
	}
		
	public List<Move> GetValidMoves(Board b, int x, int y) {
		List<Move> moves = new ArrayList<Move>();

		//Bishop can move in diagonals
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x+i, y+i) == true) {
				
				if(b.isEmpty(x+i, y+i) == false) {
				
					if(b.getPiece(x+i, y+i).color != color)
						moves.add(new Move(x,y,x+i,y+i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x+i,y+i));	
			}
		}
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x-i, y+i) == true) {
				
				if(!b.isEmpty(x-i, y+i)) {
				
					if(b.getPiece(x-i, y+i).color != color)
						moves.add(new Move(x,y,x-i,y+i));	
					
					break;
				}
				else
					moves.add(new Move(x,y,x-i,y+i));	
			}
		}
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x+i, y-i)) {
				
				if(!b.isEmpty(x+i, y-i)) {
				
					if(b.getPiece(x+i, y-i).color != color)
						moves.add(new Move(x,y,x+i,y-i));	
					
					break;

				}
				else
					moves.add(new Move(x,y,x+i,y-i));	
			}
		}
		
		for(int i = 1; i < Board.n; i++) {
			if(Board.valid(x-i, y-i)) {
				
				if(!b.isEmpty(x-i, y-i)) {

					if(b.getPiece(x-i, y-i).color != color)
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
		String piece = "bishop";		
		
		if(color == Piece.WHITE)
			return piece.toUpperCase();
		
		return piece;
	}
}