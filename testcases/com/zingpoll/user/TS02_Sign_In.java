package com.zingpoll.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.zingpoll.HomePageObject;
import pageObjects.zingpoll.PageGeneratorManager;

public class TS02_Sign_In extends AbstractTest {
	
	private WebDriver driver;
	HomePageObject homePage;
	String fullname = "Dan Pham";
	String email = "dan@mailinator.com";
	String password ="123456";
	

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName,String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void TC01_Sign_In(){
		sleepInSeconds(1);
		//click Sign In menu
		homePage.clickToSignInMenu();
		
		//Verify Sign Up popup display
		Assert.assertTrue(homePage.isSignInPopupDislayed());
		
		//Input valid data into the fields
		homePage.sendKeysToSignInEmailTextbox(email);
		homePage.sendKeysToSignInPasswordTextbox(password);

		//Click Sign In button
		homePage.clickToSignInButton();
		
		//Verify full name displays replacing Sign In button
		Assert.assertTrue(homePage.isFullNameDisplayed(fullname));
	}

	@AfterClass
	public void afterClass() {
		removeDriver();
	}
	


}
