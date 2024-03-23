package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class CalendarThree {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
//	  Alert alert = driver.switchTo().alert();
//	  alert.dismiss();
//	  Actions actions = new Actions(driver);
//	  actions.click();
	  String monthYearCheckIn = "December 2024";
	  int dayCheckIn = 20;
	  Thread.sleep(2000);
	  try {
	  driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
	  }
	  catch (NoSuchElementException e){
		  System.out.println("Element not found: " + e.getMessage());
	  }
	  
//	  WebElement calendarField = driver.findElement(By.xpath("//button[@data-testid='date-display-field-start']"));
//	  
//	  calendarField.click();
	  driver.findElement(By.xpath("//button[@data-testid='date-display-field-start']")).click();
	  Thread.sleep(2000);
	  String YearMonth = driver.findElement(By.xpath("//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/h3")).getText();
	  
	  System.out.println("Current cal Month and Year is: "+ YearMonth);
	  
	  while(!monthYearCheckIn.equals(YearMonth)) {
		 driver.findElement(By.xpath("//div[@data-testid='searchbox-datepicker-calendar']/button[@aria-label='Next month']")).click();
		 YearMonth = driver.findElement(By.xpath("//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/h3")).getText();
	  }
	  //div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//td//span[text()='20']/parent::span
//	  String dateLocator = "\"//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody[1]//td//span[text()='"+String.valueOf(dayCheckIn)+"']/parent::span\"";
//	  System.out.println("xpath is "+dateLocator);
	  
	  List<WebElement> colDayElements = driver.findElements(By.xpath("//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody[1]//td/span/span"));
	  
	  for (WebElement ele: colDayElements) {
		  String browserDay = ele.getText();
		  if (browserDay.equals(String.valueOf(dayCheckIn))) {
			  ele.click();
		  }
	  }
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@data-testid='date-display-field-end']")).click();
	  
//	  String setDateVal = "01-05-2024";
//	  
//	  JavascriptExecutor js = ((JavascriptExecutor) driver);
//	  js.executeScript("arguments[0].setAttribute('value','"+setDateVal+"');", calendarField);
	  
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("https://www.booking.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
  }

  @AfterTest
  public void afterTest() {
  }

}
