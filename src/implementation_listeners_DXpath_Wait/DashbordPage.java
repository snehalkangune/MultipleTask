package implementation_listeners_DXpath_Wait;
//9:16 time correct code

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(Listener.class) // class to listener connection
public class DashbordPage {
	WebDriver driver;
	Logger log = Logger.getLogger(DashbordPage.class);

	@BeforeClass
	public void setEnvClass() {
		driver = Utility.getBrowserOpened();
		Utility.openUrl(
				"file:///D:/snehal/selenium%20software/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");
	}

	@Test(priority = 1)
	public void verifyTitle() throws InterruptedException {
		String actualTitle = driver.getTitle();// --------getTitle method
		// System.out.println(actualTitle);
		log.info(actualTitle);
		String expTitle = "JavaByKiran | Dashboard";
		Assert.assertEquals(actualTitle, expTitle);
	}

	@Test(priority = 2)
	public void subTitleofDasgboard() {

		String subTitleofDasgboard = driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1/small"))
				.getText();
		// System.out.println(subTitleofDasgboard);
		log.info(subTitleofDasgboard);
		String expHeading = "Courses Offered";
		Assert.assertEquals(subTitleofDasgboard, expHeading);
		// __________________________________________________________________________
		// List Of Courses
		ArrayList<String> actualListOfCourses = new ArrayList<>();
		List<WebElement> listOfCources = driver.findElements(By.xpath("//h3"));
		for (WebElement course : listOfCources) {
			String courseName = course.getText();
			actualListOfCourses.add(courseName);
		}
		// System.out.println("Print name of courses " + actualListOfCourses);
		log.info("Print name of courses " + actualListOfCourses);
	}

	// -------------------------------------------------------------------------------------------------------------------------------
	@Test(priority = 3)
	public void userTabLink() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a/span")).click();
		Thread.sleep(30);
		String actualTitle = driver.getTitle();
		// System.out.println(actualTitle);
		log.info(actualTitle);

		String expTitle = "JavaByKiran | User";
		Assert.assertEquals(actualTitle, expTitle);
	}

	@Test(priority = 4)
	public void logoutButton() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li/a")).click();
		Thread.sleep(30);
		String actualTitle = driver.getTitle();
		//System.out.println(actualTitle);
		log.info(actualTitle);
		String expTitle = "JavaByKiran | Log in";
		Assert.assertEquals(actualTitle, expTitle);
	}

}
