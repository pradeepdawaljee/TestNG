package testDependencyFromOtherClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass2{

	@Test
	public void first2(){
		System.out.println("TestClass2 first method in Test");
	}
	
	@Test(dependsOnMethods={"first"})
	public void second2(){
		System.out.println("TestClass2 second method in Test");
	}
	
	@Test
	public void third2(){
		System.out.println("TestClass2 third method in Test");
		Assert.assertTrue(false);
	}
	
	@Test
	public void fourth2(){
		System.out.println("TestClass2 fourth method in Test");
	}
}
