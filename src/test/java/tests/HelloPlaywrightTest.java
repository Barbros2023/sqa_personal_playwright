package tests;

import com.microsoft.playwright.*;

public class HelloPlaywrightTest {
    public static void main(String[] args) {
        // Start Playwright
        try (Playwright playwright = Playwright.create()) {
            // Launch Chromium (headful for now so you can see it open)
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setArgs(java.util.Arrays.asList("--no-sandbox"))
            );

            // Create a new page
            Page page = browser.newPage();

            // Go to example.com
            page.navigate("https://example.com");

            // Wait 3 seconds so you can see the page
            page.waitForTimeout(3000);

            // Close everything
            browser.close();
        }
    }
}
