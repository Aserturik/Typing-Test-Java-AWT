package view.panels;

import util.Constants;
import view.buttons.PrincipalButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonsPrincipalPanel extends RightPanel {
    private JButton lessonsButton,progressButton,settingsButton;

    private GridBagConstraints gbc;

    public ButtonsPrincipalPanel(ActionListener listener){
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        super.setDefaultSize();
        initComponents(listener);
    }

    public void initComponents(ActionListener listener){
        title(gbc);
        lessonsButton(listener);
        progressButton(listener);
        settingsButton(listener);
    }

    public void title(GridBagConstraints gbc){
        gbc = super.gbcTitle(gbc);
        JLabel title = super.title(Constants.getProperty("titlePanelButtons"));
        this.add(title,gbc);
    }

    public void lessonsButton(ActionListener listener){
        gbc = super.gbcPrincipalButton(gbc,0,1);
        lessonsButton = new PrincipalButton(Constants.getProperty("lessons"));
        lessonsButton.setActionCommand(Constants.LESSONS);
        lessonsButton.addActionListener(listener);
        this.add(lessonsButton, gbc);
    }

    public void progressButton(ActionListener listener){
        gbc = super.gbcPrincipalButton(gbc, 0,2);
        progressButton = new PrincipalButton(Constants.getProperty("progress"));
        progressButton.setActionCommand(Constants.PROGRESS);
        progressButton.addActionListener(listener);
        this.add(progressButton, gbc);
    }

    public void settingsButton(ActionListener listener){
        gbc = super.gbcPrincipalButton(gbc,0,3);
        settingsButton = new PrincipalButton(Constants.getProperty("settings"));
        settingsButton.setActionCommand(Constants.SETTINGS);
        settingsButton.addActionListener(listener);
        this.add(settingsButton, gbc);
    }
}
