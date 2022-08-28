package com.envision.automation.application.framework.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationLoader {

    public static ConfigurationOptions configurationOptions;
    private Properties properties;

    public void loadConfigurationFileProperties() throws IOException {
        properties = new Properties();
        File configurationFile =  new File(System.getProperty("user.dir")+"/src/main/resources/configfile/appconfig.properties");
        properties.load(new FileInputStream(configurationFile));
    }

    public String getProperty(String name){
        return  properties.getProperty(name);
    }

    public void loadPropertyForFramework() throws IOException {
        configurationOptions = new ConfigurationOptions();
        loadConfigurationFileProperties();
        configurationOptions.setBrowserType(getProperty("browserType"));
        configurationOptions.setImplicitWait(Integer.parseInt(getProperty("implicitWait")));
        configurationOptions.setExplicitWait(Integer.parseInt(getProperty("explicitWait")));
        configurationOptions.setPageLoadWait(Integer.parseInt(getProperty("pageLoadWait")));
        configurationOptions.setTakeScreenshot(Boolean.parseBoolean(getProperty("takeScreenshot")));
        configurationOptions.setChromeDriverPath(getProperty("chromeDriverPath"));
        configurationOptions.setEdgeDriverPath(getProperty("edgeDriverPath"));
        configurationOptions.setGeckoDriverPath(getProperty("geckoDriverPath"));
        configurationOptions.setInternetDriverPath(getProperty("internetDriverPath"));
        configurationOptions.setRunOn(getProperty("runOn"));
        configurationOptions.setHeadless(Boolean.parseBoolean(getProperty("headless")));
        configurationOptions.setSeleniumHubUrl(getProperty("seleniumHubUrl"));
    }

    public static void main(String[] args) throws IOException {
        ConfigurationLoader cl = new ConfigurationLoader();
        cl.loadPropertyForFramework();
        System.out.println(configurationOptions.getBrowserType());
        System.out.println(configurationOptions.getRunOn());

    }
}
