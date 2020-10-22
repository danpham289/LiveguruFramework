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

	public void clickToReviewsTab() {
		waitElementClickable(driver, ProductDetailPageUI.REVIEWS_TAB);
		clickToElement(driver, ProductDetailPageUI.REVIEWS_TAB);
		
	}

	public String getReviewLinkTextByIndex(String index) {
		waitElementVisible(driver, ProductDetailPageUI.DYNAMIC_REVIEW_LINK_BY_INDEX,index);
		return getElementText(driver, ProductDetailPageUI.DYNAMIC_REVIEW_LINK_BY_INDEX,index);
	}

}
