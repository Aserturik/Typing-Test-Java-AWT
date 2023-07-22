package view;

import presenter.Contract;
import util.Constants;
import view.panels.PrincipalPanel;
import view.typing.TypingTestPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

public class MyFrame extends JFrame implements Contract.View {
    private PrincipalPanel principalPanel;
    private TypingTestPanel typingTestPanel;
    private Contract.Presenter presenter;
    
    public MyFrame(ActionListener actionListener, Properties properties) {
    	Constants.setProperties(properties);
        this.setTitle(Constants.getProperty("titleFrame"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 635);
        initComponents(actionListener);
        this.setResizable(false);
        setVisible(true);
    }
    
    public void initComponents(ActionListener listener) {
        //controlTime = new ControlTime(10, listener);
        // en vez del control time debe ir el timer
        principalPanel(listener);
        typingTestPanel(listener);
    }

    public void principalPanel(ActionListener actionListener) {
        principalPanel = new PrincipalPanel(actionListener, this);
        this.add(principalPanel);
    }

    public void typingTestPanel(ActionListener actionListener) {
        typingTestPanel = new TypingTestPanel(actionListener, this);
        this.add(typingTestPanel);
        typingTestPanel.setVisible(false);
    }

    public PrincipalPanel getPrincipalPanel() {
        return principalPanel;
    }

    public TypingTestPanel getTypingTestPanel() {
        return typingTestPanel;
    }
    @Override
    public void showPanelLessons() {
        principalPanel.setVisible(false);
        typingTestPanel.setVisible(true);
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void showPanelPrincipal() {
        principalPanel.setVisible(true);
        typingTestPanel.setVisible(false);
    }

    @Override
    public void showLessons() {
        showPanelPrincipal();
        principalPanel.showLessons();
    }

    @Override
    public void pauseTimer() {
        typingTestPanel.getFooterTyping().getPauseButton().setText("Reanudar");
        //getControlTime().stop();
    }

    @Override
    public void reanudeTimer() {
        typingTestPanel.getFooterTyping().getPauseButton().setText("Pausar");
        //getControlTime().start();
    }

    @Override
    public void restart(){
        //getControlTime().resetTime();
        //getTypingTestPanel().getFooterTyping().setTimerString(properties.getProperty("timeString"));
        getTypingTestPanel().getBodyTyping().clearTextArea();
        //setColorList(controlModel.getListDefaultColor(indexTest));
        setPPM(0);
        setWPM(0);
    }


    public void setColorList(ArrayList<Color> colorList) {
        typingTestPanel.getBodyTyping().setColorList(colorList);
    }

    public void setPPM(int ppm) {
        typingTestPanel.getFooterTyping().setPPM(ppm);
    }

    public void setWPM(int wpm) {
        typingTestPanel.getFooterTyping().setWPM(wpm);
    }
    
    public void closeApp() {
    	JOptionPane.showMessageDialog(this, Constants.getProperty("messageRestart"),null, JOptionPane.WARNING_MESSAGE);
    	this.dispose();
	}
}
