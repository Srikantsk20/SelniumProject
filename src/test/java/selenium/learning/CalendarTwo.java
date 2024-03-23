package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.support.ui.Select;

public class CalendarTwo {
	WebDriver driver;

  @Test
  public void f() { 
	  
	  String month = "May";
	  String year = "2024";
	  int day = 20;
	  driver.findElement(By.id("departon")).click();
      
	  WebElement monthEle = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
	  Select monthDropDown = new Select(monthEle);
	  
	  monthDropDown.selectByVisibleText(month);
      
	  WebElement yearEle = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
	  Select yearDropDown = new Select(yearEle);
	  
	  yearDropDown.selectByVisibleText(year);
	  
	
	  
	  List<WebElement> datePicker = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td/a"));
      
      for (WebElement ele: datePicker) {
    	  
    	  String dateInCal = ele.getText();
    	  if (dateInCal.equals(String.valueOf(day))) {
    		  ele.click();
    		  break;
    	  }
      }
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
	  driver.manage().window().maximize();
	  
  }

  @AfterTest
  public void afterTest() {
  }
    
}
