package GUI_JFRAME;

import chessAI.Difficulty;

import javax.swing.*;
import java.awt.event.*;

public class LaunchPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton chess = new JButton("Chess");
    JButton chessWithAI = new JButton("Chess With AI");
    JButton SuperChess = new JButton("SuperChess");

    LaunchPage(){
        chess.setBounds(150,110, 200, 40);
        chess.setFocusable(false);
        chess.addActionListener(this);

        chessWithAI.setBounds(150,160, 200, 40);
        chessWithAI.setFocusable(false);
        chessWithAI.addActionListener(this);

        SuperChess.setBounds(150, 210, 200, 40);
        SuperChess.setFocusable(false);
        SuperChess.addActionListener(this);

        frame.add(chess);
        frame.add(SuperChess);
        frame.add(chessWithAI);
        frame.setTitle("Welcome!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Set the Action of clicking Chess Button, jump to GUI_ChessBoard
        if(e.getSource()==chess) {
            GUI_ChessBoard chess = new GUI_ChessBoard(Difficulty.NONE);
            chess.display();
            frame.setVisible(false);
        }

        //Set the Action of clicking AI Button, jump to difficulty selection window
        if(e.getSource()==chessWithAI) {
            JFrame popup = new PopUp();
            frame.setVisible(false);
        }

        //Set the action of clicking Super_Chess Button, jump to Super_Board.
        if(e.getSource()==SuperChess) {
            GUI_SuperBoard superChess = new GUI_SuperBoard();
            superChess.display();
            frame.setVisible(false);
        }
    }

    static class PopUp extends JFrame{
        JFrame frame = new JFrame();
        JButton easy = new JButton("easy");
        JButton medium = new JButton("medium");
        JButton hard = new JButton("hard");

        PopUp(){
            easy.setBounds(150,110, 200, 40);
            easy.setFocusable(false);
            easy.addActionListener(e -> {
                GUI_ChessBoard chess = new GUI_ChessBoard(Difficulty.EASY);
                chess.display();
                frame.setVisible(false);

            });

            medium.setBounds(150,160, 200, 40);
            medium.setFocusable(false);
            medium.addActionListener(e -> {
                GUI_ChessBoard chess = new GUI_ChessBoard(Difficulty.MEDIUM);
                chess.display();
                frame.setVisible(false);
            });

            hard.setBounds(150, 210, 200, 40);
            hard.setFocusable(false);
            hard.addActionListener(e -> {
                GUI_ChessBoard chess = new GUI_ChessBoard(Difficulty.HARD);
                chess.display();
                frame.setVisible(false);
            });

            frame.add(easy);
            frame.add(medium);
            frame.add(hard);
            frame.setTitle("Select difficulty");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }
}
