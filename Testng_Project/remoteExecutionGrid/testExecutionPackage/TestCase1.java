package testExecutionPackage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import basePackage.TestBaseClass;

public class TestCase1 extends TestBaseClass {
	
	int count=0; // if used static then this would be associated with class, anywer in same execution if it is called, it would continue from previous value even if the different objects called this.
	
	@Test(invocationCount=10)
	public void testCase1() throws InterruptedException{
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys("one"+(count++)+"@one.com");
		Thread.sleep(2000);
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.name("Password")).sendKeys("Pass1");
		System.out.println("testCase1 done");
	}
	
	@Test
	public void testcase2(){
		
		driver.findElement(By.linkText("Forgot Password")).click();
		System.out.println("testCase2 done");
	}

}
