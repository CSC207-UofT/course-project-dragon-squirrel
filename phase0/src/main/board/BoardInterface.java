package board;

public interface BoardInterface {

    String[][] getBoard();
    void addPiece(String pieceName, int X, int Y);
    String removePiece(int X, int Y);
    boolean isPositionVacant(int X, int Y);
    String getPiece(int X, int Y);
    void reset();
}
