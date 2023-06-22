package view.panels;

import util.Constants;
import view.buttons.PrincipalButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LessonsPanel extends RightPanel {
    private JButton backMenuButton,challengeOne;
    private GridBagConstraints gbc;
    public LessonsPanel(ActionListener listener){
        gbc = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        super.setDefaultSize();
        initComponents(listener);
    }

    public void initComponents(ActionListener listener){
        title();
        challengeOne(listener);
        challengeTwo(listener);
        challengeThree(listener);
        challengeFour(listener);
        backMenuButton(listener);
    }

    public void title(){
        JLabel title = super.title(Constants.getProperty("lessons"));
        this.add(title, gbc);
    }

    public void challengeOne(ActionListener listener){
        gbc = super.gbcPrincipalButton(gbc,0,1);
        challengeOne = new PrincipalButton(Constants.getProperty("challengeOne"));
        challengeOne.setActionCommand(Constants.CHALLENGE_ONE);
        challengeOne.addActionListener(listener);
        this.add(challengeOne, gbc);
    }

    public void challengeTwo(ActionListener listener){
        gbc = super.gbcPrincipalButton(gbc,0,2);
        challengeOne = new PrincipalButton(Constants.getProperty("challengeTwo"));
        challengeOne.setActionCommand(Constants.CHALLENGE_TWO);
        challengeOne.addActionListener(listener);
        this.add(challengeOne, gbc);
    }

    public void challengeThree(ActionListener listener){
        gbc = super.gbcPrincipalButton(gbc,0,3);
        challengeOne = new PrincipalButton(Constants.getProperty("challengeThree"));
        challengeOne.setActionCommand(Constants.CHALLENGE_THREE);
        challengeOne.addActionListener(listener);
        this.add(challengeOne, gbc);
    }

    public void challengeFour(ActionListener listener){
        gbc = super.gbcPrincipalButton(gbc,0,4);
        challengeOne = new PrincipalButton(Constants.getProperty("challengeFour"));
        challengeOne.setActionCommand(Constants.CHALLENGE_FOUR);
        challengeOne.addActionListener(listener);
        this.add(challengeOne, gbc);
    }

    public void backMenuButton(ActionListener listener){
        gbc = super.gbcPrincipalButton(gbc,0,5);
        backMenuButton = new PrincipalButton(Constants.getProperty("backMenu"));
        backMenuButton.setActionCommand(Constants.BACK_MENU);
        backMenuButton.addActionListener(listener);
        this.add(backMenuButton, gbc);
    }
}
