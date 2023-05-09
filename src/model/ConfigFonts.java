package model;

public class ConfigFonts {
    private int sizeFont;
    private String font;
    private String[] fontSizes;

    public ConfigFonts(int sizeFont, String font, String[] fontSizes) {
        this.sizeFont = sizeFont;
        this.font = font;
        this.fontSizes = fontSizes;
    }

    public int getSizeFont() {
        return sizeFont;
    }

    public String getFont() {
        return font;
    }

    public String[] getFontSizes() {
        return fontSizes;
    }

    public void setSizeFont(int sizeFont) {
        this.sizeFont = sizeFont;
    }

    public void setFontUse(String fontUse) {
        this.font = fontUse;
    }
}
