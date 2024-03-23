package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class CookieHandling {
	WebDriver driver;
	
  @Test
  public void loginAndGetCookies() {
	  
	  driver.findElement(By.xpath("//input[@value=' Click Here to Log In ']")).click();
	  driver.findElement(By.xpath("//input[@name='LoginName']")).sendKeys("AutomationTestGuide");
	  driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("busyQA");
	  driver.findElement(By.xpath("//input[@value='Log Me In']")).click();
	  
	  Set<Cookie> allCookies = driver.manage().getCookies();
	  
	  System.out.println("All the cookies are below: ");
	  
	  for (Cookie c1 : allCookies) {
		  System.out.println(c1);
	  }
	  System.out.println("  ");
  }
  
  @Test(dependsOnMethods = "loginAndGetCookies", enabled = true)
  public void getCookieByName() {
	  Cookie cookie = driver.manage().getCookieNamed("DisplayInfo1");
	  System.out.println("Single coookie value: "+cookie);
	  System.out.println("  ");
  }
  
  @Test(dependsOnMethods = "getCookieByName", enabled = true)
  public void createNewCookie() {
	  	  
	  // Create a new cookie
	  //Cookie newCookie = new Cookie("cookieName", "cookieValue");
	  Cookie newCookie = new Cookie("Srikant", "TestCookieFromSelenium");
	  // Add the cookie to the browser
	  driver.manage().addCookie(newCookie);
	  
	  Set<Cookie> allCookies = driver.manage().getCookies();
	  
	  System.out.println(" All the cookies after Adding cookie ");
	  
	  for (Cookie c1 : allCookies) {
		  System.out.println(c1);
	  }
	  System.out.println("  ");
  }
  
  @Test(dependsOnMethods = "createNewCookie", enabled = true)
  public void DeleteACookie() {
	  	  
	  // Delete specific cookie
	  Cookie cookieToDelete = driver.manage().getCookieNamed("DisplayInfo1");
	  driver.manage().deleteCookie(cookieToDelete);
	  
	  Set<Cookie> allCookies = driver.manage().getCookies();
	  
	  System.out.println(" All the cookies after deleting DisplayInfo1 ");
	  
	  for (Cookie c1 : allCookies) {
		  System.out.println(c1);
	  }
	  
	  System.out.println("  ");
	  
	  // Delete specific cookie according Name
	  driver.manage().deleteCookieNamed("UserInfo1");
	  
	  Set<Cookie> allCookies1 = driver.manage().getCookies();
	  
	  System.out.println(" All the cookies after deleting UserInfo1 ");
	  
	  for (Cookie c1 : allCookies1) {
		  System.out.println(c1);
	  }
	  System.out.println("  ");
  }
  
  @Test(dependsOnMethods = "DeleteACookie", enabled = false)
  public void DeleteAllCookie() {
	  	  
	// Delete all cookies
	  driver.manage().deleteAllCookies();
	  
Set<Cookie> allCookies = driver.manage().getCookies();
	  
	  System.out.println(" Cookies after deleting everything ");
	  
	  for (Cookie c1 : allCookies) {
		  System.out.println(c1);
	  }
	  
	  System.out.println("  ");
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.navigate().to("http://www.memotome.com/");
//	  driver.get("https://demo.automationtesting.in/Register.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  Thread.sleep(2000);
  }

  @AfterTest 
  public void afterTest() {
  }

}
