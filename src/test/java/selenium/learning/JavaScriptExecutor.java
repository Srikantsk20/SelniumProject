package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptExecutor {
	WebDriver driver;
  @Test
  public void f() {
	  
	  //run1
	  // Create an instance of JavascriptExecutor
//      JavascriptExecutor js = (JavascriptExecutor) driver;
//
//      // Execute JavaScript code
//      // Example: Scroll down the page by 500 pixels
//      js.executeScript("window.scrollBy(0, 500)");
	  
	  //run2 - scroll till the end
//	  JavascriptExecutor js = (JavascriptExecutor) driver;
//	  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  
//	  //run3 - scrol till element is visible
	  WebElement bookName = driver.findElement(By.xpath("//h3[text()='Thinking in HTML']"));
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();",bookName);
  }

  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("https://practice.automationtesting.in/");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
  }

  @AfterTest
  public void afterTest() {
  }

}
