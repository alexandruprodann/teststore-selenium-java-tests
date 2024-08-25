package Tests;

import PageObjects.HomePage;
import PageObjects.SearchPage;
import Utilities.BaseClass;
import Utilities.TestConstants;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchBarTest extends BaseClass {

    @Test
    public void searchBar() {

        String SEARCH_TERM = "Mug";

        // Pages
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        // Steps
        Reporter.log("Access TestStore Homepage: " + TestConstants.BASE_URL);
        getDriver().get(TestConstants.BASE_URL);

        Reporter.log("Search for: " + SEARCH_TERM);
        homePage.searchSomething(SEARCH_TERM);

        Reporter.log("Verify that search results are displayed");
        Assert.assertTrue(searchPage.searchResultsDisplayedBool(), "Search results are not displayed!");

        Reporter.log("Verify that search results contain the search term: " + SEARCH_TERM);
        Assert.assertTrue(searchPage.getSearchResultsText().contains(SEARCH_TERM), "The search result text does not contain the search term: " + SEARCH_TERM);

    }

}