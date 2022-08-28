package com.envision.automation.application.e_commerceFunctionality;

import com.envision.automation.application.framework.resuable.BaseUtilMethods;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class MyAccountPage extends BaseUtilMethods {
    WebDriver driver;
    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public T_ShirtPage clickOnT_ShirtSubMenu() throws IOException {
        hoverOver("ECommerce.MyAccountPage.btnWomenMenuHover");
        sleepForSeconds(2);
        clickOn("ECommerce.MyAccountPage.btnShirtSubMenu");
        return new T_ShirtPage(driver);
    }

}
