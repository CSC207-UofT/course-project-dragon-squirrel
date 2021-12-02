package GUI_JFRAME;

import Controller.BoardUpdater;
import Controller.CommandSender;
import chessAI.Agent;
import chessAI.Difficulty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class GUI_ChessBoard extends JFrame {
    // icons is an array list that store the initial stage of each piece, note that empty space is considered as an
    // empty piece. We can, if that's the way, by changing the order of the list, to make moves.

    private PieceIcon[] icons = new PieceIcon[]{
            //
            new PieceIcon("\u265C"), new PieceIcon("\u265E"), new PieceIcon("\u265D"),
            new PieceIcon("\u265B"), new PieceIcon("\u265A"), new PieceIcon("\u265D"),
            new PieceIcon("\u265E"), new PieceIcon("\u265C"), new PieceIcon("\u265F"),
            new PieceIcon("\u265F"), new PieceIcon("\u265F"), new PieceIcon("\u265F"),
            new PieceIcon("\u265F"), new PieceIcon("\u265F"), new PieceIcon("\u265F"),
            new PieceIcon("\u265F"),
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
            // white
            new PieceIcon("\u2659"), new PieceIcon("\u2659"), new PieceIcon("\u2659"),
            new PieceIcon("\u2659"), new PieceIcon("\u2659"), new PieceIcon("\u2659"),
            new PieceIcon("\u2659"), new PieceIcon("\u2659"),
            new PieceIcon("\u2656"), new PieceIcon("\u2658"), new PieceIcon("\u2657"),
            new PieceIcon("\u2655"), new PieceIcon("\u2654"), new PieceIcon("\u2657"),
            new PieceIcon("\u2658"), new PieceIcon("\u2656"),
    };

    private final CommandSender cs;
    private final BoardUpdater bu;
    private Point prevSelected;
    private Agent ai;

    private Container contentPane = new Container();

    private JMenuBar bar = new JMenuBar();

    private JMenu file = new JMenu("File");
    private JMenu pref = new JMenu("Preference");

    private JMenuItem save = new JMenuItem("save");
    private JMenuItem reload = new JMenuItem("reload");
    private JMenuItem undo = new JMenuItem("undo");

    private void set_bar(){
        save.addActionListener(e -> {
            // save
            System.out.println("Test save");


        });

        reload.addActionListener(e -> {
            // reload
            System.out.println("Test reload");


        });

        file.add(save); file.add(reload); file.add(undo);

        bar.add(file); bar.add(pref);
        bar.setVisible(true);
        bar.setBounds(0, 0, 800, 20);
    }


    // TODO: Probably will change some code below, as we need to have operation on the board

    public GUI_ChessBoard(Difficulty AISetting){

        cs = new CommandSender(true);
        bu = cs.getBoardUpdater();

        if (AISetting != Difficulty.NONE)
            ai = new Agent(cs, AISetting);

        set_bar();
        add(bar);

        undo.addActionListener(e -> {
            boolean undoSuccess = cs.undoMove();
            if (undoSuccess) {
                updateBoardInfo(bu.getBoardImageAsUnicode());
            }
        });

        // Add listener to every PieceIcon
        for (int i = 0; i < icons.length; i++) {
            int finalI = i;     // intelliJ suggests me to write this
            icons[i].addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    Point clicked = indexToCoordinate(finalI);
                    PieceIcon clickedIcon = icons[finalI];

                    // When clicked on a previously highlighted tile, make a move
                    if (clickedIcon.highlighted) {
                        unselectAll();
                        unHighlightAll();
                        cs.pressMove(prevSelected.x, prevSelected.y, clicked.x, clicked.y);
                        updateBoardInfo(bu.getBoardImageAsUnicode());

                        if (ai != null) {
                            ai.makeMove();
                            updateBoardInfo(bu.getBoardImageAsUnicode());
                        }
                    }
                    // Click on a piece, show available moves
                    else if (!clickedIcon.getText().equals(" ")) {
                        unselectAll();
                        unHighlightAll();
                        clickedIcon.setSelected(true);
                        showValidMove(clicked.x, clicked.y);
                        prevSelected = clicked;
                    }
                    // Clicking for fun, unselect and unhighlight everything else
                    else if (clickedIcon.getText().equals(" ")) {
                        unselectAll();
                        unHighlightAll();
                        clickedIcon.setSelected(true);
                    }
                    else
                        System.out.println("we re not expecting this");
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });

        }
    }

    void display(){
        setTitle("Chess board");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        GridLayout gridLayout = new GridLayout(8, 8);

        contentPane.setLayout(gridLayout);
        contentPane.setBounds(0, 20, 800, 800);
        int row = -1;
        for (int i = 0; i < icons.length; i++)
        {
            if(i % 8 == 0) row ++; // increment row number
            icons[i].set(i, row);
            contentPane.add(icons[i]);
        } // i

        add(contentPane);
        setSize(800, 820);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void unselectAll() {
        for (PieceIcon icon: icons) {
            icon.setSelected(false);
        }
    }

    private void unHighlightAll() {
        for (PieceIcon icon: icons) {
            icon.setHighlighted(false);
        }
    }

    private Point indexToCoordinate(int index) {
        int row = index / 8;
        int col = index % 8;

        return new Point(row, col);
    }

    private int coordinateToIndex(Point p) {
        return p.x * 8 + p.y;
    }

    private void showValidMove(int x, int y) {

        unHighlightAll();
        List<Point> validMoves = cs.passValidMove(new Point(x, y));
        for (Point position: validMoves) {
            icons[coordinateToIndex(position)].setHighlighted(true);
        }
    }

    private void updateBoardInfo(String[][] unicode) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Point coordinate = new Point(i, j);
                icons[coordinateToIndex(coordinate)].setText(unicode[i][j]);
            }
        }
    }

    // TODO: Allow pieces to move by interacting with other code, idea: by change the array of icons.

    // Here should be some code.

}