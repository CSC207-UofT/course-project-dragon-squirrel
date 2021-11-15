import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BoardUpdater implements PropertyChangeListener {

	private BoardManager bm;

	private String[][] boardImage;

	public BoardUpdater(BoardManager bm) {
		this.bm = bm;
		boardImage = new String[8][8];
	}

//	private void updateBoardImage() {
//		boardImage = bm.getCurrentBoard();
//	}

	public void display() {
		// updateBoardImage();

		for (String[] row: boardImage) {
			for (String item: row) {
				System.out.printf("%10s" + " ", item);
			}
			System.out.println();
		}

		System.out.println("---------------------------------");
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		System.out.println("Responding...");
		System.out.println("Board, changed, updating Board Updater:");
		System.out.println(evt.getSource());
		System.out.println(evt.getPropertyName());
		System.out.println(evt.getOldValue());
		System.out.println(evt.getNewValue());

		boardImage = (String[][])evt.getNewValue();
	}
}
