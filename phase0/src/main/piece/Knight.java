package piece;

public class Knight extends Piece{

    public Knight(String name, Color color){
        super(name, color);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        int X = Math.abs(oldCoorX - newCoorX);
        int Y = Math.abs(oldCoorY - newCoorY);
        return (X == 2 && Y == 1) || (X == 1 && Y == 2);
    }
}
