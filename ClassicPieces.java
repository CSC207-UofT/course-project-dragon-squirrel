import java.util.List;

public abstract class Piece {
	//consider white = true and black = false
	public static final boolean WHITE = true, BLACK = false;

	protected boolean color;
	private int value;
	

	public Piece(boolean color) {
		this.color = color;
		value = 0;
	}
	
	public void setValue(int val) {
		this.value = val;
	}
	
	public int getValue() {
		return value;
	}

	public void setColor(boolean color){
		this.color = color;
	}

	public boolean getColor() {
		return color;
	}
	
	public abstract List<Move> GetValidMoves(Board b, int x, int y);
}