package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.TAB;

public class GoogleSearchPage extends GoogleBasePage{

    @FindBy(xpath = "//input[@name='btnI']")
    private WebElement feelLuckyButton;

    @FindBy(xpath = "//input[@id='lst-ib']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;


    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(feelLuckyButton, 10);
    }

    public boolean isPageLoaded() {
        return getCurrentUrl().equals("https://www.google.com/")
                && getCurrentTitle().equals("Google")
                && feelLuckyButton.isDisplayed();
    }


    public GoogleSearchResultsPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(TAB);
        searchButton.click();

        return new GoogleSearchResultsPage(driver);
    }
}
