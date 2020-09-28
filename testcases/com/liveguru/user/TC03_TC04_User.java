package com.liveguru.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.liveguru.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC03_TC04_User extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	MobilePageObject mobilePage;
	SonyDetailPageObject sonyDetailPage;
	ShoppingCartPageObject shoppingCartPage;
	String couponCode = "GURU50";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		log.info("Precondition - 1: Open LiveGuru99 site");
		driver = getBrowserDriver(browserName, appURL);
		homePage = new HomePageObject(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		log.info("Precondition - 2: Click Mobile menu");
		mobilePage = homePage.clickMobileMenu(driver);
	}
	
	@Test
	public void TC03_Product_Cost_In_List_Page_And_Details_Page_Are_Equal() {
		log.info("Step 1: Get Cost of SONY XPERIA on list");
		String costOfSonyInList = mobilePage.getCostOfSonyOnList();
		
		log.info("Step 2: Click SONY XPERIA detail");
		sonyDetailPage = mobilePage.clickToSonyDetailLink();
		
		log.info("Step 3: Get Cost of SONY XPERIA on detail");
		String costOfSonyInDetail = sonyDetailPage.getCostOfSonyOnDetail();
		
		log.info("Step 4: Compare cost at step 2 & 4");
		Assert.assertEquals(costOfSonyInList, costOfSonyInDetail);
	}
	
	@Test
	public void TC04_Verify_Discount_Coupon_Works() {
		log.info("Step 2: Add IPHONE to cart");
		shoppingCartPage = mobilePage.clickToIphoneAddToCartButton();
		
		log.info("VP: Verify Iphone is added to your shopping cart");
		Assert.assertTrue(shoppingCartPage.isIphoneAddedToCartSuccessMsgDisplay());
		
		log.info("Step 3: Enter COUPON CODE");
		shoppingCartPage.sendKeysToDiscountCodesTextbox(couponCode);
		shoppingCartPage.clickToApplyButton();
		
		log.info("VP: Verify discount Text displays");
		Assert.assertEquals(shoppingCartPage.getDiscountText(), "-$25.00");
	}

	@AfterClass
	public void afterClass() {
		removeDriver();
	}

}
