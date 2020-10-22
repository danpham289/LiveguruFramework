package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import driverFactory.DriverFactory;
import driverFactory.DriverManager;
import pageObjects.liveguru.AdvancedSearchPageObject;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginUserPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.MyWishlistPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.ProductDetailPageObject;
import pageObjects.liveguru.ProductReviewsPageObject;
import pageObjects.liveguru.SearchResultPageObject;
import pageObjects.liveguru.ShareYourWishlistPageObject;
import pageObjects.liveguru.TVPageObject;

public class TC08_TC10 extends AbstractTest {
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
	AdvancedSearchPageObject advancedSearchPage;
	SearchResultPageObject searchResultPage;
	String shareEmail= "share@mailinator.com";
	String thought= "Good product but high price \n fast ship ";
	String review= "Good";
	String nickname= "Test";
	
	@Parameters({"browser","userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		log.info("Precondition - 1: Open LiveGuru99 site");
		driverManager = DriverFactory.getManager(browserName);
		driver = driverManager.getDriver();
		driver.get(appURL);
		homePage = PageGeneratorManager.getHomePageOject(driver);		
	}

	@Test
	public void TC08_Add_Your_Review() {
		log.info("Step: Click TV menu");
		tvPage = homePage.clickToTVMenu(driver);
		
		log.info("Step: Click 'SAMSUNG LCD' product detail then navigate to Product Detail page");
		productDetailPage = tvPage.clickToDynamicProductDetailLink("Samsung LCD");
		
		log.info("Step: Click 'Add Your Review' link");
		productReviewsPage = productDetailPage.clickToAddYourReviewLink();
		
		log.info("Step: Click 'Submit Review' button");
		productReviewsPage.clickToSubmitReviewButton();
		
		log.info("VP: Msg 'THIS IS A REQUIRED FIELD.' displays at 3 fields THOUGHT/YOUR REVIEW/YOUR NICKNAME");
		verifyTrue(productReviewsPage.isRequiredValidateMessageOfThoughtTextareaDisplayed()); 
		verifyTrue(productReviewsPage.isRequiredValidateMessageOfReviewTextboxDisplayed()); 
		verifyTrue(productReviewsPage.isRequiredValidateMessageOfNickNameTextboxDisplayed()); 
		
		log.info("Step: Input data into 3 fields THOUGHT/YOUR REVIEW/YOUR NICKNAME");
		productReviewsPage.inputToThoughtTextarea(thought);
		productReviewsPage.inputToReviewTextarea(review);
		productReviewsPage.inputToNicknameTextarea(nickname);
		
		log.info("Step: Click 'Submit Review' button");
		productReviewsPage.clickToSubmitReviewButton();
		
		log.info("VP: Msg 'Your review has been accepted for moderation.' displays");
		verifyTrue(productReviewsPage.isReviewAcceptedMessageDisplayed()); 
	}
	
	@Test
	public void TC10_Advance_Search() {
		log.info("Step: Click 'Advance Search' link then navigate to Advance Search page");
		productReviewsPage.openFooterPageByName(driver, "Advanced Search");
		advancedSearchPage = PageGeneratorManager.getAdvancedSearchPageObject(driver);
		
		log.info("Step: Input Price 0 - 150 and click Search button");
		advancedSearchPage.inputToPriceTextbox("0");
		advancedSearchPage.inputToPriceToTextbox("150");
		searchResultPage = advancedSearchPage.clickToSearchButton();
				
		log.info("Print Product Name & Price in console");
		searchResultPage.printProductNamesAndPrices();
		
		log.info("Step: Click 'Advance Search' link then navigate to Advance Search page");
		searchResultPage.openFooterPageByName(driver, "Advanced Search");
		advancedSearchPage = PageGeneratorManager.getAdvancedSearchPageObject(driver);
		
		log.info("Step: Input Price 151 - 1000 and click Search button");
		advancedSearchPage.inputToPriceTextbox("151");
		advancedSearchPage.inputToPriceToTextbox("1000");
		searchResultPage = advancedSearchPage.clickToSearchButton();
				
		log.info("Print Product Name & Price in console");
		searchResultPage.printProductNamesAndPrices();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
