package windows_Handler;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import implementation_listeners_DXpath_Wait.Utility;


public class WindowsHandler {
	WebDriver driver;
	
	@Test
	public void windowHandler() throws Exception{
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("file:///D:/snehal/selenium%20software/Offline%20Website/Offline%20Website/pages/examples/links.html");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	String mainwindow=driver.getWindowHandle();
	List<WebElement>listofGoLinks=driver.findElements(By.xpath("//span[text()='Go !']"));
	for(WebElement golinks:listofGoLinks){
		System.out.println(golinks);
		Thread.sleep(2000);
		golinks.click();
		
	}
	Set<String>set=driver.getWindowHandles();
	Iterator<String> itr=set.iterator();
	while(itr.hasNext()){
		String childwindow=itr.next();
		if(!mainwindow.equals(childwindow)){
			String childWindowTitle=driver.switchTo().window(childwindow).getTitle();
			System.out.println(childWindowTitle);
			Thread.sleep(2000);
			driver.close();
		}
	}
	}
}
