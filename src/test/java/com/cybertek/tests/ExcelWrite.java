package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    String filePath = "Employees.xlsx";


    @Test
    public void writeToExcelSheet() throws IOException {
        FileInputStream in = new FileInputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook(in);

        XSSFSheet dataSheet = workbook.getSheetAt(0);
        XSSFCell salaryColCell = dataSheet.getRow(0).createCell(3);
        salaryColCell.setCellValue("Salary");
        XSSFCell salary1 = dataSheet.getRow(1).createCell(3);
        salary1.setCellValue(1110000);

        XSSFCell salary2 = dataSheet.getRow(2).createCell(3);
        salary1.setCellValue(2500000);
        //save the change

        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        in.close();

    }
}
