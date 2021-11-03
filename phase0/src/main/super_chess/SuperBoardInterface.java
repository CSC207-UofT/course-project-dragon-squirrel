package super_chess;

public interface SuperBoardInterface {

    // adapted methods
    String[][] getSuperBoard();
    String getSuperPiece(int X, int Y);
    void addSuperPiece(String pieceName, int X, int Y);
    String removeSuperPiece(int X, int Y);
    boolean isSuperPositionVacant(int X, int Y);

    // new methods
    void superReset();

}
