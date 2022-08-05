package stepdefinitations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HotelsSearchResult;

import java.util.ArrayList;

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
}
