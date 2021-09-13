package Select;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {
WebDriver driver;

	@Test
	public void addUser() throws Exception{
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("file:///D:/snehal/selenium%20software/Offline%20Website/Offline%20Website/pages/examples/add_user.html");
	driver.manage().window().maximize();
	
	Select state=new Select(driver.findElement(By.xpath("//select")));
	Thread.sleep(2000);
	state.selectByVisibleText("Maharashtra");
	Thread.sleep(2000);
	state.selectByValue("Delhi");
	Thread.sleep(2000);
	state.selectByIndex(3);
	List<WebElement>listofStates=state.getOptions();
	for (WebElement list : listofStates) {
		System.out.println("list of state::"+list.getText());
	}
	WebElement male=driver.findElement(By.id("Male"));
	boolean isDis=male.isDisplayed();
	System.out.println(isDis);
	boolean isEna=male.isEnabled();
	System.out.println(isEna);
	male.click();
	boolean isSel=male.isSelected();
	System.out.println(isSel);
	
	
}
}