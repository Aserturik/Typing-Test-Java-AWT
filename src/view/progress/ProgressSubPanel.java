package view.progress;

import view.Constants;

import javax.swing.*;
import java.awt.*;

public class ProgressSubPanel extends JPanel {
    private int ppmInt, wpmInt, correctCharsInt,incorrectCharsInt;

    public ProgressSubPanel() {
        this.setSize(488, 70);
        this.setMinimumSize(new Dimension(488, 70));
        this.setMaximumSize(new Dimension(488, 70));
        this.setPreferredSize(new Dimension(488, 70));
        this.setBackground(Constants.LIGHT_GREEN);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        gg.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.setFont(new Font(Constants.getProperty("arial"), Font.BOLD, 15));
        gg.setColor(Constants.WHITE);
        initComponents(gg);
    }

    public void initComponents(Graphics2D gg){
        PPM(gg);
        WPM(gg);
        correctChars(gg);
        incorrectChars(gg);
    }

    public void PPM(Graphics2D gg){
        gg.drawString(Constants.getProperty("ppm") + " " + ppmInt, 20, 25);
    }

    public void WPM(Graphics2D gg){
        gg.drawString(Constants.getProperty("wpm") + " " + wpmInt, 250, 25);
    }

    public void correctChars(Graphics2D gg){
        gg.drawString(Constants.getProperty("correctChars") + " " + correctCharsInt, 20, 50);
    }

    public void incorrectChars(Graphics2D gg){
        gg.drawString(Constants.getProperty("incorrectChars") + " " + incorrectCharsInt, 250, 50);
    }
    public void setPPMInt(int ppmInt) {
        this.ppmInt = ppmInt;
    }

    public void setWPMInt(int wpmInt) {
        this.wpmInt = wpmInt;
    }

    public void setCorrectCharsInt(int correctCharsInt) {
        this.correctCharsInt = correctCharsInt;
    }

    public void setIncorrectCharsInt(int incorrectCharsInt) {
        this.incorrectCharsInt = incorrectCharsInt;
    }
}
