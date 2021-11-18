package CommandFuture;

import Board.Board;
import java.awt.Point;


public abstract class Move implements Command {

    protected final Point oldPosition;
    protected final Point newPosition;
    protected Board board;
    protected final String actionPiece;

    public Move(Board board, int oldX, int oldY, int newX, int newY){
        this.board = board;
        oldPosition = new Point(oldX, oldY);
        newPosition = new Point(newX, newY);
        actionPiece = board.getPiece(oldX, oldY);
    }

    public String getActionPiece() {
        return actionPiece;
    }

    @Override
    public abstract void execute();
    
    @Override
    public abstract void undo();
}
