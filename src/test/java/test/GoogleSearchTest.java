package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleSearchResultsPage;


import java.util.List;

public class GoogleSearchTest extends GoogleBaseTest {
    @Test
    public void successfullSearchTest() {
        String searchTerm = "Selenium";
        Assert.assertTrue(googleSearchPage.isPageLoaded(), "googleSearch page is not loaded");

        GoogleSearchResultsPage googleSearchResultsPage = googleSearchPage.search(searchTerm);
        Assert.assertTrue(googleSearchResultsPage.isPageLoaded(), "SearchResultsPage is not loaded");

        Assert.assertEquals(googleSearchResultsPage.getSearchResultsNumber(), 10, "Wrong number of searchResults on first Search page");

        List<String> searchResultsList = googleSearchResultsPage.getSearchResultsList();
        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "SearchTerm " + searchTerm + " not found in:\n" + searchResult);
        }

        googleSearchResultsPage.getNextSearchResults();

        Assert.assertEquals(googleSearchResultsPage.getSearchResultsNumber(), 10, "Wrong number of searchResults on second Search page");

        List<String> searchResultsList2 = googleSearchResultsPage.getSearchResultsList();
        for (String searchResult : searchResultsList2) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "SearchTerm " + searchTerm + " not found in:\n" + searchResult);
        }



    }

}