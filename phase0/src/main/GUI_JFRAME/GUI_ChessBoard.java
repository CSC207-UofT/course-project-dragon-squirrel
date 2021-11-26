package GUI_JFRAME;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_ChessBoard extends JFrame {
    // icons is an array list that store the initial stage of each pieces, note that empty space is considered as an
    // empty piece. We can, if that's the way, by changing the order of the list, to make moves.

    /*
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

     */

    // TODO: Probably will change some code below, as we need to have operation on the board
    JButton[] coords_button = new JButton[]{
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
            new JButton(), new JButton(), new JButton(), new JButton(),
    };

    String[] coords = new String[]{
            "00", "01", "02", "03", "04", "05", "06", "07",
            "10", "11", "12", "13", "14", "15", "16", "17",
            "20", "21", "22", "23", "24", "25", "26", "27",
            "30", "31", "32", "33", "34", "35", "36", "37",
            "40", "41", "42", "43", "44", "45", "46", "47",
            "50", "51", "52", "53", "54", "55", "56", "57",
            "60", "61", "62", "63", "64", "65", "66", "67",
            "70", "71", "72", "73", "74", "75", "76", "77",
    };
    public GUI_ChessBoard(){}

    void display(){
        setTitle("Chess board");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        Container contentPane = getContentPane();
        GridLayout gridLayout = new GridLayout(8, 8);

        contentPane.setLayout(gridLayout);
        /*
        int row = -1;
        for (int i = 0; i < icons.length; i++)
        {
            if(i % 8 == 0) row ++; // increment row number
            icons[i].set(i, row);
            contentPane.add(icons[i]);
        } // i
        */
        int r = -1;
        for (int j = 0; j < coords_button.length; j++){
            if(j % 8 == 0) r ++;
            coords_button[j].setBounds(j, r, contentPane.getWidth(), contentPane.getHeight());
            coords_button[j].setOpaque(false);
            coords_button[j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int w = 0; w < coords_button.length; w++) {
                        if (e.getSource() == coords_button[w]) {
                            System.out.println(coords[w]);
                        }
                    }
                }
            });
            contentPane.add(coords_button[j]);
        }

        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    // TODO: Allow pieces to move by interacting with other code, idea: by change the array of icons.

    // Here should be some code.

}
