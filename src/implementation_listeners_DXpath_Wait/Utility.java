package implementation_listeners_DXpath_Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility {
	static public WebDriver driver;

	// 1.To Open Browser
	static public WebDriver getBrowserOpened() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	// 2.Thread Sleep
	static public void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 3.To Open URL
	static public void openUrl(String url) {
		System.out.println("to open Url>>" + url);
		driver.get(url);
	}

	// 4.Enter Text
	static public void enterText(String locName, String locvalue, String dataToEnter) {
		if (locName.equals("id")) {
			driver.findElement(By.id(locvalue)).sendKeys(dataToEnter);
		}
		if (locName.equals("xpath")) {
			driver.findElement(By.xpath(locvalue)).sendKeys(dataToEnter);
		}
	}

	// 5.Click Button
	static public void clickButton(String locName, String locvalue) {
		if (locName.equals("id")) {
			driver.findElement(By.id(locvalue)).click();

		}
		if (locName.equals("xpath")) {
			driver.findElement(By.xpath(locvalue)).click();

		}
	}

	static public String displayText(String locName, String locValue) {
		String massage=null;
		if(locName.equals("className")){
			WebElement Msg=driver.findElement(By.className(locValue));
			massage=Msg.getText();
		}
		if (locName.equals("id")) {
		WebElement Msg=	driver.findElement(By.id(locValue));
				massage=Msg.getText();
			
		}
		if (locName.equals("xpath")) {
			WebElement Msg=	driver.findElement(By.xpath(locValue));
					massage=Msg.getText();
		}
		return massage;
	}
	static public void clearText(String locName, String locvalue) {
		if (locName.equals("id")) {
			driver.findElement(By.id(locvalue)).clear();

		}
		if (locName.equals("xpath")) {
			driver.findElement(By.xpath(locvalue)).clear();

		}
	}
}
