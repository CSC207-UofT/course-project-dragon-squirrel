package Piece;
public class Bishop extends Piece{

    public Bishop(String name, Color color){
        super(name, color);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        return Math.abs(oldCoorX - newCoorX) == Math.abs(oldCoorY - newCoorY);
    }
}
