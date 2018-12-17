package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasicPageActions {

    //*********Constructor*********
    public SearchResultsPage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    int random = (int )(Math.random() * 3 + 1);

    //*********Web Elements*********
    By searchResultsPageCheckPoint = By.id("ajaxsrwrap");
    By searchResult = By.xpath("//div[@id='hotellist_inner']/div["+random+"]//a");


    //*********Page Methods*********

    //Click on one of the first three results.
    public void clickOnARandomSearchResult(){
        assertElementPresent(searchResultsPageCheckPoint);
        System.out.println("On Search Results Page");
        click(searchResult);
    }
}