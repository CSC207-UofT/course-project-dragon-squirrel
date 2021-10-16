import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
	private JButton startGameBtn;
	private JPanel rootPanel;
	private JTextField startXtf;
	private JTextField startYtf;
	private JTextField targetXtf;
	private JTextField targetYtf;
	private JButton moveBtn;
	private JLabel startPositionLabel1;
	private JLabel startPositionLabel2;
	private JTable board;

	private CommandSender cs;
	private BoardUpdater bu;

	public GUI() {
		setTitle("Chess");
		setSize(800, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		add(rootPanel);
		createUIComponents();
		addActionListeners();

		cs = new CommandSender();
		bu = cs.getBoardUpdater();
	}

	private void createUIComponents() {

	}

	private void addActionListeners() {

		startGameBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cs.startNewGame();
				bu.display();
			}
		});

		moveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int startX = Integer.parseInt(startXtf.getText());
				int startY = Integer.parseInt(startYtf.getText());
				int targetX = Integer.parseInt(targetXtf.getText());
				int targetY = Integer.parseInt(targetYtf.getText());
				boolean moveSuccess = cs.makeMove(startX, startY, targetX, targetY);
				if (moveSuccess) {
					bu.display();
				}
			}
		});

	}

	private void refreshBoard() {
		board.setValueAt("bb", 0, 0);
		board.setRowHeight(100);
		startGameBtn.setText("change");
//		String[] colName = {null, null, null, null, null, null, null, null};
//		String[][] boardContent = {
//				{"Rook", "Knight", "Bishop", "Queen", "King", "Bishop", "Knight", "Rook"},
//				{"Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn"},
//				{null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null},
//				{null, null, null, null, null, null, null, null},
//				{"Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn", "Pawn"},
//				{"Rook", "Knight", "Bishop", "Queen", "King", "Bishop", "Knight", "Rook"}
//		};
////
//		board = new JTable(new DefaultTableModel(boardContent, colName));
//		board.setRowHeight(50);
	}

	public static void main(String[] args) {
		JFrame window = new GUI();
	}
}
