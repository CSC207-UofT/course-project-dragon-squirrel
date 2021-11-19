package BoardManager;

import piece.*;

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

    @Override
    public void resetBoard() {
        SuperPieceDecorator[][] Piece2dArray = new SuperPieceDecorator[13][10];

        // initialize white pieces
        Piece2dArray[12][0] = new SuperPieceDecorator(new Rook("rook_l", Color.WHITE), 4, 1);
        Piece2dArray[12][2] = new SuperPieceDecorator(new Knight("knight_l", Color.WHITE), 3, 5);
        Piece2dArray[12][3] = new SuperPieceDecorator(new Bishop("bishop_l", Color.WHITE), 4, 1);
        Piece2dArray[12][4] = new SuperPieceDecorator(new Queen("queen", Color.WHITE), 2, 2);
        Piece2dArray[12][5] = new SuperPieceDecorator(new King("king", Color.WHITE), 2, 7);
        Piece2dArray[12][6] = new SuperPieceDecorator(new Bishop("bishop_r", Color.WHITE), 4, 1);
        Piece2dArray[12][7] = new SuperPieceDecorator(new Knight("knight_r", Color.WHITE), 3, 5);
        Piece2dArray[12][9] = new SuperPieceDecorator(new Rook("rook_r", Color.WHITE), 4, 1);

        // initialize white pawns
        for (int i = 0; i < 10; i++) {
            String name = "pawn_" + i;
            Piece2dArray[11][i] = new SuperPieceDecorator(new Pawn(name, Color.WHITE), 5, 6);
        }

        // initialize black pieces
        Piece2dArray[0][0] = new SuperPieceDecorator(new Rook("rook_l", Color.BLACK), 4, 1);
        Piece2dArray[0][2] = new SuperPieceDecorator(new Knight("knight_l", Color.BLACK), 3, 5);
        Piece2dArray[0][3] = new SuperPieceDecorator(new Bishop("bishop_l", Color.BLACK), 4, 1);
        Piece2dArray[0][4] = new SuperPieceDecorator(new Queen("queen", Color.BLACK), 2, 2);
        Piece2dArray[0][5] = new SuperPieceDecorator(new King("king", Color.BLACK), 2, 7);
        Piece2dArray[0][6] = new SuperPieceDecorator(new Bishop("bishop_r", Color.BLACK), 4, 1);
        Piece2dArray[0][7] = new SuperPieceDecorator(new Knight("knight_r", Color.BLACK), 3, 5);
        Piece2dArray[0][9] = new SuperPieceDecorator(new Rook("rook_r", Color.BLACK), 4, 1);

        // initialize black pawns
        for (int i = 0; i < 10; i++) {
            String name = "pawn_" + i;
            Piece2dArray[1][i] = new SuperPieceDecorator(new Pawn(name, Color.BLACK), 5, 6);
        }

        // initialize remaining board with no pieces
        for (int i = 2; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                Piece2dArray[i][i] = null;
            }
        }

        Piece2dArray[0][1] = null;
        Piece2dArray[0][8] = null;
        Piece2dArray[12][1] = null;
        Piece2dArray[12][8] = null;

        board.reset(Piece2dArray);
    }
}
