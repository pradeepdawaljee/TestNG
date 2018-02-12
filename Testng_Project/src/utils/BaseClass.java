package utils;

import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public ExcelClass data;
	
	@BeforeSuite
	public void base(){
		
		data.dataProviderGetData("ManyUsers");
		
	}

}

