package com.envision.automation.application.e_commerceFunctionality;
import com.envision.automation.application.framework.resuable.BaseAssertMethods;
import com.envision.automation.application.framework.resuable.BaseUtilMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class Shirt_iFrame extends BaseUtilMethods {
    WebDriver driver;
    protected Shirt_iFrame(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public Shirt_iFrame switchToFrame() throws IOException {
        switchToFrame("ECommerce.Shirt_iFramePage.ifrmShirt");
        return this;
    }

    public Shirt_iFrame clickAddToCartButton() throws IOException {
        clickOn("ECommerce.Shirt_iFramePage.btnAddToCart");
        driver.switchTo().defaultContent();
        return this;
    }

    public boolean ifProductAdded() throws IOException {
        WebElement element=findElementForValidation("ECommerce.Shirt_iFramePage.txtSuccessMsg");
        sleepForSeconds(5);
        BaseAssertMethods.shouldContain
                (element,"Product successfully added to your shopping cart",
                        "Success message is wrong");
        return element.isDisplayed();
    }
    public Shirt_iFrame checkIfProductIsAddedToCart() throws IOException {
        BaseAssertMethods.shouldBeTrue(ifProductAdded());
        return this;
    }

    public OrderSummaryPage clickProceedToCheckoutButton() throws IOException {
        clickOn("ECommerce.Shirt_iFramePage.btnCheckout");
        return new OrderSummaryPage(driver);
    }
}
