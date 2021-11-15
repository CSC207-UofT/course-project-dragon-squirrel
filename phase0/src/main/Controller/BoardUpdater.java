package Controller;

import BoardManager.*;

public class BoardUpdater {

	private BoardManager bm;

	private String[][] boardImage;

	public BoardUpdater(BoardManager bm) {
		this.bm = bm;
		boardImage = new String[8][8];
	}

	public BoardUpdater(SuperBoardManager bm) {
		this.bm = bm;
		boardImage = new String[13][10];
	}

	public String[][] getBoardImage(){
		return this.boardImage;
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
