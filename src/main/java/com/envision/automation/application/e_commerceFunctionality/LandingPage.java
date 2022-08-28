package com.envision.automation.application.e_commerceFunctionality;
import com.envision.automation.application.framework.resuable.BaseUtilMethods;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class LandingPage extends BaseUtilMethods {

    WebDriver driver;
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public LandingPage lunchApplication(String url){
        launchURL(url);
        return this;
    }

    public LoginPage clickSignInOption() throws IOException {
        clickOn("ECommerce.LandingPage.btnSignIn");
        return new LoginPage(driver);
    }
}
