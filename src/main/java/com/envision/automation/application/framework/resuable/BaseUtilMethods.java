package com.envision.automation.application.framework.resuable;

import com.envision.automation.application.framework.configuration.ConfigurationLoader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseUtilMethods {
    public WebDriver driver;
    static int waitTime = ConfigurationLoader.configurationOptions.getExplicitWait();

    public BaseUtilMethods(WebDriver driver) {
        this.driver=driver;
    }

    public void takeScreenShot( String testName) throws IOException {
        if(ConfigurationLoader.configurationOptions.isTakeScreenshot()) {
            TakesScreenshot tScreenshot = (TakesScreenshot) driver;
            File screenshot = tScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(
                    screenshot,
                    new File(System.getProperty("user.dir") +
                            "\\src\\test\\resources\\screenshots\\ScreenshotOf-" + testName + ".png"));
        }
    }

    public String objectRepositoryLocator(String locatorName) throws IOException {
        Properties properties= new Properties();
        File ORFile =  new File(System.getProperty("user.dir")+"/src/main/resources/ObjectRepository/OR.properties");
        properties.load(new FileInputStream(ORFile));
        return properties.getProperty(locatorName);
    }

    public void sleepForSeconds(int second){
        try{
            Thread.sleep(second*1000);}
        catch (Exception e) {}
    }

    public void launchURL(String url){
        driver.get(url);
        sleepForSeconds(5);
    }

    public WebElement splitValue(String elementLink) throws IOException {
        String how= elementLink.split(":",2)[0];
        String valueOfHow = elementLink.split(":",2)[1];
        WebElement elementToPerformActionOn= findElement(how,valueOfHow);
        return elementToPerformActionOn;
    }

    public WebElement findElement(String how, String valueOfHow) throws IOException {
        WebElement element= null;
        switch (how){
            case "id":
                element = driver.findElement(By.id(valueOfHow));
                break;
            case "name":
                element= driver.findElement(By.name(valueOfHow));
                break;
            case "tag":
                element=driver.findElement(By.tagName(valueOfHow));
                break;
            case "class":
                element=driver.findElement(By.className(valueOfHow));
                break;
            case "lt":
                element=driver.findElement(By.linkText(valueOfHow));
                break;
            case "plt":
                element=driver.findElement(By.partialLinkText(valueOfHow));
                break;
            case "css":
                element=driver.findElement(By.cssSelector(valueOfHow));
                break;
            case "xpath":
                element= driver.findElement(By.xpath(valueOfHow));
                break;
        }
        return element;
    }
    public WebElement findElementForValidation(String locatorName) throws IOException {
        String elementLink= objectRepositoryLocator(locatorName);
        String how= elementLink.split(":",2)[0];
        String valueOfHow = elementLink.split(":",2)[1];
        WebElement element = findElement(how,valueOfHow);
        return element;
    }

    public List<WebElement> findElementsBy(String locateBy, String locatorValue ){
        List<WebElement> listOfWebElements = null;
        switch(locateBy){
            case "id":
                listOfWebElements = driver.findElements(By.id(locatorValue));
                break;
            case "name":
                listOfWebElements = driver.findElements(By.name(locatorValue));
                break;
            case "class":
                listOfWebElements = driver.findElements(By.className(locatorValue));
                break;
            case "tag":
                listOfWebElements = driver.findElements(By.tagName(locatorValue));
                break;
            case "lt":
                listOfWebElements = driver.findElements(By.linkText(locatorValue));
                break;
            case "plt":
                listOfWebElements = driver.findElements(By.partialLinkText(locatorValue));
                break;
            case "css":
                listOfWebElements = driver.findElements(By.cssSelector(locatorValue));
                break;
            case "xpath":
                listOfWebElements = driver.findElements(By.xpath(locatorValue));
                break;
        }
        return listOfWebElements;
    }

    public By findBy(String how, String valueOfHow){
        By by= null;
        switch (how){
            case "id":
                by = By.id(valueOfHow);
                break;
            case "name":
                by= By.name(valueOfHow);
                break;
            case "tag":
                by=By.tagName(valueOfHow);
                break;
            case "class":
                by=By.className(valueOfHow);
                break;
            case "lt":
                by=By.linkText(valueOfHow);
                break;
            case "plt":
                by=By.partialLinkText(valueOfHow);
                break;
            case "css":
                by=By.cssSelector(valueOfHow);
                break;
            case "xpath":
                by= By.xpath(valueOfHow);
                break;
        }
        return by;
    }

    public void clickOn(String elementLink) throws IOException {
       waitUntilElementClickableAndScrollAndClickOnElement(elementLink);
    }

    public void typeInto(String elementLink, String value) throws IOException {
        waitUntilElementVisibleAndTypeValue(elementLink,value);
    }

    public void hoverOver(String elementLink) throws IOException {
        waitUntilElementVisibleAndMouseHover(elementLink);
    }

    public void hoverAndClickOn(String elementLink) throws IOException {
        waitUntilElementVisibleAndHoverAndClickOnElement(elementLink);
    }

    public void waitUntilElementVisibleAndMouseHover(String locatorName) throws IOException {
        String elementLink= objectRepositoryLocator(locatorName);
        WebElement elementToHover = splitValue(elementLink);
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOf(elementToHover));
        scrollToTheElement(elementToHover);
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).build().perform();
        sleepForSeconds(3);
    }

    public void waitUntilElementVisibleAndHoverAndClickOnElement(String locatorName) throws IOException {
        String elementLink= objectRepositoryLocator(locatorName);
        WebElement elementToHover = splitValue(elementLink);
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOf(elementToHover));
        scrollToTheElement(elementToHover);
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).build().perform();
        sleepForSeconds(3);
        elementToHover.click();
    }

    public void waitUntilElementVisibleAndTypeValue(String locatorName, String value) throws IOException {
        String elementLink= objectRepositoryLocator(locatorName);
        WebElement elementToTypeInto = splitValue(elementLink);
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOf(elementToTypeInto));
        scrollToTheElement(elementToTypeInto);
        elementToTypeInto.click();
        elementToTypeInto.clear();
        elementToTypeInto.sendKeys(value);
        sleepForSeconds(3);
    }

    public void scrollToTheElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitUntilElementClickableAndScrollAndClickOnElement(String locatorName) throws IOException {
        String elementLink= objectRepositoryLocator(locatorName);
        WebElement elementToScrollAndClick = splitValue(elementLink);
        Wait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOf(elementToScrollAndClick));
        wait.until(ExpectedConditions.elementToBeClickable(elementToScrollAndClick));
        scrollToTheElement(elementToScrollAndClick);
        sleepForSeconds(3);
        elementToScrollAndClick.click();
    }
    public String waitUntilElementVisibleAndGetText(String locatorName) throws IOException {
        String elementLink= objectRepositoryLocator(locatorName);
        WebElement elementToGetTextFrom = splitValue(elementLink);
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOf(elementToGetTextFrom));
        String textFromElement= elementToGetTextFrom.getText();
        return textFromElement;
    }
    public void switchToFrame(String elementLink) throws IOException {
        waitUntilFrameAvailableAndSwitch(elementLink);
    }

    public void waitUntilFrameAvailableAndSwitch(String locatorName) throws IOException {
        String elementLink= objectRepositoryLocator(locatorName);
        WebElement elementToSwitch = splitValue(elementLink);
        Wait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(elementToSwitch));
