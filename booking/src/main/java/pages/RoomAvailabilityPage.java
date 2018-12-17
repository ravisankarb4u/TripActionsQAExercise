package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.List;

public class RoomAvailabilityPage extends BasicPageActions {

    //*********Constructor*********
    public RoomAvailabilityPage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    int random = (int )(Math.random() * 3 + 1);

    //*********Web Elements*********
    By roomAvailabilityPageCheckPoint = By.id("hp_hotel_name");
    By priceList = By.className("hprt-price-price");
    By reserveButton = By.xpath("//button[contains(text(),'reserve')]");
    By reservePageCheckPoint = By.id("b2bookPage");


    //*********Page Methods*********

    //get all price list and select the lowest.
    public String getLowestPrice(){

        switchTabs();
        assertElementPresent(roomAvailabilityPageCheckPoint);
        System.out.println("In Room Availability Page");

        Double leastPrice = Double.MAX_VALUE, val;
        List <WebElement> results = getList(priceList);

        if(results == null){
            System.out.println("No Results found");
        }
        else{
            System.out.println(results.size()+" results to compare");

            for(WebElement we: results){
                System.out.println("Comparing current least value "+leastPrice+" with "+we.getText());
                val  = Double.parseDouble(we.getText().substring(1));
                if(leastPrice>val){
                    leastPrice = val;
                }
            }
        }
        if(leastPrice == Double.MAX_VALUE) {
            System.out.println("No Results Found " + leastPrice);
            assert(false);
            return "0.0";
        }
        else {
            System.out.println("Found Least Price: "+leastPrice);
            String strVal;
            if(leastPrice%1==0) {
                 strVal = leastPrice.toString();
                 return strVal.substring(0,strVal.indexOf('.'));
            }
            else
                return leastPrice.toString();
        }
    }

    public void selectRoomWithPrice(String price)  {
        String roomCode = getRoomCode(price);
        System.out.println("Room Code: "+roomCode);
        driver.findElement(By.xpath("//tr[@data-block-id='"+roomCode+"']")).findElement(By.xpath("//option[contains(text(),'"+price+"')]")).click();
        click(reserveButton);
        assertElementPresent(reservePageCheckPoint);
        System.out.println("On Reserve Page\n");


    }
}