package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.commons.Common_01_Register_User;

import commons.AbstractTest;
import driverFactory.DriverFactory;
import driverFactory.DriverManager;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginUserPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.PageGeneratorManager;

public class TC07_TC08_TV extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	DriverManager driverManager;
	LoginUserPageObject loginPage;
	MyDashboardPageObject myDashboardPage;

	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		log.info("Precondition - 1: Open LiveGuru99 site");
		driverManager = DriverFactory.getManager(browserName);
		driver = driverManager.getDriver();
		driver.get(appURL);
		homePage = PageGeneratorManager.getHomePageOject(driver);
		
		log.info("Precondition - 1b: Login");
		homePage.clickToAccountMenu();
		loginPage = homePage.clickToLogInLink();
		loginPage.inputToEmailTextbox(Common_01_Register_User.email);
		loginPage.inputToPasswordTextbox(Common_01_Register_User.password);
		myDashboardPage = loginPage.clickToLoginButton();
	}

	@BeforeMethod
	public void beforeMethod() {
		log.info("Precondition - 2: Click TV menu");
//		tvPage = homePage.clickTVMenu(driver);
	}
	
	@Test
	public void TC01_Register_Success_To_System() {
		
	}


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
