package com.liveguru.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.liveguru.AccountInformationPageObject;
import pageObjects.liveguru.CustomerInfomationPageObject;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginAdminPageObject;
import pageObjects.liveguru.LoginUserPageObject;
import pageObjects.liveguru.ManageCustomersPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.RegisterPageObject;

public class TS01_Check_Account_Create_Success extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginUserPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	RegisterPageObject registerPage;
	LoginAdminPageObject loginAdminPage;
	ManageCustomersPageObject manageCustomersPage;
	AccountInformationPageObject accountInformationPage;
	CustomerInfomationPageObject customerInfomationPage;
	
	String firstNameUpdate = "DanUpdate";
	String firstName = "Dan";
	String lastName = "Pham";
	String lastNameUpdate = "PhamUpdate";
	String email = "dan" + randomNumber() + "@gmail.com";
	String emailUpdate = "danup" + randomNumber() + "@gmail.com";
	String password = "111111";
	String registerSuccessMessage = "Thank you for registering with Main Website Store.";
	String loginSuccessMessage = "Hello, " + firstName + " " + lastName + "!";
	String telephone = "0905000111";
	String address = "01 hoang van thu";
	String city = "Da nang";
	String country = "Vietnam";
	String state = "Hai Chau";
	String zip = "012345";
	

	
