package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.MobilePageUI;
import pageUIs.liveguru.ProductDetailPageUI;

public class ProductDetailPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public String getCostOfSonyOnDetail() {
		waitElementVisible(driver, ProductDetailPageUI.PRODUCT_COST_TEXT);
		return getElementText(driver, ProductDetailPageUI.PRODUCT_COST_TEXT);
	}

	public ProductReviewsPageObject clickToAddYourReviewLink() {
		waitElementClickable(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getProductReviewsPageObject(driver);
	}

}
