package testNGFramework;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ListnerMainXML {
	@Test
    public void method1() {
        System.out.println("Pass Message from method 1");
        Assert.assertTrue(true); // Pass criteria
    }

    @Test
    public void method2() {
        System.out.println("fail message from method 2");
        Assert.fail("Intentional failure"); // Fail criteria
    }

    @Test
    public void method3() {
        System.out.println("skip message from method 3");
        throw new SkipException("Intentional skip"); // Skip criteria
    }
}
