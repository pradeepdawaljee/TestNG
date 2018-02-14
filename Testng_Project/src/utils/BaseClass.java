package utils;

import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public ExcelClass data;
	
	@BeforeSuite
	public void base(){
		data=new ExcelClass(System.getProperty("user.dir")+"/src/excelFiles/login.xlsx");
		//data.dataProviderGetData("ManyUsers");
		
	}

}

