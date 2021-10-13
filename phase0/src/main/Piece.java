// An abstract class that respresents the commonality of all pieces.
// The abstract methods are implemented by the children classes.s

public class Piece {

    private boolean white;  // Whether piece is white or not
    private boolean alive;   // Whether piece is alive or not

    // Instantiates a piece
    // @white whether piece is white or not
    // @alive whether piece is alive or not
    public Piece(boolean white, boolean alive) {
        this.white = this.setWhite(white);
        this.alive = this.setAlive(alive);
    }

    // @return whether piece is white or not
    public boolean isWhite(){
        return this.white;
    }

    // set piece as white or not
    // @white whether piece is white or not
    public void setWhite(boolean white){
        this.white = white;
    }

    // @return whether piece is alive or not
    public boolean isAlive() {
        return this.alive;
    }

    // set piece as alive or not
    // @alive whether piece is alive or not
    public void setAlive(boolean alive){
        this.alive = alive;
    }

    // each subclass of piece will implement their own validMove
    // Board will handle outside of board boundaries error
    // @board board that the game is taking place on
    // @start starting space
    // @end ending space
    // @return whether move is valid or not
    public abstract boolean validMove(Board board, Space start, Space end);

}
