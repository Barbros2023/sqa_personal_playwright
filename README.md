# Playwright BDD

## Initial Project Setup
- **Language:** Java  
- **Build System:** Gradle  
- **JDK:** Temurin 20 (Java 17+ also works)  
- **Gradle DSL:** Groovy  
- **Test Runner:** JUnit 5  

---

## Tools & Libraries Used
- [Playwright for Java](https://playwright.dev/java/) – browser automation  
- [JUnit 5](https://junit.org/junit5/) – test runner  
- [Cucumber (Gherkin BDD)](https://cucumber.io/) – BDD-style scenarios  
- Page Object Model (POM) – clean structure for pages  
- Gradle – build system  
- GitHub Actions – CI/CD pipeline  

---

## What This Project Does
This project automates an **end-to-end test flow** on [saucedemo.com](https://www.saucedemo.com/):  

1. Login with valid credentials  
2. Add an item to the cart  
3. Proceed to checkout  
4. Enter user details  
5. Finish checkout successfully  

---

## Story: Overcoming Hurdles
At first, Playwright’s **browser dependency downloads** caused a lot of problems in CI.  
I tried multiple approaches. here's the simple stories:

### Old DriverFactory #1
*“Okay Playwright, you do your thing.”*  
- Relied on Playwright to auto-download browsers.  
- Failed due to network instability and dependency problem (timeouts, `ECONNRESET`).  

### Old DriverFactory #2 (Over-engineering Attempt)
*“I don’t trust Playwright, let me control everything myself.”*  
- Forced **Google Chrome executable path** manually.  
- Tried to bypass Playwright’s managed Chromium.  
- Mixed Selenium-style setup with Playwright logic.  
- Added redundant flags like `--no-sandbox`, etc.  
- Broke things worse:  
  - Mismatched browser versions (Playwright expected build 1140, system had build 1187).  
  - Added complexity without solving the root cause (network + dependency mismatch).
  - I haven't realize the dependency problem yet  

### New DriverFactory (Final)
*“Okay Playwright, you do your thing (again).”*  
- Returned to Playwright’s **default browser management**.  
- Trusted Playwright to handle binaries & drivers.  
- Only added **headless mode** and CI-friendly flags.  
- Smooth run:  
  - Fixed dependency issues. Randomly tries another playwright dependency.
  - Simplified the code.  
  - Stable in local and GitHub Actions.  

---

## Running the Tests
```bash
./gradlew test
