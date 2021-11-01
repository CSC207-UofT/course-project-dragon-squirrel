package piece;

public class Rook extends Piece{

    public boolean hasMovedDuringGame;

    public Rook(String name, Color color){
        super(name, color);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        return Math.abs(oldCoorX - newCoorX) == 0 || Math.abs(oldCoorY - newCoorY) == 0;
    }

    @Override
    public boolean hasSameColor(PieceInterface another) {
        return this.color == another.getColor();
    }
}
