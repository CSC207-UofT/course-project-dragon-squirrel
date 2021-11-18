package CommandFuture;

import Board.Board;
import BoardManager.BoardManager;
import piece.Piece;


public abstract class Move implements Command {

    protected final int[] oldPosition = new int[2];
    protected final int[] newPosition = new int[2];
    protected BoardManager boardManager;
    protected Board board;
    protected final Piece movedPiece;
    protected final String newPieceName;

    public Move(BoardManager newBM, int oldX, int oldY, int newX, int newY){
        boardManager = newBM;
        oldPosition[0] = oldX;
        oldPosition[1] = oldY;
        newPosition[0] = newX;
        newPosition[1] = newY;
        movedPiece = boardManager.getBoard().getPiece(oldX, oldY);
        newPieceName = boardManager.getBoard().getPiece(newX, newY);
    }

    public int getOldCoordX(){
        return oldPosition[0];
    }

    public int getOldCoordY(){
        return oldPosition[1];
    }

    public int getNewCoordX(){
        return newPosition[0];
    }

    public int getNewCoordY(){
        return newPosition[1];
    }

    public String getMovedPiece(){
        return movedPiece;
    }

    public String getNewPieceName(){
        return newPieceName;
    }


    @Override
    public abstract void execute();
    
    @Override
    public abstract void undo();
}
