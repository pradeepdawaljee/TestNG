package checkAllLinksStatusOnWebPage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyLinksOnPage {
	
	private WebDriver driver;
	private String baseUrl="https://www.expedia.com";
	
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
	}
	
	@Test
	public void testFindLinks(){
		List<WebElement> linksList=clickableLinks(driver, "a", "img");
		System.out.println("Total number of links on the page="+linksList.size());
		for(WebElement link:linksList){
			String href=link.getAttribute("href");
			
			try{
				System.out.println("URL="+href+"    ******************   status returned="+linkStatus(new URL(href)));
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
		}
		System.out.println("Done");
		
	}
	
	
	
	public static List<WebElement> clickableLinks(WebDriver driver,String tagNameAsAnchor,String tagNameAsIMG){
		
		List<WebElement> elements=driver.findElements(By.tagName(tagNameAsAnchor)); // "a" for links, generally
		elements.addAll(driver.findElements(By.tagName(tagNameAsIMG))); // "img" as images also clickable
		
		List<WebElement> linksToClick=new ArrayList<WebElement>();
		for(WebElement element:elements){
			
			if(element.getAttribute("href")!=null){
				linksToClick.add(element);
			}
		}
		
		return linksToClick;
		
	}
	
	public static String linkStatus(URL url){
		// http://download.java.net something extra
		try {
			HttpURLConnection http= (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage=http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	

}
