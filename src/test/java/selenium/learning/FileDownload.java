package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.chrome.ChromeOptions;
public class FileDownload {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//*[@id='textbox']")).sendKeys("Srikant is Testing");
	  
	  driver.findElement(By.id("createTxt")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("link-to-download")).click();
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  
      driver = new ChromeDriver();
      driver.get("https://demo.automationtesting.in/FileDownload.html");
      Thread.sleep(3000);
  }

  @AfterTest
  public void afterTest() {
  }

}
