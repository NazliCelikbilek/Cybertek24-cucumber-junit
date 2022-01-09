package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class Google_StepDefinitions {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleSearchPage searchPage = new GoogleSearchPage();

    @Given("User is on google home page")
    public void user_is_on_google_home_page() {
        Driver.getDriver().get("https://www.google.com");
    }

    @When("User searches for apple")
    public void user_searches_for_apple() {

        googleSearchPage.searchBar.sendKeys("apple" + Keys.ENTER);
    }

    @Then("User should see apple in title")
    public void user_should_see_apple_in_title() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "apple";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Then("User should be able to search for following:")
    public void user_should_be_able_to_search_for_following(List<String> items) {
        System.out.println("items = " + items);
        //loop and search for each item on Google


        for (String eachItem : items) {
            searchPage.searchBar.clear();
            searchPage.searchBar.sendKeys(eachItem + Keys.ENTER);
        }
    }

    @When("User searches for {string} capital")
    public void userSearchesForCapital(String countryName) {
        searchPage.searchBar.sendKeys("what is capital of " + countryName + Keys.ENTER);

    }

    @Then("User should see {string} in the result")
    public void userShouldSeeInTheResult(String capitalCity) {
        System.out.println("what is capital city " + capitalCity);
        Assert.assertEquals(capitalCity, searchPage.searchResultCityName.getText());
    }
}
