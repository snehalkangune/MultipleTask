package MonyControl;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Task1 {
	WebDriver driver;
	FileInputStream fis;
	Workbook wb;
	Sheet sh;

	@Test
	public void companyName() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/markets/indian-indices/");
		driver.manage().window().maximize();

		ArrayList<String> expList = new ArrayList<>();
		fis = new FileInputStream("MonyContol.xls");
		wb = Workbook.getWorkbook(fis);
		sh = wb.getSheet("Sheet1");
		int rows = sh.getRows();
		int cols = sh.getColumns();
		for (int i = 1; i < rows; i++) {
			Cell cell = sh.getCell(0, i);
			String company = cell.getContents();

			if (company.contains("Bharti Airtel"))
				System.out.println("Print Company name    :" + company);
			expList.add(company);
			if (company.contains("HDFC") )
				System.out.println("Print Company name    :" + company);
			expList.add(company);
			if (company.contains("Infosys"))
				System.out.println("Print Company name    :" + company);
			expList.add(company);
			if (company.contains("HCL Tech"))
				System.out.println("Print Company name    :" + company);
			expList.add(company);
			if (company.contains("Larsen"))
				System.out.println("Print Company name    :" + company);
			expList.add(company);
		}
		
	}
	
	
	
}