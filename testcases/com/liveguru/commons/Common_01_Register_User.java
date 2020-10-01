package com.liveguru.commons;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.AbstractTest;
import pageObjects.liveguru.AccountInformationPageObject;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginUserPageObject;
import pageObjects.liveguru.MyAddressBookPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.RegisterPageObject;

public class Common_01_Register_User extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginUserPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	RegisterPageObject registerPage;
	MyAddressBookPageObject myAddressBookPage;
	AccountInformationPageObject accountInformationPage;

	String firstName = "Dan";
	String lastName = "Pham";
	public static String email = "dan" + randomNumber() + "@mailinator.com";
	public static String password = "111111";
	String registerSuccessMessage = "Thank you for registering with Main Website Store.";

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String appURL) {
		log.info("Precondition: Open LiveGuru99 site");
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getHomePageOject(driver);
		homePage.clickToAccountMenu();
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		myDashboardPage = registerPage.clicTokRegisterButton();
		driver.quit();
	}

}
