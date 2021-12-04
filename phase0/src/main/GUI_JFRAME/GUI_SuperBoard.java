package GUI_JFRAME;

import Controller.BoardUpdater;
import Controller.CommandSender;
import chessAI.Agent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class GUI_SuperBoard extends JFrame{
    private PieceIcon[] icons = new PieceIcon[]{
            //
            new PieceIcon("\u265C"), new PieceIcon(" "), new PieceIcon("\u265E"),
            new PieceIcon("\u265D"), new PieceIcon("\u265B"), new PieceIcon("\u265A"),
            new PieceIcon("\u265D"), new PieceIcon("\u265E"), new PieceIcon(" "),
            new PieceIcon("\u265C"), new PieceIcon("\u265F"), new PieceIcon("\u265F"),
            new PieceIcon("\u265F"), new PieceIcon("\u265F"), new PieceIcon("\u265F"),
            new PieceIcon("\u265F"), new PieceIcon("\u265F"), new PieceIcon("\u265F"),
            new PieceIcon("\u265F"), new PieceIcon("\u265F"),
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
            // white
            new PieceIcon("\u2659"), new PieceIcon("\u2659"), new PieceIcon("\u2659"),
            new PieceIcon("\u2659"), new PieceIcon("\u2659"), new PieceIcon("\u2659"),
            new PieceIcon("\u2659"), new PieceIcon("\u2659"), new PieceIcon("\u2659"),
            new PieceIcon("\u2659"), new PieceIcon("\u2656"), new PieceIcon(" "),
            new PieceIcon("\u2658"), new PieceIcon("\u2657"), new PieceIcon("\u2655"),
            new PieceIcon("\u2654"), new PieceIcon("\u2657"), new PieceIcon("\u2658"),
            new PieceIcon(" "), new PieceIcon("\u2656"),
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

    public GUI_SuperBoard(){

        cs = new CommandSender(false);
        bu = cs.getBoardUpdater();


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
        setTitle("Super board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Color brown_background = new Color(140, 100, 60);
        Color white_background = new Color(243, 225, 204);
        Color blue_background = new Color(84, 249, 255);
        Color green_background = new Color(144, 255, 110);

        GridLayout gridLayout = new GridLayout(13, 10);

        contentPane.setLayout(gridLayout);
        contentPane.setBounds(0, 20, 800, 800);
        int row = -1;
        int col;
        for (int i = 0; i < icons.length; i++) {
            col = i % 10; // increment column number
            if(i % 10 == 0) row ++; // increment row number
            icons[i].setSuper();
            if (row == 0 || row == 12) {
                if (col == 1 || col == 8) {
                    icons[i].setBackground(blue_background);
                }
                else if (col > 2 && col < 7) {
                    icons[i].setBackground(green_background);
                } else {icons[i].setBackground(white_background);}
            }
            if (row == 1 || (row > 2 && row < 6) || (row > 6 && row < 10) || row == 11) {
                icons[i].setBackground((col == 1 || col == 8) ? blue_background : white_background);
            }
            if (row == 2 || row == 10) {
                icons[i].setBackground((col < 3 || col > 6) ? brown_background : white_background);
            }
            if (row == 6) {
                icons[i].setBackground((col == 3 || col == 6) ? blue_background : brown_background);
            }
            contentPane.add(icons[i]);
        }

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
        int row = index / 10;
        int col = index % 10;

        return new Point(row, col);
    }

    private int coordinateToIndex(Point p) {
        return p.x * 10 + p.y;
    }

    private void showValidMove(int x, int y) {

        unHighlightAll();
        List<Point> validMoves = cs.passValidMove(new Point(x, y));
        for (Point position: validMoves) {
            icons[coordinateToIndex(position)].setHighlighted(true);
        }
    }

    private void updateBoardInfo(String[][] unicode) {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 10; j++) {
                Point coordinate = new Point(i, j);
                icons[coordinateToIndex(coordinate)].setText(unicode[i][j]);
            }
        }
    }
}
