package com.envision.automation.application.testDataManager;

import com.envision.automation.application.framework.resuable.JsonUtilMethods;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class JSONDataGenerator {

    public static String getURLDataFromJson(String key) throws IOException, ParseException {
        JsonUtilMethods tdg= new JsonUtilMethods();
        tdg.loadingTestDataFromJSON();
        JSONObject objectData= (JSONObject) tdg.getJSONObject("pageUrl");
        String value = tdg.ObjectData(objectData,key);
        return value;
    }

    public static String getLoginDataFromJson(String key) throws IOException, ParseException {
        JsonUtilMethods tdg= new JsonUtilMethods();
        tdg.loadingTestDataFromJSON();
        JSONObject objectData= (JSONObject) tdg.getJSONObject("loginPageData");
        String value = tdg.ObjectData(objectData,key);
        return value;
    }
}
