package view.buttons;

import util.Constants;

import javax.swing.*;
import java.awt.*;

public class PrincipalButton extends JButton {

    public PrincipalButton(String text){
        super(text);
        this.setFont(new Font(Constants.getProperty("arial"), Font.BOLD, 20));
        this.setForeground(Constants.WHITE);
        this.setBackground(Constants.DARK_BLUE);
        this.setSize(450, 50);
        this.setPreferredSize(new Dimension(450, 50));
        this.setMinimumSize(new Dimension(450, 50));
        this.setMaximumSize(new Dimension(450, 50));
    }
}
