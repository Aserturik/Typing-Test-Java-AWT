package view.buttons;

import view.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TypingButton extends JButton {
    public TypingButton(String text,String actionCommand, ActionListener listener){
        super(text);
        this.addActionListener(listener);
        this.setActionCommand(actionCommand);
        this.setForeground(Color.WHITE);
        this.setFont(new Font(Constants.getProperty("arial"), Font.PLAIN, 20));
        initComponent();
    }

    public void initComponent(){
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBorder(BorderFactory.createLineBorder(Color.BLUE));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBorder(BorderFactory.createLineBorder(Color.white));
            }
        });
    }
    public void setSizes(int width, int height){
        this.setPreferredSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
    }
}
