package piece;

public abstract class Piece implements PieceInterface {
    protected String name;  // ex: "w_pawn_1"
    protected Color color;    // Black or White (BLACK/WHITE)
    protected boolean status;     // This tells whether this piece has been moved during the turn

    public Piece(String name, Color color) {
        this.name = name;
        this.color = color;
        this.status = false;
    }

    public String getName() { return name; }

    public Color getColor() { return color; }

    public boolean getStatus() { return status; }

    public void setStatus(boolean status){
        this.status = status;
    }

    public abstract boolean validMove(int oldX, int oldY, int newX, int newY);

    public boolean hasSameColor(PieceInterface targetPiece) {
        return this.color == targetPiece.getColor();
    }
}
