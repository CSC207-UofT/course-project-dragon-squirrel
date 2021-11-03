import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

	public Pawn(boolean color) {
		super(color);

		this.setValue(1);
	}
		
	public List<Move> GetValidMoves(Board b, int x, int y) {
		List<Move> moves = new ArrayList<Move>();
		
		//pawn moves forward , not backward so checking for white and black separately
		if(color == Piece.WHITE) {
			if(Board.valid(x,y+1) && b.isEmpty(x, y+1)) {
				moves.add(new Move(x,y,x,y+1));
			}

			if(Board.valid(x+1,y+1) && !b.isEmpty(x+1, y+1) && b.getPiece(x+1, y+1).getColor() != color) {
				moves.add(new Move(x,y,x+1,y+1));
			}
			if(Board.valid(x-1,y+1) && !b.isEmpty(x-1, y+1) && b.getPiece(x-1, y+1).getColor() != color) {
				moves.add(new Move(x,y,x-1,y+1));
			}
		}
		else {
			if(Board.valid(x,y-1) && b.isEmpty(x, y-1)) {
				moves.add(new Move(x,y,x,y-1));
			}
			
			if(Board.valid(x+1,y-1) && b.isEmpty(x+1, y-1) && b.getPiece(x+1, y-1).getColor() != color) {
				moves.add(new Move(x,y,x+1,y-1));
			}
			if(Board.valid(x-1,y-1) && b.isEmpty(x-1, y-1) && b.getPiece(x-1, y-1).getColor() != color) {
				moves.add(new Move(x,y,x-1,y-1));
			}
		}
		
		return moves;
	}
	
	public String toString() {
		String piece = "pawn";
		
		if(color == Piece.WHITE)
			return piece.toUpperCase();
		
		return piece;
	}

}