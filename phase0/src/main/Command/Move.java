package Command;

import BoardManager.BoardManager;
import piece.*;

import java.io.Serializable;

public abstract class Move implements Command, Serializable {
    protected BoardManager BM;
    protected ChessMove CM;
    protected PieceInterface actionPiece;
    protected PieceInterface targetPiece;

    public Move(BoardManager newBM){
        this.BM = newBM;
    }

    public Move(BoardManager newBM, ChessMove newChessMove){
        this.BM = newBM;
        this.CM = newChessMove;
        this.actionPiece = newChessMove.getOldPiece();
        this.targetPiece = newChessMove.getNewPiece();
    }

    @Override
    public void execute() {
        if (actionPiece.getName().contains("pawn")) {
            try {
                ((Pawn) actionPiece).hasNotMovedDuringGame = false;}
            catch (ClassCastException e){
                ((SuperPieceDecorator) actionPiece).hasNotMoved = false;
            }
        }
        if (actionPiece instanceof Rook)
            ((Rook) actionPiece).setHasMovedDuringGame(true);
        if (actionPiece instanceof King)
            ((King) actionPiece).setHasMovedDuringGame(true);
    }
    
    @Override
    public void undo() {
        if (CM.getFirstMoveStatus() && actionPiece.getName().contains("pawn")) {
            try {
                ((Pawn) actionPiece).hasNotMovedDuringGame = true;}
            catch (ClassCastException e) {
                ((SuperPieceDecorator) actionPiece).hasNotMoved = true;
            }
        }
        if (CM.getFirstMoveStatus() && actionPiece instanceof Rook) {
            ((Rook) actionPiece).setHasMovedDuringGame(false);
        }
        if (CM.getFirstMoveStatus() && actionPiece instanceof King) {
            ((King) actionPiece).setHasMovedDuringGame(false);
        }
    }
}
