package tests;

import com.microsoft.playwright.*;

public class SauceDemoLoginTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setArgs(java.util.Arrays.asList("--no-sandbox"))
            );

            Page page = browser.newPage();

            // 1. Go to saucedemo
            page.navigate("https://www.saucedemo.com/");

            // 2. Fill username and password
            page.fill("#user-name", "standard_user");
            page.fill("#password", "secret_sauce");

            // 3. Click login
            page.click("#login-button");

            // 4. Wait a bit so you can see it logged in
            page.waitForTimeout(3000);

            // 5. Close browser
            browser.close();
        }
    }
}
