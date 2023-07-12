package presenter;

import model.persistence.PersistenceData;
import view.panels.PrincipalPanel;
import view.typing.TypingTestPanel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface Contract {
    public interface Presenter {
        void run(String path);

        ActionListener getListener();

        void setModel(Model model);

        void setView(View view);
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

        void setPresenter(Presenter presenter);
    }
}
