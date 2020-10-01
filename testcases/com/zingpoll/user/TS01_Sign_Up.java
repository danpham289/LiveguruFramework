package com.zingpoll.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.zingpoll.HomePageObject;
import pageObjects.zingpoll.PageGeneratorManager;

public class TS01_Sign_Up extends AbstractTest {
	
	private WebDriver driver;
	HomePageObject homePage;
	String fullName = "Testing";
	String email = "testing"+randomNumber()+"@mailinator.com";
	String password ="123456";
	

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName,String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
	}

	@Test
	public void TC01_Sign_Up_1(){
		sleepInSeconds(1);
		//click Sign In menu
		homePage.clickToSignInMenu();
		
		//Verify Sign Up popup display
		Assert.assertTrue(homePage.isSignInPopupDislayed());
		
		//check New User radio button
		homePage.checkNewUserRadioButton();
		
		//Input valid data into the fields
		homePage.sendKeysToFullNameTextbox(fullName);
		homePage.sendKeysToEmailTextbox(email);
		homePage.sendKeysToPasswordTextbox(password);
		homePage.sendKeysToReenterPasswordTextbox(password);
		
		//Select Agree Terms checkbox
		homePage.checkAgreecheckbox();
		
		//Click Register button
		homePage.clickToRegisterButton();
		
		//Verify "An activation link has sent to your mailbox." Message displays
		Assert.assertTrue(homePage.isActivationLinkMessageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		removeDriver();
	}
	


}
