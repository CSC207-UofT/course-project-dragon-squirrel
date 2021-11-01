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
	}

	private void createUIComponents() {

	}

	private void addActionListeners() {

		startGameBtn.addActionListener(e -> {
			cs = new CommandSender();
			cs.startNewGame();
			bu = cs.getBoardUpdater();
			bu.display();
		});

		moveBtn.addActionListener(e -> {
			int startX = Integer.parseInt(startXtf.getText());
			int startY = Integer.parseInt(startYtf.getText());
			int targetX = Integer.parseInt(targetXtf.getText());
			int targetY = Integer.parseInt(targetYtf.getText());
			boolean moveSuccess = cs.makeMove(startX, startY, targetX, targetY);
			if (moveSuccess) {
				bu.display();
			}
		});

	}

	private void refreshBoard() {
		board.setValueAt("bb", 0, 0);
		board.setRowHeight(100);
		startGameBtn.setText("change");
	}

	public static void main(String[] args) {
		JFrame window = new GUI();
	}
}
