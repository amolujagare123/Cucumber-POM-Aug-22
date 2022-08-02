package stepdefinitations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.DarkskyHome;

import static stepdefinitations.SharedSD.getDriver;

public class DarkskySD {


    DarkskyHome darkskyHome = new DarkskyHome();

    @Given("I am on Darksky Home Page")
    public void i_am_on_darksky_home_page() {

        Assert.assertEquals(getDriver().getTitle(),
                "Dark Sky - Sansad Marg, New Delhi, Delhi",
                "This is not a darksky homepage");
    }

    @Then("I verify current temp is equal to Temperature from Daily Timeline")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline() {

        int expected = darkskyHome.getCurrentTemp();
        int actual = darkskyHome.getTimelineTemp();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"temperature does not match");
    }



}
