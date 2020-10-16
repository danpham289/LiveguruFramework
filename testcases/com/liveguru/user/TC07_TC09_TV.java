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
import pageObjects.liveguru.CheckoutPageObject;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginUserPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.MyWishlistPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.ProductDetailPageObject;
import pageObjects.liveguru.ProductReviewsPageObject;
import pageObjects.liveguru.ShareYourWishlistPageObject;
import pageObjects.liveguru.ShoppingCartPageObject;
import pageObjects.liveguru.TVPageObject;

public class TC07_TC09_TV extends AbstractTest {
	WebDriver driver;
	HomePageObject homePage;
	DriverManager driverManager;
	LoginUserPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	MyWishlistPageObject myWishlistPage;
	TVPageObject tvPage;
	ShareYourWishlistPageObject shareYourWishlistPage;
	ProductDetailPageObject productDetailPage;
	ProductReviewsPageObject productReviewsPage;
	ShoppingCartPageObject shoppingCartPage;
	CheckoutPageObject checkoutPage;
	
	String shareEmail= "share@mailinator.com";
	String product= "LG LCD";
	String country= "United States";
	String state= "New York";
	String zip= "543432";
	String address= "01 HVT";
	String telephone= "0905789456";
	String city= "DN";

	
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
	
	@Test
	public void TC07_Share_Wishlist() {
		
		log.info("Step: Click TV menu");
		tvPage = homePage.clickToTVMenu(driver);
		
		log.info("Step: Click 'Add to Wishlist' link of 'LG LCD' then navigate to My Wishlist");
		myWishlistPage = tvPage.clickToAddToWishlistLinkByProduct(product);
		
		log.info("VP: Msg 'LG LCD has been added to your wishlist. Click here to continue shopping.' displays");
		verifyTrue(myWishlistPage.isProductAddedToWishlistMessageDisplayed(product));
		
		log.info("Step: Click 'Share Wishlist' button and navigate to Share Your Wishlist Page");
		shareYourWishlistPage = myWishlistPage.clickToShareWishlistButton();
		
		log.info("Step: Input valid email and Click 'Share Wishlist' button and navigate to My Wishlist Page");
		shareYourWishlistPage.inputToEmailTextbox(shareEmail);
		
		myWishlistPage = shareYourWishlistPage.clickToShareWishlistButton();
		
		log.info("VP: Msg 'Your Wishlist has been shared.' displays, My Wishlist page has 1 item 'LG LCD'");
		verifyTrue(myWishlistPage.isYourWishlistSharedMessageDisplayed());
		verifyEquals(myWishlistPage.getNumberOfItemsInWishlist(), 1);
		verifyEquals(myWishlistPage.getProductNameByRowNumber(1), product);
	}

	@Test
	public void TC09_Purchase_Product() {
//		log.info("Step: Click 'MY WISHLIST' link on Left menu then navigate to My Wishlist");
//		myDashboardPage.openLeftMenuPageByName(driver,"My Wishlist");
//		myWishlistPage = PageGeneratorManager.getMyWishlistPageObject(driver);
		
		log.info("VP: Step: Click 'Add to cart' button and navigate to Shopping Cart page");
		shoppingCartPage= myWishlistPage.clickToAddToCartButtonByProduct(product);
		
		log.info("Step: Input data to Country, State/Province, Zip field");
		shoppingCartPage.selectCountryDropdown(country);
		shoppingCartPage.selectStateDropdown(state);
		shoppingCartPage.inputToZipTextbox(zip);
		
		log.info("Step: Click ESTIMATE button");
		shoppingCartPage.clickToEstimateButton();
		
		log.info("VP: Shipping cost is generated $5.00");
		verifyEquals(shoppingCartPage.getFlatRateShippingPrice(), "$5.00");
		
		log.info("Step: Click Flat Rate Shipping cost radiobutton and UPDATE TOTAL button");
		shoppingCartPage.clickToFlatRateShippingCostRadiobutton();
		shoppingCartPage.clickToUpdateTotalButton();
		
		log.info("VP: Shipping cost is added to total product cost");
		verifyTrue(shoppingCartPage.isShippingCostAddedToTotalCost());
		
		log.info("Step: Click PROCEED TO CHECKOUT button then navigate to Checkout page");
		checkoutPage = shoppingCartPage.clickToProceedToCheckoutButton();
		
		log.info("Step: Click CONTINUE button on Billing Information");
		checkoutPage.inputToBillingAddressTextbox(address);
		checkoutPage.inputToBillingCityTextbox(city);
		checkoutPage.selectBillingStateDropdown(state);
		checkoutPage.inputToBillingZipTextbox(zip);
		checkoutPage.inputToBillingTelephoneTextbox(telephone);
		checkoutPage.clickToBillingContinueButton();
		
		log.info("Step: Click CONTINUE button on Shipping Information");
		checkoutPage.clickToShippingContinueButton();
		
		log.info("Step: Select 'Check/Money Order' radiobutton then Click CONTINUE button on Payment Information");
		checkoutPage.clickToCheckMoneyOrderRadiobutton();
		checkoutPage.clickToPaymentContinueButton();
		
		log.info("Step: Click PLACE ORDER  button ");
		checkoutPage.clickPlaceOrderButton();
		
		log.info("VP: Order is placed, Order Number is generated");
		verifyTrue(checkoutPage.isYourOrderTextDisplayed());
		log.info(checkoutPage.getOrderNumberText());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
