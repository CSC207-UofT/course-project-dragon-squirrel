package Command;

import BoardManager.*;
import piece.PieceInterface;

public abstract class Move implements Command{
    protected BoardManager BM;
    protected ChessMove CM;
    protected PieceInterface actionPiece;
    protected PieceInterface targetPiece;

    public Move(BoardManager newBM){
        this.BM = newBM;
    }

    public Move(BoardManager newBM, ChessMove newChessRule){
        this.BM = newBM;
        this.CM = newChessRule;
        this.actionPiece = newChessRule.getOldPiece();
        this.targetPiece = newChessRule.getNewPiece();
    }

    @Override
    public abstract void execute();
    
    @Override
    public abstract void undo();
}
