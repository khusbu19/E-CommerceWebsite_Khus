package com.envision.automation.application.framework.browsers;

import com.envision.automation.application.framework.configuration.ConfigurationLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class ChromeBrowser extends Browser{

    WebDriver driver;
    ChromeOptions chromeOptions;

    @Override
    public void setCapabilities() {
        chromeOptions = new ChromeOptions();
        setHeadless(ConfigurationLoader.configurationOptions.isHeadless());
        setRunOn(ConfigurationLoader.configurationOptions.getRunOn());
        if(isHeadless()){
            chromeOptions.setHeadless(true);
        }
        Map<String,String> prefrences =new HashMap<>();
        prefrences.put("excludeSwitches","disable-popup-blocking");
        prefrences.put("download.default_directory",System.getProperty("user.dir")+"/src/test/resources/downloads/");
        chromeOptions.setExperimentalOption("prefs",prefrences);
    }

    @Override
    public WebDriver launchBrowser() throws Exception {
        setCapabilities();
        if(getRunOn().equalsIgnoreCase("local")){
            System.setProperty("webdriver.chrome.driver",ConfigurationLoader.configurationOptions.getChromeDriverPath());
            driver = new ChromeDriver(chromeOptions);
        }
        else{
            driver=new RemoteWebDriver(new URL(ConfigurationLoader.configurationOptions.getSeleniumHubUrl()),chromeOptions);
        }
        return driver ;
    }
}
