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
import driverFactory.DriverFactory;
import driverFactory.DriverManager;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginUserPageObject;
import pageObjects.liveguru.MyAddressBookPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.RegisterPageObject;

public class User_01_Page_Generator_Manager extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginUserPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	RegisterPageObject registerPage;
	MyAddressBookPageObject myAddressBookPage;
	private DriverManager driverManager;
	String firstName = "Dan";
	String lastName = "Pham";
	String email = "dan" + randomNumber() + "@gmail.com";
	String password = "111111";
	String registerSuccessMessage = "Thank you for registering with Main Website Store.";
	String loginSuccessMessage = "Hello, " + firstName + " " + lastName + "!";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driverManager = DriverFactory.getManager(browserName);
		driver = driverManager.getDriver();
		driver.get(appURL);
		homePage = PageGeneratorManager.getHomePageOject(driver);

	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@Test
	public void TC01_Register_Valid_Data() {
		// Click My Account -> open Login page
		loginPage = homePage.clickToMyAccountLink();

		// Click Create an Account -> open Register page
		registerPage = loginPage.clickCreateAccountButton();

		// Input data
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		// click Register button -> open MyDashboard page
		myDashboardPage = registerPage.clicTokRegisterButton();

		// Verify register successfully
		Assert.assertEquals(myDashboardPage.getRegisterSuccessMsg(), registerSuccessMessage);
	}

	@Test
	public void TC02_Login_Valid_Data() {
		// click logout -> return HomePage
		homePage = myDashboardPage.clickToLogOutbutton();
		// click MyAccount link
		loginPage = homePage.clickToMyAccountLink();
		// Input valid email and password
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		// click Login button
		myDashboardPage = loginPage.clickToLoginButton();
		// Verify login successfully text 'Hello, firstname lastname' display
		Assert.assertEquals(myDashboardPage.getLoginSuccessMsg(), loginSuccessMessage);

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
