import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

	public Knight(boolean color) {
		super(color);
		this.setValue(3);
	}
	
	public List<Move> GetValidMoves(Board b, int x, int y) {
		List<Move> moves = new ArrayList<Move>();
		
		// Knight move in L-shaped

		if(Board.valid(x-1,y-2) && (b.isEmpty(x-1,y-2) || (!b.isEmpty(x-1,y-2) && b.getPiece(x-1,y-2).getColor() != color))) {
			moves.add(new Move(x,y,x-1,y-2));	
		}
		
		if(Board.valid(x+2,y-1) && (b.isEmpty(x+2,y-1) || (!b.isEmpty(x+2,y-1) && b.getPiece(x+2,y-1).getColor() != color))) {
			moves.add(new Move(x,y,x+2,y-1));
		}
		
		if(Board.valid(x+1,y-2) && (b.isEmpty(x+1,y-2) || (!b.isEmpty(x+1,y-2) && b.getPiece(x+1,y-2).getColor() != color))) {
			moves.add(new Move(x,y,x+1,y-2));
		}
		
		if(Board.valid(x+1, y+2) && (b.isEmpty(x+1, y+2) || (!b.isEmpty(x+1, y+2) && b.getPiece(x+1, y+2).getColor() != color))) {
			moves.add(new Move(x,y,x+1, y+2));
		}
	
		if(Board.valid(x+2, y+1) && (b.isEmpty(x+2, y+1) || (!b.isEmpty(x+2, y+1) && b.getPiece(x+2, y+1).getColor() != color))) {
			moves.add(new Move(x,y,x+2, y+1));
		}
			
		if(Board.valid(x-2,y-1) && (b.isEmpty(x-2,y-1) || (!b.isEmpty(x-2,y-1) && b.getPiece(x-2,y-1).getColor() != color))) {
			moves.add(new Move(x,y,x-2,y-1));
		}

		if(Board.valid(x-1,y+2) && (b.isEmpty(x-1,y+2) || (!b.isEmpty(x-1,y+2) && b.getPiece(x-1,y+2).getColor() != color))) {
			moves.add(new Move(x,y,x-1,y+2));
		}
		
		if(Board.valid(x-2,y+1) && (b.isEmpty(x-2,y+1) || (!b.isEmpty(x-2,y+1) && b.getPiece(x-2,y+1).getColor() != color))) {
			moves.add(new Move(x,y,x-2,y+1));
		}
				
		return moves;
	}
	

	public String toString() {
		String piece = "knight";
		
		if(color == Piece.WHITE)
			return piece.toUpperCase();

		return piece;
	}

}