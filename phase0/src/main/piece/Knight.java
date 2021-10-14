public class Knight extends Piece{
    private String name;
    private Player owner;
    private boolean status;

    public Knight(String name, Player owner){
        super(name, owner);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        if (!super.validMove(oldCoorX, oldCoorY, newCoorX, newCoorY)) {
            return false;
        }
        int X = Math.abs(oldCoorX - newCoorX);
        int Y = Math.abs(oldCoorY - newCoorY);
        return (X == 2 && Y == 1) || (X == 1 && Y == 2);
    }
}
