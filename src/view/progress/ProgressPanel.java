package view.progress;

import util.Constants;
import view.buttons.PrincipalButton;
import view.panels.RightPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProgressPanel extends RightPanel {
    private PrincipalButton backMenuButton;
    private GridBagConstraints gbc;
    private JLabel titleChallenge;
    private ProgressSubPanel pSPOne, pSPTwo, pSPThree, pSPFour;
    public ProgressPanel(ActionListener listener) {
        this.setSize(488, 1500);
        this.setMinimumSize(new Dimension(488, 1500));
        this.setMaximumSize(new Dimension(488, 1500));
        this.setPreferredSize(new Dimension(488, 1500));
        super.setDefaultSize();
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        initComponents(listener);
    }

    public void initComponents(ActionListener listener){
        setProgressOne();
        setProgressTwo();
        setProgressThree();
        setProgressFour();
        backMenuButton(listener);
    }

    public void setProgressOne(){
        titleChallenge = new JLabel(Constants.getProperty("maxChallengeOne"));
        titleChallenge = super.getTitleLabel(titleChallenge);
        gbc = super.gbcPrincipalButton(gbc,0,1);
        gbc.insets = new Insets(0, 60, 0, 0);
        this.add(titleChallenge, gbc);
        pSPOne = new ProgressSubPanel();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(pSPOne, gbc);
    }

    public void setProgressTwo(){
        titleChallenge = new JLabel(Constants.getProperty("maxChallengeTwo"));
        titleChallenge = super.getTitleLabel(titleChallenge);
        gbc = super.gbcPrincipalButton(gbc,0,3);
        gbc.insets = new Insets(0, 60, 0, 0);
        this.add(titleChallenge, gbc);
        pSPTwo = new ProgressSubPanel();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(pSPTwo, gbc);
    }

    public void setProgressThree(){
        titleChallenge = new JLabel(Constants.getProperty("maxChallengeThree"));
        titleChallenge = super.getTitleLabel(titleChallenge);
        gbc = super.gbcPrincipalButton(gbc,0,5);
        gbc.insets = new Insets(0, 60, 0, 0);
        this.add(titleChallenge, gbc);
        pSPThree = new ProgressSubPanel();
        gbc = super.gbcPrincipalButton(gbc,0,6);
        add(pSPThree, gbc);
    }

    public void setProgressFour(){
        titleChallenge = new JLabel(Constants.getProperty("maxChallengeFour"));
        titleChallenge = super.getTitleLabel(titleChallenge);
        gbc = super.gbcPrincipalButton(gbc,0,7);
        gbc.insets = new Insets(0, 60, 0, 0);
        this.add(titleChallenge, gbc);
        pSPFour = new ProgressSubPanel();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(pSPFour, gbc);
    }

    public void backMenuButton(ActionListener listener){
        gbc = super.gbcPrincipalButton(gbc,0,9);
        backMenuButton = new PrincipalButton(Constants.getProperty("backMenu"));
        backMenuButton.setActionCommand(Constants.BACK_MENU);
        backMenuButton.addActionListener(listener);
        this.add(backMenuButton, gbc);
    }

    public ProgressSubPanel getPSP(int index){
        switch (index){
            case 0:
                return pSPOne;
            case 1:
                return pSPTwo;
            case 2:
                return pSPThree;
            case 3:
                return pSPFour;
            default:
                return null;
        }
    }
}
