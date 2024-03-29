package Global;
public class Cronometer {
    private long initialTime;
    private long pausedTime;
    private static Cronometer instance;

    private Cronometer() {

    }

    public static Cronometer getInstance() {
        return instance == null ? instance = new Cronometer() : instance;
    }

    public void start() {
        initialTime = System.currentTimeMillis();
        pausedTime = 0;
    }

    public void pauseTime() {
        pausedTime = System.currentTimeMillis() - initialTime;
    }

    public void continueTime() {
        initialTime = System.currentTimeMillis() - pausedTime;
        pausedTime = 0;
    }
    public String getTime() {
        long time = System.currentTimeMillis() - initialTime;
        int hours = (int) (time / 3600000);
        int minutes = (int) (time / 60000);
        int seconds = (int) ((time % 60000) / 1000);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public int getSeconds() {
        long time = System.currentTimeMillis() - initialTime;
        int seconds = (int) ((time % 60000) / 1000);
        return seconds;
    }

    public void resetTime() {
        initialTime = 0;
        pausedTime = 0;
    }
}

