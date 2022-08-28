package com.envision.automation.application.framework.configuration;

public class ConfigurationOptions {

    private String browserType;
    private int implicitWait;
    private int pageLoadWait;
    private int explicitWait;
    private boolean takeScreenshot;
    private String chromeDriverPath;
    private String edgeDriverPath;
    private String geckoDriverPath;
    private String internetDriverPath;
    private String runOn;
    private boolean headless;
    private String seleniumHubUrl;


    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public int getImplicitWait() {
        return implicitWait;
    }

    public void setImplicitWait(int implicitWait) {
        this.implicitWait = implicitWait;
    }

    public int getPageLoadWait() {
        return pageLoadWait;
    }

    public void setPageLoadWait(int pageLoadWait) {
        this.pageLoadWait = pageLoadWait;
    }

    public int getExplicitWait() {
        return explicitWait;
    }

    public void setExplicitWait(int explicitWait) {
        this.explicitWait = explicitWait;
    }

    public boolean isTakeScreenshot() {
        return takeScreenshot;
    }

    public void setTakeScreenshot(boolean takeScreenshot) {
        this.takeScreenshot = takeScreenshot;
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public void setChromeDriverPath(String chromeDriverPath) {
        this.chromeDriverPath = chromeDriverPath;
    }

    public String getEdgeDriverPath() {
        return edgeDriverPath;
    }

    public void setEdgeDriverPath(String edgeDriverPath) {
        this.edgeDriverPath = edgeDriverPath;
    }

    public String getGeckoDriverPath() {
        return geckoDriverPath;
    }

    public void setGeckoDriverPath(String geckoDriverPath) {
        this.geckoDriverPath = geckoDriverPath;
    }

    public String getInternetDriverPath() {
        return internetDriverPath;
    }

    public void setInternetDriverPath(String internetDriverPath) {
        this.internetDriverPath = internetDriverPath;
    }

    public String getRunOn() {
        return runOn;
    }

    public void setRunOn(String runOn) {
        this.runOn = runOn;
    }

    public boolean isHeadless() {
        return headless;
    }

    public void setHeadless(boolean headless) {
        this.headless = headless;
    }

    public String getSeleniumHubUrl() {
        return seleniumHubUrl;
    }

    public void setSeleniumHubUrl(String seleniumHubUrl) {
        this.seleniumHubUrl = seleniumHubUrl;
    }

}
