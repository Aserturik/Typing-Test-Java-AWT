package view.panels;

import view.Constants;

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel {
    private ImageIcon logoIcon;

    public LogoPanel() {
        this.setSize(512, 600);
        this.setPreferredSize(new Dimension(512, 600));
        this.setMinimumSize(new Dimension(512, 600));
        this.setMaximumSize(new Dimension(512, 600));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.setBackground(Constants.WHITE);
        title(gbc);
        logo(gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {

    }

    public void title(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel title = new JLabel(Constants.getProperty("titleLogoPanel"));
        title.setFont(new Font(Constants.getProperty("arial"), Font.BOLD, 30));
        title.setForeground(Constants.DARK_BLUE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setSize(512, 88);
        title.setPreferredSize(new Dimension(512, 88));
        title.setMinimumSize(new Dimension(512, 88));
        title.setMaximumSize(new Dimension(512, 88));
        this.add(title, gbc);
    }

    public void logo(GridBagConstraints gbc) {
        logoIcon = new ImageIcon(Constants.getProperty("logo"));
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setSize(logoIcon.getIconWidth(), logoIcon.getIconHeight());
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(logoLabel,gbc);
    }
}
