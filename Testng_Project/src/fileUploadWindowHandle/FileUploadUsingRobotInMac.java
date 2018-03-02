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

public class FileUploadUsingRobotInMac {
	
	@Test
	public void fileUploadInMac() throws AWTException{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://files.fm/");
		driver.findElement(By.xpath(".//*[@id='uploadifive-file_upload']/span[2]")).click();
		
		String filePath=System.getProperty("user.dir")+"\\src\\excelFiles\\login.xlsx";
		StringSelection filePathToCopy=new StringSelection(filePath);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathToCopy, null);
		
		//cmd+tab > cmd+shift+g > paste>two tyms enter  ----- This is to upload file in mac through keyboard
		
		Robot robot=new Robot();
		//cmd+tab to operate on file window
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(2000);
		//cmd+shift+g
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);
		//paste- cmd+V
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);
		//Hit Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		//Again hit Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}
