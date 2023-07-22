package presenter;

import model.time.Cronometer;
import java.awt.*;
import util.Constants;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import model.ControlModel;

public class Presenter implements ActionListener, KeyListener, Contract.Presenter {
    private int indexTest;
    private ArrayList<String> keyTyped;
    private Properties properties;
    private Contract.Model model;
    private Contract.View view;
    private String timerString;
    private ControlModel controlModel;
    private boolean isRunning;

    public void run() {
        properties = model.getPersistenceData().getProperties();
        this.timerString = properties.getProperty("timeString");
        controlModel = new ControlModel();
        keyTyped = new ArrayList<String>();
    }

    @Override
    public ActionListener getListener() {
        return this;
    }

    @Override
    public void setModel(Contract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(Contract.View view) {
        this.view = view;
    }

    @Override
    public ArrayList<Color> getListDefaultColor() {
        return model.getListDefaultColor(indexTest);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "LESSONS":
            case "BACK_BUTTON_TITLE":
                lessons();
                break;
            case "BACK_MENU_CONFIG":
                backMenuConfig();
                break;
            case "PROGRESS":
                progress();
                break;
            case "SETTINGS":
                config();
                break;
            case "LANGUAGE_CHANGE":
                change();
                break;
            case "BACK_MENU":
                backMenu();
                break;
            case "CHALLENGE_ONE":
                openChallenge(0);
                break;
            case "CHALLENGE_TWO":
                openChallenge(1);
                break;
            case "CHALLENGE_THREE":
                openChallenge(2);
                break;
            case "CHALLENGE_FOUR":
                openChallenge(3);
                break;
            case "TIMER":
                timer();
                break;
            case "PAUSE":
                pause();
                break;
            case "RESTART":
                restart();
                break;
        }
    }

    // Eventos para el panel de Lecciones
    public void lessons() {
        restart();
        view.showLessons();
    }

    private void pause() {
        model.getTest(indexTest).pause();
        if (model.getTest(indexTest).isPause()) {
            view.pauseTimer();
        } else {
            view.reanudeTimer();
        }
    }

    private void restart() {
        view.restart();
        model.getCronometer().resetTime();
        if (model.getTest(indexTest).isPause()) {
            model.getTest(indexTest).pause();
            view.getTypingTestPanel().getFooterTyping().getPauseButton().setText(properties.getProperty("pauseButton"));
        } else {
            //view.getControlTime().stop();
            isRunning = false;
            Cronometer.getInstance().pauseTime();
        }
        keyTyped.clear();
    }

    private void timer() {
        System.out.println("Timer");
    }

    public void openChallenge(int indexTest) {
        this.indexTest = indexTest;
        view.getTypingTestPanel().getBodyTyping().setFontSize(model.getPersistenceConfig().getFontSize());
        view.getTypingTestPanel().getBodyTyping().setFontUse(model.getPersistenceConfig().getFont());
        view.getTypingTestPanel().getTittleTyping().setTitle(model.getTest(indexTest).getNameTest());
        view.getTypingTestPanel().getBodyTyping().setText(model.getTest(indexTest).getContentTest());
        view.getTypingTestPanel().getBodyTyping().setColorListDefault();
        view.getTypingTestPanel().getFooterTyping().setTimerString(this.timerString);

        view.showPanelLessons();
    }

    // Eventos para el panel de Progreso
    public void progress() {
        view.getPrincipalPanel().showProgress();
    }

	// Eventos para el panel de Configuracion
	public void config() {
		view.getPrincipalPanel().setSizesFont(controlModel.getPersistenceConfig().getFontSizes());
		view.getPrincipalPanel().showConfig();
	}
	public void change() {
		String language = view.getPrincipalPanel().languageChange();
		ManagerGeneral managerGeneral = new ManagerGeneral();
		switch (language) {
		case "CHANGE TO SPANISH":
			controlModel.languageChange("ES");
			view.closeApp();
			managerGeneral.run();
			break;

		case "CAMBIAR A INGLES":
			controlModel.languageChange("EN");
			view.closeApp();
			managerGeneral.run();
			break;
		default:
			break;
		}
	}

	// Eventos Globales
	public void backMenu() {
		view.getPrincipalPanel().showMenu();
	}

    public void backMenuConfig() {
        model.getPersistenceConfig().setFontSize(view.getPrincipalPanel().getFontSize());
        model.getPersistenceConfig().setFontUse(view.getPrincipalPanel().getFontUse());
        view.getPrincipalPanel().showMenu();
    }

    // Eventos de teclado
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        isPause();
        isStartTest();
        keyTyped.add(String.valueOf(keyEvent.getKeyChar()));
        pPM();
        wPM();

        if (!isEndTest()) {
            view.setColorList(model.getColorList(indexTest, keyTyped.size() - 1, keyEvent.getKeyChar()));
            if (keyTyped.size() == model.getTest(indexTest).getContentTest().length()) {
                model.getTest(indexTest).setEndTest(true);
                //view.getControlTime().stop();
                saveProgress();
            }
        }
    }

    private void runThread(){
        if (keyTyped.size() >= 1){
            isRunning = true;
            Thread thread = new Thread(() -> {
                while (isRunning) {
                    view.getTypingTestPanel().getFooterTyping().setTimerString(model.getTimerString());
                }
            });

            thread.start();
        }
    }

    public void isPause() {
        if (model.getTest(indexTest).isPause()) {
            //model.reanudeCronometer();
            model.startCronometer();
            System.out.println("isPause");
        }
    }

    public void isStartTest() {
        if (keyTyped.size() == 1) {
            runThread();
            model.getCronometer().start();
            model.startCronometer();
            view.getTypingTestPanel().getFooterTyping().setTimerString(model.getTimerString());
        }
    }

    public boolean isEndTest() {
        return model.getTest(indexTest).isEndTest();
    }

    public void saveProgress() {
        model.getPersistenceData().saveProgress(indexTest);
        view.setPPM(model.getPPM());
        //view.getPrincipalPanel().getProgressPanel().getPSP(indexTest).setPPMInt(model.getTest(indexTest).getPpm());
        //view.getPrincipalPanel().getProgressPanel().getPSP(indexTest).setWPMInt(model.getTest(indexTest).getWpm());
        //view.getPrincipalPanel().getProgressPanel().getPSP(indexTest).setCorrectCharsInt(model.getTest(indexTest).getCorrectCharacters());
        //view.getPrincipalPanel().getProgressPanel().getPSP(indexTest).setIncorrectCharsInt(model.getTest(indexTest).getIncorrectCharacters());
        saveRecords();
    }

    public void saveRecords() {
        model.getPersistenceData().saveRecords();
    }

    // pulsaciones por minuto
    public void pPM() {
        if (keyTyped.size() > 1 && !isEndTest()) {
            view.setPPM(model.getPPM());
        }
    }

    // palabras por minuto
    public void wPM() {
        if (keyTyped.size() > 5 && !isEndTest()) {
            //view.setWPM(model.getWPM(view.getControlTime().getTime(), indexTest));
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
