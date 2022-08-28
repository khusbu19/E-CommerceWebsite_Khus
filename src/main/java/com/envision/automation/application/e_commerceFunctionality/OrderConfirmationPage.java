package com.envision.automation.application.e_commerceFunctionality;

import com.envision.automation.application.framework.resuable.BaseAssertMethods;
import com.envision.automation.application.framework.resuable.BaseUtilMethods;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderConfirmationPage extends BaseUtilMethods {
    WebDriver driver;
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public String fetchOrderConfirmMsg() throws IOException {
        String confirmationMsg =(String)(fetchValue("ECommerce.OrderConfirmationPage.txtConfirmMsg"));
        return confirmationMsg;
    }

    public OrderConfirmationPage checkConfirmationMsg() throws IOException {
        BaseAssertMethods.shouldBeEqual("Your order on My Store is complete.", fetchOrderConfirmMsg(),
                "Order is not complete.");
        return this;
    }

    public List<String> fetchWireDetails() throws IOException {
        List<String> wireDetails = new ArrayList<>();
        wireDetails.add((findElementForValidation("ECommerce.OrderConfirmationPage.txtTotalAmount")).getText());
        wireDetails.add((findElementForValidation("ECommerce.OrderConfirmationPage.txtOwnerName")).getText());
        wireDetails.add((findElementForValidation("ECommerce.OrderConfirmationPage.txtBankName")).getText());
        return wireDetails;
    }
}
