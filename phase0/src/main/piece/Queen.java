package piece;

public class Queen extends Piece{

    public Queen(String name, Color color){
        super(name, color);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
//        if (!super.validMove(oldCoorX, oldCoorY, newCoorX, newCoorY)) {
//            return false;
//        }
        return Math.abs(oldCoorX - newCoorX) == Math.abs(oldCoorY - newCoorY) || (Math.abs(oldCoorX - newCoorX) == 0 || Math.abs(oldCoorY - newCoorY) == 0);
    }
}
