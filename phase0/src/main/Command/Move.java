package Command;

import BoardManager.BoardManager;
import piece.Pawn;
import piece.PieceInterface;

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
        if (actionPiece instanceof Pawn)
            ((Pawn) actionPiece).hasNotMovedDuringGame = false;

        System.out.println("Black remain time: " + BM.getTimer().getBlackRemainTime() + "s");
        System.out.println("White remain time: " + BM.getTimer().getWhiteRemainTime() + "s");
    }
    
    @Override
    public void undo() {
        if (CM.getFirstMoveStatus() && actionPiece instanceof Pawn) {
            ((Pawn) actionPiece).hasNotMovedDuringGame = true;
        }

        System.out.println("Black remain time: " + BM.getTimer().getBlackRemainTime() + "s");
        System.out.println("White remain time: " + BM.getTimer().getWhiteRemainTime() + "s");
    }
}
