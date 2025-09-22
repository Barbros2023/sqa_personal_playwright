package pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {
    private final Page page;

    private final String firstNameInput = "#first-name";
    private final String lastNameInput = "#last-name";
    private final String zipInput = "#postal-code";
    private final String continueButton = "#continue";
    private final String finishButton = "#finish";
    private final String confirmationMessage = ".complete-header";

    public CheckoutPage(Page page) {
        this.page = page;
    }

    public void fillInformation(String first, String last, String zip) {
        page.fill(firstNameInput, first);
        page.fill(lastNameInput, last);
        page.fill(zipInput, zip);
        page.click(continueButton);
    }

    public void finishCheckout() {
        page.click(finishButton);
    }

    public String getConfirmationMessage() {
        return page.textContent(confirmationMessage);
    }
}
