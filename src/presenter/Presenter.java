package presenter;

import model.ControlModel;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Presenter implements ActionListener, KeyListener, Contract.Presenter {
	
	private ControlModel controlModel;
	private int indexTest;
	private ArrayList<String> keyTyped;
	private Properties properties;
	private Contract.Model model;
	private Contract.View view;

	public void run() {
		controlModel = new ControlModel();
		properties = controlModel.getPersistenceData().getProperties();
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
		controlModel.getTest(indexTest).pause();
		if (controlModel.getTest(indexTest).isPause()) {
			view.pauseTimer();
		} else {
			view.reanudeTimer();
		}
	}

	private void restart() {
		view.restart();
		if (controlModel.getTest(indexTest).isPause()) {
			controlModel.getTest(indexTest).pause();
			view.getTypingTestPanel().getFooterTyping().getPauseButton().setText(properties.getProperty("pauseButton"));
		} else {
			// view.getControlTime().stop();
		}
		keyTyped.clear();
	}

	private void timer() {
		// view.getTypingTestPanel().getFooterTyping().setTimerString(view.getControlTime().getTimeString());
	}

	public void openChallenge(int indexTest) {
		this.indexTest = indexTest;
		view.getTypingTestPanel().getBodyTyping().setFontSize(controlModel.getPersistenceConfig().getFontSize());
		view.getTypingTestPanel().getBodyTyping().setFontUse(controlModel.getPersistenceConfig().getFont());
		view.getTypingTestPanel().getTittleTyping().setTitle(controlModel.getTest(indexTest).getNameTest());
		view.getTypingTestPanel().getBodyTyping().setText(controlModel.getTest(indexTest).getContentTest());
		view.getTypingTestPanel().getBodyTyping().setColorListDefault();
		view.getTypingTestPanel().getFooterTyping().setTimerString(properties.getProperty("timeString"));

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
//		String language = view.getPrincipalPanel().languageChange();
//		switch (language) {
//		case "GO BACK TO MENU":
//			path = "ES";
//			run();
//			setModel(controlModel);
//			setView(view);
//			System.out.println("AVISO A ESPAÑOL");
//			break;
//		case "CAMBIAR A INGLES":
//			path = "EN";
//			run();
//			setModel(controlModel);
//			setView(view);
//			System.out.println("AVISO A INGLES");
//			break;
//		default:
//			break;
//		}
	}

	// Eventos Globales
	public void backMenu() {
		view.getPrincipalPanel().showMenu();
	}

	public void backMenuConfig() {
		controlModel.getPersistenceConfig().setFontSize(view.getPrincipalPanel().getFontSize());
		controlModel.getPersistenceConfig().setFontUse(view.getPrincipalPanel().getFontUse());
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
			view.setColorList(controlModel.getColorList(indexTest, keyTyped.size() - 1, keyEvent.getKeyChar()));
			if (keyTyped.size() == controlModel.getTest(indexTest).getContentTest().length()) {
				controlModel.getTest(indexTest).setEndTest(true);
				// view.getControlTime().stop();
				saveProgress();
			}
		}
	}

	public void isPause() {
		if (controlModel.getTest(indexTest).isPause()) {
			// view.getControlTime().start();
			System.out.println("isPause");
		}
	}

	public void isStartTest() {
		if (keyTyped.size() == 1) {
			// new Thread(() -> view.getControlTime().start()).start();
			System.out.println("isStartTest");
		}
	}

	public boolean isEndTest() {
		return controlModel.getTest(indexTest).isEndTest();
	}

	public void saveProgress() {
		controlModel.getPersistenceData().saveProgress(indexTest);
		view.setPPM(controlModel.getPPM());
		// view.getPrincipalPanel().getProgressPanel().getPSP(indexTest).setPPMInt(controlModel.getTest(indexTest).getPpm());
		// view.getPrincipalPanel().getProgressPanel().getPSP(indexTest).setWPMInt(controlModel.getTest(indexTest).getWpm());
		// view.getPrincipalPanel().getProgressPanel().getPSP(indexTest).setCorrectCharsInt(controlModel.getTest(indexTest).getCorrectCharacters());
		// view.getPrincipalPanel().getProgressPanel().getPSP(indexTest).setIncorrectCharsInt(controlModel.getTest(indexTest).getIncorrectCharacters());
		saveRecords();
	}

	public void saveRecords() {
		controlModel.getPersistenceData().saveRecords();
	}

	// pulsaciones por minuto
	public void pPM() {
		if (keyTyped.size() > 1 && !isEndTest()) {
			// view.setPPM(controlModel.getPPM(view.getControlTime().getTime(), indexTest));
		}
	}

	// palabras por minuto
	public void wPM() {
		if (keyTyped.size() > 5 && !isEndTest()) {
			// view.setWPM(controlModel.getWPM(view.getControlTime().getTime(), indexTest));
		}
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {

	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {

	}
}
