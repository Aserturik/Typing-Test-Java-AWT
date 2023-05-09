package view.typing;

import view.Constants;
import view.buttons.TypingButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FooterTyping extends JPanel {
    private String timerString;
    private int ppm, wpm;
    private boolean isStart;
    private GridBagConstraints gbc;
    private TypingButton pauseButton;

    public FooterTyping(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(1000, 150));
        this.setMinimumSize(new Dimension(1000, 150));
        this.setMaximumSize(new Dimension(1000, 150));
        this.setBackground(Color.black);
        gbc = new GridBagConstraints();
        isStart = true;

        initComponents(listener);
        if (isStart) {
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        initComponents(gg);
    }

    public void initComponents(ActionListener listener) {
        pauseButton(listener);
        restartButton(listener);
    }

    public void initComponents(Graphics2D gg) {
        timer(gg);
        pPM(gg);
        wPM(gg);
    }

    public void timer(Graphics2D gg) {
        gg.setColor(new Color(255, 255, 255));
        gg.setFont(new Font(Constants.getProperty("arial"), Font.BOLD, 30));
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gg.drawString(timerString, 140, 75);
    }

    public void pauseButton(ActionListener listener) {
        pauseButton = new TypingButton(Constants.getProperty("pauseButton"), Constants.PAUSE, listener);
        pauseButton.setSizes(150, 50);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridheight = 2;
        gbc.insets = new Insets(0, 250, 25, 0);
        this.add(pauseButton, gbc);
    }

    public TypingButton getPauseButton() {
        return pauseButton;
    }

    public void restartButton(ActionListener listener) {
        TypingButton restartButton = new TypingButton(Constants.getProperty("restartButton"),Constants.RESTART, listener);
        restartButton.setSizes(150, 50);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.gridheight = 2;
        gbc.insets = new Insets(0, 10, 25, 250);
        this.add(restartButton, gbc);
    }

    public void pPM(Graphics2D gg) {
        gg.setColor(new Color(255, 255, 255));
        gg.setFont(new Font(Constants.getProperty("arial"), Font.BOLD, 18));
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gg.drawString(Constants.getProperty("ppm") + this.ppm, 700, 48);
    }

    public void setPPM(int ppm){
        this.ppm = ppm;
        repaint();
    }

    public void wPM(Graphics2D gg) {
        gg.setColor(new Color(255, 255, 255));
        gg.setFont(new Font(Constants.getProperty("arial"), Font.BOLD, 18));
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gg.drawString(Constants.getProperty("wpm") + this.wpm, 700, 80);
    }

    public void setWPM(int wpm){
        this.wpm = wpm;
        repaint();
    }

    public void setTimerString(String timerString) {
        this.timerString = timerString;
        repaint();
    }
}
