 package selenium.learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FirstTestFile {
private static final Logger logger = LogManager.getLogger(FirstTestFile.class);

	@Test
  public void f() { 
	  System.out.println("This is main Method");
	  logger.info("This is a sample log message 1");
  }
  @Test
  public void f1() { 
	  System.out.println("This is main Method 2");
	  logger.info("This is a sample log message 2");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is before class");
	  logger.info("This is a sample log message 3");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is after test");
  }
  

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is BS");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is AS");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is BM");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is AM");
  }

}

class FirstTestFile1 {
	  @Test
	  public void f() { 
		  System.out.println("This is 2nd main");
	  }
	  @Test
	  public void f1() { 
		  System.out.println("This is 3rd main");
	  }
	

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("This is before test 2");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("This is after test 2");
	  }
	  

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("This is BS 2");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("This is AS 2");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("This is BM 2");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("This is AM 2");
	  }

	}
