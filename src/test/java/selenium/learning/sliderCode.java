package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.interactions.Actions;
public class sliderCode {
	WebDriver driver;
  @Test
  public void f() {
	  WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/a"));
	// Create an instance of Actions class

      Actions actions = new Actions(driver);
      
      actions.dragAndDropBy(slider, 500, 0).build().perform();
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("https://demo.automationtesting.in/Slider.html");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
