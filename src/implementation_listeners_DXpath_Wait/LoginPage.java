package implementation_listeners_DXpath_Wait;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(Listener.class) //class to listener connection
public class LoginPage {
	WebDriver driver;
	Logger log = Logger.getLogger(DashbordPage.class);
	@BeforeClass
	public void setEnvClass() {
		driver = Utility.getBrowserOpened();
		Utility.openUrl("file:///D:/snehal/selenium%20software/Offline%20Website/Offline%20Website/index.html");
	}

	@BeforeMethod
	public void clearTextFromTextBox() {
		Utility.clearText("id", "email");
		Utility.clearText("id", "password");
	}

	@Test(priority = 1)
	public void pageLayout() {
		boolean Image = driver.findElement(By.xpath("//img[@src='pages/images/jbk.png']")).isDisplayed();
		//String actMsg =Utility.displayText("xpath", "//a[@href='#']");
		String actMsg =Utility.displayText("xpath", "/html/body/div/div[1]/a/b");
		String expMsg = "Java By Kiran";
		Assert.assertEquals(actMsg, expMsg);
	}

	@Test(priority = 2)
	public void VerifyHeading() {
		String actMsg = Utility.displayText("xpath", "/html/body/div/div[1]/a/h4");
		String expMsg = "JAVA | SELENIUM | PYTHON";
		Assert.assertEquals(actMsg, expMsg);
	}

	@Test(priority = 3)
	public void login() {
		driver.findElement(By.xpath("//p[@class='login-box-msg']")).getText();
		Utility.enterText("id", "email", " ");
		Utility.enterText("id", "password", "");
		Utility.clickButton("xpath", "//button[@type='submit']");
		String actMsg = Utility.displayText("xpath", "//div[@id='email_error']");
		String expMsg = "Please enter valid email.";
		Assert.assertEquals(actMsg, expMsg);

	}

	@Test(priority = 4)
	public void verifyinvalidEmail() {
		Utility.enterText("id", "email", "snehal@gmail.com");
		Utility.enterText("id", "password", "12345");
		Utility.clickButton("xpath", "//button[@type='submit']");
		String actMsg = Utility.displayText("xpath", "//div[@id='email_error']");
		String expMsg = "Please enter email as kiran@gmail.com";
		Assert.assertEquals(actMsg, expMsg);
	}
	//_____________________________________________________________________________
	//Failure test case for ss
	@Test(priority = 5)
	public void blankPass() {
		driver.findElement(By.xpath("//p[@class='login-box-msg']")).getText();
		Utility.enterText("id", "email", " ");
		Utility.enterText("id", "password", "");
		Utility.clickButton("xpath", "//button[@type='submit']");
		String actMsg = Utility.displayText("xpath", "//div[text()='Please enter password.']");
		String expMsg = "Please enter password..";
		Assert.assertEquals(actMsg, expMsg);
		
	}

	@Test(priority = 6)
	public void invalidPass() {
		Utility.enterText("id", "email", "snehal@gmail.com");
		Utility.enterText("id", "password", "12345");
		Utility.clickButton("xpath", "//button[@type='submit']");
		String actMsg = Utility.displayText("xpath", "//div[@id='password_error']");
		String expMsg = "Please enter password 123456..";
		Assert.assertEquals(actMsg, expMsg);
	}
	//__________________________________________________________________________

	@Test(priority = 7)
	public void verifyCorrectData() {
		Utility.openUrl("file:///D:/snehal/selenium%20software/Offline%20Website/Offline%20Website/index.html");
		Utility.enterText("id", "email", "kiran@gmail.com");
		Utility.enterText("id", "password", "123456");
		Utility.clickButton("xpath", "//button[@type='submit']");
		String actualTitle = driver.getTitle();
		//System.out.println(actualTitle);
		log.info(actualTitle);
		String expTitle = "JavaByKiran | Dashboard";
		Assert.assertEquals(actualTitle, expTitle);

	}

	@AfterClass
	public void closeSetup() {
		driver.close();
	}


}
