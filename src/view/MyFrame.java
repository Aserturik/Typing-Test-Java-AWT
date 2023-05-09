package view;

import view.panels.PrincipalPanel;
import view.timer.ControlTime;
import view.typing.TypingTestPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

public class MyFrame extends JFrame {
    private PrincipalPanel principalPanel;
    private TypingTestPanel typingTestPanel;
    private ControlTime controlTime;
    public MyFrame(ActionListener actionListener, Properties properties) {
        Constants.setProperties(properties);
        this.setTitle(Constants.getProperty("titleFrame"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 635);
        initComponents(actionListener);
        this.setResizable(false);
        setVisible(true);
    }

    public void initComponents(ActionListener listener){
        controlTime = new ControlTime(10, listener);
        principalPanel(listener);
        typingTestPanel(listener);
    }

    public void principalPanel(ActionListener actionListener) {
        principalPanel = new PrincipalPanel(actionListener);
        this.add(principalPanel);
    }

    public void typingTestPanel(ActionListener actionListener) {
        typingTestPanel = new TypingTestPanel(actionListener);
        this.add(typingTestPanel);
        typingTestPanel.setVisible(false);
    }

    public PrincipalPanel getPrincipalPanel(){
        return principalPanel;
    }
    public TypingTestPanel getTypingTestPanel(){
        return typingTestPanel;
    }
    public ControlTime getControlTime(){
        return controlTime;
    }

    public void showPanelLessons(){
        principalPanel.setVisible(false);
        typingTestPanel.setVisible(true);
    }

    public void showPanelPrincipal(){
        principalPanel.setVisible(true);
        typingTestPanel.setVisible(false);
    }

    public void setColorList(ArrayList<Color> colorList){
        typingTestPanel.getBodyTyping().setColorList(colorList);
    }

    public void setPPM(int ppm){
        typingTestPanel.getFooterTyping().setPPM(ppm);
    }

    public void setWPM(int wpm){
        typingTestPanel.getFooterTyping().setWPM(wpm);
    }
}
