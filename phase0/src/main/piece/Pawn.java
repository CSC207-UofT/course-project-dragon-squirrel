package piece;

public class Pawn extends Piece{

    public boolean hasNotMovedDuringGame;

    public Pawn(String name, Color color){
        super(name, color);
        hasNotMovedDuringGame = true;
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        boolean solution;
        if (color == Color.WHITE) {
            solution = ((newCoorX - oldCoorX == -1 && newCoorY - oldCoorY == 0) || (newCoorX - oldCoorX == -1 && Math.abs(newCoorY - oldCoorY) == 1));
        }
        else {
            solution = ((newCoorX - oldCoorX == 1 && newCoorY - oldCoorY == 0) || (newCoorX - oldCoorX == 1 && Math.abs(newCoorY - oldCoorY) == 1));
        }
        if (solution) {
            return true;
        }
        if (hasNotMovedDuringGame) {
            if (color == Color.WHITE) {
                solution = (newCoorX - oldCoorX == -2 && newCoorY - oldCoorY == 0);
            }
            else {
                solution = (newCoorX - oldCoorX == 2 && newCoorY - oldCoorY == 0);
            }
        }

        return solution;
    }

    @Override
    public boolean hasSameColor(PieceInterface another) {
        return this.color == another.getColor();
    }
}
