package model;

import model.persistence.PersistenceConfig;
import model.persistence.PersistenceData;
import presenter.Contract;

import java.awt.*;
import java.util.ArrayList;

public class ControlModel implements Contract.Model {
    private PersistenceData persistenceData;
    private PersistenceConfig persistenceConfig;
    private Contract.Presenter presenter;

    public ControlModel() {
        persistenceData = new PersistenceData();
        persistenceConfig = new PersistenceConfig();
    }

    public PersistenceData getPersistenceData() {
        return persistenceData;
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    public TestWords getTest(int index) {
        return persistenceData.getTest(index);
    }

    public PersistenceConfig getPersistenceConfig() {
        return persistenceConfig;
    }

    public ArrayList<Color> getColorList(int indexTest, int indexChar, char charPressed) {
        return persistenceData.getTest(indexTest).getColors(indexChar, charPressed);
    }

    public ArrayList<Color> getListDefaultColor(int indexTest) {
        return persistenceData.getTest(indexTest).getDefaultColorList();
    }

    public int getPPM(String time, int indexTest) {
        return persistenceData.getTest(indexTest).getPPM(time);
    }

    public int getWPM(String time, int indexTest) {
        return persistenceData.getTest(indexTest).getWPM(time);
    }
}