//	@Parameters({"browser","userUrl"})
//	@BeforeClass
//	public void beforeClass(String browserName, String appURL) {
//		log.info("Precondition: Open LiveGuru99 site");
//		driver = getBrowserDriver(browserName, appURL);
//		homePage = PageGeneratorManager.getHomePageOject(driver);
//	}
	
	@Parameters({"browser","userUrl","adminUrl"})
	@Test
	public void TC01_Check_Account_Created_Success_In_Admin(String browserName, String userUrl, String adminUrl) {
		log.info("Precondition: Open LiveGuru99 user site");
		driver = getBrowserDriver(browserName, userUrl);		
		homePage = PageGeneratorManager.getHomePageOject(driver);
		log.info("Precondition: Register new account in User page");
		log.info("Precondition: Click My Account -> open Login page");
		loginPage = homePage.clickToMyAccountLink();

		log.info("Precondition: Click Create an Account -> open Register page");
		registerPage = loginPage.clickCreateAccountButton();

		log.info("Precondition: Input data to First name, Last Name, Email, Password, Confirm Password fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Precondition: Click Register button -> open MyDashboard page");
		myDashboardPage = registerPage.clicTokRegisterButton();

		log.info("Precondition: Verify register successfully");
		verifyEquals(myDashboardPage.getRegisterSuccessMsg(), registerSuccessMessage);
		driver.quit();
		
		log.info("Step: Open LiveGuru99 admin site");
		driver = getBrowserDriver(browserName, adminUrl);
		loginAdminPage = PageGeneratorManager.getLoginAdminPageObject(driver);
		
		log.info("Step: Input admin username & password");
		loginAdminPage.inputToUsernameTextbox(GlobalConstants.ADMIN_USER);
		loginAdminPage.inputToPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
		
		log.info("Step: Click Login button");
		manageCustomersPage = loginAdminPage.clickToLoginButton();
		
		log.info("Step: Close Incoming Message Popup");
		manageCustomersPage.closeIncomingMessagePopUp();
		
		log.info("Step: Input Email textbox to search account");
		manageCustomersPage.InputToSearchTextboxByColumnName("Email",email);
		
		log.info("Step:Click Search button");
		manageCustomersPage.clickToSearchButton();
		
		log.info("VP: Verify search result displays , New account with correct info displays");
		verifyTrue(manageCustomersPage.isValueDisplayedAtColumnNameByRowNumber("Email","1",email));
		verifyTrue(manageCustomersPage.isValueDisplayedAtColumnNameByRowNumber("Name","1",firstName +" "+lastName));
		driver.quit();
	}

	@Parameters({"browser","userUrl","adminUrl"})
	@Test(dependsOnMethods = "TC01_Check_Account_Created_Success_In_Admin")
	public void TC02_Check_Update_Account_Info_Success_In_Admin(String browserName, String userUrl, String adminUrl) {
		log.info("Precondition: Open LiveGuru99 user site");
		driver = getBrowserDriver(browserName, userUrl);		
		homePage = PageGeneratorManager.getHomePageOject(driver);
		
		log.info("Precondition: Login by new account registered above");
		homePage.clickToAccountMenu();
		loginPage = homePage.clickToLogInLink();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		myDashboardPage = loginPage.clickToLoginButton();
		
		log.info("Precondition: Click Account Information on left menu");
		myDashboardPage.openLeftMenuPageByName(driver, "Account Information");
		accountInformationPage = PageGeneratorManager.getAccountInformationPageObject(driver);
		
		log.info("Precondition: Update First Name, Last Name, Email ");
		accountInformationPage.inputToFirstNameTextbox(firstNameUpdate);
		accountInformationPage.inputToLastNameTextbox(lastNameUpdate);
		accountInformationPage.inputToEmailTextbox(emailUpdate);
		accountInformationPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Precondition: Click Save button ");
		myDashboardPage = accountInformationPage.clickToSaveButton();
		
		log.info("Precondition: Verify message 'The account information has been saved.' displays ");
		verifyTrue(myDashboardPage.isAccountInfoSavedMessageDisplayed());
		driver.quit();
		
		log.info("Step: Open LiveGuru99 admin site");
		driver = getBrowserDriver(browserName, adminUrl);
		loginAdminPage = PageGeneratorManager.getLoginAdminPageObject(driver);
		
		log.info("Step: Input admin username & password");
		loginAdminPage.inputToUsernameTextbox(GlobalConstants.ADMIN_USER);
		loginAdminPage.inputToPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
		
		log.info("Step: Click Login button");
		manageCustomersPage = loginAdminPage.clickToLoginButton();
		
		log.info("Step: Close Incoming Message Popup");
		manageCustomersPage.closeIncomingMessagePopUp();
		
		log.info("Step: Input Old Email textbox to search account");
		manageCustomersPage.InputToSearchTextboxByColumnName("Email",email);
		
		log.info("Step:Click Search button");
		manageCustomersPage.clickToSearchButton();
		
		log.info("VP: Verify 'No records found.' text displays");
		verifyTrue(manageCustomersPage.isNoRecordsTextDisplayed());
		
		log.info("Step: Input Updated Email textbox to search account");
		manageCustomersPage.InputToSearchTextboxByColumnName("Email",emailUpdate);
		
		log.info("Step:Click Search button");
		manageCustomersPage.clickToSearchButton();
		
		log.info("VP: Verify search result displays , New account with correct info displays");
		verifyTrue(manageCustomersPage.isValueDisplayedAtColumnNameByRowNumber("Email","1",emailUpdate));
		verifyTrue(manageCustomersPage.isValueDisplayedAtColumnNameByRowNumber("Name","1",firstNameUpdate +" "+lastNameUpdate));
		
	}
	
	@Parameters({"browser","userUrl","adminUrl"})
	@Test(dependsOnMethods = "TC02_Check_Update_Account_Info_Success_In_Admin")
	public void TC03_Delete_Account(String browserName, String userUrl, String adminUrl) {
		log.info("Step: click Edit link of the account above");
		customerInfomationPage = manageCustomersPage.clickToEditLinkByRowNumber("1");
		
		log.info("Step: click Delete Customer button");
		customerInfomationPage.clickToDeleteCustomerButton();
		
		log.info("Step: accept alert popup");
		manageCustomersPage = customerInfomationPage.acceptDeleteCustomerConfirmAlert();
		
		log.info("VP: Customer deleted successfully message displays");
		verifyTrue(manageCustomersPage.isCustomerDeletedSuccessMessageDisplayed());
		driver.quit();
		
		log.info("Step: Open LiveGuru99 user site");
		driver = getBrowserDriver(browserName, userUrl);		
		homePage = PageGeneratorManager.getHomePageOject(driver);
		
		log.info("Step: Login by deleted account");
		homePage.clickToAccountMenu();
		loginPage = homePage.clickToLogInLink();
		loginPage.inputToEmailTextbox(emailUpdate);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		log.info("VP: 'Invalid login or password.' message displays");
		verifyTrue(loginPage.isInvalidLoginMessageDisplayed());
	}
	
	@AfterClass(alwaysRun=true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
