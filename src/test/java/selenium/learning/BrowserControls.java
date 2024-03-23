package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class BrowserControls {
	WebDriver driver;
  
  @Test (enabled = false)
  public void navigateConcepts() throws InterruptedException {
	  String title = driver.getTitle();
	  System.out.println("Title of the page is: "+title);
	  Thread.sleep(2000);
  }
  
  @Test (dependsOnMethods = "navigateConcepts", enabled = false)
  public void getURL() throws InterruptedException {
	  driver.findElement(By.xpath("//a[text()='WebTable']")).click();
	  Thread.sleep(2000);
	  
	  String currentURL = driver.getCurrentUrl();
	  System.out.println("Current URL is: "+currentURL);
  }
  
  @Test (dependsOnMethods = "getURL", enabled = false)
  public void getpageSource() throws InterruptedException {
	
//	  driver.findElement(By.xpath("//a[text()='SwitchTo']")).click();
	  driver.get("https://demo.automationtesting.in/Windows.html");
	  
//	  String getPageSourceVal = driver.getPageSource();
//	  System.out.println("Page Source is: "+getPageSourceVal);
	  
	  boolean result = driver.getPageSource().contains("Open New Seperate Windows"); 
	  if(result) {
	  System.out.println("Message is present");
	  }
	  else {
		  System.out.println("Message is not present");
	  }
	  
	  boolean result2 = driver.getPageSource().contains("Srikant"); 
	  if(result2) {
	  System.out.println("Message 2 is present");
	  }
	  else {
		  System.out.println("Message 2 is not present");
	  }
//	  driver.findElement(By.xpath("//a[@target='_blank']/button")).click();
  }
  
  @Test (dependsOnMethods = "getpageSource", enabled = false)
  public void driverclosequit() throws InterruptedException {
	
	  driver.get("https://demo.automationtesting.in/Windows.html");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[@target='_blank']/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[@target='_blank']/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[@target='_blank']/button")).click();
	  
	  //driver.close();
	  
	  driver.quit();
  }
  
  @Test 
  public void navigateOptions() throws InterruptedException {
	
//	  driver.get("https://demo.automationtesting.in/Windows.html");
	  
	  driver.navigate().to("https://demo.automationtesting.in/Windows.html");
	  Thread.sleep(3000);
	  driver.navigate().back();
	  Thread.sleep(3000);
	  driver.navigate().forward();
	  Thread.sleep(3000);
	  driver.navigate().back();
	  driver.findElement(By.xpath("//label[contains(text(),'Address')]/following-sibling::div/textarea")).sendKeys("This is Srikant before refresh");
//	  driver.navigate().back();
	  Thread.sleep(3000);
	  driver.navigate().refresh();
	  Thread.sleep(3000);
  }
  
  
  @BeforeClass
  public void openBrowser() throws InterruptedException {
	  
	  driver = new ChromeDriver();
	  driver.navigate().to("https://demo.automationtesting.in/Register.html");
//	  driver.get("https://demo.automationtesting.in/Register.html");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
  }

  @AfterClass
  public void classBrowser() {
//	  driver.quit();
  }

}
