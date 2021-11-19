package Command;

import BoardManager.BoardManager;
import piece.PieceInterface;

public class ChessMove {
    private final int[] oldPosition = new int[2];
    private final int[] newPosition = new int[2];
    private BoardManager BM;
    private final PieceInterface oldPiece;
    private final PieceInterface newPiece;
    private final int moveType;

    /**
     * @param typeOfMove   1 if it is an attack <P>
     *                     2 if it is a move
     *                     3 if it is a move after a successful attack
     */
    public ChessMove(BoardManager newBM, int oldX, int oldY, int newX, int newY, int typeOfMove){
        BM = newBM;
        oldPosition[0] = oldX;
        oldPosition[1] = oldY;
        newPosition[0] = newX;
        newPosition[1] = newY;
        oldPiece = newBM.getBoard().getPiece(oldX, oldY);
        newPiece = newBM.getBoard().getPiece(newX, newY);
        moveType = typeOfMove;
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

    public PieceInterface getOldPiece(){
        return oldPiece;
    }

    public PieceInterface getNewPiece(){
        return newPiece;
    }

    /**
     * @return  1 if it is an attack <P>
     *          2 if it is a move <P>
     *          3 if it is a move after a successful attack
     */
    public int getMoveType() {
        return moveType;
    }
}
