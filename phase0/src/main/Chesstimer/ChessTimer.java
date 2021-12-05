package Chesstimer;

import piece.Color;

import java.util.Timer;
import java.util.TimerTask;
/**
 * This is a timer for chess game. And it contains two timer, one for white player and the other for black player.
 */
public class ChessTimer {
    Timer timer;
    private long blackRemainTime;
    private long whiteRemainTime;
    TimerTask timerTask;
    Color activeTimerColor = Color.WHITE;

    public ChessTimer(long blackRemainTime, long whiteRemainTime){
        this.blackRemainTime = blackRemainTime;
        this.whiteRemainTime = whiteRemainTime;
    }

    /**
     * Subtract one second from whiteRemainTime for every second that passes.
     */
    private class whiteTimerTask extends TimerTask{
        @Override
        public void run(){
            whiteRemainTime --;
            if (whiteRemainTime == 0){
                cancel();
            }
        }
    }

    /**
     * Subtract one second from blackRemainTime for every second that passes.
     */
    private class blackTimerTask extends TimerTask{
        @Override
        public void run(){
            blackRemainTime --;
            if (blackRemainTime == 0){
                cancel();
            }
        }
    }

    public long getBlackRemainTime(){
        return blackRemainTime;
    }

    public long getWhiteRemainTime(){
        return whiteRemainTime;
    }

    public void startBlackTimer(){
        timer = new Timer();
        timerTask = new blackTimerTask();
        timer.schedule(timerTask, 0,1000L);
    }

    public void startWhiteTimer(){
        timer = new Timer();
        timerTask = new whiteTimerTask();
        timer.schedule(timerTask, 0,1000L);
    }

    public void pauseTimer(){
        timer.cancel();
    }

    public void stopTimer(){
        if (timer != null){
            timer.cancel();
        }
    }

    /**
     * When a new game start, start this timer.
     */
    public void startTimer(){
        startWhiteTimer();
    }

    /**
     * Switch timer each turn.
     */
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
}
