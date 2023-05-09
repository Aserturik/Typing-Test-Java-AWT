package view.typing;

import view.Constants;
import view.buttons.PrincipalButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TittleTyping extends JPanel {
    private PrincipalButton backMenuButton;
    private GridBagConstraints gbc;
    private String title;

    public TittleTyping(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        this.setPreferredSize(new Dimension(1000, 100));
        this.setMinimumSize(new Dimension(1000, 100));
        this.setMaximumSize(new Dimension(1000, 100));
        initComponents(listener);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        initComponents(gg);
    }

    public void initComponents(ActionListener listener) {
        backMenuButton(listener);
    }

    public void initComponents(Graphics2D gg) {
        title(gg);
    }

    public void backMenuButton(ActionListener listener) {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 860);
        backMenuButton = new PrincipalButton(Constants.getProperty("backMenuButton"));
        backMenuButton.setActionCommand(Constants.BACK_BUTTON_TITLE);
        backMenuButton.addActionListener(listener);
        backMenuButton.setPreferredSize(new Dimension(100, 50));
        add(backMenuButton, gbc);
    }

    public void title(Graphics2D gg) {
        gg.setColor(new Color(3, 1, 56));
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font font1 = new Font(Constants.getProperty("arial"), Font.PLAIN, 32);
        gg.setFont(font1);
        gg.drawString(this.title, 230, 50);
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
