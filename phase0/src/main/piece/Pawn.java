public class Pawn extends Piece{
    private String name;
    private Player owner;
    private boolean status;
    public boolean init;
    private final boolean isWhite;

    public Pawn(String name, Player owner, boolean whiteOrNot){
        super(name, owner);
        init = true;
        isWhite = whiteOrNot;
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        if (!super.validMove(oldCoorX, oldCoorY, newCoorX, newCoorY)) {
            return false;
        }
        boolean solution;
        if (isWhite) {
            solution = ((newCoorY - oldCoorY == -1 && newCoorX - oldCoorX == 0) || (newCoorY - oldCoorY == -1 && Math.abs(newCoorX - oldCoorX) == 1));
        }
        else {
            solution = ((newCoorY - oldCoorY == 1 && newCoorX - oldCoorX == 0) || (newCoorY - oldCoorY == 1 && Math.abs(newCoorX - oldCoorX) == 1));
        }
        if (solution) {
            return true;
        }
        if (init) {
            if (isWhite) {
                solution = (newCoorY - oldCoorY == -2 && newCoorX - oldCoorX == 0);
            }
            else {
                solution = (newCoorY - oldCoorY == 2 && newCoorX - oldCoorX == 0);
            }
        }

        return solution;
    }
}
