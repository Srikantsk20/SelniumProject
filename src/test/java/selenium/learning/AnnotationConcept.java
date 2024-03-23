package selenium.learning;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationConcept {
  @Test
  public void testMethod() {
	  System.out.println("This is test method");
  }
  
  @Test
  public void testMethod2() {
	  System.out.println("This is test method 2");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is before class");
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
	  System.out.println("This is before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is after Suite");
  }

}

class FirstTestFile2 {
	  @Test
	  public void f() { 
		  System.out.println("This is 2nd main");
	  }
	  @Test
	  public void f1() { 
		  System.out.println("This is 3rd main");
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
