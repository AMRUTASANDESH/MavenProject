package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	
	public static WebDriver driver;
	
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeTest
	public void DataSetUp() throws IOException {
		
		FileInputStream fis= new FileInputStream("excelData.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("Sheet1");
		
		report = new ExtentReports(System.getProperty("user.dir")+"ExtentReport.html");
	}
	@AfterTest
	public void DataTearDown() throws IOException
	{
		wbook.close();
		driver.close();
		report.flush();
		report.close();
	}
	
	
	
	@BeforeMethod
	public void SetUp() {
		test= report.startTest("LoginFaliureTest","failure testcse");
		System.setProperty("webdriver.chrome.driver", "/home/amruta/Desktop/automation_simplie_learn/chromedriver_linux64_new/chromedriver");
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	@AfterMethod
	public void TearDown() {
		report.endTest(test);
		driver.quit();
	}

}
