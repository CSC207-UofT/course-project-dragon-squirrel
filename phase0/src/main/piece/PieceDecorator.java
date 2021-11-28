package piece;

import java.awt.Point;

import java.util.List;

import Board.Board;

import Board.BoardInterface;

public class PieceDecorator implements PieceInterface {
    private Piece piece;

    public PieceDecorator(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String getName() {
        return piece.getName();
    }

    @Override
    public Color getColor() {
        return piece.getColor();
    }

    @Override
    public boolean getStatus() {
        return piece.getStatus();
    }

    @Override
    public void setStatus(boolean status) {
        piece.setStatus(status);
    }

    @Override
    public boolean validMove(int oldX, int oldY, int newX, int newY) {
        return piece.validMove(oldX, oldY, newX, newY);
    }

    @Override
	public List<Point> getValidMoves(BoardInterface b, int x, int y){
    	return piece.getValidMoves(b, x, y);
    }
    
    @Override
    public boolean withinBoundary(int x, int y, BoardInterface b) {
    	return piece.withinBoundary(x, y, b);
    }
    
    @Override
    public boolean isOpponentPiece(int x, int y, BoardInterface b) {
    	return piece.isOpponentPiece(x, y, b);
    }
    @Override
    public boolean isBlack() {
        return piece.isBlack();
    }

    @Override
    public boolean isWhite() {
        return piece.isWhite();
    }

    @Override
    public boolean hasSameColor(PieceInterface targetPiece) {
        return piece.hasSameColor(targetPiece);
    }
}
