package testExecutionPackage;

import org.testng.annotations.Test;

import basePackage.TestBaseClass;

public class TestCase1 extends TestBaseClass {
	
	@Test
	public void testCase1(){
		System.out.println("testCase1 done");
	}
	
	@Test
	public void testcase2(){
		System.out.println("testCase2 done");
	}

}
