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
            solution = ((newCoorX - oldCoorX == -1 && newCoorY - oldCoorY == 0) || (newCoorX - oldCoorX == -1 && Math.abs(newCoorY - oldCoorY) == 1));
        }
        else {
            solution = ((newCoorX - oldCoorX == 1 && newCoorY - oldCoorY == 0) || (newCoorX - oldCoorX == 1 && Math.abs(newCoorY - oldCoorY) == 1));
        }
        if (solution) {
            return true;
        }
        if (init) {
            if (isWhite) {
                solution = (newCoorX - oldCoorX == -2 && newCoorY - oldCoorY == 0);
            }
            else {
                solution = (newCoorX - oldCoorX == 2 && newCoorY - oldCoorY == 0);
            }
        }

        return solution;
    }
}
