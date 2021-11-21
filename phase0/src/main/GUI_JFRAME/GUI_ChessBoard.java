package GUI_JFRAME;

import CommandFuture.Move;

import javax.swing.*;
import java.awt.*;

public class GUI_ChessBoard extends JFrame {
    // icons is an array list that store the initial stage of each pieces, note that empty space is considered as an
    // empty piece. We can, if that's the way, by changing the order of the list, to make moves.

    private PieceIcon[] icons = new PieceIcon[]{
            // white
            new PieceIcon("\u2656"), new PieceIcon("\u2658"), new PieceIcon("\u2657"),
            new PieceIcon("\u2655"), new PieceIcon("\u2654"), new PieceIcon("\u2657"),
            new PieceIcon("\u2658"), new PieceIcon("\u2656"), new PieceIcon("\u2659"),
            new PieceIcon("\u2659"), new PieceIcon("\u2659"), new PieceIcon("\u2659"),
            new PieceIcon("\u2659"), new PieceIcon("\u2659"), new PieceIcon("\u2659"),
            new PieceIcon("\u2659"),
            // empty
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "),
            // black
            new PieceIcon("\u265F"), new PieceIcon("\u265F"), new PieceIcon("\u265F"),
            new PieceIcon("\u265F"), new PieceIcon("\u265F"), new PieceIcon("\u265F"),
            new PieceIcon("\u265F"), new PieceIcon("\u265F"), new PieceIcon("\u265C"),
            new PieceIcon("\u265E"), new PieceIcon("\u265D"), new PieceIcon("\u265B"),
            new PieceIcon("\u265A"), new PieceIcon("\u265D"), new PieceIcon("\u265E"),
            new PieceIcon("\u265C")
    };

    // TODO: Probably will change some code below, as we need to have operation on the board

    public GUI_ChessBoard(){}

    void display(){
        setTitle("Chess board");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Container contentPane = getContentPane();
        GridLayout gridLayout = new GridLayout(8, 8);

        contentPane.setLayout(gridLayout);

        int row = -1;
        for (int i = 0; i < icons.length; i++)
        {
            if(i % 8 == 0) row ++; // increment row number
            icons[i].set(i, row);
            contentPane.add(icons[i]);
        } // i

        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // TODO: Allow pieces to move by interacting with other code, idea: by change the array of icons.

    // Here should be some code.

}
