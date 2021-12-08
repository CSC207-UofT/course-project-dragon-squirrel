package GUI_JFRAME;

import Controller.BoardUpdater;
import Controller.CommandSender;
import chessAI.Agent;
import chessAI.Difficulty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.List;

public class GUI_ChessBoard extends JFrame{
    // icons is an array list that store the initial stage of each piece, note that empty space is considered as an
    // empty piece. We can, if that's the way, by changing the order of the list, to make moves.

    private final PieceIcon[] icons = new PieceIcon[]{
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

    private final Container contentPane = new Container();

    private final JMenuBar bar = new JMenuBar();

    private final JMenu file = new JMenu("File");
    private final JMenu pref = new JMenu("Preference");

    private final JMenuItem save = new JMenuItem("save");
    private final JMenuItem reload = new JMenuItem("reload");
    private final JMenuItem undo = new JMenuItem("undo");

    private void set_bar(){
        save.addActionListener(e -> {
            // save
            cs.saveGame();
            JOptionPane.showMessageDialog(this, "Game saved");
        });

        reload.addActionListener(e -> {
            // reload
            cs.loadGame();
            updateBoardInfo(bu.getBoardImageAsUnicode());
            if (ai != null)
                ai.reloadAI();
            JOptionPane.showMessageDialog(this, "Game loaded");
        });

        file.add(save);
        file.add(reload);
        file.add(undo);

        bar.add(file); bar.add(pref);
        bar.setVisible(true);
        bar.setBounds(0, 0, 800, 20);
    }

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
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {}

                @Override
                public void mouseExited(MouseEvent e) {}
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

    /**
     * Unselect all tiles on the board
     */
    private void unselectAll() {
        for (PieceIcon icon: icons) {
            icon.setSelected(false);
        }
    }

    /**
     * Unhighlight all tiles on the board
     */
    private void unHighlightAll() {
        for (PieceIcon icon: icons) {
            icon.setHighlighted(false);
        }
    }

    /**
     * Convert array index to 2d array coordinate
     */
    private Point indexToCoordinate(int index) {
        return new Point(index / 8, index % 8);
    }

    /**
     * Convert 2d array coordinate to array index
     */
    private int coordinateToIndex(Point p) {
        return p.x * 8 + p.y;
    }

    /**
     * Assume icons[x][y] is a piece, show its valid moves
     */
    private void showValidMove(int x, int y) {
        unHighlightAll();
        List<Point> validMoves = cs.passValidMove(new Point(x, y));
        for (Point position: validMoves) {
            icons[coordinateToIndex(position)].setHighlighted(true);
        }
    }

    /**
     * Refresh the board in gui with the unicode info
     * @param unicode   The unicode representation of board, provided by BoardUpdater
     */
    private void updateBoardInfo(String[][] unicode) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Point coordinate = new Point(i, j);
                icons[coordinateToIndex(coordinate)].setText(unicode[i][j]);
            }
        }
    }
}