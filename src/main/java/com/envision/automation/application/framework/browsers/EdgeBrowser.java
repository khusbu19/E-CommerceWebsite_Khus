package com.envision.automation.application.framework.browsers;

import com.envision.automation.application.framework.configuration.ConfigurationLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class EdgeBrowser extends Browser{

    EdgeOptions edgeOptions;

    @Override
    public void setCapabilities() {
        edgeOptions= new EdgeOptions();
        setHeadless(ConfigurationLoader.configurationOptions.isHeadless());
        setRunOn(ConfigurationLoader.configurationOptions.getRunOn());
        Map<String,String> prefrences =new HashMap<>();
        prefrences.put("excludeSwitches","disable-popup-blocking");
        prefrences.put("download.default_directory",System.getProperty("user.dir")+"/src/test/resources/downloads/");
        edgeOptions.setCapability("prefs",prefrences);
    }
    @Override
    public WebDriver launchBrowser() throws Exception {
        setCapabilities();
        WebDriver driver=null;
        if(getRunOn().equalsIgnoreCase("local")){
            System.setProperty("webdriver.edge.driver",ConfigurationLoader.configurationOptions.getEdgeDriverPath());
            driver = new EdgeDriver();
        }
        else{
            driver=new RemoteWebDriver(new URL(ConfigurationLoader.configurationOptions.getSeleniumHubUrl()),edgeOptions);
        }
        return driver ;
    }
}
