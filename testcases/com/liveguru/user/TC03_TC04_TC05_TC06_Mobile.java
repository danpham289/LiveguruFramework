package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.commons.Common_01_Register_User;

import commons.AbstractTest;
import pageObjects.liveguru.CompareProductPageObject;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginUserPageObject;
import pageObjects.liveguru.MobilePageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.ShoppingCartPageObject;
import pageObjects.liveguru.SonyDetailPageObject;

public class TC03_TC04_TC05_TC06_Mobile extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	MobilePageObject mobilePage;
	SonyDetailPageObject sonyDetailPage;
	ShoppingCartPageObject shoppingCartPage;
	CompareProductPageObject compareProductPage;
	LoginUserPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	String couponCode = "GURU50";

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		log.info("Precondition - 1a: Open LiveGuru99 site");
		driver = getBrowserDriver(browserName, appURL);
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
		log.info("Precondition - 2: Click Mobile menu");
		mobilePage = myDashboardPage.clickMobileMenu(driver);
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
		log.info("Step 1: Add IPHONE to cart");
		shoppingCartPage = mobilePage.clickToIphoneAddToCartButton();
		
		log.info("VP: Verify Iphone is added to your shopping cart");
		Assert.assertTrue(shoppingCartPage.isIphoneAddedToCartSuccessMsgDisplay());
		
		log.info("Step 2: Enter COUPON CODE");
		shoppingCartPage.sendKeysToDiscountCodesTextbox(couponCode);
		shoppingCartPage.clickToApplyButton();
		
		log.info("VP: Verify discount Text displays");
		Assert.assertEquals(shoppingCartPage.getDiscountText(), "-$25.00");
	}

	@Test
	public void TC05_Cannot_Add_More_500_Items_Of_Product() {
		log.info("Step 1: Add SONY XPERIA to cart");
		shoppingCartPage = mobilePage.clickToAddToCartButtonByProduct("Sony Xperia");
		
		log.info("Step 2: Change QTY to 501 and click UPDATE button");
		shoppingCartPage.sendKeysToQTYTextboxByProduct("Sony Xperia","501");
		shoppingCartPage.clickToUpdateButtonByProduct("Sony Xperia");
		
		log.info("VP: Verify error message");
		Assert.assertTrue(shoppingCartPage.isMaximunQuantityErrorMessageDisplayed());
		
		log.info("Step 3: Click 'Empty cart' link");
		shoppingCartPage.clickToEmptyCartLink();
		
		log.info("VP: Verify cart is empty");
		Assert.assertTrue(shoppingCartPage.isEmptyCartMessageDisplayed());
		Assert.assertTrue(shoppingCartPage.isNoItemMessageDisplayed());
	}
	
	@Test
	public void TC06_Compare_Two_Products() {
		log.info("Step 1: Click 'Add to compare' on SONY XPERIA and IPHONE");
		log.info("VP: Verify message");
		mobilePage.clickToAddToCompareByProduct("Sony Xperia");
		Assert.assertTrue(mobilePage.isProductAddedToComparisonListMsgDisplayed("Sony Xperia"));
		mobilePage.clickToAddToCompareByProduct("IPhone");
		Assert.assertTrue(mobilePage.isProductAddedToComparisonListMsgDisplayed("IPhone"));
		
		log.info("Step 2: Click 'COMPARE' button");
		compareProductPage = mobilePage.clickToCompareButton();
		
		log.info("VP: Verify popup window open with heading as COMPARE PRODUCT and selected products display");
		Assert.assertTrue(compareProductPage.isCompareProductHeadingDisplayed());
		Assert.assertTrue(compareProductPage.isSelectedProductDisplayed("Sony Xperia"));
		Assert.assertTrue(compareProductPage.isSelectedProductDisplayed("IPhone"));
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
