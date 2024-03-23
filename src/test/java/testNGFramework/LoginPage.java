package testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(name = "userName") WebElement txtUsername;
	
	//@FindBy(name = "password") WebElement txtPassword;
	By txtPassword = By.name("password");
	
	@FindBy(name = "submit") WebElement btnSubmit;
	
	LoginPage(WebDriver rdriver){
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String uname) {
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		driver.findElement(txtPassword).sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
}
