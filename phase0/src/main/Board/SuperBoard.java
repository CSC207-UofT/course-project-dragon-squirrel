package Board;

import piece.PieceInterface;

public class SuperBoard extends Board{

    public static String[][] superBoardLand; // Each cell contains the name of the type of land

    public SuperBoard(int column, int row) {
        super(13, 10);
        superBoardLand = new String[13][10];
        superSetLand();
    }

    /**
     * @return river, bridge, black_zone, or white_zone according to land type at superBoardLand[X][Y]
     */
    public String getLandType(int X, int Y) {return superBoardLand[X][Y];}

//    @Override
//    public void reset() {
//        PieceInterface[][] board = super.getBoard();
//        // initialize white pieces
//        super.addPiece("w_rook_l", 12, 0);
//        super.addPiece("w_knight_l", 12, 2);
//        super.addPiece("w_bishop_l", 12, 3);
//        super.addPiece("w_queen", 12, 4);
//        super.addPiece("w_king", 12, 5);
//        super.addPiece("w_bishop_r", 12, 6);
//        super.addPiece("w_knight_r", 12, 7);
//        super.addPiece("w_rook_r", 12, 9);
//
//        // initialize white pawns
//        for (int i = 0; i < 10; i++) {
//            super.addPiece("w_pawn_" + i, 11, i);
//        }
//
//        // initialize black pieces
//        super.addPiece("b_rook_l", 0, 0);
//        super.addPiece("b_knight_l", 0, 2);
//        super.addPiece("b_bishop_l", 0, 3);
//        super.addPiece("b_queen", 0, 4);
//        super.addPiece("b_king", 0, 5);
//        super.addPiece("b_bishop_r", 0, 6);
//        super.addPiece("b_knight_r", 0, 7);
//        super.addPiece("b_rook_r", 0, 9);
//
//        // initialize black pawns
//        for (int i = 0; i < 10; i++) {
//            super.addPiece("b_pawn_" + i, 1, i);
//        }
//
//        // initialize remaining board with no pieces
//        for (int i = 2; i < 11; i++) {
//            for (int j = 0; j < 10; j++) {
//                super.addPiece("vacant", i, j);
//            }
//        }
//
//        super.addPiece("vacant", 0, 1);
//        super.addPiece("vacant", 0, 8);
//        super.addPiece("vacant", 12, 1);
//        super.addPiece("vacant", 12, 8);
//    }

    public void superSetLand() {
        // river (r), bridge (b), black_zone (z), white_zone (x) ground (.)

        String s =  ".r.zzzz.r." +
                    ".r......r." +
                    "bbb....bbb" +
                    ".r......r." +
                    ".r......r." +
                    ".r..bb..r." +
                    "bbbrbbrbbb" +
                    ".r..bb..r." +
                    ".r......r." +
                    ".r......r." +
                    "bbb....bbb" +
                    ".r......r." +
                    ".r.xxxx.r.";

        // initialize type of land
        for (int k = 0; k < s.length(); k++) {
            char c = s.charAt(k);
            int i = k / 10;
            int j = k % 10;
            String land;

            if (c == 'r') {
                land = "river";
            } else if (c == 'b') {
                land = "bridge";
            } else if (c == 'z') {
                land = "black_zone";
            } else if (c == 'x') {
                land = "white_zone";
            } else {
                land = "ground";
            }

            superBoardLand[i][j] = land;
        }
    }
}
