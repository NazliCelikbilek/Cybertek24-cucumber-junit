package com.cybertek.step_definitions;

import com.cybertek.pages.EtsyAllCategoriesPage;
import com.cybertek.pages.EtsyHomePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class EtsySearch {

    WebDriver driver;

    @Given("User is on etsy homepage")
    public void user_is_on_etsy_homepage() {

        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("etsy.url"));
    }

    @Then("Page title should be as expected")
    public void page_title_should_be_as_expected() {


        Assert.assertEquals("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone", driver.getTitle());
    }

    @When("User searches for wooden spoon")
    public void user_searches_for_wooden_spoon() {
        EtsyHomePage etsyPage = new EtsyHomePage();
        etsyPage.searchFor("Wooden spoon");

    }

    @Then("Page title should start with wooden spoon")
    public void page_title_should_start_with_wooden_spoon() {
        BrowserUtils.sleep(5);
        Assert.assertTrue("title did not match", driver.getTitle().startsWith("Wooden spoon"));


    }

    @When("User searches for empty value")
    public void userSearchesForEmptyValue() {
        EtsyHomePage etsypage=new EtsyHomePage();
        etsypage.searchFor("");
    }

    @Then("All categories should be display")
    public void allCategoriesShouldBeDisplay() {
      Assert.assertEquals("All categories | Etsy", driver.getTitle());

        EtsyAllCategoriesPage etsyAllCategoriesPage= new EtsyAllCategoriesPage();
       BrowserUtils.sleep(5);
        Assert.assertTrue( etsyAllCategoriesPage.allCategoriesHeather.isDisplayed());

    }


}
