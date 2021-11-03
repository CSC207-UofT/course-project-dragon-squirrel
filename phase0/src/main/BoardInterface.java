
public interface BoardInterface {
    String[][] getBoard(); // not for superchess
    void addPiece(String pieceName, int X, int Y);
    String removePiece(int X, int Y);
    boolean isPositionVacant(int X, int Y);
    String getPiece(int X, int Y);
    void reset(); // not for superchess
}
