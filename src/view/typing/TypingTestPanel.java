package view.typing;

import view.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class TypingTestPanel extends JPanel {
    private GridBagConstraints gbc;
    private TittleTyping tittleTyping;
    private BodyTyping bodyTyping;
    private FooterTyping footerTyping;
    private MyFrame view;
    public TypingTestPanel(ActionListener listener, MyFrame view) {
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        this.view = view;
        this.setPreferredSize(new Dimension(1000, 600));
        this.setMinimumSize(new Dimension(1000, 600));
        this.setMaximumSize(new Dimension(1000, 600));
        initComponents(listener);
    }

    public void initComponents(ActionListener listener){
        title(listener);
        typingTest(listener);
        footer(listener);
    }

    public void title(ActionListener listener){
        gbc.gridx = 0;
        gbc.gridy = 0;
        tittleTyping = new TittleTyping(listener);
        this.add(tittleTyping, gbc);
    }

    public void typingTest(ActionListener listener){
        gbc.gridx = 0;
        gbc.gridy = 1;
        bodyTyping = new BodyTyping((KeyListener) listener);
        this.add(bodyTyping, gbc);
    }

    public void footer(ActionListener listener){
        gbc.gridx = 0;
        gbc.gridy = 2;
        footerTyping = new FooterTyping(listener);
        this.add(footerTyping, gbc);
    }

    public TittleTyping getTittleTyping() {
        return tittleTyping;
    }

    public BodyTyping getBodyTyping() {
        return bodyTyping;
    }

    public FooterTyping getFooterTyping() {
        return footerTyping;
    }
}
