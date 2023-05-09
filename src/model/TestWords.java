package model;

import view.colors.ColorCharacters;

import java.awt.*;
import java.util.ArrayList;

public class TestWords {
    private String nameTest;
    private String contentTest;
    private int correctCharacters;
    private int incorrectCharacters;
    private int ppm;
    private int wpm;
    private boolean isEnd;
    private boolean isPause;

    public String getNameTest() {
        return nameTest;
    }

    public String getContentTest() {
        return contentTest;
    }

    public boolean isEndTest() {
        return isEnd;
    }

    public void setEndTest(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public void pause(){
        isPause = !isPause;
    }

    public boolean isPause(){
        return isPause;
    }

    public ArrayList<Color> getColors(int index, char character) {
        if (index == 0) {
            ColorControl.initColorList(contentTest.length());
            isEnd = false;
        }
        ColorControl.setColors(character == contentTest.charAt(index), index);

        return ColorControl.getColorList();
    }

    public ArrayList<Color> getDefaultColorList(){
        isEnd = false;
        return ColorControl.getDefaultColorList(contentTest.length());
    }

    public int getPPM(String time) {
        ppm = 0;
        int minutes = Integer.parseInt(time.substring(0, 2));
        int seconds = Integer.parseInt(time.substring(3, 5));
        int miliseconds = Integer.parseInt(time.substring(6, 8));
        int totalSeconds = (minutes * 60) + seconds + (miliseconds / 100);
        if (totalSeconds > 0) {
            ppm = (contentTest.length() / totalSeconds) * 60;
        }
        return ppm;
    }

    public int getWPM(String time) {
        wpm = 0;
        if (getPPM(time) > 5) {
            wpm = getPPM(time) / 5;
        }
        return wpm;
    }

    public void correctCharacters(){
        for (Color color : ColorControl.getColorList()) {
            if (color == ColorCharacters.CORRECT_COLOR) {
                this.correctCharacters++;
            } else if (color == ColorCharacters.WRONG_COLOR) {
                this.incorrectCharacters++;
            }
        }
    }

    public void saveProgress(TestRecord testRecord){
        correctCharacters();
        if(testRecord.getCorrectChars() < correctCharacters && testRecord.getWpm() < wpm){
            testRecord.setCorrectChars(correctCharacters);
            testRecord.setIncorrectChars(incorrectCharacters);
            testRecord.setWpm(wpm);
            testRecord.setPpm(ppm);
        }
    }

    public int getPpm() {
        return ppm;
    }

    public int getWpm(){
        return wpm;
    }

    public int getCorrectCharacters() {
        return correctCharacters;
    }

    public int getIncorrectCharacters() {
        return incorrectCharacters;
    }
}

