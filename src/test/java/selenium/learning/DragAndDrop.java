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
public class DragAndDrop {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  // source element
	  WebElement dragableEle = driver.findElement(By.xpath("//img[@id='angular']"));
	  
	  //target element
	  WebElement targetElement = driver.findElement(By.xpath("//div[@id='droparea']"));
	  
	  // Create an instance of Actions class
      Actions actions = new Actions(driver);

      // Perform drag-and-drop operation
      actions.dragAndDrop(dragableEle, targetElement).build().perform();
      
      WebElement newLink = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
      actions.moveToElement(newLink).build().perform();
      Thread.sleep(2000);
      actions.contextClick(newLink).build().perform();
      
      Thread.sleep(2000);
      
      driver.navigate().to("https://demo.automationtesting.in/Selectable.html");
      WebElement ddclick = driver.findElement(By.xpath("//b[contains(text(),'Sakinalium - Readability')]"));
      actions.doubleClick(ddclick).build().perform();
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("https://demo.automationtesting.in/Static.html");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
  }

  @AfterTest
  public void afterTest() {
  }

}

