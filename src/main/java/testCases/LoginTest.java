package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends BaseClass{
	
	
	@Test
	public void LoginFailiureTest() {
		
		
		
		
		LoginPage login = new LoginPage();
		login.LoginFunction("xyz@abc.com","Abc@12345");
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box")); 
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpMsg);
		
	}
	
//	@Test
//	public void LoginSuccessTest() {
//		
//		LoginPage login = new LoginPage();
//		login.LoginFunction("abc@abc.com","Abc@12345");
//		
//	}
//	
////	@Test
////	@Parameters ({"username","password"})
////	public void ParameterizedTest(String Username,String Password)
////	{
////		LoginPage login = new LoginPage();
////		login.LoginFunction(Username,Password);
////		
////		
////	}
//	
//	@Test
//	public void ExternalDataTest()
//	{
//		String username = sheet.getRow(1).getCell(0).getStringCellValue();
//		String password = sheet.getRow(1).getCell(1).getStringCellValue();
//		
//		LoginPage login = new LoginPage();
//		login.LoginFunction(username,password);
//		
//		
//	}
}
