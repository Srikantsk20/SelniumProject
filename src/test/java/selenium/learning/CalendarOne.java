package selenium.learning;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class CalendarOne {
	WebDriver driver;
	static int targetDay = 0, targetMonth = 0, targetYear=0;
	static int currentDay = 0, currentMonth = 0, currentYear=0;
	static boolean increment = true;
	static String monthInBrowser = null;
	static String yearInBrowser = null;
	
  @Test
  public void mainCode() throws InterruptedException {
//	  System.out.println("Enter Date to Set in DD/MM/YYYY format: ");
//	  Scanner scanner = new Scanner(System.in);
//	  String dateToSet = scanner.next();
//	  scanner.close();
	  String dateToSet = "24/6/2024";
	  getCurrentDateMonthAndYear();
	  System.out.println("Current Date: " + currentYear + "-" + currentMonth + "-" + currentDay);
	  setTargetDateMonthAndYear(dateToSet);
	  System.out.println("Target Date: " + targetYear + "-" + targetMonth + "-" + targetDay);
	  
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
      driver.findElement(By.xpath("//input[@id='datepicker']")).click();
      monthInBrowser = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
      yearInBrowser = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
      // Convert month name to its corresponding number representation
      YearMonth browserCalDate = YearMonth.of(Integer.parseInt(yearInBrowser), (Month.valueOf(monthInBrowser.toUpperCase())).getValue());
      YearMonth setCalDate = YearMonth.of(targetYear, targetMonth);
      
      // Calculate the difference in months
      long differenceInMonths = ChronoUnit.MONTHS.between(browserCalDate, setCalDate);
      
      if (differenceInMonths < 0 ) {
    	  increment = false;
      }
      
      
      System.out.println("Difference in months is: "+ differenceInMonths);
           
      for(int i = 0 ; i < Math.abs(differenceInMonths); i++) {
    	  if(increment) {
    		  driver.findElement(By.xpath("//a[@title='Next']")).click();
    		  Thread.sleep(2000);
    		  }
    	  else {
    		  driver.findElement(By.xpath("//a[@title='Prev']")).click();
    		  increment =  false;
    		  Thread.sleep(2000);
    	  }
      }
      
      //link text
      //driver.findElement(By.linkText(String.valueOf(targetDay))).click();
      
      //forloop
      
      List<WebElement> datePicker = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td/a"));
      
      for (WebElement ele: datePicker) {
    	  
    	  String dateInCal = ele.getText();
    	  if (dateInCal.equals(String.valueOf(targetDay))) {
    		  ele.click();
    		  break;
    	  }
      }
      
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.get("https://jqueryui.com/datepicker/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }
  
  public static void getCurrentDateMonthAndYear() {
	  Calendar cal = new GregorianCalendar();
	  currentYear = cal.get(Calendar.YEAR);
      currentMonth = cal.get(Calendar.MONTH) + 1; // Adding 1 because months are 0-based
      currentDay = cal.get(Calendar.DAY_OF_MONTH);
  }
  
  public static void setTargetDateMonthAndYear(String dateToSet) {
	  int firstIndex = dateToSet.indexOf("/");
	  int lastIndex = dateToSet.lastIndexOf("/");
	  targetDay = Integer.parseInt(dateToSet.substring(0,firstIndex));
	  targetMonth = Integer.parseInt(dateToSet.substring(firstIndex+1,lastIndex));
	  targetYear = Integer.parseInt(dateToSet.substring(lastIndex+1,dateToSet.length()));
  }

}
