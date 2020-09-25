package com.liveguru.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.liveguru.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC03_User extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	MobilePageObject mobilePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		log.info("Precondition: Open LiveGuru99 site");
		driver = getBrowserDriver(browserName, appURL);
		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC03_Product_Cost_In_List_Page_And_Details_Page_Are_Equal() {
		log.info("Step 1: Click Mobile menu");
		mobilePage = homePage.clickMobileMenu(driver);
		
		log.info("Step 2: Get Cost of SONY XPERIA on list");
//		String costOfSonyInList = mobilePage.getCostOfSonyOnList();
	}

	@AfterClass
	public void afterClass() {
		removeDriver();
	}

}
