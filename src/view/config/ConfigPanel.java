package view.config;

import util.Constants;
import view.buttons.PrincipalButton;
import view.panels.RightPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConfigPanel extends RightPanel {
	private static final long serialVersionUID = 1L;

	private GridBagConstraints gbc;
    private JComboBox<String> fontComboBox;
    private JComboBox<String> fontSizeComboBox;
    private PrincipalButton languageChange;
    private PrincipalButton backMenuButton;
    
    
    public ConfigPanel(ActionListener listener){
        gbc = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(488, 600));
        this.setMinimumSize(new Dimension(488, 600));
        this.setMaximumSize(new Dimension(488, 600));
        initComponents(listener);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        initComponents(gg);
    }
    public void initComponents(ActionListener listener) {
        title();
        font();
        fontComboBox();
        sizeFontComboBox(new String[]{});
        backMenuButton(listener);
    }

    public void initComponents(Graphics2D gg) {
        previewFont(gg);
        sizeTitle(gg);
    }
    
    public void title(){
        JLabel title = super.title(Constants.getProperty("settings"));
        gbc.gridy = 0;
        this.add(title, gbc);
    }

    public void font(){
        JLabel font = super.title(Constants.getProperty("font"));
        gbc.gridy = 1;
        gbc.insets = new Insets(0,0,50,0);
        this.add(font, gbc);
    }

    public void fontComboBox(){
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontComboBox = new JComboBox<String>(fonts);
        gbc.gridy = 2;
        fontComboBox.setBackground(Constants.DARK_BLUE);
        fontComboBox.setForeground(Constants.WHITE);
        this.add(fontComboBox, gbc);
    }

    public void previewFont(Graphics2D gg){
        String font = (String) fontComboBox.getSelectedItem();
        Font font1 = new Font(Constants.getProperty("arial"), Font.PLAIN, 25);
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gg.setColor(Color.WHITE);
        gg.setFont(font1);
        gg.drawString(fontComboBox.getSelectedItem().toString(), 100, 190);
        repaint();
    }

    public void sizeFontComboBox(String[] sizes){
        fontSizeComboBox = new JComboBox<String>(sizes);
        gbc.gridy = 3;
        fontSizeComboBox.setBackground(Constants.DARK_BLUE);
        fontSizeComboBox.setForeground(Constants.WHITE);
        gbc.insets = new Insets(50,180,0,0);
        this.add(fontSizeComboBox, gbc);
    }

    public void setFontSizeComboBox(String[] sizes){
        fontSizeComboBox.removeAllItems();
        for (String size : sizes) {
            fontSizeComboBox.addItem(size);
        }
    }

    public void sizeTitle(Graphics2D gg){
        Font font1 = new Font(Constants.getProperty("arial"), Font.PLAIN, 25);
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gg.setColor(Color.WHITE);
        gg.setFont(font1);
        gg.drawString(Constants.getProperty("size"), 170, 375);
        repaint();
    }

    public void backMenuButton(ActionListener listener){
        gbc = super.gbcPrincipalButton(gbc,0,5);
        backMenuButton = new PrincipalButton(Constants.getProperty("backMenu"));
        backMenuButton.setActionCommand(Constants.BACK_MENU_CONFIG);
        backMenuButton.addActionListener(listener);
        this.add(backMenuButton, gbc);
    }

    public int getFontSize(){
        return Integer.parseInt((String) fontSizeComboBox.getSelectedItem());
    }

    public String getFontUse(){
        return (String) fontComboBox.getSelectedItem();
    }
}
