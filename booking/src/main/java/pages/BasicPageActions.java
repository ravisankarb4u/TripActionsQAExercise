package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BasicPageActions {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasicPageActions (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    //Click Method
    public void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Write Text
    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read Text
    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public List<WebElement> getList( By elementBy){
        if(!driver.getPageSource().contains("Sorry, this hotel has no rooms available for the dates of your stay"))
            return driver.findElements(elementBy);
        else return null;
    }

    public void switchTabs(){
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
    }

    //Assert
    public void assertEquals (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }

    public void assertElementPresent (By elementBy) {
        Assert.assertEquals(driver.findElement(elementBy).isDisplayed(), true);
    }

    public String getRoomCode(String price){
        return driver.findElement(By.xpath("//span[contains(., '"+price+"')]/ancestor::tr")).getAttribute("data-block-id");
    }




}