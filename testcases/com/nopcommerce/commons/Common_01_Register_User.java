package com.nopcommerce.commons;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.nopcommerce.EndUser;

import commons.AbstractTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;


public class Common_01_Register_User extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;

	public static String email = EndUser.Register.EMAIL + randomNumber() + "@mailinator.com";
	String registerSuccessMessage = "Your registration completed";

	@Parameters({ "browser", "userUrl" })
	@BeforeTest
	public void beforeTest(String browserName, String appURL) {
		log.info("Precondition: Open NopCommerce site");
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		registerPage =homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(EndUser.Register.FIRST_NAME);
		registerPage.inputToLastNameTextbox(EndUser.Register.LAST_NAME);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(EndUser.Register.PASSWORD);
		registerPage.inputToConfirmPasswordTextbox(EndUser.Register.PASSWORD);
		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.getResultMessageText(),registerSuccessMessage);
		driver.quit();
	}

}
