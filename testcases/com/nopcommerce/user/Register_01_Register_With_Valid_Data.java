package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.EndUser;

import commons.AbstractTest;
import driverFactory.DriverFactory;
import driverFactory.DriverManager;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import pageObjects.nopcommerce.HomePageObject;

public class Register_01_Register_With_Valid_Data extends AbstractTest{
	WebDriver driver;
	DriverManager driverManager;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	String email;
	
	@Parameters({"browser","userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Precondition - Step 01: Open nopCommerce site");
		driverManager = DriverFactory.getManager(browserName);
		driver = driverManager.getDriver();
		driver.get(appUrl);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		email = EndUser.Register.EMAIL + randomNumber() +"@mailinator.com";
	}
	
	@Test
	public void TC01_Register_With_Valid_Data() {
		log.info("Step 01: Click Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Step 02: Input data to First Name textbox");
		registerPage.inputToFirstNameTextbox(EndUser.Register.FIRST_NAME);
		
		log.info("Step 03: Input data to Last Name textbox");
		registerPage.inputToLastNameTextbox(EndUser.Register.LAST_NAME);
		
		log.info("Step 03: Input data to Email textbox");
		registerPage.inputToEmailTextbox(email);
		
		log.info("Step 04: Input data to Company textbox");
		registerPage.inputToCompanyTextbox(EndUser.Register.COMPANY);
		
		log.info("Step 05: Input data to Password textbox");
		registerPage.inputToPasswordTextbox(EndUser.Register.PASSWORD);
		
		log.info("Step 06: Input data to Confirm Password textbox");
		registerPage.inputToConfirmPasswordTextbox(EndUser.Register.PASSWORD);
		
		log.info("Step 07: Click Register button");
		registerPage.clickToRegisterButton();
		
		log.info("VP: 'Your registration completed' message displays");
		verifyEquals(registerPage.getResultMessageText(),"Your registration completed");
	}
	


	@AfterClass(alwaysRun=true)
	public void afterClass() {
//		closeBrowserAndDriver(driver);
	}

}
