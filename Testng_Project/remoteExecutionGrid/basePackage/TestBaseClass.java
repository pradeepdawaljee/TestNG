package basePackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/* This Block to be saved as grid_node.json and in command prompt use 
 java -jar selenium-server-standalone-2.47.1.jar -role node -nodeConfig grid_node.json 
 Make sure open this file only in IDE's so that format doesn't mess up
{
	"capabilities":
		[
			{
				"browserName": "chrome",
				"maxInstances": 1
			},
			{
				"browserName": "firefox",
				"maxInstances": 1
			}
		],
			"port":5555,
			"hubPort":4444,
			"hubHost":"192.168.0.101",
			"registerCycle":10000,
			"register":true,
			"timeout":0,
			"maxSession":2
}
 */


public class TestBaseClass {
	
	protected WebDriver driver;
	
	public static WebDriver getRemoteWebDriverInstance(String platform,String browser,String version,String url) throws MalformedURLException{
		
		//String nodeUrl="http://ipAddessewithport/wd/hub";
		//String nodeUrl="http://192.168.0.137:5555/wd/hub";
		String nodeUrl="http://192.168.0.108:5555/wd/hub";
		WebDriver driver=null;
		//Platform platform=null;
		//String version=null;
		//URL remoteAddress=new URL(nodeUrl);
		
		
		DesiredCapabilities caps=new DesiredCapabilities();
		
		if(platform.equalsIgnoreCase("Windows")){
			caps.setPlatform(Platform.WINDOWS);
		}else if(platform.equalsIgnoreCase("Mac")){
			caps.setPlatform(Platform.MAC);
		}else{
			caps.setPlatform(Platform.WIN10);
		}
		
		if(browser.equalsIgnoreCase("chrome")){
			caps=DesiredCapabilities.chrome();			
		}else if(browser.equalsIgnoreCase("firefox")){
			caps=DesiredCapabilities.firefox();
		}else{
			caps=DesiredCapabilities.htmlUnit();
		}
		
	
		caps.setVersion(version);
		
		driver=new RemoteWebDriver(new URL(nodeUrl), caps);
		
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	@Parameters({"platform","browser","version","url"})
	@BeforeClass
	public void setup(String platform,String browser,String version,String url) throws MalformedURLException{
		driver=getRemoteWebDriverInstance(platform, browser, version, url);
	}
	
	
	
	@AfterClass
	public void tearDown(){
		//driver.quit();
	}
	
	/**
	 * 
	 * Selenium Grid Configurations

Step 1:

Download the selenium server from http://docs.seleniumhq.org/download/ Put it on Hub and all Nodes

Step 2:

Go to hub. Using the command prompt, navigate to the directory Selenium Server jar is placed.

Run selenium server using this command

java -jar selenium-server-standalone-2.47.1.jar -role hub


Name of the jar files varies on version 2.47.1 is not always true


Step 3:

Go to all nodes. Using the command prompt, navigate to the directory Selenium Server jar is placed.

Run selenium server using this command

java -jar selenium-server-standalone-2.47.1.jar –role webdriver – hub http://<hostname/ip of hub>:4444/grid/register –port 5555

Advance command for specific instance

java -jar selenium-server-standalone-2.47.1.jar -role node –hub <hub hostname>/grid/register -browser "browserName=internet explorer,version=11,maxinstance=1, platform=WINDOWS" –port 5656
	 
	####{@link #getRemoteWebDriverInstance(String, String, String, String)}   
	
java -jar selenium-server-standalone-2.48.2.jar -role node -hub http://10.0.0.6:4444/grid/register -Dwebdriver.chrome.driver=.\chromedriver.exe
	
	
	
	
	 * */
	
	
	

}
