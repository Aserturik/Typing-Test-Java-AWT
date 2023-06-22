package util;

import java.awt.*;
import java.util.Properties;

public class Constants {
    private static Properties properties;

    public static final Color WHITE = new Color(228, 242, 231);
    public static final Color LIGHT_GREEN = new Color(56, 115, 115);
    public static final Color DARK_BLUE = new Color(3, 1, 56);
    public static final String TIMER = "TIMER";
    public static final String LESSONS = "LESSONS";
    public static final String PROGRESS = "PROGRESS";
    public static final String SETTINGS = "SETTINGS";
    public static final String CHALLENGE_ONE = "CHALLENGE_ONE";
    public static final String CHALLENGE_TWO = "CHALLENGE_TWO";
    public static final String CHALLENGE_THREE = "CHALLENGE_THREE";
    public static final String CHALLENGE_FOUR = "CHALLENGE_FOUR";
    public static final String BACK_MENU = "BACK_MENU";
    public static final String BACK_MENU_CONFIG = "BACK_MENU_CONFIG";
    public static final String BACK_BUTTON_TITLE = "BACK_BUTTON_TITLE";
    public static final String PAUSE = "PAUSE";
    public static final String RESTART = "RESTART";
    public static void setProperties(Properties properties) {
        Constants.properties = properties;
    }

    public static String getProperty(String nameProperty){
        return properties.getProperty(nameProperty);
    }
}
