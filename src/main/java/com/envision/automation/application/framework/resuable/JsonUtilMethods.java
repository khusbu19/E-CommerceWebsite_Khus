package com.envision.automation.application.framework.resuable;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtilMethods {
    JSONObject object;
    public JSONObject loadingTestDataFromJSON() throws IOException, ParseException {
        File jsonFile= new File(System.getProperty("user.dir")+"/src/test/resources/testdata/test-data.json");
        JSONParser jsonParser=new JSONParser();
        FileReader fileReader= new FileReader(jsonFile);
        this.object = (JSONObject) jsonParser.parse(fileReader);
        return object;
    }

    public Object getJSONObject(String objectName){
        JSONObject jsonObject= (JSONObject)this.object.get(objectName);
        return jsonObject;
    }

    public String ObjectData(JSONObject object, String key){
        String value = object.get(key).toString();
        return value;
    }

    public static void main(String[] args) throws IOException, ParseException {
        JsonUtilMethods tdg= new JsonUtilMethods();
        tdg.loadingTestDataFromJSON();
        JSONObject o1= (JSONObject) tdg.getJSONObject("loginPageData");
        String v = tdg.ObjectData(o1,"userName");
        System.out.println(v);
    }
}
