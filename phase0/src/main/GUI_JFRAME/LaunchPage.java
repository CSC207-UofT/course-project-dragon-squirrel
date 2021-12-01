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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Set the Action of clicking Chess Button, jump to GUI_ChessBoard
        if(e.getSource()==chess) {
            GUI_ChessBoard chess = new GUI_ChessBoard(Difficulty.NONE);
            chess.display();
            frame.setVisible(false);
        }

        //Set the Action of clicking Chess Button, jump to GUI_ChessBoard
        if(e.getSource()==chessWithAI) {
            GUI_ChessBoard chess = new GUI_ChessBoard(Difficulty.EASY);
            System.out.println("Now easy AI takes over black side");
            chess.display();
            frame.setVisible(false);
        }

        //Set the action of clicking Super_Chess Button, jump to Super_Board.
        if(e.getSource()==SuperChess) {
            GUI_SuperBoard superChess = new GUI_SuperBoard();
            frame.setVisible(false);
        }
    }
}
