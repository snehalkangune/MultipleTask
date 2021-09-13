package implementation_listeners_DXpath_Wait;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class Listener implements ITestListener {
	Logger log = Logger.getLogger(DashbordPage.class);
	long starttimeforsuite = 0;
	long endtimeforsuite = 0;
	long startTime = 0;

	@Override
	public void onTestStart(ITestResult result) {
		//System.out.println("onTestStart- " + result.getName());
		log.info("onTestStart- " + result.getName());
		startTime = System.currentTimeMillis();
		//System.out.println("start time test case= " + startTime);
		log.info("start time test case= " + startTime);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//System.out.println("onTestSuccess..... ");
		log.info("onTestSuccess....." );
		long successTime = System.currentTimeMillis();
		//System.out.println("success time test case= " + successTime);
		log.info("success time test case= " + successTime);
		long totaltimefortestcase = successTime - startTime;
		System.out.println("Total time taken by testcases=" + totaltimefortestcase);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//System.out.println("onTestFailure...... " + result.getName());
		log.info("onTestFailure...... " + result.getName());
		// _______________________________________________________________
		// Take Screenshot
		TakesScreenshot ts = (TakesScreenshot) Utility.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				System.getProperty("user.dir") + "/ScreenShotFolder/image" + result.getName() + ".jpg");
		// FileUtils.copyFile(source,destination);
		try {
			Files.copy(source, destination);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//System.out.println("onTestSkipped...... " + result.getName());
		log.info("onTestSkipped...... " + result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// System.out.println("onTestFailedButWithinSuccessPercentage>> ");
		
	}

	@Override
	public void onStart(ITestContext context) {
		//System.out.println("onStart........");
		log.info("onStart........");
		starttimeforsuite = System.currentTimeMillis();
		//.out.println("Suite start time " + starttimeforsuite);
		log.info("Suite start time " + starttimeforsuite);
	}

	@Override
	public void onFinish(ITestContext context) {
		//System.out.println("onFinish....... ");
		log.info("onFinish....... ");
		endtimeforsuite = System.currentTimeMillis();
		//System.out.println("Suite end time " + endtimeforsuite);
		log.info("Suite end time " + endtimeforsuite);
		long totaltime = endtimeforsuite - starttimeforsuite;
		System.out.println("Total time taken by suite=" + totaltime);
	}
}
