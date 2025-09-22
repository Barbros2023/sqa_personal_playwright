package pages;

import com.microsoft.playwright.Page;

public class CartPage {
    private final Page page;

    private final String cartLink = ".shopping_cart_link";
    private final String checkoutButton = "#checkout";

    public CartPage(Page page) {
        this.page = page;
    }

    public void goToCart() {
        page.click(cartLink);
    }

    public void checkout() {
        page.click(checkoutButton);
    }
}
