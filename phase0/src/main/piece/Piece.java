package piece;

public abstract class Piece{
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

    public boolean hasSameColor(Piece another) { return this.color == another.color; }

    public abstract boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY);

}
