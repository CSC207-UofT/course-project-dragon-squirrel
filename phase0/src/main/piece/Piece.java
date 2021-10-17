package piece;

public abstract class Piece {
    protected String name;  // ex: "w_pawn"
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

    // This can actually be done in GameRule, so I moved the code there (try not let entity enforce rules)
    // The subclasses of Piece can still override it tho
    public abstract boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY);

        // to be overridden but the first line of the overridden method can call super.validMove(...) just to check that
        // the new coordinates given are within the boundaries of the board and that the new coordinates given are a new
        // set of coordinates, return false otherwise.


}
