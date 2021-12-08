package Controller;

import BoardManager.*;

public class BoardUpdater{

	private BoardManager bm;

	private String[][] boardImage;
	private final int[] boundary;

	public BoardUpdater(BoardManager bm) {
		this.bm = bm;
		boundary = new int[]{8, 8};
		boardImage = new String[8][8];
	}

	public BoardUpdater(SuperBoardManager bm) {
		this.bm = bm;
		boundary = new int[]{13, 10};
		boardImage = new String[13][10];
	}

	/**
	 * For deserialization only, load the sava game
	 */
	public void loadBoardManager(BoardManager bm) {
		this.bm = bm;
	}

	/**
	 * Get the newest info from BoardManager, store them in boardImage
	 */

	private void updateBoardImage() {
		boardImage = bm.getBoardAsString();
	}

	/**
	 * @return The current boardImage but in 2d unicode array format
	 */
	public String[][] getBoardImageAsUnicode() {
		updateBoardImage();

		String[][] unicodeArray = new String[boundary[0]][boundary[1]];

		for (int i = 0; i < boundary[0]; i++) {
			for (int j = 0; j < boundary[1]; j++) {
				String piece = boardImage[i][j];
				String pieceUnicode = "";

				if (piece.contains("w_")) {
					if (piece.contains("king"))
						pieceUnicode = "\u2654";
					if (piece.contains("queen"))
						pieceUnicode = "\u2655";
					if (piece.contains("rook"))
						pieceUnicode = "\u2656";
					if (piece.contains("bishop"))
						pieceUnicode = "\u2657";
					if (piece.contains("knight"))
						pieceUnicode = "\u2658";
					if (piece.contains("pawn"))
						pieceUnicode = "\u2659";
				} else if (piece.contains("b_")) {
					if (piece.contains("king"))
						pieceUnicode = "\u265A";
					if (piece.contains("queen"))
						pieceUnicode = "\u265B";
					if (piece.contains("rook"))
						pieceUnicode = "\u265C";
					if (piece.contains("bishop"))
						pieceUnicode = "\u265D";
					if (piece.contains("knight"))
						pieceUnicode = "\u265E";
					if (piece.contains("pawn"))
						pieceUnicode = "\u265F";
				} else
					pieceUnicode = " ";

				unicodeArray[i][j] = pieceUnicode;
			}
		}

		return unicodeArray;
	}
}
