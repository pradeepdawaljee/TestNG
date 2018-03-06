package javaScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpeningBrowserAndNavigationThroughJS {
	
	JavascriptExecutor js;
	String baseUrl="https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
	
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		js= (JavascriptExecutor)driver;
	}
	
	@Test
	public void openURL(){
		js.executeScript("window.location='"+baseUrl+"';");
		WebElement username=(WebElement) js.executeScript("return document.getElementById('identifierId');");
		username.sendKeys("Sending value using js scripts");
		
	}
	
	@AfterClass
	public void tearDown(){
		//Getting window size
		long height=(Long)js.executeScript("return innerHeight;");
		long width=(Long)js.executeScript("return innerWidth;");
		System.out.println("height="+height+" , width="+width);
	}

}
