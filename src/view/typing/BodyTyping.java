package view.typing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import view.colors.ColorCharacters;

public class BodyTyping extends JPanel {
    private GridBagConstraints gbc;
    private JTextArea textArea;
    private String text,fontUse;
    private ArrayList<Color> colorList;
    private boolean isStart;
    private int fontSize;

    public BodyTyping(KeyListener listener){
        this.setPreferredSize(new Dimension(1000, 400));
        this.setMinimumSize(new Dimension(1000, 400));
        this.setMaximumSize(new Dimension(1000, 400));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.gray);
        gbc = new GridBagConstraints();
        initComponents(listener);
        this.addKeyListener(listener);
        colorList = new ArrayList<Color>();
        isStart = false;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        initComponents(gg);
    }

    public void initComponents(KeyListener listener){
        textArea(listener);
    }

    public void initComponents(Graphics2D gg){
        text(gg);
    }

    public void textArea(KeyListener listener){
        textArea = new JTextArea();
        textArea.setMinimumSize(new Dimension(800, 20));
        textArea.setPreferredSize(new Dimension(800, 20));
        textArea.setMaximumSize(new Dimension(800, 20));
        textArea.addKeyListener(listener);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(200, 0, 0, 0);
        this.add(textArea, gbc);
    }

    public void clearTextArea(){
        textArea.setText("");
    }

    public void text(Graphics2D gg){
        gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font font1 = new Font(fontUse, Font.PLAIN, fontSize);
        gg.setFont(font1);
        if(!isStart){
            setColorListDefault();
        }

        for(int i = 0; i < text.length(); i++){
            gg.setColor(colorList.get(i));
            int x = i;
            int y = 100;
            if (i>=25 && i<50){
                y += 50;
                x -= 25;
            }else if (i>=50 && i<75) {
                y += 100;
                x -= 50;
            }else if (i>=75 && i<100) {
                y += 150;
                x -= 75;
            }
            if(text.substring(i, i+1).equals(" ")){
                gg.drawString("_", 100 + (x*gg.getFont().getSize()), y);
            }else {
                gg.drawString(text.substring(i, i + 1), 100 + (x * (gg.getFont().getSize())), y);
            }
        }

        this.isStart = true;
    }

    public void setColorListDefault(){
        for(int i = 0; i < text.length(); i++){
            colorList.add(ColorCharacters.DEFAULT_COLOR);
        }
    }

    public void setText(String text){
        this.text = text;
    }

    public void setColorList(ArrayList<Color> colorList){
        this.colorList = colorList;
        repaint();
    }

    public void setFontSize(int fontSize){
        this.fontSize = fontSize;
    }

    public void setFontUse(String fontUse){
        this.fontUse = fontUse;
    }
}
