package com.cybertek.step_definitions;

import com.cybertek.pages.ClaudTablesPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CaludeTablesStepDefs {
    ClaudTablesPage claudTablesPage = new ClaudTablesPage();

    @Given("User is on cloudtables homepage")
    public void user_is_on_cloudtables_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cloudtables.url"));
        Assert.assertEquals("Editor | Editing for DataTables", Driver.getDriver().getTitle());
    }

    @When("User clicks on New button")
    public void user_clicks_on_new_button() {
        claudTablesPage.newBtn.click();

    }

    @When("User enters {string} to firstname field")
    public void user_enters_to_firstname_field(String firstname) {
        claudTablesPage.fistNameField.sendKeys(firstname);

    }

    @And("User enters {string} to lastname field")
    public void user_enters_to_lastname_field(String lastname) {
        claudTablesPage.lastNameField.sendKeys(lastname);
    }

    @And("User enters {string} to position field")
    public void user_enters_to_position_field(String position) {
        claudTablesPage.positionField.sendKeys(position);
    }

    @And("User enters {string} to salary field")
    public void user_enters_to_salary_field(String salary) {
        claudTablesPage.SalaryField.sendKeys(salary);
    }

    @And("User clicks on create button")
    public void user_clicks_on_create_button() {
        claudTablesPage.creatBtn.click();
    }


}
