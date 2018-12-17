package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasicPageActions {

    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    //*********Constructor*********
    public HomePage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "https://www.booking.com/";

    //*********Web Elements*********
    By titleText = By.className("sb-searchbox__title-text");
    By searchBox = By.id("ss");
    By calender = By.className("xp__dates-inner");
    By date = By.xpath("//td[contains(@data-date,'date')]"); // placeholder
    By searchButton = By.className("sb-searchbox__button");


    //*********Page Methods*********
    //Go to Homepage
    public void load(){
        driver.get(baseURL);
        assertEquals(titleText, "Find Deals for Any Season");
    }

    //Enter search Criteria and search
    public void searchFor(String searchString, String startDate, String endDate){
        System.out.println("In Home Page");

        writeText(searchBox, searchString);
        click(calender);
        click(By.xpath("//td[contains(@data-date,'"+startDate+"')]"));
        click(By.xpath("//td[contains(@data-date,'"+endDate+"')]"));
        click(searchButton);
    }
}