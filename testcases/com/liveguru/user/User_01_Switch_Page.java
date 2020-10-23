package com.liveguru.user;

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
import pageObjects.liveguru.AboutUsPageObject;
import pageObjects.liveguru.AdvancedSearchPageObject;
import pageObjects.liveguru.CustomerServicePageObject;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginUserPageObject;
import pageObjects.liveguru.MyAddressBookPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.RegisterPageObject;
import pageObjects.liveguru.SearchTermPageObject;

public class User_01_Switch_Page extends AbstractTest {
	WebDriver driver;
	
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
		homePage = PageGeneratorManager.getHomePageObject(driver);

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
		
		// click logout -> return HomePage
		homePage = myDashboardPage.clickToLogOutbutton();
	}

	@Test
	public void TC02_Login_Valid_Data() {

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

	@Test
	public void TC02_Switch_Page() {
//		aboutUsPage = myDashboardPage.openAboutUsPage(driver);
//		advancedSearchPage = aboutUsPage.openAdvancedSearchPage(driver);
//		customerServicePage = advancedSearchPage.openCustomerServicePage(driver);
//		searchTermPage = customerServicePage.openSearchTermPage(driver);
//		aboutUsPage = searchTermPage.openAboutUsPage(driver);
//		customerServicePage = aboutUsPage.openCustomerServicePage(driver);
		
		myDashboardPage.openFooterPageByName(driver, "About Us");
		aboutUsPage = PageGeneratorManager.getAboutUsPageObject(driver);
		
		aboutUsPage.openFooterPageByName(driver, "Advanced Search"); 
		advancedSearchPage = PageGeneratorManager.getAdvancedSearchPageObject(driver);
		
		advancedSearchPage.openFooterPageByName(driver, "Customer Service");
		customerServicePage = PageGeneratorManager.getCustomerServicePageObject(driver);
				
		customerServicePage.openFooterPageByName(driver, "Search Terms");
		searchTermPage = PageGeneratorManager.getSearchTermPageObject(driver);
				
		searchTermPage.openFooterPageByName(driver, "About Us");
		aboutUsPage = PageGeneratorManager.getAboutUsPageObject(driver);
		
		aboutUsPage.openFooterPageByName(driver, "Customer Service");
		customerServicePage = PageGeneratorManager.getCustomerServicePageObject(driver);
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	AboutUsPageObject aboutUsPage;
	AdvancedSearchPageObject advancedSearchPage;
	CustomerServicePageObject customerServicePage;
	SearchTermPageObject searchTermPage;	
	HomePageObject homePage;
	LoginUserPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	RegisterPageObject registerPage;
	MyAddressBookPageObject myAddressBookPage;
}
