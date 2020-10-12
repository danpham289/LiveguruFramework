package com.liveguru.user;

import java.util.concurrent.TimeUnit;

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
import pageObjects.liveguru.AddNewAddressPageObject;
import pageObjects.liveguru.AdvancedSearchPageObject;
import pageObjects.liveguru.CustomerServicePageObject;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginAdminPageObject;
import pageObjects.liveguru.LoginUserPageObject;
import pageObjects.liveguru.ManageCustomersPageObject;
import pageObjects.liveguru.MyAddressBookPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.RegisterPageObject;
import pageObjects.liveguru.SearchTermPageObject;

public class Admin_01_Handle_Grid_Data extends AbstractTest {
	WebDriver driver;
	
	private DriverManager driverManager;
	String firstName = "Dan";
	String lastName = "Pham";
	String email = "dan" + randomNumber() + "@gmail.com";
	String password = "111111";
	String registerSuccessMessage = "Thank you for registering with Main Website Store.";
	String loginSuccessMessage = "Hello, " + firstName + " " + lastName + "!";
	String telephone = "0905000111";
	String address = "01 hoang van thu";
	String city = "Da nang";
	String country = "Vietnam";
	String state = "Hai Chau";
	String zip = "012345";
	
	String adminUser = "user01";
	String adminPassword = "guru99com";
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driverManager = DriverFactory.getManager(browserName);
		driver = driverManager.getDriver();
		//driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//homePage = PageGeneratorManager.getHomePageOject(driver);

	}

	@BeforeMethod
	public void beforeMethod() {

	}

	
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

	
	public void TC02_Update_Address_Book() {

		// click Manage Addresses link
		addNewAddressPage = myDashboardPage.clickToManageAddressesLink();
		
		// Input Telephone, Street Address, City, State/Province, Zip, Country
		addNewAddressPage.inputToTelephoneTextbox(telephone);
		addNewAddressPage.inputToStreetAddressTextbox(address);
		addNewAddressPage.inputToCityTextbox(city);
		addNewAddressPage.inputToZipTextbox(zip);
		addNewAddressPage.selectCountryDropDown(country);
		addNewAddressPage.inputToStateTextbox(state);
		
		// click Save Address button
		myAddressBookPage = addNewAddressPage.clickToSaveAddressButton();
		driver.close();
		

	}

	@Test
	public void TC03_Handle_Grid_Data() throws InterruptedException {
		//open url of admin page
		driver.get("http://live.guru99.com/index.php/backendlogin");
		loginAdminPage = PageGeneratorManager.getLoginAdminPageObject(driver);
		
		//Input username, password
		loginAdminPage.inputToUsernameTextbox(adminUser);
		loginAdminPage.inputToPasswordTextbox(adminPassword);
		
		//Click Login button
		manageCustomersPage = loginAdminPage.clickToLoginButton();
		
		// close incoming message popup
		manageCustomersPage.closeIncomingMessagePopUp();
		
		// Input Search textbox by column name
		manageCustomersPage.InputToSearchTextboxByColumnName("Telephone","0905000111");
		
		Thread.sleep(5000);
		//Click Search button
		manageCustomersPage.clickToSearchButton();
		Thread.sleep(5000);
		
		//Verify search result display
		Assert.assertTrue(manageCustomersPage.isValueDisplayedAtColumnNameByRowNumber("Telephone","1","0905000111"));
		
		
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
	AddNewAddressPageObject addNewAddressPage;
	LoginAdminPageObject loginAdminPage;
	ManageCustomersPageObject manageCustomersPage;
	
}
