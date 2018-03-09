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
	JavascriptExecutor jse;
	String baseUrl="https://letskodeit.teachable.com/p/practice";

	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		jse= (JavascriptExecutor)driver;
	}

	@Test(priority=1)
	public void openURL() throws InterruptedException{
		jse.executeScript("window.location='"+baseUrl+"';");

		Thread.sleep(2000);

		jse.executeScript("window.scrollBy(0,1500);");//Scroll down. 0 shows horizontal, other vertical

		Thread.sleep(2000);

		jse.executeScript("window.scrollBy(0,-1500);");//Scroll up

		Thread.sleep(2000);

		//WebElement element=(WebElement) js.executeScript("return document.getElementById('search-courses');");
		WebElement element=driver.findElement(By.id("mousehover"));
		
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		
		Thread.sleep(2000);
		
		jse.executeScript("window.scrollBy(0,-150);");
		
		Thread.sleep(1000);

	}
	
	@Test(priority=2)
	public void clickUsingJS(){
		WebElement element=driver.findElement(By.id("bmwradio"));
		//element.click();
		jse.executeScript("arguments[0].click();", element); // Use only when .click is not working
		
	}

	@AfterClass
	public void tearDown(){
		//Getting window size
		long height=(Long)jse.executeScript("return innerHeight;");
		long width=(Long)jse.executeScript("return innerWidth;");
		System.out.println("height="+height+" , width="+width);
	}
}
