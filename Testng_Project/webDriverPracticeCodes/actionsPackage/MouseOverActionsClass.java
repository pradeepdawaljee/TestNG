package actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseOverActionsClass {
	
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
		driver.get(baseUrl);

		//WebElement element=(WebElement) js.executeScript("return document.getElementById('search-courses');");
		WebElement mainElement=driver.findElement(By.id("mousehover"));
		
		jse.executeScript("arguments[0].scrollIntoView(true);",mainElement);
		
		jse.executeScript("window.scrollBy(0,-150);");
		
		Actions action=new Actions(driver);
		action.moveToElement(mainElement).perform();
		Thread.sleep(1000);
		
		WebElement subElement=driver.findElement(By.xpath("//div[@class='mouse-hover']//a[text()='Top']"));
		//subElement.click(); This can also be used
		action.moveToElement(subElement).click().perform();
		
		
		Thread.sleep(1000);

	}
	

}
