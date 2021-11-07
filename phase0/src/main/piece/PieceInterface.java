package piece;

public interface PieceInterface {
    String getName();
    Color getColor();
    boolean getStatus();
    void setStatus(boolean status);
    boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY);
    boolean hasSameColor(PieceInterface targetPiece);
}
