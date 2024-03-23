package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.JavascriptExecutor;
public class FileUpload {
	WebDriver driver;
  @Test
  public void f() throws IOException, InterruptedException {
	  //driver.findElement(By.xpath("//*[@id='imagesrc']")).click();
	  WebElement button = driver.findElement(By.xpath("//*[@id='imagesrc']"));
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click();", button);
	  Thread.sleep(3000);
	  Runtime.getRuntime().exec("C://Users//Srikant//Desktop//AutoITExefile//uploadfilescript.exe"+" "+"C:\\Users\\Srikant\\Desktop\\FiletoUpload\\TestFile.txt");
	  
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = new FirefoxDriver();
	  driver.get("https://demo.automationtesting.in/Register.html");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
  }

  @AfterTest
  public void afterTest() {
	  
  }

}
