package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class MercuryDDT1 {
	WebDriver driver;
  @Test
  public void f() {
	  String excelFilePath = "C:\\Users\\Srikant\\New-workspace\\learning\\src\\test\\java\\selenium\\ExcelFiles\\DriverFileIP.xlsx";
      
      try {
          // Read from Excel file
          FileInputStream inputStream = new FileInputStream(excelFilePath);
          
          XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
          
          //Go to sheet to read from.
          XSSFSheet sheet = workbook.getSheet("MercuryLogin");

          //Number of Rows and column
          int rownum = sheet.getLastRowNum();
      
          // Iterate over rows and columns
          for(int i = 1; i<= rownum ; i++) {
	        	XSSFRow row = sheet.getRow(i);
	        	String username = row.getCell(0).toString();
	        	String password = row.getCell(1).toString();
	        	System.out.println("Value is "+username+" pasword is: "+ password); 
        		
	        	String result = validateLogin(username, password);
	        	
	        	XSSFCell newcell=row.createCell(2);
	        	newcell.setCellValue(result);
          }
          
          FileOutputStream outputStream = new FileOutputStream(excelFilePath);
          
          // Close streams
          workbook.write(outputStream);
          workbook.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterTest
  public void afterTest() {
  }

  public String validateLogin(String uName, String pass) {
	  String result = "Fail";
	  driver.get("https://demo.guru99.com/test/newtours/login.php");
	
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uName);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
	  driver.findElement(By.xpath("//input[@name='submit']")).click();
	  String actualTitle = driver.getTitle();
	  System.out.println("Actual Title is :"+actualTitle);
	  String expectedTitle = "Login: Mercury Tours";
	  if(actualTitle.equals(expectedTitle)) {
		  result = "Pass";
	  }
	  return result;
  }
}
