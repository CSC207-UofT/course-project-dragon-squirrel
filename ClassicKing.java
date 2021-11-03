import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	boolean hasMoved = false;

	public King(boolean color) {
		super(color);
		this.setValue(0);
	}
	
	public King(boolean color, boolean hasMoved) {
		super(color);
		this.hasMoved = hasMoved;
		this.setValue(0);
	}
	

	public List<Move> GetValidMoves(Board b, int x, int y) {
		List<Move> moves = new ArrayList<Move>();
		
		//checking in all directions
		//The king can move one space in any direction
		
		if(Board.valid(x-1,y-1) && (b.isEmpty(x-1,y-1) || (!b.isEmpty(x-1,y-1) && b.getPiece(x-1,y-1).getColor() != color))) {
			moves.add(new Move(x,y,x-1,y-1));
		}
		
		if(Board.valid(x+1,y) && (b.isEmpty(x+1,y) || (!b.isEmpty(x+1,y) && b.getPiece(x+1,y).getColor() != color))) {
			moves.add(new Move(x,y,x+1,y));
		}
		
		if(Board.valid(x+1,y-1) && (b.isEmpty(x+1,y-1) || (!b.isEmpty(x+1,y-1) && b.getPiece(x+1,y-1).getColor() != color))) {
			moves.add(new Move(x,y,x+1,y-1));
		}

		if(Board.valid(x+1, y+1) && (b.isEmpty(x+1, y+1)|| (!b.isEmpty(x+1, y+1) && b.getPiece(x+1, y+1).getColor() != color))) {
			moves.add(new Move(x,y,x+1,y+1));
		}

		if(Board.valid(x,y-1) && (b.isEmpty(x,y-1) || (!b.isEmpty(x,y-1) && b.getPiece(x,y-1).getColor() != color))) {
			moves.add(new Move(x,y,x,y-1));
		}

		
		if(Board.valid(x-1,y) && (b.isEmpty(x-1,y) || (b.isEmpty(x-1,y) && b.getPiece(x-1,y).getColor() != color))) {
			moves.add(new Move(x,y,x-1,y));
		}

		if(Board.valid(x-1,y+1) && (b.isEmpty(x-1,y+1) || (b.isEmpty(x-1,y+1) && b.getPiece(x-1,y+1).getColor() != color))) {
			moves.add(new Move(x,y,x-1,y+1));
		}
		
		if(Board.valid(x, y+1) && (!b.isEmpty(x, y+1) || (!b.isEmpty(x, y+1) && b.getPiece(x, y+1).getColor() != color))) {
			moves.add(new Move(x,y,x,y+1));
		}
	
		if(color == Piece.WHITE) {			
			if(hasMoved == false && x == 4 && y == 0) {
				if(b.isEmpty(5, 0) && b.isEmpty(6, 0) && !b.isEmpty(7, 1-1) && b.getPiece(7, 1-1).toString().equals("ROOK")){
					moves.add(new Move(x,y,x+2,y));
				}	
						
			}
			else 
				hasMoved = true;
		}
		else { 
			if(!hasMoved && x == 4 && y == 7) {
				
			}
			else 
				hasMoved = true;
		}		
		return moves;
	}
	
	
	public String toString() {
		String piece = "king";
		
		if(color == Piece.WHITE)
			return piece.toUpperCase();
		
		return piece;
	}

}