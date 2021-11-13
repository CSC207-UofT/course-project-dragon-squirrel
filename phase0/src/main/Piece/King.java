package Piece;

public class King extends Piece{

    public boolean hasMovedDuringGame;

    public King(String name, Color color){
        super(name, color);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        return Math.abs(oldCoorX - newCoorX) <= 1 && Math.abs(oldCoorY - newCoorY) <= 1;

        //TODO: what if we are castling
    }
}
