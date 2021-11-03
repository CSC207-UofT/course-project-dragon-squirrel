package super_chess;

import board.BoardInterface;

public class SuperBoardAdapter extends SuperBoard implements SuperBoardInterface {

    BoardInterface superBoard;

    @Override
    public String[][] getSuperBoard() {
        return this.superBoard.getBoard();
    }

    @Override
    public String getSuperPiece(int X, int Y) {
        return this.superBoard.getPiece(X, Y);
    }

    @Override
    public void addSuperPiece(String pieceName, int X, int Y) {
        this.superBoard.addPiece(pieceName, X, Y);
    }

    @Override
    public String removeSuperPiece(int X, int Y) {
        return this.superBoard.removePiece(X, Y);
    }

    @Override
    public boolean isSuperPositionVacant(int X, int Y) {
        return this.superBoard.isPositionVacant(X, Y);
    }

}
