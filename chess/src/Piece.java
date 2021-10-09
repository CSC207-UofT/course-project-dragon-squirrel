public class Piece {
    private String name;
    private Player owner;
    private boolean status;     // This tells whether this piece has been moved during the turn

    public Piece(String name, Player owner) {
        status = false;
    }
}
