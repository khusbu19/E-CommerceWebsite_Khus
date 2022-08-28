package com.envision.automation.application.framework.browsers;

import com.envision.automation.application.framework.configuration.ConfigurationLoader;
import com.envision.automation.application.framework.resuable.BaseUtilMethods;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BrowserManager {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
    public void initializeBrowser() throws Exception{

        Browser browser=null;

        if(BrowserType.CHROME.toString().equalsIgnoreCase(ConfigurationLoader.configurationOptions.getBrowserType())){
            browser= new ChromeBrowser();
        } else if (BrowserType.EDGE.toString().equalsIgnoreCase(ConfigurationLoader.configurationOptions.getBrowserType())) {
            browser=new EdgeBrowser();
        } else if (BrowserType.FIREFOX.toString().equalsIgnoreCase(ConfigurationLoader.configurationOptions.getBrowserType())){
            browser= new FirefoxBrowser();
        }else {
            throw new UnsupportedOperationException("Unsupported Browser.");
        }
        this.driver= browser.launchBrowser();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(ConfigurationLoader.configurationOptions.getPageLoadWait(), TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(ConfigurationLoader.configurationOptions.getImplicitWait(), TimeUnit.SECONDS);
    }

    public void captureProof(String testName) throws IOException {
        BaseUtilMethods baseUtilMethods= new BaseUtilMethods(getDriver());
        baseUtilMethods.takeScreenShot(testName);
    }

}
