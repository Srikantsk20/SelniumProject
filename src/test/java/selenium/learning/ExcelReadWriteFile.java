package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class ExcelReadWriteFile {
  @Test
  public void readFromExcelFile() {
	  String excelFilePath = "C:\\Users\\Srikant\\New-workspace\\learning\\src\\test\\java\\selenium\\ExcelFiles\\DriverFileIP.xlsx";
      
      try {
          // Read from Excel file
          FileInputStream inputStream = new FileInputStream(excelFilePath);
          XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
          
          //Go to sheet to read from.
          //Sheet sheet = workbook.getSheetAt(0);
          XSSFSheet sheet = workbook.getSheet("EmployeeData");
          
          //Find Number of Rows and Column
          
          //Number of Rows and column
          int rownum = sheet.getLastRowNum();
          int colnum = sheet.getRow(0).getLastCellNum();
          
          // Iterate over rows and columns
          for(int i = 0; i< rownum ; i++) {
        	  XSSFRow row = sheet.getRow(i);
        	  for(int j = 0; j< colnum ; j++) {
        		  String value = row.getCell(j).toString();
        		  System.out.println("Value is "+value);
        	  }
        	  System.out.println(" ");
          }
 
          // Close streams
          inputStream.close();
          workbook.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
	  
  }
  @Test
  public void writeIntoExcelFile() {
	  
	  String outputExcelFilePath = "C:\\Users\\Srikant\\New-workspace\\learning\\src\\test\\java\\selenium\\ExcelFiles\\DriverFileOP.xlsx";
	  
      try {
           // Write to Excel file
          FileOutputStream outputStream = new FileOutputStream(outputExcelFilePath);
          //open workbook
          XSSFWorkbook workbook = new XSSFWorkbook();
          XSSFSheet sheet = workbook.createSheet("EmployeeData");
          
          // Iterate over rows and columns
          for(int i = 0; i< 5 ; i++) {
        	  XSSFRow row = sheet.createRow(i);
        	  for(int j = 0; j< 3 ; j++) {
        		  row.createCell(j).setCellValue("abcdefg");
        	  }
          }
          // Write changes to output Excel file
          workbook.write(outputStream);

          // Close streams
          outputStream.close();
          workbook.close();
          
      } catch (IOException e) {
          e.printStackTrace();
      } 
  }
  
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
