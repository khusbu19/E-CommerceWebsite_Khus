package com.envision.automation.application.framework.resuable;

import com.envision.automation.application.framework.browsers.BrowserManager;
import com.envision.automation.application.framework.configuration.ConfigurationLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTestMethods {
    public String currentWindow;
    public BrowserManager browserManager;

    @BeforeSuite
    public void loadConfiguration() throws IOException {
        ConfigurationLoader configurationLoader = new ConfigurationLoader();
        configurationLoader.loadPropertyForFramework();
        browserManager=new BrowserManager();
    }

    @BeforeTest
    public void launchBrowser() throws Exception {
        browserManager.initializeBrowser();
        currentWindow= browserManager.getDriver().getWindowHandle();
    }

    @AfterTest
    public void closeBrowser() {
        browserManager.getDriver().quit();
    }


    @AfterMethod
    public void afterEveryTestCaptureProofs(Method method) throws IOException {
        browserManager.captureProof(method.getName());
    }

}
