package testNGFramework;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoggerFile {
	static Logger logger = Logger.getLogger(LoggerFile.class);
	WebDriver driver;
	
	@Test (priority = 1)
	public void loginPage() throws IOException {
		
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Mercury");
		  logger.info("Entered UserName Successfully");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Mercury");
		  logger.info("Entered password Successfully");
		  driver.findElement(By.xpath("//input[@name='submit']")).click();
		  
		  String actualTitle = driver.getTitle();
		  logger.info("Login is Successful");
		  System.out.println("Actual Title is :"+actualTitle);
		  String expectedTitle = "Login: Mercury Tours";
		 
		  Assert.assertEquals(expectedTitle,actualTitle);
		  logger.info("Assert is Pass");
	}
	@Test (priority = 2)
	public void loginPage2() throws IOException {
		  driver.get("https://demo.guru99.com/test/newtours/login.php");	
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("ererere");
		  logger.warn("Entered UserName Successfully");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12ereer34");
		  logger.info("Entered password Successfully");
		  driver.findElement(By.xpath("//input[@name='submit']")).click();
		  
		  String actualTitle = driver.getTitle();
		  logger.fatal("Login failed");
		  
		  System.out.println("Actual Title is :"+actualTitle);
		  String expectedTitle = "Login: Mercury Tours";
		  
		  Assert.assertEquals(expectedTitle,actualTitle);
		  logger.fatal("Assertion Fail");
	}
	@AfterTest
	public void closeMethod() {
		
	}
	
	@BeforeTest
	public void driverSetup() {
		PropertyConfigurator.configure("src\\test\\resources\\log4j.properties");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/login.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Link open successful");
	}
}
