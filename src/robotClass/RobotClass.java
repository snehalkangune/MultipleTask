package robotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.MouseEvent;

public class RobotClass {
WebDriver driver;

@Test
public void tast01() throws Exception{
	System.setProperty("Webdriver.Chrome.driver","Chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("file:///D:/snehal/selenium%20software/Offline%20Website/Offline%20Website/index.html");
	Robot r=new Robot();
	Actions act=new Actions(driver);
	
	act.contextClick(driver.findElement(By.tagName("img"))).perform();
	//r.mousePress(KeyEvent.BUTTON3_DOWN_MASK);
	//r.keyPress(KeyEvent.BUTTON1_MASK);
	//r.mousePress(MouseEvent.BUTTON_RIGHT);
	r.delay(3000);
	r.keyPress(KeyEvent.VK_DOWN);
	r.delay(3000);
	r.keyPress(KeyEvent.VK_DOWN);
	r.delay(3000);
	r.keyPress(KeyEvent.VK_DOWN);
	r.delay(3000);
	r.keyPress(KeyEvent.VK_UP);
	r.delay(3000);
	r.keyPress(KeyEvent.VK_ENTER);
	r.delay(3000);
	r.keyPress(KeyEvent.VK_ENTER);
	
	
	

}
}
