package com.cybertek.tests;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {

    String filePath = "VyTrackQa2Users.xlsx";

    @Before
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));

    }

    @Test
    public void loginDDTTest() throws IOException {
        WebElement login = Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement password = Driver.getDriver().findElement(By.id("prependedInput2"));
        WebElement submitBtn = Driver.getDriver().findElement(By.id("_submit"));
        WebElement userMenu = Driver.getDriver().findElement(By.id("user-menu"));
        WebElement logOut = Driver.getDriver().findElement(By.linkText("Logout"));


        FileInputStream in = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet dataSheet = workbook.getSheetAt(0);

        System.out.println("dataSheet = " + dataSheet.getRow(0).getCell(0));
        BrowserUtils.sleep(5);


        for (int i = 1; i <= 16; i++) {
            XSSFCell loginRow = dataSheet.getRow(i).getCell(0);
            XSSFCell passwordRow = dataSheet.getRow(i).getCell(1);
            login.sendKeys(loginRow.toString());
            password.sendKeys(passwordRow.toString());
            submitBtn.click();
            Driver.getDriver().findElement(By.id("user-menu")).click();
            Driver.getDriver().findElement(By.linkText("Logout")).click();


        }


    }

}
