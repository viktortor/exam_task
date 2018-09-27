package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class GoogleSearchResultsPage extends GoogleBasePage{

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement searchResultsTotal;

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement secondPageLink;






    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
          waitUntilElementVisible(searchResultsTotal, 10);
    }

        public boolean isPageLoaded(){
            return getCurrentUrl().contains("/search?source")
                    && getCurrentTitle().contains("Selenium")
                    && searchResultsTotal.isDisplayed();
        }

    public int getSearchResultsNumber () {
        return searchResults.size();
    }

    public List<String> getSearchResultsList () {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", searchResult);
            searchResultsList.add(searchResult.getText());
            System.out.println(searchResult.getText());
        }
        return searchResultsList;
    }

    public void getNextSearchResults(){
        secondPageLink.sendKeys(ENTER);
    }


    }

