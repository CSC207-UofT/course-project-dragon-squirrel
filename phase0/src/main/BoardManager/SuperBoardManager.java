package BoardManager;

import Board.*;
import piece.*;
import piece.SuperPieceDecorator;

public class SuperBoardManager extends BoardManager{

    public SuperBoardManager() {
        super(13, 10);
    }

    /**
     * @return Hp of piece at board[X][Y]
     */
    public int getHp(int X, int Y){
        SuperPieceDecorator piece = (SuperPieceDecorator) board.getPiece(X, Y);
        return piece.getHp();
    }

    /**
     * If deduct is true, subtract the hp of the attacked piece at board[newX][newY] by the attack level of the piece at
     * board [oldX][oldY]. If the hp of the attacked piece becomes less than 1, set its hp as 0. <p>
     *
     * If deduct is false, add the hp of the attacked piece by the attack level of the attacking piece. This is used in
     * undo.
     */
    public void deductOrAddHp(int oldX, int oldY, int newX, int newY, boolean deduct) {
        SuperPieceDecorator piece = (SuperPieceDecorator) board.getPiece(oldX, oldY);
        SuperPieceDecorator pieceToModify = (SuperPieceDecorator) board.getPiece(newX, newY);

        int atkLevel = piece.getAtk();
        int newHp;

        if (deduct) {
            newHp = pieceToModify.getHp() - atkLevel;
            if (newHp < 1) {
                newHp = 0;
            }
        }
        else {
            newHp = pieceToModify.getHp() + atkLevel;
        }
        pieceToModify.setHp(newHp);
    }

    /**
     * Changes Hp of the piece attacked.
     * @return true if piece has been attacked to death, false otherwise
     */
    public boolean attackToDeath(int oldX, int oldY, int newX, int newY){
        deductOrAddHp(oldX, oldY, newX, newY, true);
        SuperPieceDecorator pieceToModify = (SuperPieceDecorator) board.getPiece(newX, newY);

        return pieceToModify.getHp() < 1;
    }

//    @Override
//    public void resetMap() {
//        // instantiate white pieces and put into Map: write in health point and attack level
//        super.setPieces("w_rook_l", new SuperPieceDecorator(new Rook("w_rook_l", Color.WHITE), 4, 1));
//        super.setPieces("w_knight_l", new SuperPieceDecorator(new Knight("w_knight_l", Color.WHITE), 3, 5));
//        super.setPieces("w_bishop_l", new SuperPieceDecorator(new Bishop("w_bishop_l", Color.WHITE), 4, 1));
//        super.setPieces("w_queen", new SuperPieceDecorator(new Queen("w_queen", Color.WHITE), 2, 2));
//        super.setPieces("w_king", new SuperPieceDecorator(new King("w_king", Color.WHITE), 2, 7));
//        super.setPieces("w_bishop_r", new SuperPieceDecorator(new Bishop("w_bishop_r", Color.WHITE), 4, 1));
//        super.setPieces("w_knight_r", new SuperPieceDecorator(new Knight("w_knight_r", Color.WHITE), 3, 5));
//        super.setPieces("w_rook_r", new SuperPieceDecorator(new Rook("w_rook_r", Color.WHITE), 4, 1));
//
//        for (int i = 0; i < 10; i++) {
//            String name = "w_pawn_" + i;
//            super.setPieces(name, new SuperPieceDecorator(new Pawn(name, Color.WHITE), 5, 6));
//        }
//
//        // instantiate black pieces and put into Map: write in health point and attack level
//        super.setPieces("b_rook_l", new SuperPieceDecorator(new Rook("b_rook_l", Color.BLACK), 4, 1));
//        super.setPieces("b_knight_l", new SuperPieceDecorator(new Knight("b_knight_l", Color.BLACK), 3, 5));
//        super.setPieces("b_bishop_l", new SuperPieceDecorator(new Bishop("b_bishop_l", Color.BLACK), 4, 1));
//        super.setPieces("b_queen", new SuperPieceDecorator(new Queen("b_queen", Color.BLACK), 2, 2));
//        super.setPieces("b_king", new SuperPieceDecorator(new King("b_king", Color.BLACK), 2, 7));
//        super.setPieces("b_bishop_r", new SuperPieceDecorator(new Bishop("b_bishop_r", Color.BLACK), 4, 1));
//        super.setPieces("b_knight_r", new SuperPieceDecorator(new Knight("b_knight_r", Color.BLACK), 3, 5));
//        super.setPieces("b_rook_r", new SuperPieceDecorator(new Rook("b_rook_r", Color.BLACK), 4, 1));
//
//        for (int i = 0; i < 10; i++) {
//            String name = "b_pawn_" + i;
//            super.setPieces(name, new SuperPieceDecorator(new Pawn(name, Color.BLACK), 5, 6));
//        }
//    }
}
