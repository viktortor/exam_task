package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.GoogleSearchPage;

public class GoogleBaseTest {
    WebDriver driver;
    GoogleSearchPage googleSearchPage;
    private String browserName = "Chrome";

    /**
     * preconditions for all tests:
     * - initialise new ChromeDriver
     * - Navigate to linkedin.com
     * - initialise LinkedIn Login Page
     */
    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browserName) throws Exception {

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new Exception("Browser " + browserName + " is not supported");
        }

        driver.get("https://www.google.com/");
        googleSearchPage = new GoogleSearchPage(driver);
    }

    /**
     * final conditions:
     * - close browser
     */
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.quit();
    }

}
