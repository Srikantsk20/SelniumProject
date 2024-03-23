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
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class WebTableHandling {
	WebDriver driver;
  
	@Test
  public void f() {
		//identify the table:
		
		WebElement tableEle = driver.findElement(By.xpath("//table[@id='table1']"));
		
		
		// Find all rows in the table
        List<WebElement> rows = tableEle.findElements(By.tagName("tr"));

        // Print the number of rows in the table
        System.out.println("Number of rows in the table: " + rows.size());

//        // After finding rows in the table
//        for (WebElement row : rows) {
//            // Find all columns in the row
//            List<WebElement> columns = row.findElements(By.tagName("td"));
//
//            // Print the number of columns in each row
//            System.out.println("Number of columns in the row: " + columns.size());		
//        }
        	
        	// After finding rows in the table
        	for (int i = 1; i < rows.size(); i++) {
	            WebElement row = rows.get(i);
	            // Find all columns in the row
	            List<WebElement> columns = row.findElements(By.tagName("td"));
	            System.out.print("No. of columns are: "+columns.size() + "\t");
	            // Iterate through columns and print data
	            for (WebElement column : columns) {
	                System.out.print(column.getText() + "\t");
	            }
            System.out.println(); // Move to the next row
        	}
        	
        	//validate last Names:
        	
        	String[] lastNames = {"Smith", "Bach", "Doe", "Conway"};
        	
        	// After finding rows in the table
        	for (int i = 1; i < rows.size(); i++) {
	            WebElement row = rows.get(i);
	            // Find all columns in the row
	            List<WebElement> columns = row.findElements(By.tagName("td"));
	            System.out.print("No. of columns are: "+columns.size() + "\t");
	            // Iterate through columns and print data
	            
	            WebElement column = columns.get(0);
	            String tableLName = column.getText();
	            System.out.println("Lname from array is: "+ lastNames[i-1] + " Lname from table is: "+tableLName);
	            
	            Assert.assertEquals(tableLName, lastNames[i-1]);
	            
	            	
	            }
            System.out.println(); // Move to the next row
        	}
            
//        	// After finding rows in the table
//            for (WebElement row : rows) {
//            // Find all columns in the row
//            List<WebElement> columns = row.findElements(By.tagName("td"));
//
//            // Iterate through columns and print data
//            for (WebElement column : columns) {
//                System.out.print(column.getText() + "\t");
//            }
//            System.out.println(); // Move to the next row
        
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	
		  driver = new ChromeDriver();
		  driver.get("https://the-internet.herokuapp.com/tables");
		  driver.manage().window().maximize();
		  Thread.sleep(2000);
  }

  @AfterTest
  public void afterTest() {
  }

}
