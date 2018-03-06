package javaScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollingElement {

	WebDriver driver;
	JavascriptExecutor js;
	String baseUrl="https://letskodeit.teachable.com/p/practice";

	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		js= (JavascriptExecutor)driver;
	}

	@Test
	public void openURL() throws InterruptedException{
		js.executeScript("window.location='"+baseUrl+"';");

		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,1500);");//Scroll down. 0 shows horizontal, other vertical

		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,-1500);");//Scroll up

		Thread.sleep(2000);

		//WebElement element=(WebElement) js.executeScript("return document.getElementById('search-courses');");
		WebElement element=driver.findElement(By.id("mousehover"));
		
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,-150);");

	}

	@AfterClass
	public void tearDown(){
		//Getting window size
		long height=(Long)js.executeScript("return innerHeight;");
		long width=(Long)js.executeScript("return innerWidth;");
		System.out.println("height="+height+" , width="+width);
	}
}
