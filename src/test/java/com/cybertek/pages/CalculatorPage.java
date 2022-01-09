package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

    public CalculatorPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(id="sciOutPut")
public WebElement resultElement;

    /**
     * @param buttonText clickOn("5"); it should  click 5 on calc
     *                   clickOn("7"); it should  click 5 on calc
     *                   clickOn("5"); it should  click 5 on calc
     *                   //span[.='text of btn']
     */

    public void clickOn(String buttonText) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//span[.='" +buttonText+ "']"));
        element.click();
    }
}
