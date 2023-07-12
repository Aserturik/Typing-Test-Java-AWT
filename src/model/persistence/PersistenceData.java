package model.persistence;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import model.PersistenceRecords;
import model.TestWords;

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

    public PersistenceData(String path) {
        testWords = new ArrayList<TestWords>();
        loadProperties(path);
        loadAllTest();
        loadRecords();
    }

    public void loadProperties(String path){
        properties = new Properties();
        try {
            properties.load(new FileReader(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Properties getProperties(){
        return properties;
    }

    public void loadAllTest(){
        testWords.add(newTest("firstText"));
        testWords.add(newTest("secondText"));
        testWords.add(newTest("thirdText"));
        testWords.add(newTest("fourthText"));
    }

    public TestWords newTest(String nameTest){
        try {
            JsonReader reader = new Gson().newJsonReader(new FileReader("data/json/typingTest/"+nameTest+".json"));
            test1 = new Gson().fromJson(reader, TestWords.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return test1;
    }

    public void loadRecords(){
        try {
            JsonReader reader = new Gson().newJsonReader(new FileReader("data/json/typingTest/records.json"));
            records = new Gson().fromJson(reader, PersistenceRecords.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public TestWords getTest(int index){
        return testWords.get(index);
    }

    public void saveProgress(int index){
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
