import Command.ChessMove;
import Controller.*;
import GUI_JFRAME.*;

import javax.swing.*;

public class GUI extends JFrame{
	private JButton startGameBtn;
	private JButton startSuperGameBtn;
	private JPanel rootPanel;
	private JTextField startXtf;
	private JTextField startYtf;
	private JTextField targetXtf;
	private JTextField targetYtf;
	private JButton moveBtn;
	private JButton undoMoveBtn;
	private JLabel startPositionLabel1;
	private JLabel startPositionLabel2;
	private JButton saveButton;
	private JButton reloadButton;
	private JTable board;

	private CommandSender cs;
	private BoardUpdater bu;


	public GUI() {
		setTitle("Chess");
		setSize(800, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(rootPanel);
		createUIComponents();
		addActionListeners();
	}

	private void createUIComponents() {

	}

	private void addActionListeners() {

		startGameBtn.addActionListener(e -> {
			cs = new CommandSender(true);
			bu = cs.getBoardUpdater();
			bu.display();
		});

		startSuperGameBtn.addActionListener(e -> {
			cs = new CommandSender(false);
			bu = cs.getBoardUpdater();
			bu.display();
		});

		undoMoveBtn.addActionListener(e -> {
			boolean undoSuccess = cs.undoMove();
			if (undoSuccess){
				bu.display();
			}
		});

		moveBtn.addActionListener(e -> {
			int startX = Integer.parseInt(startXtf.getText());
			int startY = Integer.parseInt(startYtf.getText());
			int targetX = Integer.parseInt(targetXtf.getText());
			int targetY = Integer.parseInt(targetYtf.getText());
//			boolean moveSuccess = cs.pressMove(startX, startY, targetX, targetY);
//			if (moveSuccess) {
//				bu.display();
//			}
		});

		saveButton.addActionListener(e -> {
			//serialization goes here

		});

		reloadButton.addActionListener(e -> {
			// reload goes here
		});
	}

	private void refreshBoard() {
		board.setValueAt("bb", 0, 0);
		board.setRowHeight(100);
		startGameBtn.setText("change");
	}

	public static void main(String[] args) {
		JFrame controller = new GUI();
	}
}
