public class Piece {
    private String name;
    private Player owner;
    private boolean status;     // This tells whether this piece has been moved during the turn

    public Piece(String name, Player owner) {
        status = false;
    }

//    public move(int x, int y) {
//
//        if isValidMove()
//    }

    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        if (newCoorX > 0 & newCoorX < 9 & newCoorY > 0 & newCoorY < 9 &
                (oldCoorX != newCoorX || oldCoorY != newCoorY )) {
            return true;}
        else {
            return false;
        }
        // to be overridden but the first line of the overridden method can call super.validMove(...) just to check that
        // the new coordinates given are within the boundaries of the board and that the new coordinates given are a new
        // set of coordinates, return false otherwise.
    }

}
