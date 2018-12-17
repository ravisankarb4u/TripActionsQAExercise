package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RoomAvailabilityPage;
import pages.SearchResultsPage;


public class searchHotelTest extends BaseTest{

    @Test(priority = 0)
    public void searchForARoomWithBestPrice() {



        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        RoomAvailabilityPage roomAvailabilityPage = new RoomAvailabilityPage(driver);

        //*************Search********************
        homePage.load();  //Loads HomePage
        homePage.searchFor("Los Angeles", "2018-12-18", "2018-12-21");  // Search for desired criteria
        searchResultsPage.clickOnARandomSearchResult(); //Select a hotel in the results. Pick a random one amongst the top 3 returned
        String lowestPrice = roomAvailabilityPage.getLowestPrice();  //Select the cheapest available room
        roomAvailabilityPage.selectRoomWithPrice(lowestPrice);
    }


}
