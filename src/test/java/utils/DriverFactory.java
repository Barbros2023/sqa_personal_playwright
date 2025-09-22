package utils;

import com.microsoft.playwright.*;

public class DriverFactory {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    public static Page getPage() {
        if (page == null) {
            playwright = Playwright.create();

            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                    .setHeadless(true) // set to true later for CI/CD
                    .setArgs(java.util.Arrays.asList(
                            "--no-sandbox",
                            "--disable-setuid-sandbox",
                            "--disable-dev-shm-usage",
                            "--disable-gpu"
                    ));

            browser = playwright.chromium().launch(options);
            page = browser.newPage();
        }
        return page;
    }

    public static void close() {
        if (page != null) {
            page.close();
            page = null;
        }
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }
}
