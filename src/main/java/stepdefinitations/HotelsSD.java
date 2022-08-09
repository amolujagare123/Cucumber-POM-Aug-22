package stepdefinitations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HotelsSearchResult;

import java.time.Duration;
import java.util.ArrayList;

import static stepdefinitations.SharedSD.getDriver;

public class HotelsSD {


    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Given("I am on default locations search result screen")
    public void i_am_on_default_locations_search_result_screen() {

    }


    @Then("I verify {string} is within search result")
    public void i_verify_is_within_search_result(String expectedHotel) {

        System.out.println("expectedHotel = "+expectedHotel);

        ArrayList<String> hotelsList = hotelsSearchResult.getHotelsList();

        for (int i=0;i<hotelsList.size();i++)
        {
            System.out.println(hotelsList.get(i));
        }

        boolean result = hotelsList.contains(expectedHotel);

        Assert.assertTrue(result,"given hotel is not in the list");
    }

    @When("^I select option for stars as (.+)$")
    public void i_select_option_for_stars_as(String stars)  // "5 stars"
    {

        hotelsSearchResult.clickStarRating(stars.split(" ")[0]);
    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {

        getDriver().navigate().refresh();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        int totalRatings = hotelsSearchResult.getTotalRatings();
        int totalStars = hotelsSearchResult.getTotalStars();

        System.out.println("totalRatings="+totalRatings); // 25
        System.out.println("totalStars="+totalStars); // 125

        int actualStars = totalStars / totalRatings ;
        int expectedStars = Integer.parseInt(stars.split(" ")[0]);

        System.out.println("actualStars="+actualStars);
        System.out.println("expectedStars="+expectedStars);


        Assert.assertEquals(actualStars,expectedStars,"wrong stars");

    }



}
