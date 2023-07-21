package model.persistence;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import model.PersistenceRecords;
import model.TestWords;
import util.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class PersistenceData {
	private ArrayList<TestWords> testWords;
	private TestWords test1;
	private Properties properties;
	private PersistenceRecords records;
	private String path;
	private Properties startPath;

	public PersistenceData() {
		testWords = new ArrayList<TestWords>();
        path= new String();
		loadProperties();
		loadAllTest();
		loadRecords();
	}

	public void loadProperties() {
        properties = new Properties();
        try {
        	switch (this.getPath()) {
			case "ES":
				properties.load(new FileReader("data/properties/dataES.properties"));
				break;
			case "EN":
				properties.load(new FileReader("data/properties/dataEN.properties"));
				break;
			default:
				properties.load(new FileReader("data/properties/dataEN.properties"));
				break;
			}
        	Constants.setProperties(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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
