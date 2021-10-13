// Represents one spot in the board and optional piece

public class Space {

    private Piece piece;    // piece occupying (or null) this space
    private int x;  // space's x coordinate
    private int y;  // space's y coordinate

    // Instantiation of space
    // @piece the piece occupying the space
    // @x space's x coordinate
    // @y space's y coordinate
    public Space(Piece piece, int x, int y){
        this.piece = this.setPiece(piece);
        this.x = this.setX(x);
        this.y = this.setY(y);
    }

    public Piece getPiece(){
        return this.piece;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
    }

    public int getX(){
        return this.x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return this.y;
    }

    public void setY(int y){
        this.y = y;
    }

}