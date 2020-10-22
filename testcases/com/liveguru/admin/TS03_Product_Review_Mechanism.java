package com.liveguru.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginAdminPageObject;
import pageObjects.liveguru.ManageCustomersPageObject;
import pageObjects.liveguru.MobilePageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.PendingReviewsPageObject;
import pageObjects.liveguru.ProductDetailPageObject;
import pageObjects.liveguru.ProductReviewsPageObject;
import pageObjects.liveguru.ReviewDetailsPageObject;

public class TS03_Product_Review_Mechanism extends AbstractTest{
	WebDriver driver;
	LoginAdminPageObject loginAdminPage;
	ManageCustomersPageObject manageCustomersPage; 
	ProductReviewsPageObject productReviewsPage;
	PendingReviewsPageObject pendingReviewsPage;
	ReviewDetailsPageObject reviewDetailsPage;
	HomePageObject homePage;
	MobilePageObject mobilePage;
	ProductDetailPageObject productDetailPage;
	
	String reviewProductLink = "http://live.demoguru99.com/index.php/review/product/list/id/1";
	String thought= "Good product but high price";
	String review= "Good";
	String nickname= "Test";
	String productName= "Sony Xperia";
	
	@Parameters({"browser","adminUrl","userUrl"})
	@Test
	public void TC03_Product_Review_Mechanism(String browserName, String adminUrl, String userUrl) {
		
		log.info("Step: Open LiveGuru99 user site");
		driver = getBrowserDriver(browserName, userUrl);
		
		log.info("Step: Go to Link - http://live.demoguru99.com/index.php/review/product/list/id/1");
		driver.get(reviewProductLink);
		productReviewsPage = PageGeneratorManager.getProductReviewsPageObject(driver);
		
		log.info("Step: Input required fields and click Submit Review button");
		productReviewsPage.inputToThoughtTextarea(thought);
		productReviewsPage.inputToReviewTextarea(review);
		productReviewsPage.inputToNicknameTextarea(nickname);
		productReviewsPage.clickToSubmitReviewButton();
		
		log.info("VP: Review accepted Message displays");
		verifyTrue(productReviewsPage.isReviewAcceptedMessageDisplayed());
		
		log.info("Step: Open LiveGuru99 admin site");
		driver.get(adminUrl);
		loginAdminPage = PageGeneratorManager.getLoginAdminPageObject(driver);
				
		log.info("Step: Login with admin credentials");
		loginAdminPage.inputToUsernameTextbox(GlobalConstants.ADMIN_USER);
		loginAdminPage.inputToPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
		manageCustomersPage = loginAdminPage.clickToLoginButton();
		
		log.info("Step: Close Incoming Message Popup");
		manageCustomersPage.closeIncomingMessagePopUp();
		
		log.info("Step: Open 'Catalog' > 'Reviews and Ratings' > 'Customer Reviews' > 'Pending Reviews' on top menu");
		manageCustomersPage.openSubMenuPageInAdminByItems(driver, "Catalog", "Reviews and Ratings","Customer Reviews","Pending Reviews");
		pendingReviewsPage = PageGeneratorManager.getPendingReviewsPageObject(driver);
		
		log.info("Step: Input Thought, Nickname, Review, Product Name above and click Search button");
		pendingReviewsPage.inputToSearchTextboxByColumnName("Title",review);
		pendingReviewsPage.inputToSearchTextboxByColumnName("Nickname",nickname);
		pendingReviewsPage.inputToSearchTextboxByColumnName("Review",thought);
		pendingReviewsPage.inputToSearchTextboxByColumnName("Product Name",productName);
		pendingReviewsPage.clickToSearchButton();
		
		log.info("Step: Click Edit link at the 1 st row");
		reviewDetailsPage = pendingReviewsPage.clickToEditLinkByRowNumber("1");
		
		log.info("Step: Select 'Approved' in Status dropdown and click Save Review buton");
		reviewDetailsPage.selectItemInStatusDropdown("Approved");
		pendingReviewsPage = reviewDetailsPage.clickToSaveReviewbutton();
		
		log.info("VP: Review saved message displays");
		verifyTrue(pendingReviewsPage.isReviewSavedMessageDisplayed());
		
		log.info("Step: Open LiveGuru99 user site");
		driver.get(userUrl);
		homePage = PageGeneratorManager.getHomePageOject(driver);
		
		log.info("Step: Click Mobile menu");
		mobilePage = homePage.clickToMobileMenu(driver);
		
		log.info("Step: Click Sony Xperia link");
		productDetailPage = mobilePage.clickToProductDetailLinkByProductName(productName);
		
		log.info("Step: Click Reviews tab");
		productDetailPage.clickToReviewsTab();
		
		log.info("Step: Verify the approved review above displays");
		verifyEquals(productDetailPage.getReviewLinkTextByIndex("1"), review.toUpperCase());
	}
		
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
