package fileUploadWindowHandle;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploadUsingRobot {

	@Test
	public void fileUpload() throws AWTException, InterruptedException{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://files.fm/");
		driver.findElement(By.xpath(".//*[@id='uploadifive-file_upload']/span[2]")).click();
		
		StringSelection path=new StringSelection(System.getProperty("user.dir")+"/src/excelFiles/login.xlsx");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
		
		Robot robot=new Robot();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}
