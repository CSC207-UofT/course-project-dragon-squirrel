public class Rook extends Piece{
    private String name;
    private Player owner;
    private boolean status;

    public Rook(String name, Player owner){
        super(name, owner);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        if (!super.validMove(oldCoorX, oldCoorY, newCoorX, newCoorY)) {
            return false;
        }
        return Math.abs(oldCoorX - newCoorX) == 0 || Math.abs(oldCoorY - newCoorY) == 0;
    }
}
