package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.interactions.Actions;
public class AlertsClass {
	WebDriver driver;
  @Test (enabled = false)
  public void alertSimple() throws InterruptedException {
	  driver.findElement(By.xpath("//button[contains(text(),'click the button to display an  alert box')]")).click();
	  Thread.sleep(3000);
	  // Switch to the alert
      Alert alert = driver.switchTo().alert();

      // Get the text of the alert
      String alertMessage = alert.getText();
      System.out.println("Alert message: " + alertMessage);

      // Accept the alert
      alert.accept();
	  
  }
  
  @Test (dependsOnMethods = "alertSimple", enabled = false)
  public void alertOkCancel() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
	  driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box ')]")).click();
	  Thread.sleep(3000);
	  
	  // Switch to the alert
      Alert alert = driver.switchTo().alert();

      // Get the text of the alert
      String alertMessage = alert.getText();
      System.out.println("Alert message: " + alertMessage);
      Thread.sleep(2000);
      
      // Accept the alert
//      alert.accept();
      
      // Dismiss the alert (click Cancel)
      alert.dismiss();
	  
      String message = driver.findElement(By.xpath("//p[@id='demo']")).getText();
      System.out.println("message is: " + message);
      
  }
  
  @Test//(dependsOnMethods = "alertOkCancel", enabled = false)
  public void alertTextBox() throws InterruptedException {
	  driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox ')]")).click();
	  driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box ')]")).click();
	  Thread.sleep(3000);
	  
	  // Switch to the alert
      Alert alert = driver.switchTo().alert();

      // Get the text of the alert
      String alertMessage = alert.getText();
      System.out.println("Alert message: " + alertMessage);

      // Enter text into the prompt
      alert.sendKeys("Srikant");
      Thread.sleep(2000);
      
      // Accept the alert
      alert.accept();
      
      // Dismiss the alert (click Cancel)
//      alert.dismiss();
	  
//      String message = driver.findElement(By.xpath("//p[@id='demo']")).getText();
//      System.out.println("message is: " + message);
	  
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("https://demo.automationtesting.in/Alerts.html");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
  }

  @AfterTest
  public void afterTest() {
	  
	  
  }

}
