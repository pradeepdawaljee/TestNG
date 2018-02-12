package preserve;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//@Listeners(listnersTestPack.MyTestNGListners.class)
public class ClassOne {

	@Parameters({"One","Two"})
	@Test(testName="MyFirstOwnTestName")
	public void first(String One,String two){
		System.out.println("ClassOne first method in Test "+One+" & "+two);
	}

	@Test
	public void second(){
		Assert.assertTrue(true);
		System.out.println("ClassOne second method in Test");
	}

	@Test
	public void third(){
		System.out.println("ClassOne third method in Test");
	}

	@Test
	public void fourth(){
		System.out.println("ClassOne fourth method in Test");
	}

	@Test(dataProvider="data")
	public void dataProviderParameters(String dataCol1,String dataCol2,String dataCol3){
		System.out.println("The data is "+dataCol1+" "+dataCol2+" "+dataCol3);
	}

	@DataProvider
	public Object[][] data(){

		Object[][] dataObj=new Object[2][3];

		//1st Row
		dataObj[0][0]="00";
		dataObj[0][1]="01";
		dataObj[0][2]="02";

		//2nd Row
		dataObj[1][0]="10";
		dataObj[1][1]="11";
		dataObj[1][2]="12";

		/*//3nd Row
		dataObj[2][0]="20";
		dataObj[2][1]="21";
		dataObj[2][2]="22";*/


		return dataObj;

	}

}
