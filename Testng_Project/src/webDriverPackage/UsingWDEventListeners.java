package webDriverPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class UsingWDEventListeners {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		CustomeWebDriverListeners cwdl=new CustomeWebDriverListeners();
		
		eDriver.register(cwdl);
		
		eDriver.get("https://www.google.com");
		
		eDriver.findElement(By.xpath("")).click();

	}

}
