package com.envision.automation.application.e_commerceFunctionality;

import com.envision.automation.application.framework.resuable.BaseAssertMethods;
import com.envision.automation.application.framework.resuable.BaseUtilMethods;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class OrderShippingPage extends BaseUtilMethods {
    WebDriver driver;
    public OrderShippingPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public OrderShippingPage acceptTerms() throws IOException {
        clickOn("ECommerce.OrderShippingPage.chkbxAcceptTerms");
        return this;
    }

    public Object fetchDeliveryFees() throws IOException {
        Object deliveryFees = fetchValue("ECommerce.OrderShippingPage.txtDeliveryFees");
        return deliveryFees;
    }

    public OrderShippingPage checkDeliveryFeesLimit() throws IOException {
        BaseAssertMethods.shouldBeTrue(((Double)fetchDeliveryFees()) < 5,
                "Delivery fees is more than $5.");
        return this;
    }

    public OrderPaymentPage proceedToCheckOut() throws IOException {
        clickOn("ECommerce.OrderShippingPage.btnCheckout");
        return  new OrderPaymentPage(driver);
    }
}
