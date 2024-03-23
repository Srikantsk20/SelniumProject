package testNGFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataProviderExample {
	WebDriver driver;
  @Test(dataProvider = "Login")
  public void dataProviderLogin(String username, String password) {
	  String result = "Fail";	
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
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

  @DataProvider (name = "Login")
  public Object[][] getLoginData() {
    return new Object[][] {
      new Object[] { "mercury", "mercury" },
      new Object[] { "mercury", "abcde" },
    };
  }
}
