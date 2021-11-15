package Command;

import BoardManager.BoardManager;

public class ChessMove {
    private final int[] oldPosition = new int[2];
    private final int[] newPosition = new int[2];
    private BoardManager BM;
    private final String oldPieceName;
    private final String newPieceName;
    private int moveType;

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
        oldPieceName = newBM.getBoard().getPiece(oldX, oldY);
        newPieceName = newBM.getBoard().getPiece(newX, newY);
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

    public String getOldPieceName(){
        return oldPieceName;
    }

    public String getNewPieceName(){
        return newPieceName;
    }

    /**
     * @return  1 if it is an attack <P>
     *          2 if it is a move <P>
     *          3 if it is a move after a successful attack
     */
    public int getMoveType() {
        return moveType;
    }

    public BoardManager getBM(){
        return this.BM;
    }

}
