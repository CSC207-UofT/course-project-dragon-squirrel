public class ModifiedPiece extends Piece{
    private int hp;
    private int atk;

    public ModifiedPiece(String name, Player owner) {
        super(name, owner);
        // Generate hp & atk according to name
    }
}
