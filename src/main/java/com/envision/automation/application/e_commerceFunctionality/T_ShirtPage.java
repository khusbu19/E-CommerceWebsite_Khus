package com.envision.automation.application.e_commerceFunctionality;

import com.envision.automation.application.framework.resuable.BaseUtilMethods;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class T_ShirtPage extends BaseUtilMethods {
    WebDriver driver;
    public T_ShirtPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public T_ShirtPage hoverOverShirtImage() throws IOException {
        hoverOver("ECommerce.TshirtPage.lnkShirtHover");
        return this;
    }
    public Shirt_iFrame clickOnShirtImage() throws IOException {
        clickOn("ECommerce.TshirtPage.btnShirtQuickView");
        sleepForSeconds(3);
        return new Shirt_iFrame(driver);
    }
}
