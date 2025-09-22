package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    // Locators
    private final String usernameInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginButton = "#login-button";
    private final String firstAddToCartButton = "button[data-test='add-to-cart-sauce-labs-backpack']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String username, String password) {
        page.fill(usernameInput, username);
        page.fill(passwordInput, password);
        page.click(loginButton);
    }

    public void addFirstItemToCart() {
        page.click(firstAddToCartButton);
    }
}
