package e_commercewebsite;
import com.envision.automation.application.e_commerceFunctionality.*;
import com.envision.automation.application.framework.resuable.BaseTestMethods;
import com.envision.automation.application.testDataManager.JSONDataGenerator;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class EndToEndTest extends BaseTestMethods {

    @Test
    public void endToEndTestingOfE_CommerceWebsite() throws IOException, ParseException {
        String applicationURL = JSONDataGenerator.getURLDataFromJson("url");
        String username = JSONDataGenerator.getLoginDataFromJson("username");
        String password = JSONDataGenerator.getLoginDataFromJson("password");

        LandingPage landingPage= new LandingPage(browserManager.getDriver());

        LoginPage loginPage=landingPage
                                .lunchApplication(applicationURL)
                                .clickSignInOption();

        MyAccountPage myAccountPage =loginPage
                                .enterUserName(username)
                                .enterPassword(password)
                                .clickSignInButton();

        T_ShirtPage t_shirtPage= myAccountPage
                                .clickOnT_ShirtSubMenu();

        Shirt_iFrame shirt_iFrame=t_shirtPage
                                .hoverOverShirtImage()
                                .clickOnShirtImage();

        OrderSummaryPage orderSummaryPage=shirt_iFrame
                                .switchToFrame()
                                .clickAddToCartButton()
                                .checkIfProductIsAddedToCart()
                                .clickProceedToCheckoutButton();

        OrderShippingPage orderShippingPage=orderSummaryPage
                                .checkTotalPriceLimit()
                                .clickOnCheckOutButton();

        OrderPaymentPage orderPaymentPage=orderShippingPage
                                .checkDeliveryFeesLimit()
                                .acceptTerms()
                                .proceedToCheckOut();

        OrderConfirmationPage orderConfirmationPage=orderPaymentPage
                                .clickOnBankWireOption()
                                .clickOnConfirm();

        List<String> wireDetails = orderConfirmationPage
                                .checkConfirmationMsg()
                                .fetchWireDetails();

        System.out.println(wireDetails);
    }

}
