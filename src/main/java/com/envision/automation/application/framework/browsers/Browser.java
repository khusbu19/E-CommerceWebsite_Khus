package com.envision.automation.application.framework.browsers;
import org.openqa.selenium.WebDriver;

public abstract class Browser {

    private boolean headless;
    private String runOn;

    public boolean isHeadless() {
        return headless;
    }
    public void setHeadless(boolean headless) {
        this.headless = headless;
    }
    public String getRunOn() {
        return runOn;
    }
    public void setRunOn(String runOn) {
        this.runOn = runOn;
    }

    public abstract WebDriver launchBrowser() throws Exception;

    public abstract void setCapabilities();
}
