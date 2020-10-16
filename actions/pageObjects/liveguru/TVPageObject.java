package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.TVPageUI;

public class TVPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public TVPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public MyWishlistPageObject clickToAddToWishlistLinkByProduct(String product) {
		waitElementClickable(driver, TVPageUI.DYNAMIC_ADD_TO_WISHLIST_LINK_BY_PRODUCT, product);
		clickToElement(driver, TVPageUI.DYNAMIC_ADD_TO_WISHLIST_LINK_BY_PRODUCT, product);
		return PageGeneratorManager.getMyWishlistPageObject(driver);
	}

	public ProductDetailPageObject clickToDynamicProductDetailLink(String product) {
		waitElementClickable(driver, TVPageUI.DYNAMIC_PRODUCT_LINK, product);
		clickToElement(driver, TVPageUI.DYNAMIC_PRODUCT_LINK, product);
		return PageGeneratorManager.getProductDetailPageObject(driver);
	}

}
