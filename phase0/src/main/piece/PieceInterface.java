package piece;

public interface PieceInterface {
    String getName();
    Color getColor();
    boolean getStatus();
    void setStatus(boolean status);
    //boolean hasSameColor(Piece another);  // tricky
    boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY);
}
