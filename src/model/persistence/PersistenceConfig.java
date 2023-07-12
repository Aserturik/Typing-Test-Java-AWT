package model.persistence;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import model.ConfigFonts;

import java.io.*;

public class PersistenceConfig {
    private ConfigFonts configFonts;
    public PersistenceConfig() {
        try {
            JsonReader reader = new Gson().newJsonReader(new FileReader("data/json/jsonConfig/jsonConfig.json"));
            configFonts = new Gson().fromJson(reader, ConfigFonts.class);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String[] getFontSizes() {
        return configFonts.getFontSizes();
    }

    public void setFontSize(int sizeFont){
        configFonts.setSizeFont(sizeFont);
        try(FileWriter writer = new FileWriter("data/json/jsonConfig/jsonConfig.json");
                JsonWriter jsonWriter = new Gson().newJsonWriter(writer)) {
            String json = new Gson().toJson(configFonts);
            jsonWriter.jsonValue(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFontUse(String fontUse){
        configFonts.setFontUse(fontUse);
        try {
            String json = new Gson().toJson(configFonts);
            FileWriter writer = new FileWriter("data/json/jsonConfig/jsonConfig.json");
            JsonWriter jsonWriter = new Gson().newJsonWriter(writer);
            jsonWriter.jsonValue(json);
            jsonWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getFontSize(){
        return configFonts.getSizeFont();
    }

    public String getFont(){
        return configFonts.getFont();
    }
}
