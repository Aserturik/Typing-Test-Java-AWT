package view.panels;

import view.MyFrame;
import view.config.ConfigPanel;
import view.progress.ProgressPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PrincipalPanel extends JPanel {
    private GridBagConstraints gbc;
    private LogoPanel logoPanel;
    private ButtonsPrincipalPanel buttonsPrincipalPanel;
    private LessonsPanel lessonsPanel;
    private ConfigPanel configPanel;
    private ProgressPanel progressPanel;
    private MyFrame view;

    public PrincipalPanel(ActionListener listener, MyFrame view) {
        setSize(1000, 600);
        this.view = view;
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        logoPanel = new LogoPanel();
        buttonsPrincipalPanel = new ButtonsPrincipalPanel(listener);
        lessonsPanel = new LessonsPanel(listener);
        configPanel = new ConfigPanel(listener);
        progressPanel = new ProgressPanel(listener);
        logoPanel();
        lessonsPanel();
        configPanel();
        progressPanel();
        lessonsPanel.setVisible(false);
        configPanel.setVisible(false);
        progressPanel.setVisible(false);
        buttonsPrincipalPanel();
    }

    public void showMenu() {
        lessonsPanel.setVisible(false);
        configPanel.setVisible(false);
        progressPanel.setVisible(false);
        buttonsPrincipalPanel.setVisible(true);
    }

    public void logoPanel() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(logoPanel, gbc);
    }

    // metodo para el gbc de la derecha
    public void rightGBC() {
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
    }

    public void buttonsPrincipalPanel() {
        rightGBC();
        this.add(buttonsPrincipalPanel, gbc);
    }

    public void lessonsPanel() {
        rightGBC();
        this.add(lessonsPanel, gbc);
    }

    public void showLessons() {
        buttonsPrincipalPanel.setVisible(false);
        lessonsPanel.setVisible(true);
    }

    public void configPanel() {
        rightGBC();
        this.add(configPanel, gbc);
    }

    public void showConfig() {
        buttonsPrincipalPanel.setVisible(false);
        configPanel.setVisible(true);
    }
    
    public String languageChange() {
		return configPanel.languageChange();
	}

    public void progressPanel() {
        rightGBC();
        this.add(progressPanel, gbc);
    }

    public void showProgress() {
        buttonsPrincipalPanel.setVisible(false);
        configPanel.setVisible(false);
        lessonsPanel.setVisible(false);
        progressPanel.setVisible(true);
    }

    public ProgressPanel getProgressPanel() {
        return progressPanel;
    }

    public void setSizesFont(String[] sizes) {
        configPanel.setFontSizeComboBox(sizes);
    }
    
    public ConfigPanel getConfigPanel() {
		return configPanel;
	}

    public int getFontSize() {
        return configPanel.getFontSize();
    }

    public String getFontUse() {
        return configPanel.getFontUse();
    }
}
