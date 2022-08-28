package com.envision.automation.application.e_commerceFunctionality;

import com.envision.automation.application.framework.resuable.BaseAssertMethods;
import com.envision.automation.application.framework.resuable.BaseUtilMethods;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
public class OrderSummaryPage extends BaseUtilMethods {
    WebDriver driver;
    public OrderSummaryPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public Object fetchTotalPrice() throws IOException {
        Object totalPrice = fetchValue("ECommerce.OrderSummaryPage.txtTotalPrice");
        return totalPrice;
    }
    public OrderSummaryPage checkTotalPriceLimit() throws IOException {
        BaseAssertMethods.shouldBeTrue(((Double)fetchTotalPrice()) < 20,"Total price is more than $20.");
        return this;
    }
    public OrderShippingPage clickOnCheckOutButton() throws IOException {
        clickOn("ECommerce.OrderSummaryPage.btnCheckout1");
        clickOn("ECommerce.OrderSummaryPage.btnCheckout2");
        return new OrderShippingPage(driver);
    }
}
