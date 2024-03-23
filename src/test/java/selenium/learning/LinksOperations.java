package selenium.learning;

import org.testng.annotations.Test;
import java.util.ArrayList; // Import ArrayList class
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LinksOperations {
	WebDriver driver;
  @Test
  public void f() {
	  
	  
	  
	  int linkCount = driver.findElements(By.tagName("a")).size();
	  System.out.println("Total number of links on the page: " + linkCount);
	  
	  // Find all links on the page
      List<WebElement> links = driver.findElements(By.tagName("a"));

      // Capture values of all links
      for (WebElement link : links) {
          System.out.println(link.getAttribute("href"));
          
          String url = link.getAttribute("href");
          verifyLink(url);
          
      // Check if the link is displayed
      if (link.isDisplayed()) {
          System.out.println("The link is displayed.");
      } else {
          System.out.println("The link is not displayed.");
      }
          
      }
      
      
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	// ChromeOptions to disable Chrome's notifications
	  ChromeOptions options = new ChromeOptions();
      options.addArguments("--disable-notifications");
	  driver = new ChromeDriver(options);
	  driver.get("https://demo.guru99.com/test/newtours/");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);	  
  }

  @AfterTest
  public void afterTest() {
  }
  
  public static void verifyLink(String url) {
      try {
          URL linkUrl = new URL(url);
          HttpURLConnection httpURLConnection = (HttpURLConnection) linkUrl.openConnection();
          httpURLConnection.setConnectTimeout(3000);
          httpURLConnection.connect();

          if (httpURLConnection.getResponseCode() == 200) {
              System.out.println(url + " - " + httpURLConnection.getResponseMessage());
          } else {
              System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
          }
      } catch (Exception e) {
          System.out.println(url + " - " + "Link is broken.");
      }
  }


}
