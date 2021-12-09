package BoardManager;

import piece.*;

public class SuperBoardManager extends BoardManager{

    public SuperBoardManager() {
        super(13, 10);
    }

    /**
     * Instantiate the super pieces and add them to their corresponding starting positions in a 2d SuperPieceDecorator
     * array. Set this array as the board held by the Board class.
     */
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
        for (int i = 2; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                Piece2dArray[i][i] = null;
            }
        }

        Piece2dArray[0][1] = null;
        Piece2dArray[0][8] = null;
        Piece2dArray[12][1] = null;
        Piece2dArray[12][8] = null;

        board.reset(Piece2dArray);
    }

    /**
     * @return true if piece has moved during game, false otherwise.
     */
    @Override
    public boolean getHasMovedStatus(PieceInterface p) {
        return !((SuperPieceDecorator) p).hasNotMoved;
    }
}
