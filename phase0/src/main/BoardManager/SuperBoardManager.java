package BoardManager;

import Board.*;
import Piece.*;
import Piece.SuperPieceDecorator;

public class SuperBoardManager extends BoardManager{

    public SuperBoardManager() {
        super(13, 10);
    }

    /**
     * This kicks in when a piece is being attacked
     */
    public void deductPieceHp(SuperPieceDecorator pieceToModify, int HpDeduction) {
        int newHp = pieceToModify.getHp() - HpDeduction;
        if (newHp < 1){
            newHp = -1;
        }
        pieceToModify.setHp(newHp);
    }

    // Changes hp of piece attacked.
    // Return true if piece has been attacked to death.
    public boolean attackToDeath(int oldX, int oldY, int newX, int newY){
        Board superBoard = super.getBoard();
        String pieceName = superBoard.getPiece(oldX, oldY);
        String pieceToAttackName = superBoard.getPiece(newX, newY);
        SuperPieceDecorator piece = (SuperPieceDecorator) getPieces().get(pieceName);
        SuperPieceDecorator pieceToAttack = (SuperPieceDecorator) getPieces().get(pieceToAttackName);
        int atkLevel = piece.getAtk();

        deductPieceHp(pieceToAttack, atkLevel);

        return atkLevel >= pieceToAttack.getHp();
    }

    @Override
    public void resetMap() {
        // instantiate white pieces and put into Map: write in health point and attack level
        super.setPieces("w_rook_l", new SuperPieceDecorator(new Rook("w_rook_l", Color.WHITE), 1, 1));
        super.setPieces("w_knight_l", new SuperPieceDecorator(new Knight("w_knight_l", Color.WHITE), 1, 1));
        super.setPieces("w_bishop_l", new SuperPieceDecorator(new Bishop("w_bishop_l", Color.WHITE), 1, 1));
        super.setPieces("w_queen", new SuperPieceDecorator(new Queen("w_queen", Color.WHITE), 1, 1));
        super.setPieces("w_king", new SuperPieceDecorator(new King("w_king", Color.WHITE), 1, 1));
        super.setPieces("w_bishop_r", new SuperPieceDecorator(new Bishop("w_bishop_r", Color.WHITE), 1, 1));
        super.setPieces("w_knight_r", new SuperPieceDecorator(new Knight("w_knight_r", Color.WHITE), 1, 1));
        super.setPieces("w_rook_r", new SuperPieceDecorator(new Rook("w_rook_r", Color.WHITE), 1, 1));

        for (int i = 0; i < 10; i++) {
            String name = "w_pawn_" + i;
            super.setPieces(name, new SuperPieceDecorator(new Pawn(name, Color.WHITE), 5, 1));
        }

        // instantiate black pieces and put into Map: write in health point and attack level
        super.setPieces("b_rook_l", new SuperPieceDecorator(new Rook("b_rook_l", Color.BLACK), 1, 1));
        super.setPieces("b_knight_l", new SuperPieceDecorator(new Knight("b_knight_l", Color.BLACK), 1, 1));
        super.setPieces("b_bishop_l", new SuperPieceDecorator(new Bishop("b_bishop_l", Color.BLACK), 1, 1));
        super.setPieces("b_queen", new SuperPieceDecorator(new Queen("b_queen", Color.BLACK), 1, 2));
        super.setPieces("b_king", new SuperPieceDecorator(new King("b_king", Color.BLACK), 1, 1));
        super.setPieces("b_bishop_r", new SuperPieceDecorator(new Bishop("b_bishop_r", Color.BLACK), 1, 1));
        super.setPieces("b_knight_r", new SuperPieceDecorator(new Knight("b_knight_r", Color.BLACK), 1, 1));
        super.setPieces("b_rook_r", new SuperPieceDecorator(new Rook("b_rook_r", Color.BLACK), 1, 1));

        for (int i = 0; i < 10; i++) {
            String name = "b_pawn_" + i;
            super.setPieces(name, new SuperPieceDecorator(new Pawn(name, Color.BLACK), 1, 1));
        }
    }
}
