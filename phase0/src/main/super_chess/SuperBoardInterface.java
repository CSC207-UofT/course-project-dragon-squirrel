package super_chess;

public interface SuperBoardInterface {
    String[][] getSuperBoard();
    String getSuperPiece(int X, int Y);
    void addSuperPiece(String pieceName, int X, int Y);
    void removeSuperPiece(int X, int Y);
    boolean isSuperPositionVacant(int X, int Y);
    void superReset();

    // new features
}
