package com.cybertek.step_definitions;

import com.cybertek.pages.LyftPriceForFareEstimatePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LyftFareEstimateStepDefs {
    LyftPriceForFareEstimatePage lyftPriceForFareEstimatePage = new LyftPriceForFareEstimatePage();

    @Given("User is on lyft fare estimate page")
    public void user_is_on_lyft_fare_estimate_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("lyft.fare.estimate.url"));
        String expectedTitle = "Get Fare Estimates for Your City - Lyft Price Estimate | Lyft";
        String actualTitle = Driver.getDriver().getTitle();

        assertEquals("Lyft fare estimate page is not display", expectedTitle, actualTitle);
    }

    @When("User enters {string} to pickup address")
    public void user_enters_to_pickup_address(String string) {
        lyftPriceForFareEstimatePage.enterPickUpLocation(string);


    }

    @And("User enters {string} to drop-off address")
    public void user_enters_to_drop_off_address(String string) {
        lyftPriceForFareEstimatePage.enterDropOffLocation(string);

    }

    @And("User clicks on get estimate button")
    public void user_clicks_on_get_estimate_button() {
        lyftPriceForFareEstimatePage.getEstimateBtn.click();
        BrowserUtils.sleep(2);
        lyftPriceForFareEstimatePage.getEstimateBtn.click();

    }

    @Then("User should see estimated prices")
    public void user_should_see_estimated_prices() {
        assertTrue(lyftPriceForFareEstimatePage.rideTypesHeader.isDisplayed());
        System.out.println("Lyft Estimated price and time = " + lyftPriceForFareEstimatePage.liftPrice.getText());
    }

    @Then("User should see error message")
    public void user_should_see_error_message() {

        assertTrue(lyftPriceForFareEstimatePage.errorMsg.isDisplayed());

    }

}



