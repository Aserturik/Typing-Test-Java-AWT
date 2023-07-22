package model.persistence;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import model.PersistenceRecords;
import model.TestWords;
import util.Constants;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

public class PersistenceData {
	private ArrayList<TestWords> testWords;
	private TestWords test1;
	private Properties properties;
	private PersistenceRecords records;
	private String optionLanguage;

	public PersistenceData() {
		testWords = new ArrayList<TestWords>();
		optionLanguage = new String();
		loadProperties();
		loadAllTest();
		loadRecords();
	}

	public void loadProperties() {
		properties = new Properties();
		try {
			properties.load(new FileReader(loadLanguage()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void loadProperties(String path) {
		switch (path) {
		case "ES":
			setOptionLanguage("data/properties/dataES.properties");
			writeNewPath();
			break;
		case "EN":
			setOptionLanguage("data/properties/dataEN.properties");
			writeNewPath();
			break;
		}
	}

	public String loadLanguage() {
		Properties path = new Properties();
		try {
			path.load(new FileReader("data/properties/path.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return path.getProperty("starterLanguage");
	}

	public void writeNewPath() {
		Properties path = new Properties();
		try (FileOutputStream output = new FileOutputStream("data/properties/path.properties")) {
			path.setProperty("starterLanguage", getOptionLanguage());
			path.store(output, null);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String getOptionLanguage() {
		return optionLanguage;
	}

	public void setOptionLanguage(String optionLanguage) {
		this.optionLanguage = optionLanguage;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public void loadAllTest() {
		testWords.add(newTest("firstText"));
		testWords.add(newTest("secondText"));
		testWords.add(newTest("thirdText"));
		testWords.add(newTest("fourthText"));
	}

	public TestWords newTest(String nameTest) {
		try {
			JsonReader reader = new Gson().newJsonReader(new FileReader("data/json/typingTest/" + nameTest + ".json"));
			test1 = new Gson().fromJson(reader, TestWords.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return test1;
	}

	public void loadRecords() {
		try {
			JsonReader reader = new Gson().newJsonReader(new FileReader("data/json/typingTest/records.json"));
			records = new Gson().fromJson(reader, PersistenceRecords.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public TestWords getTest(int index) {
		return testWords.get(index);
	}

	public void saveProgress(int index) {
		testWords.get(index).saveProgress(records.getRecord(index));
	}

	public void saveRecords() {
		try {
			FileWriter writer = new FileWriter("data/json/typingTest/records.json");
			new Gson().toJson(records, writer);
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
