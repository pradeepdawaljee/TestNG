package otherAll;

import org.testng.annotations.*;

public class AllAnnotationsExecutionOrder{
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("AllAnnotationsExecutionOrder beforeSuite");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("AllAnnotationsExecutionOrder beforeTest");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("AllAnnotationsExecutionOrder beforeClass");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("AllAnnotationsExecutionOrder beforeMethod");
	}
	
	@Test(priority=1)
	public void test1(){
		System.out.println("AllAnnotationsExecutionOrder test1");
	}
	
	@Test
	public void test2(){
		System.out.println("AllAnnotationsExecutionOrder test2");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("AllAnnotationsExecutionOrder afterMethod");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("AllAnnotationsExecutionOrder afterClass");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("AllAnnotationsExecutionOrder afterTest");
	}
	
	@AfterSuite
	public void afterSuite(){		
		System.out.println("AllAnnotationsExecutionOrder afterSuite");
	}
	
	
	//Output
	
	/*AllAnnotationsExecutionOrder beforeSuite
AllAnnotationsExecutionOrder beforeTest
AllAnnotationsExecutionOrder beforeClass
AllAnnotationsExecutionOrder beforeMethod
AllAnnotationsExecutionOrder test1
AllAnnotationsExecutionOrder afterMethod
AllAnnotationsExecutionOrder beforeMethod
AllAnnotationsExecutionOrder test2
AllAnnotationsExecutionOrder afterMethod
AllAnnotationsExecutionOrder afterClass
AllAnnotationsExecutionOrder afterTest
AllAnnotationsExecutionOrder afterSuite*/
	
	
	

}
