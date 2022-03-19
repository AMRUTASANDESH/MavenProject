package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testCases.BaseClass;

public class LoginPage {
	
	WebDriver driver = BaseClass.driver;
	
	ExtentTest test=BaseClass.test;
	
	
	//========================= Web Elements ======================
	
	@FindBy(className = "login")
	WebElement LoginLink;
	
	@FindBy(name = "user_login")
	WebElement UserName;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(name = "btn_login")
	WebElement LoginBtn;
	
	@FindBy(className = "rememberMe")
	WebElement RememberMe;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//========================= Functions =============================
	
	public void LoginFunction(String UserNameVal, String PasswordVal) {
		
		LoginLink.click();
		test.log(LogStatus.PASS, "Click on Login Link","Login Link Clicked Successfully");
		UserName.sendKeys(UserNameVal);
		test.log(LogStatus.PASS, "Enter Username","Username entered Successfully");
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter Password","Password entered Successfully");
		RememberMe.click();
		test.log(LogStatus.PASS, "Click on Remember Link","Clicked Successfully");
		LoginBtn.click();
		test.log(LogStatus.PASS, "Click on Login Button","Login Button Clicked Successfully");
	}
	
}
