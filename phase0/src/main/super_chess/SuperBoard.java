package super_chess;

public interface SuperBoard {
    String[][] getSuperBoard();
    String getSuperPiece();
    String addSuperPiece();
    void removeSuperPiece();
    boolean isSuperPositionVacant();
    void superReset();

    // new features
}
