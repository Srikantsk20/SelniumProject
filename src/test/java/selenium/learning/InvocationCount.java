package selenium.learning;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList; // Import ArrayList class
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
public class InvocationCount{
	WebDriver driver;
  @Test (priority = 1)
  public void radioButtonMethod() throws InterruptedException {
	  System.out.println("Priority is 1");
	  WebElement genederSelector = driver.findElement(By.xpath("//label[text() =' Male ']/input"));
	  
	  System.out.println("isEnabled ? : "+genederSelector.isEnabled());
	  System.out.println("isDisplayed ? : "+genederSelector.isDisplayed());
	  
	   if (!genederSelector.isSelected()) {
		   genederSelector.click();
	   }
	   Thread.sleep(3000);
	   
	   WebElement genederFemaleSelector = driver.findElement(By.xpath("//label[text() =' FeMale']/input"));
	   if (!genederFemaleSelector.isSelected()) {
		   genederFemaleSelector.click();
	   }   
  }
  
  @Test (priority = 2,enabled = false)
  public void CheckBoxMethod() throws InterruptedException {
	  System.out.println("Priority is 2");
	  WebElement checkboxFirst = driver.findElement(By.xpath("//input[@id='checkbox1']"));
	  
	  //isDisplayed() checks if the element is visible.
	  //isEnabled() checks if the element is enabled for interaction.
	  
	  System.out.println("isEnabled ? : "+checkboxFirst.isEnabled());
	  System.out.println("isDisplayed ? : "+checkboxFirst.isDisplayed());
	  
	   if (!checkboxFirst.isSelected()) {
		   checkboxFirst.click();
	   }
	   WebElement checkboxFirst2 = driver.findElement(By.xpath("//input[@id='checkbox2']"));
	   if (!checkboxFirst2.isSelected()) {
		   checkboxFirst2.click();
	   }
	   WebElement checkboxFirst3 = driver.findElement(By.xpath("//input[@id='checkbox3']"));
	   if (!checkboxFirst3.isSelected()) {
		   checkboxFirst3.click();
	   }
	   Thread.sleep(3000);
	   
	   //Unselect the check box 
	   if (checkboxFirst.isSelected()) {
		   checkboxFirst.click();
	   }
	   if (checkboxFirst3.isSelected()) {
		   checkboxFirst3.click();
	   } 
  }
  
  @Test (priority = 3, invocationCount = 3)
  public void DropdownHandles() throws InterruptedException {
	  System.out.println("Priority is 3");
	  WebElement dropdownSkills = driver.findElement(By.xpath("//Select[@id='Skills']"));
	  
	  Select selectDropdownSkills = new Select(dropdownSkills);
	  
	// Select options by visible text
	  selectDropdownSkills.selectByVisibleText("Android");
	  Thread.sleep(2000);
	  selectDropdownSkills.selectByVisibleText("AutoCAD");
	  Thread.sleep(2000);
	 
      // Alternatively, you can select options by value or index
       selectDropdownSkills.selectByValue("APIs");
       Thread.sleep(2000);
	   selectDropdownSkills.selectByValue("Art Design");
	   Thread.sleep(2000);
	   
	  // Alternatively, you can select options by index
      selectDropdownSkills.selectByIndex(0); //first option
      Thread.sleep(2000);
      selectDropdownSkills.selectByIndex(5); //6th option
  }
  
  @Test (priority = 4, enabled = false)
  public void DropdownMultiselectHandles() throws InterruptedException {
	  System.out.println("Priority is 4");  
  WebElement dropdownLanguages = driver.findElement(By.xpath("//div[@id='msdd']/parent::multi-select"));
  dropdownLanguages.click();
  
  WebElement danishSelect = dropdownLanguages.findElement(By.xpath("//a[text()='Danish']"));
  danishSelect.click();
  
  WebElement englishSelect = dropdownLanguages.findElement(By.xpath("//a[text()='English']"));
  englishSelect.click();
  
  WebElement germanSelect = dropdownLanguages.findElement(By.xpath("//a[text()='German']"));
  germanSelect.click();
   
  }
  
  @Test (priority = 5,enabled=false,alwaysRun = true)
  public void dropdownselect_deselect() throws InterruptedException {
	  System.out.println("Priority is 5");
	  WebElement dropdownCountry = driver.findElement(By.xpath("//Select[@id='country']"));
	  
	  Select selectDropdownSkills = new Select(dropdownCountry);
	  
	  int countSel = selectDropdownSkills.getOptions().size();
	  System.out.println("Number of element: "+ (countSel-1));
	// Get all selected options
      List<WebElement> selectedOptions = selectDropdownSkills.getOptions();

      List<String> selectedOptionTexts = new ArrayList<>();
      
      for (WebElement option : selectedOptions) {
          selectedOptionTexts.add(option.getText());
      }
      
      System.out.println(selectedOptionTexts);
      
	// Select options by visible text
	  selectDropdownSkills.selectByVisibleText("Bangladesh");
	  Thread.sleep(2000);	 
  }
  
  @BeforeMethod
  public void openBrowser() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.get("https://demo.automationtesting.in/Register.html");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
  }

  @AfterMethod
  public void classBrowser() {
	 driver.close(); 
  }

}
