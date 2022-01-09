package com.cybertek.step_definitions;

import com.cybertek.pages.CalculatorPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CalculatorStepDefs {
    CalculatorPage calculatorPage = new CalculatorPage();

    @Given("User is on calculator page")
    public void user_is_on_calculator_page() {
        System.out.println("User on calculator page");
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator.url"));
       // Assert.assertEquals("Editor | Editing for DataTables",Driver.getDriver().getTitle());
    }

    @Given("User clicks on {string} on calculator")
    public void user_clicks_on_on_calculator(String buttonText) {
        System.out.println("user clickOn { " + buttonText + " }");
        calculatorPage.clickOn(buttonText);
    }

    @Then("result {string} should be displayed")
    public void result_should_be_displayed(String expectedResult) {

        System.out.println("result should be  = " + expectedResult);
       String actualResult= calculatorPage.resultElement.getText().trim();
        Assert.assertEquals(expectedResult,actualResult);
        System.out.println("ActualResult = " + actualResult);
        System.out.println("ExpectedResult = " + expectedResult);
    }


}
