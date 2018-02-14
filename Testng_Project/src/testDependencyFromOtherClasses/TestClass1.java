package testDependencyFromOtherClasses;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestClass1 {

	@Test
	public void first(){
		System.out.println("TestClass1 first method in Test");
		Assert.assertTrue(false);
	}
	
	@Test
	public void second(){
		System.out.println("TestClass1 second method in Test");
	}
	
	@Test(dependsOnMethods="testDependencyFromOtherClasses.TestClass2.third2")
	public void third(){
		System.out.println("TestClass1 third method in Test");
	}
	
	@Test
	public void fourth(){
		System.out.println("TestClass1 fourth method in Test");
	}
}
