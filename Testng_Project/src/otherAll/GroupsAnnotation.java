package otherAll;

import org.testng.annotations.Test;

public class GroupsAnnotation {
	
	@Test(description="Test Case 1",groups="login")
	public static void test1(){
		System.out.println("GroupsAnnotation test1");
	}
	
	@Test(groups="logout",priority=1,dependsOnGroups={"login"})
	public void test2(){
		System.out.println("GroupsAnnotation test2");
	}
	
	@Test(groups="reg",priority=2)
	public static void test3(){
		System.out.println("GroupsAnnotation test3");
	}
	
	@Test(groups="login",priority=2)
	public void test4(){
		System.out.println("GroupsAnnotation test4");
	}
	
	@Test(groups="reg",enabled=true)
	public static void test5(){
		System.out.println("GroupsAnnotation test5");
	}
	
	@Test(alwaysRun=true,groups="logout")
	public void test6(){
		System.out.println("GroupsAnnotation test6");
	}

}
