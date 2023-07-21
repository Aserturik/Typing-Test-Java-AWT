package view.panels;

import util.Constants;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

    public RightPanel(){
        this.setBackground(Constants.DARK_BLUE);
    }

    public void setDefaultSize(){
        this.setSize(488, 600);
        this.setPreferredSize(new Dimension(488, 600));
        this.setMinimumSize(new Dimension(488, 600));
        this.setMaximumSize(new Dimension(488, 600));
    }
    public JLabel title(String titleString){
        JLabel title;
        title = new JLabel(Constants.getProperty(titleString));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font(Constants.getProperty("arial"), Font.BOLD, 30));
        title.setForeground(Constants.WHITE);
        title.setSize(488, 88);
        title.setPreferredSize(new Dimension(488, 88));
        title.setMinimumSize(new Dimension(488, 88));
        title.setMaximumSize(new Dimension(488, 88));
        title.setText(Constants.getProperty(titleString));
        return title;
    }

    public GridBagConstraints gbcTitle(GridBagConstraints gbc){
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        return gbc;
    }

    public GridBagConstraints gbcPrincipalButton(GridBagConstraints gbc, int x, int y){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        return gbc;
    }

    public JLabel getTitleLabel(JLabel label){
        label.setFont(new Font(Constants.getProperty("arial"), Font.BOLD, 20));
        label.setForeground(Constants.WHITE);
        label.setSize(488, 50);
        label.setPreferredSize(new Dimension(488, 50));
        label.setMinimumSize(new Dimension(488, 50));
        label.setMaximumSize(new Dimension(488, 50));
        return label;
    }
}