//        driver.switchTo().frame(elementToSwitch);
        sleepForSeconds(3);
    }

    public Object fetchValue(String locatorName) throws IOException {
        String elementLink= objectRepositoryLocator(locatorName);
        String fetchedValue = (splitValue(elementLink)).getText();
        sleepForSeconds(3);
        if(fetchedValue.contains("$")){
            double convertedValue = Double.parseDouble(fetchedValue.substring(1));
            sleepForSeconds(5);
            return convertedValue;
        }
        else{
            sleepForSeconds(5);
            return fetchedValue;
        }
    }
    public void waitUntilElementVisibleAndMouseClick(String locatorName) throws IOException {
        String elementLink= objectRepositoryLocator(locatorName);
        WebElement elementToClick= splitValue(elementLink);
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOf(elementToClick));
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
        elementToClick.click();
    }

    public void waitUntilElementVisibleAndClearField(String locatorName) throws IOException {
        String elementLink= objectRepositoryLocator(locatorName);
        WebElement elementToClear= splitValue(elementLink);
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOf(elementToClear));
        elementToClear.clear();
        sleepForSeconds(3);
    }

    public int sortingIntValueFromText(String locatorName) throws IOException {
        String elementLink= objectRepositoryLocator(locatorName);
        String fetchedValue = waitUntilElementVisibleAndGetText(elementLink);
        fetchedValue = fetchedValue.replaceAll("[^0-9]","");
        int fetchedIntValue= Integer.parseInt(fetchedValue);
        return fetchedIntValue;
    }

    public void scrollToMiddle(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,420)");
        sleepForSeconds(3);
    }
}
