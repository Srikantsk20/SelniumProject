package testNGFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

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
import org.testng.annotations.AfterMethod;

public class ParameterizationXML {
	WebDriver driver;
  @Parameters({"userName" , "password"})
  @Test
  public void validateLoginMain(String userName, String password) {
	  String result = "Fail";	
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(userName);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@name='submit']")).click();
	  String actualTitle = driver.getTitle();
	  System.out.println("Actual Title is :"+actualTitle);
	  String expectedTitle = "Login: Mercury Tours";
	  if(actualTitle.equals(expectedTitle)) {
		  result = "Pass";
	  }
	  System.out.println("Login validation :"+result);
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = new ChromeDriver();
	  driver.get("https://demo.guru99.com/test/newtours/login.php");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
  }
}
