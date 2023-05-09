package model;

import view.colors.ColorCharacters;

import java.awt.*;
import java.util.ArrayList;

public class ColorControl {
    public static ArrayList<Color> colorList = new ArrayList<>();

    public static void initColorList(int size) {
        for(int i = 0; i < size; i++){
            colorList.add(ColorCharacters.DEFAULT_COLOR);
        }
    }

    public static void setColors(boolean isCorrect, int index) {
        if (isCorrect) {
            colorList.set(index, ColorCharacters.CORRECT_COLOR);
        } else {
            colorList.add(index, ColorCharacters.WRONG_COLOR);
        }
    }

    public static ArrayList<Color> getColorList() {
        return colorList;
    }

    public static ArrayList<Color> getDefaultColorList(int size) {
        colorList.clear();
        initColorList(size);
        return colorList;
    }
}
