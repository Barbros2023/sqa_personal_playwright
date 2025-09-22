package stepdefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import org.assertj.core.api.Assertions;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import utils.DriverFactory;

public class CheckoutSteps {

    private Page page;
    private LoginPage loginPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Given("I am on the login page")
    public void iAmOnLoginPage() {
        page = DriverFactory.getPage();
        page.navigate("https://www.saucedemo.com/");
        loginPage = new LoginPage(page);
    }

    @When("I login with username {string} and password {string}")
    public void iLogin(String username, String password) {
        loginPage.login(username, password);
    }

    @And("I add an item to the cart")
    public void iAddItemToCart() {
        loginPage.addFirstItemToCart();
        cartPage = new CartPage(page);
    }

    @And("I proceed to checkout")
    public void iProceedToCheckout() {
        cartPage.goToCart();
        cartPage.checkout();
        checkoutPage = new CheckoutPage(page);
    }

    @And("I fill in checkout information with {string}, {string}, {string}")
    public void iFillCheckoutForm(String firstName, String lastName, String zip) {
        checkoutPage.fillInformation(firstName, lastName, zip);
    }

    @And("I finish the checkout")
    public void iFinishCheckout() {
        checkoutPage.finishCheckout();
    }

    @Then("I should see a confirmation message")
    public void iSeeConfirmation() {
        Assertions.assertThat(checkoutPage.getConfirmationMessage())
                .contains("Thank you for your order!");
        DriverFactory.close();
    }
}
