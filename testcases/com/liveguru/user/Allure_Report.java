package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import driverFactory.DriverManager;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginUserPageObject;
import pageObjects.liveguru.MyAddressBookPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.RegisterPageObject;


public class Allure_Report extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginUserPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	RegisterPageObject registerPage;
	MyAddressBookPageObject myAddressBookPage;
	private DriverManager driverManager;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		
		//driverManager = DriverFactory.getManager(browserName);	
		driver = getBrowserDriver(browserName, appURL);
		log.info("Pre-condition - Step 01: Open browser and application.");
		//driver.get(appURL);
		homePage = new HomePageObject(driver);		
		
	}

	@BeforeMethod
	public void beforeMethod() {
		// Click My Account -> open Login page
		log.info("Pre-condition - Step 02: Click My Account link.");
		homePage.clickToMyAccountLink();
		loginPage = new LoginUserPageObject(driver);
		
		// Click Create an Account -> open Register page
		log.info("Pre-condition - Step 03: Click Create an Account button.");
		loginPage.clickCreateAccountButton();
		registerPage = new RegisterPageObject(driver);
	}
	
	@Test
	public void Register_01_Empty_Data() {
		//click Register button
		log.info("Register_01 - Step 01: Click Register button.");
		registerPage.clicTokRegisterButton();

		// Verify data
		log.info("Register_01 - Step 02: Verify the validation message display for the blank fields");
//		verifyEquals(registerPage.getRequiredErrorMsgAtFirstName(), "This is a required field.");
//		verifyEquals(registerPage.getRequiredErrorMsgAtLastName(), "This is a required field");
//		verifyEquals(registerPage.getRequiredErrorMsgAtEmail(), "This is a required field");
//		verifyEquals(registerPage.getRequiredErrorMsgAtPassword(), "This is a required field");
//		verifyEquals(registerPage.getRequiredErrorMsgAtConfirmPassword(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequiredErrorMsgAtFirstName(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequiredErrorMsgAtLastName(), "This is a required field");
		Assert.assertEquals(registerPage.getRequiredErrorMsgAtEmail(), "This is a required field");
		Assert.assertEquals(registerPage.getRequiredErrorMsgAtPassword(), "This is a required field");
		Assert.assertEquals(registerPage.getRequiredErrorMsgAtConfirmPassword(), "This is a required field.");
		
	}
	
	@Test
	public void Register_02_Invalid_Email() {
		// Input data
		log.info("Register_02 - Step 01: Input data into Email textbox");
		registerPage.inputToEmailTextbox("dan@111.111");
		
		//click Register button
		log.info("Register_02 - Step 02: Click Register button");
		registerPage.clicTokRegisterButton();
		
		// Verify data
		log.info("Register_02 - Step 03: Verify validation msg displays for email field");
		Assert.assertEquals(registerPage.getAdviceValidateErrorMsgAtEmail(),"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void Register_03_Password_Less_Than_6_Chars() {
		// Input data
		log.info("Register_03 - Step 01: Input data into Password textbox");
		registerPage.inputToPasswordTextbox("111");

		//click Register button
		log.info("Register_03 - Step 02: Click Register button");
		registerPage.clicTokRegisterButton();

		// Verify data
		log.info("Register_03 - Step 03: Verify validation msg displays for Password field");
		Assert.assertEquals(registerPage.getAdviceValidateErrorMsgAtPassword(),"Please enter 6 or more characters without leading or trailing spaces.");

	}

	@Test	
	public void Register_04_Confirm_Password_Not_Matching_Password() {
		// Input data
		log.info("Register_04 - Step 01: Input data into Password and ConfirmPassword textbox");
		registerPage.inputToPasswordTextbox("111111");
		registerPage.inputToConfirmPasswordTextbox("123456");
	
		//click Register button
		log.info("Register_04 - Step 02: Click Register button");
		registerPage.clicTokRegisterButton();
		
		// Verify data
		log.info("Register_04 - Step 03: Verify validation msg displays for Password field");
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
		Assert.assertEquals(myDashboardPage.getRegisterSuccessMsg(),"Thank you for registering with Main Website Store.");
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
