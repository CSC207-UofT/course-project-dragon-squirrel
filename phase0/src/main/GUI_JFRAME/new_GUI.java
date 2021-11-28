package GUI_JFRAME;

import Controller.BoardUpdater;
import Controller.CommandSender;

import javax.swing.*;
import java.awt.*;


public class new_GUI extends JFrame{
    private JButton newButton;
    private JPanel Board;
    private JPanel Cmd_panel;
    private JButton reloadButton;
    private JTextField startX;
    private JTextField startY;
    private JTextField targetX;
    private JTextField targetY;
    private JButton moveButton;
    private JButton undoButton;
    private JButton saveButton;
    private JLabel Information;
    private JButton newSuperButton;
    private boolean is_new_game = true;
    private boolean is_classic;

    private PieceIcon[] icons;

    private CommandSender cs;
    private BoardUpdater bu;
    private final GUI_ChessBoard gui_board = new GUI_ChessBoard();

    void setBoard(){
        Board.add(gui_board);
        Board.setVisible(true);
    }

    private void addActionListener(){
        newButton.addActionListener(e -> {
            cs = new CommandSender(true);
            bu = cs.getBoardUpdater();
            bu.display();
            is_new_game = true;
            setBoard();
        });

        newSuperButton.addActionListener(e -> {
            cs = new CommandSender(false);
            bu = cs.getBoardUpdater();
            bu.display();
            is_new_game = true;
            setBoard();

        });

        reloadButton.addActionListener(e -> {
            is_new_game = false;
        });

        saveButton.addActionListener(e -> {
            // serialization goes here
        });

        moveButton.addActionListener(move -> {
            int start_X = Integer.parseInt(startX.getText());
            int start_Y = Integer.parseInt(startY.getText());
            int target_X = Integer.parseInt(targetX.getText());
            int target_Y = Integer.parseInt(targetY.getText());
            boolean moveSuccess = cs.pressMove(start_X, start_Y, target_X, target_Y);
            if (moveSuccess) {
                bu.display();
                gui_board.sw_piece(start_X, start_Y, target_X, target_Y);
            }

        });

        undoButton.addActionListener(e -> {
            boolean undoSuccess = cs.undoMove();
            if (undoSuccess){
                bu.display();
                // GUI_Board goes here
            }
        });
    }

    public new_GUI(){
        setTitle("Classic Chess");
        setSize(1000, 1000);
        setBoard();

        addActionListener();

        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args){
        new_GUI window = new new_GUI();
    }

}
