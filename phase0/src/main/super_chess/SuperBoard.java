package super_chess;

public abstract class SuperBoard implements SuperBoardInterface{

    private String[][] superBoard; // Each cell contains the name of the piece
    public static String[][] superBoardLand; // Each cell contains the name of the type of land

    public SuperBoard() {
        superBoard = new String[13][10];
        superBoardLand = new String[13][10];
        superReset();
        superSetLand();
    }

    public String[][] getSuperBoardLand() {
        return superBoardLand;
    }

    public String getLand(int X, int Y) {
        return superBoardLand[X][Y];
    }

    @Override
    public void superReset() {
        // initialize white pieces
        superBoard[12][0] = "w_rook_l";
        superBoard[12][2] = "w_knight_l";
        superBoard[12][3] = "w_bishop_l";
        superBoard[12][4] = "w_queen";
        superBoard[12][5] = "w_king";
        superBoard[12][6] = "w_bishop_r";
        superBoard[12][7] = "w_knight_r";
        superBoard[12][9] = "w_rook_r";

        // initialize white pawns
        for (int i = 0; i < 10; i++) {
            superBoard[11][i] = "w_pawn_" + i;
        }

        // initialize black pieces
        superBoard[0][0] = "b_rook_l";
        superBoard[0][2] = "b_knight_l";
        superBoard[0][3] = "b_bishop_l";
        superBoard[0][4] = "b_queen";
        superBoard[0][5] = "b_king";
        superBoard[0][6] = "b_bishop_r";
        superBoard[0][7] = "b_knight_r";
        superBoard[0][9] = "b_rook_r";

        // initialize black pawns
        for (int i = 0; i < 10; i++) {
            superBoard[1][i] = "b_pawn_" + i;
        }

        // initialize remaining board with no pieces
        for (int i = 2; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                superBoard[i][j] = "vacant";
            }
        }

        superBoard[0][1] = "vacant";
        superBoard[0][8] = "vacant";
        superBoard[12][1] = "vacant";
        superBoard[12][8] = "vacant";
    }

    public void superSetLand() {
        // water (w), bridge (b), safe (s), ground (.)

        String s =  "w..ssss..w" +
                ".w......w." +
                "bbb....bbb" +
                ".w......w." +
                ".w......w." +
                "bwb.bb.bwb" +
                "bbbwbbwbbb" +
                "bwb.bb.bwb" +
                ".w......w." +
                ".w......w." +
                "bbb....bbb" +
                ".w......w." +
                "w..ssss..w";

        // initialize type of land
        for (int k = 0; k < s.length(); k++) {
            char c = s.charAt(k);
            int i = k / 10;
            int j = k % 10;
            String land;

            if (c == 'w') {
                land = "water";
            } else if (c == 'b') {
                land = "bridge";
            } else if (c == 's') {
                land = "safe";
            } else {
                land = "ground";
            }

            superBoardLand[i][j] = land;
        }
    }
}
