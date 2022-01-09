package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelRead {

    @Test
    public void readingFromExcel() throws IOException {
        //Workbook > Worksheet > Row > Cell
        //open excel workbook using XSSFWorkbook class
        //PassFilName in the constructor
        XSSFWorkbook workbook =new XSSFWorkbook("Employees.xlsx");

        // Goto worksheet. pass the worksheet name
        XSSFSheet worksheet =workbook.getSheet("data");
        
        
        //print
        System.out.println("Name = " + worksheet.getRow(1).getCell(0));
        System.out.println("LastName = " + worksheet.getRow(2).getCell(1));
        
    }

}
