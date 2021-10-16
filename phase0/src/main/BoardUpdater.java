public class BoardUpdater {

	private BoardManager bm;

	private String[][] boardImage;

	public BoardUpdater(BoardManager bm) {
		this.bm = bm;
		boardImage = new String[8][8];

//		boardImage = new String[][]{
//				{"Rook", "Knight", "Bishop", "Queen", "King", "Bishop", "Knight", "Rook"},
//				{"Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn"},
//				{null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null},
//				{"Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn"},
//				{"Rook", "Knight", "Bishop", "Queen", "King", "Bishop", "Knight", "Rook"}
//		};
	}

	private void updateBoardImage() {
		boardImage = bm.getCurrentBoard();
	}

	public void display() {
		updateBoardImage();

		for (String[] row: boardImage) {
			for (String item: row) {
				System.out.printf("%10s" + " ", item);
			}
			System.out.println();
		}

		System.out.println("---------------------------------");
	}
}
