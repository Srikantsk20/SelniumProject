package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Frames {
	WebDriver driver;
  @Test //(enabled = false)
  public void f() throws InterruptedException {
	  //driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Srikant");
	  // we will get error unable to locate element
	  
	  //Switch to Frame by ID or Name
//	  driver.switchTo().frame("singleframe");
//	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Srikant");
	  
	//Switch to Frame by Index
	  driver.switchTo().frame(1);
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Srikant");
	  
	  Thread.sleep(3000);
	   
  }
  
  @Test(dependsOnMethods = "f", enabled = false)
  public void f2() {
	  
	  // Find all frames on the page
      List<WebElement> frames = driver.findElements(By.tagName("iframe"));

      // Print the index of each frame
      for (int i = 0; i < frames.size(); i++) {
          WebElement frame = frames.get(i);
          System.out.println("Index of frame " + i + ": " + frame.getAttribute("id"));
      }
  }
  
  @Test(dependsOnMethods = "f")
  public void f3() {
	//switch back to default frame
	  driver.switchTo().defaultContent();
	  driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();
	  
	  driver.switchTo().frame(2);
	  
	  WebElement frameIdentifier = driver.findElement(By.xpath("//h5[text()='Nested iFrames']/parent::div/iframe"));
	  driver.switchTo().frame(frameIdentifier);
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Srikant2");
	  
  }
  
  @Test(dependsOnMethods = "f3")
  public void f4() {
	//switch back to parent Frame twice
	 // driver.switchTo().parentFrame();
//	  driver.switchTo().parentFrame();
	 
	  //switch back to default content
	  driver.switchTo().defaultContent();
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Single Iframe ')]")).click();
	  
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("https://demo.automationtesting.in/Frames.html");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
  }

  @AfterTest
  public void afterTest() {
  }

}
