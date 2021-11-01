package piece;

public class Pawn extends Piece{

    private boolean hasNotMovedDuringGame;

    public Pawn(String name, Color color){
        super(name, color);
        hasNotMovedDuringGame = true;
    }

    public void setMoved(){
        hasNotMovedDuringGame = false;
    }

    public boolean getMoved(){
        return hasNotMovedDuringGame;
    }
}
