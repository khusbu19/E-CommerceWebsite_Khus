package com.envision.automation.application.e_commerceFunctionality;

import com.envision.automation.application.framework.resuable.BaseUtilMethods;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
public class OrderPaymentPage extends BaseUtilMethods {
    WebDriver driver;

    public OrderPaymentPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public OrderPaymentPage clickOnBankWireOption() throws IOException {
        clickOn("ECommerce.OrderPaymentPage.btnBankWire");
        return this;
    }

    public OrderConfirmationPage clickOnConfirm() throws IOException {
        clickOn("ECommerce.OrderPaymentPage.btnCheckout");
        return new OrderConfirmationPage(driver);
    }
}
