package ActionClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassDemo {
	WebDriver driver;
	 Actions action;
	@Test
	public void addUser() throws Exception{
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://javabykiran.com/playground/");
	driver.manage().window().maximize();
	action=new Actions(driver);
	 
	 WebElement target=driver.findElement(By.xpath("//h2[text()='API Demo']"));
	 action.doubleClick(target).contextClick().build().perform();
	 action.contextClick(driver.findElement(By.xpath("//h2[text()='List all the users - ']"))).perform();
	//______________________________________________________
   List<WebElement> list=driver.findElements(By.xpath("//a[@class='nav-link']"));
   for (WebElement webElement : list) {
	   action.moveToElement(webElement).pause(2000).build().perform();
   }
 //______________________________________________________
 driver.findElement(By.linkText("Drag and Drop")).click();
 WebElement source=driver.findElement(By.xpath("//div[text()='Home ']"));
 WebElement destination=driver.findElement(By.xpath("//div[text()='Contact Us']"));
 //action.dragAndDrop(source, destination).pause(9000).build().perform();
 action.clickAndHold(source).moveToElement(destination).release(source).pause(9000).build().perform();

}
}