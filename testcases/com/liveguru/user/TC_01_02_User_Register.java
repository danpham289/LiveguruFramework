package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.liveguru.AccountInformationPageObject;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginUserPageObject;
import pageObjects.liveguru.MyAddressBookPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.RegisterPageObject;

public class TC_01_02_User_Register extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginUserPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	RegisterPageObject registerPage;
	MyAddressBookPageObject myAddressBookPage;
	AccountInformationPageObject accountInformationPage;

	String firstName ;
	String lastName ;
	String email ;
	String password ;
	String registerSuccessMessage ;

	@Parameters({ "browser", "userUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		log.info("Precondition: Open LiveGuru99 site");
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		firstName = "Dan";
		lastName = "Pham";
		email = "dan" + randomNumber() + "@mailinator.com";
		password = "111111";
		registerSuccessMessage = "Thank you for registering with Main Website Store.";
		
	}

	@Test
	public void TC01_Register_Success_To_System() {
		log.info("Step 1: Click ACCOUNT menu");
		homePage.clickToAccountMenu();

		log.info("Step 2: Click Register link -> open Register Page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Step 3: Input all valid data to form");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Step 4: Click Register button -> open My Dashboard Page");
		myDashboardPage = registerPage.clicTokRegisterButton();

		log.info("Step 5: Verify text displays after registered successfully");
		Assert.assertEquals(myDashboardPage.getRegisterSuccessMsg(), "Thank you for registering with Main Website Store.");
	}

	@Test
	public void TC02_Verify_User_Information_Is_Correct_After_Registered_Successfully() {
		log.info("Step 1: Click MY ACCOUNT link");
		myDashboardPage.openFooterPageByName(driver, "My Account");

		log.info("Step 2: Click ACCOUNT INFORMATION link -> open Account Information page");
		myDashboardPage.openLeftMenuPageByName(driver, "Account Information");
		accountInformationPage = PageGeneratorManager.getAccountInformationPageObject(driver);
		
		log.info("Step 3: Verify firstname, lastname, email are correct");
		Assert.assertEquals(accountInformationPage.getFirstName(), firstName);
		Assert.assertEquals(accountInformationPage.getLastName(), lastName);
		Assert.assertEquals(accountInformationPage.getEmail(), email);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}


}
