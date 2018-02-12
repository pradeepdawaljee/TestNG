package otherAll;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class ExecuteFailedTestCasesOnly {
	
	String suiteName="";
	
	@Test(dependsOnMethods="getTestSuitName")
	public void main() {
		
		System.out.println("Running Failed Test cases only for suite="+suiteName);
		
		suiteName="Preserve_Order";
		
		TestNG runner=new TestNG();
		
		List<String> suites=new ArrayList<String>();
		String path=System.getProperty("user.dir")+"\\test-output\\"+suiteName+"\\testng-failed.xml";
		
		suites.add(path);
		
		runner.setTestSuites(suites);
		runner.run();
		
		System.out.println("Failed Test cases Executed,path="+path);
		
	}
	
	@Test
	public void getTestSuitName(ITestContext context){
		suiteName=context.getCurrentXmlTest().getSuite().getName();
		System.out.println("SuiteName="+suiteName);
		
	}

}
