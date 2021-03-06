package GUI_JFRAME;

import Controller.BoardUpdater;
import Controller.CommandSender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.List;

public class GUI_SuperBoard extends JFrame{
    private final PieceIcon[] icons = new PieceIcon[]{
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

    private final Container contentPane = new Container();

    private final JMenuBar bar = new JMenuBar();

    private final JMenu file = new JMenu("File");
    private final JMenu pref = new JMenu("Preference");

    private final JMenuItem save = new JMenuItem("save");
    private final JMenuItem reload = new JMenuItem("reload");
    private final JMenuItem undo = new JMenuItem("undo");
    private final JMenuItem instructions = new JMenuItem("instructions");
    private final JMenuItem attackAndHealthTable = new JMenuItem("hp and atk lvl");

    /**
     * Set up the menu bar
     */
    private void set_bar(){
        save.addActionListener(e -> {
            // save
            System.out.println("Test save");


        });

        reload.addActionListener(e -> {
            // reload
            System.out.println("Test reload");


        });

        instructions.addActionListener(e -> {
            SuperChessInstructions superChessInstructions = new SuperChessInstructions();
            superChessInstructions.display();
            contentPane.setVisible(true);
        });

        attackAndHealthTable.addActionListener(e -> {
            SuperChessInstructions superChessInstructions = new SuperChessInstructions();
            superChessInstructions.displayTable();
            contentPane.setVisible(true);
        });

        file.add(save); file.add(reload); file.add(undo); file.add(instructions); file.add(attackAndHealthTable);

        bar.add(file); bar.add(pref);
        bar.setVisible(true);
        bar.setBounds(0, 0, 800, 20);
    }

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

    /**
     * Display this window
     */
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
        return new Point(index / 10, index % 10);
    }

    /**
     * Convert 2d array coordinate to array index
     */
    private int coordinateToIndex(Point p) {
        return p.x * 10 + p.y;
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
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 10; j++) {
                Point coordinate = new Point(i, j);
                icons[coordinateToIndex(coordinate)].setText(unicode[i][j]);
            }
        }
    }
}
