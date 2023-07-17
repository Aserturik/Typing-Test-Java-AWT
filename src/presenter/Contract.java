package presenter;

import model.TestWords;
import model.persistence.PersistenceConfig;
import model.persistence.PersistenceData;
import model.time.Cronometer;
import view.panels.PrincipalPanel;
import view.typing.TypingTestPanel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface Contract {
    public interface Presenter {
        void run();

        ActionListener getListener();

        void setModel(Model model);

        void setView(View view);
        ArrayList<Color> getListDefaultColor();
    }

    public interface View {

        void setPresenter(Presenter presenter);

        void showPanelPrincipal();

        void showLessons();

        void pauseTimer();

        void reanudeTimer();

        void restart();

        TypingTestPanel getTypingTestPanel();

        PrincipalPanel getPrincipalPanel();


        void setColorList(ArrayList<Color> colorList);
        void showPanelLessons();
        void setPPM(int ppm);
    }

    public interface Model {

        PersistenceData getPersistenceData();
        TestWords getTest(int index);
        PersistenceConfig getPersistenceConfig();
        ArrayList<Color> getColorList(int indexTest, int indexChar, char charPressed);
        int getPPM();
        void setPresenter(Presenter presenter);
        ArrayList<Color> getListDefaultColor(int indexTest);
        int getTimer();
        void startCronometer();
        String getTimerString();
        Cronometer getCronometer();
    }
}
