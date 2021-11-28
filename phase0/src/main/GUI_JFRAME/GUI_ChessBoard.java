package GUI_JFRAME;

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

    //initialize the board
    public void ini(){
        setTitle("Chess board");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        Container contentPane = getContentPane();
        GridLayout gridLayout = new GridLayout(8, 8);

        contentPane.setLayout(gridLayout);
        add_piece();

        setSize(800, 800);
        setVisible(true);
    }

    //the method that adds piece lable to the panel
    void add_piece(){
        Container contentPane = getContentPane();
        int row = -1;
        for (int i = 0; i < icons.length; i++) {
            if (i % 8 == 0) row++; // increment row number
            icons[i].set(i, row);
            contentPane.add(icons[i]);
        }
    }
    //switch pieces position by changing the Icon array
    public void sw_piece(int startX, int startY, int targetX, int targetY){
        Container contentPane = getContentPane();
        int start = startY * 8 + startX;
        int target = targetY * 8 + targetX;
        contentPane.removeAll();
        PieceIcon target_piece = icons[target];
        icons[target] = icons[start];
        icons[start] = target_piece;
        add_piece();
    }

    //undo visualization
    public void undo(){
    }

}
