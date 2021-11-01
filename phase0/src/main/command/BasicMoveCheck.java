package command;

import Board.Board;
import Board.BoardManager;

public class BasicMoveCheck {
    Board board;
    BoardManager bm;
    public BasicMoveCheck(Board board, BoardManager bm){
        this.board = board;
        this.bm = bm;
    }

    /**
     * Check whether piece is moving and out of bound.
     * @return true if piece violates the above rule.
     */
    boolean checkBoundAndMove(int oldX, int oldY, int newX, int newY){
        if (oldX == newX && oldY == newY){
            return true;
        }
        return newX >= board.getBoard().length || newY >= board.getBoard()[0].length || newX >= 0 || newY >= 0;
    }

    /**
     * return ture if path is clean.
    */
    boolean isPathClear(int oldX, int oldY, int newX, int newY) {
        if (oldY == newY) {
            // vertical north and south
            for (int i = Math.min(oldX, newX) + 1; i < Math.max(oldX, newX); i++) {
                if (board.isPositionVacant(i, newY))
                    return false;
            }
        }

        if (oldX == newX) {
            // horizontal east and west
            for (int i = Math.min(oldY, newY) + 1; i < Math.max(oldY, newY); i++) {
                if (board.isPositionVacant(newX, i))
                    return false;
            }
        }

        if ((oldX < newX & oldY < newY) || (oldX > newX & oldY > newY)) {
            // diagonal northwest or southeast
            for (int i = 1; i < Math.abs(newX - oldX); i++) {
                if (board.isPositionVacant(Math.min(oldX, newX) + i, Math.min(oldY, newY) + i))
                    return false;
            }
        }

        if ((oldX > newX & oldY < newY) || (oldX < newX & oldY > newY)) {
            // diagonal northeast or southwest
            for (int i = Math.abs(newX - oldX) - 1; i > 0; i--) {
                if (board.isPositionVacant(Math.max(oldX, newX) - i, Math.min(oldY, newY) + i))
                    return false;
            }
        }

        return true;
    }

    /**
     *
     * @return true if destination is not vacant or departure has the same color with destination.
     */
    public boolean isColorSame(int oldX, int oldY, int newX, int newY) {
        if (board.getPiece(newX, newY).equals("vacant")){
            return false;
        }
        return  bm.getCorrespondPiece(newX, newY).hasSameColor(
                bm.getCorrespondPiece(oldX, oldY));
    }

    /**
     *
     * @param oldX x-coordinate of piece of being moved
     * @param oldY y-coordinate of piece of being moved
     * @param newX x-coordinate of destination
     * @param newY y-coordinate of destination
     * @return true if this move violates some basic rule of chess.
     */
    public boolean basicCheck(int oldX, int oldY, int newX, int newY){
        if (checkBoundAndMove(oldX, oldY, newX, newY)){
            return true;
        }
        // check bound and move.

        if (!isPathClear(oldX, oldY, newX, newY)){
            return true;
        }
        // check path clean.

        if (isColorSame(oldX, oldY, newX, newY)){
            return true;
        }
        // check same color.

        return false;
    }

}
