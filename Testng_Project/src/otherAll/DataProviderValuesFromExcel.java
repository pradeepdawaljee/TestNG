package otherAll;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;

public class DataProviderValuesFromExcel extends BaseClass {
	
	@DataProvider()
	public Object[][] getManyUsers(){
		
		//ExcelClass data=new ExcelClass(System.getProperty("user.dir")+"/src/excelFiles/login.xlsx");
		
		Object[][] data1=data.dataProviderGetData("ManyUsers");
		return data1;
	}
	
	@DataProvider()
	public Object[][] getManyUsersOtherSheet(){
		
		//ExcelClass data=new ExcelClass(System.getProperty("user.dir")+"/src/excelFiles/login.xlsx");
		
		return data.dataProviderGetData("GiveOtherSheet");
	}
	
	@Test(dataProvider="getManyUsers")
	public void test(String username,String password){
		
		System.out.println(username+" "+password);
	}
	

}
