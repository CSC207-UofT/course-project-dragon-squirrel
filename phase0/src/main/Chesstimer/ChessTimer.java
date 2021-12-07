package Chesstimer;

import piece.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.Timer;

public class ChessTimer implements Serializable {
    private int blackRemainTime;
    private int whiteRemainTime;
    private final static int ONE_SECOND = 1000;
    Color activeTimerColor;
    ActionListener whiteTimerListener = new whiteTimerListener();
    ActionListener blackTimerListener = new blackTimerListener();
    Timer whiteTimer = new Timer(ONE_SECOND, whiteTimerListener);
    Timer blackTimer = new Timer(ONE_SECOND, blackTimerListener);

    public ChessTimer(){
        blackRemainTime = 600 * ONE_SECOND;
        whiteRemainTime = 600 * ONE_SECOND;
        activeTimerColor = Color.WHITE;
    }

    public int getWhiteRemainTime() {
        return whiteRemainTime;
    }

    public int getBlackRemainTime() {
        return blackRemainTime;
    }

    public Color getActiveTimerColor(){
        return activeTimerColor;
    }

    public void startWhiteTimer(){
        whiteTimer.setRepeats(true);
        whiteTimer.setInitialDelay(0);
        whiteTimer.start();
    }

    public void startBlackTimer(){
        blackTimer.setRepeats(true);
        blackTimer.setInitialDelay(0);
        blackTimer.start();
    }

    public void pauseTimer(){
        if (whiteTimer.isRunning()){
            whiteTimer.stop();
        }
        if (blackTimer.isRunning()) {
            blackTimer.stop();
        }
    }

    public void switchTimer(){
        pauseTimer();
        if (activeTimerColor.equals(Color.WHITE)){
            startBlackTimer();
            activeTimerColor = Color.BLACK;
        }
        else {
            startWhiteTimer();
            activeTimerColor = Color.WHITE;
        }
    }

    public class whiteTimerListener implements ActionListener, Serializable {

        @Override
        public void actionPerformed(ActionEvent e) {
            whiteRemainTime--;
        }
    }

    public class blackTimerListener implements ActionListener, Serializable {

        @Override
        public void actionPerformed(ActionEvent e) {
            blackRemainTime--;
        }
    }

}
