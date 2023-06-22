package view.timer;

import util.Constants;

import javax.swing.Timer;
import java.awt.event.ActionListener;

public class ControlTime extends Timer {
    private String timeString;
    private int minutes = 0;
    private int seconds = 0;
    private int milliseconds = 0;
    public ControlTime(int delay, ActionListener listener) {
        super(delay, listener);
        this.setActionCommand(Constants.TIMER);
        timeString = Constants.getProperty("timeString");
    }

    @Override
    public void start() {
        super.start();
    }

    public String getTimeString() {
        milliseconds ++;
        if (milliseconds == 100) {
            seconds++;
            milliseconds = 0;
        }
        if (seconds == 60) {
            minutes++;
            seconds = 0;
        }
        if (minutes == 60) {
            minutes = 0;
        }
        timeString = (minutes <= 9 ? "0" : "") + minutes + ":" + (seconds <= 9 ? "0" : "") + seconds + ":" + (milliseconds <= 9 ? "0" : "") + milliseconds;
        return timeString;
    }

    public void resetTime(){
        minutes = 0;
        seconds = 0;
        milliseconds = 0;
    }

    public String getTime(){
        return timeString;
    }
}