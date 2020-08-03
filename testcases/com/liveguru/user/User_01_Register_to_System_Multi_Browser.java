package com.liveguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginPageObject;
import pageObjects.liveguru.MyAddressBookPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.RegisterPageObject;


public class User_01_Register_to_System_Multi_Browser extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	RegisterPageObject registerPage;
	MyAddressBookPageObject myAddressBookPage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = openMultiBrowser(browserName, appURL);		
		homePage = new HomePageObject(driver);		
		
	}

	@BeforeMethod
	public void beforeMethod() {
		// Click My Account -> open Login page
		homePage.clickToMyAccountLink();
		loginPage = new LoginPageObject(driver);
		
		// Click Create an Account -> open Register page
		loginPage.clickCreateAccountButton();
		registerPage = new RegisterPageObject(driver);
	}
	
	@Test
	public void Register_01_Empty_Data() {
		//click Register button
		registerPage.clicTokRegisterButton();

		// Verify data
		Assert.assertEquals(registerPage.getRequiredErrorMsgAtFirstName(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequiredErrorMsgAtLastName(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequiredErrorMsgAtEmail(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequiredErrorMsgAtPassword(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequiredErrorMsgAtConfirmPassword(), "This is a required field.");
		
	}
	
	@Test
	public void Register_02_Invalid_Email() {
		// Input data
		registerPage.inputToEmailTextbox("dan@111.111");
		
		//click Register button
		registerPage.clicTokRegisterButton();
		
		// Verify data
		Assert.assertEquals(registerPage.getAdviceValidateErrorMsgAtEmail(),"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void Register_03_Password_Less_Than_6_Chars() {
		// Input data
		registerPage.inputToPasswordTextbox("111");

		//click Register button
		registerPage.clicTokRegisterButton();

		// Verify data
		Assert.assertEquals(registerPage.getAdviceValidateErrorMsgAtPassword(),"Please enter 6 or more characters without leading or trailing spaces.");

	}

	@Test
	public void Register_04_Confirm_Password_Not_Matching_Password() {
		// Input data
		registerPage.inputToPasswordTextbox("111111");
		registerPage.inputToConfirmPasswordTextbox("123456");
	
		//click Register button
		registerPage.clicTokRegisterButton();
		
		// Verify data
		Assert.assertEquals(registerPage.getAdviceValidateErrorMsgAtConfirmPassword(),"Please make sure your passwords match.");
			
	}

	@Test
	public void Register_05_Valid_Data() {
		// Input data
		registerPage.inputToFirstnameTextbox("Dan");
		registerPage.inputToLastnameTextbox("Pham");
		registerPage.inputToEmailTextbox("dan"+randomNumber()+"@gmail.com");
		registerPage.inputToPasswordTextbox("111111");
		registerPage.inputToConfirmPasswordTextbox("111111");
		
    	//click Register button -> open MyDashboard page
		registerPage.clicTokRegisterButton();
		myDashboardPage = new MyDashboardPageObject(driver);
		
		// Verify data
		Assert.assertEquals(myDashboardPage.getSuccessMsg(),"Thank you for registering with Main Website Store.");
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public int randomNumber() {
		Random num = new Random();
		return num.nextInt();
	}

}
