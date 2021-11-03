package super_chess;

public interface SuperBoardInterface {

    // adapted methods
    String getSuperPiece(int X, int Y);
    String addSuperPiece();
    void removeSuperPiece();
    boolean isSuperPositionVacant();

    // new features
    String[][] getSuperBoard();
    void superReset();

}
