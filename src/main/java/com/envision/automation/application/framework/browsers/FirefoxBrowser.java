package com.envision.automation.application.framework.browsers;

import com.envision.automation.application.framework.configuration.ConfigurationLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class FirefoxBrowser extends Browser{

    FirefoxOptions firefoxOptions;
    @Override
    public void setCapabilities() {
        firefoxOptions = new FirefoxOptions();
        setHeadless(ConfigurationLoader.configurationOptions.isHeadless());
        setRunOn(ConfigurationLoader.configurationOptions.getRunOn());
    }

    @Override
    public WebDriver launchBrowser() throws Exception {
        setCapabilities();
        WebDriver driver=null;
        if(getRunOn().equalsIgnoreCase("local")){
            System.setProperty("webdriver.gecko.driver",ConfigurationLoader.configurationOptions.getGeckoDriverPath());
            driver = new FirefoxDriver();
        }
        else{
            driver=new RemoteWebDriver(new URL(ConfigurationLoader.configurationOptions.getSeleniumHubUrl()),firefoxOptions);
        }
        return driver ;
    }
}
