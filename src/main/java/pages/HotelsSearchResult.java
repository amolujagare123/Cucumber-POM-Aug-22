package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

import static stepdefinitations.SharedSD.getDriver;

public class HotelsSearchResult extends Base{

    By hotelList = By.xpath("//div[@data-testid='title']");

    By totalRatings = By.xpath("//div[@data-testid='rating-stars']");

    By totalStars = By.xpath("//div[@data-testid='rating-stars']/span");

    public ArrayList<String> getHotelsList()
    {
        return getElementTextList(hotelList);
    }

    public void clickStarRating(String star) // 4 ,5, 3
    {
      // getDriver().navigate().refresh();
       By starRating = By.xpath("//div[@data-filters-group='class']//input[@value='class="+star+"']");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        js.executeScript("arguments[0].click()",webAction(starRating));

       //clickOn(starRating);
    }


    public int getTotalRatings()
    {
        return  getDriver().findElements(totalRatings).size();
    }


    public int getTotalStars()
    {
        return  getDriver().findElements(totalStars).size();
    }
}
