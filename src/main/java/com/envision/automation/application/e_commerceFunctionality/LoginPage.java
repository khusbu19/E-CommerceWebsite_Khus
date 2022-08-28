package com.envision.automation.application.e_commerceFunctionality;
import com.envision.automation.application.framework.resuable.BaseUtilMethods;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
public class LoginPage extends BaseUtilMethods {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public LoginPage enterUserName(String userName) throws IOException {
        typeInto("ECommerce.LoginPage.tbxUsername",userName);
        return this;
    }

    public LoginPage enterPassword(String password) throws IOException {
        typeInto("ECommerce.LoginPage.tbxPassword",password);
        return this;
    }
    public MyAccountPage clickSignInButton() throws IOException {
        clickOn("ECommerce.LoginPage.btnSignIn");
        return new MyAccountPage(driver);
    }
}
