package model;

public class TestRecord {
    private int correctChars, incorrectChars, ppm, wpm;

    public TestRecord(int correctChars, int incorrectChars, int ppm, int wpm) {
        this.correctChars = correctChars;
        this.incorrectChars = incorrectChars;
        this.ppm = ppm;
        this.wpm = wpm;
    }

    public int getCorrectChars() {
        return correctChars;
    }

    public void setCorrectChars(int correctChars) {
        this.correctChars = correctChars;
    }

    public void setIncorrectChars(int incorrectChars) {
        this.incorrectChars = incorrectChars;
    }

    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public int getWpm() {
        return wpm;
    }

    public void setWpm(int wpm) {
        this.wpm = wpm;
    }
}
