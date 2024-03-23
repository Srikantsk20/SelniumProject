package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.sikuli.script.Pattern;
public class FileUploadSikuli {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException, FindFailed {
	  
	  WebElement button = driver.findElement(By.xpath("//*[@id='imagesrc']"));
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click();", button);
	  Thread.sleep(3000);
	  
	  //Image files
	  String imagesFilePath="C:\\Users\\Srikant\\Desktop\\Sikuli\\";
	  String inputFilePath="C:\\Users\\Srikant\\Desktop\\Sikuli\\";
	  
	  // Initialize Sikuli Screen
	  Screen s = new Screen();

      // Specify the file input using Sikuli Pattern
      Pattern fileInputTextbox = new Pattern(inputFilePath+"FileName.PNG");
      Pattern openButton = new Pattern(imagesFilePath+"openButton.PNG");
      
      Thread.sleep(5000);
      
      s.wait(fileInputTextbox,20);
      s.type(fileInputTextbox,inputFilePath+"Session1thumb.PNG");
      s.click(openButton);
     
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
