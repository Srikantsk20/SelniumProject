//This code doesnt work.
//package selenium.learning;
//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeTest;
//import java.time.Duration;
//import java.util.Date;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterTest;
//import org.openqa.selenium.*;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//public class CookieFile2 {
//  @Test
//  public void f() throws InterruptedException, ParseException {
//	  WebDriver driver;
//	  driver = new ChromeDriver();
//	  driver.manage().window().maximize();
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	  
//	  // Set the date and time string
//      String dateString = "26 Apr 2025 12:52:35 GMT-04:00";
//      
//      // Parse the date string into a Date object
//      SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
//      Date expiryDate = dateFormat.parse(dateString);
//      
//      // Set the domain, path, and expiry date for the cookie
//      String domain = ".memotome.com";
//      String path = "/";
//      
//      // Create the cookie with SameSite=Lax attribute
//      Cookie newCookie = new Cookie.Builder("DisplayInfo1", "PADI=847794&DateFormat=%25A%2C+%25B+%25%23d%2C+%25Y&DisplayName=Testing+User")
//              .domain(domain)
//              .path(path)
//              .expiresOn(expiryDate)
//              .sameSite("Lax")
//              .build();
//	  
//      Cookie newCookie1 = new Cookie.Builder("UserInfo1", "UserId=Y35PZCNR")
//              .domain(domain)
//              .path(path)
//              .expiresOn(expiryDate)
//              .sameSite("Lax")
//              .build();
//	
//	  //Cookie newCookie1 = new Cookie("UserInfo1", "UserId=Y35PZCNR", ".memotome.com",  "/", new Date(System.currentTimeMillis() + 86400000) );
//	  //Cookie newCookie2 = new Cookie("V1", "A0rJmd16Xctzv8wNPHWCa4bLPLhAFEwwRLkrJvNUKZUGf9JbmZXBoQ%3D%3D", ".memotome.com",  "/", new Date(System.currentTimeMillis() + 86400000) );
//	  driver.manage().addCookie(newCookie);
//	  driver.manage().addCookie(newCookie1);
//	  //driver.manage().addCookie(newCookie2);
//	  
//	  driver.navigate().to("http://www.memotome.com/home.asp?display=reminder");
//	
//	  String textmessage = driver.findElement(By.partialLinkText("Testing Reminder")).getText();
//	  System.out.println("textmessage is:"+ textmessage);
//	  
//	  Thread.sleep(2000);
//  }
// 
//
//}
