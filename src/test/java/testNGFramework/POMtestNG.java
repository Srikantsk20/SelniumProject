package testNGFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class POMtestNG {
	WebDriver driver;
  @Test
  public void LoginTestMethod() {
	  LoginPage lp = new LoginPage(driver);
	  lp.setUserName("mercury");
	  lp.setPassword("mercury");
	  lp.clickSubmit();
  }
  
  @BeforeClass
  public void beforeClass() {
	  	driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/login.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterClass
  public void afterClass() {
  }

}
