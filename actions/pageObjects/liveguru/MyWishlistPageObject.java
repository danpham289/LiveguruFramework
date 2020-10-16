package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.MyWishlistPageUI;

public class MyWishlistPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public MyWishlistPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public boolean isProductAddedToWishlistMessageDisplayed(String product) {
		waitElementVisible(driver, MyWishlistPageUI.DYNAMIC_PRODUCT_ADDED_TO_WISHLIST_MESSAGE, product);
		return isElementDisplayed(driver, MyWishlistPageUI.DYNAMIC_PRODUCT_ADDED_TO_WISHLIST_MESSAGE, product);
	}

	public ShareYourWishlistPageObject clickToShareWishlistButton() {
		waitElementClickable(driver, MyWishlistPageUI.SHARE_WISHLIST_BUTTON);
		clickToElement(driver, MyWishlistPageUI.SHARE_WISHLIST_BUTTON);
		return PageGeneratorManager.getShareYourWishlistPageObject(driver);
	}

	public boolean isYourWishlistSharedMessageDisplayed() {
		waitElementVisible(driver, MyWishlistPageUI.YOUR_WISHLIST_SHARED_MESSAGE);
		return isElementDisplayed(driver, MyWishlistPageUI.YOUR_WISHLIST_SHARED_MESSAGE);
	}

	public int getNumberOfItemsInWishlist() {
		waitElementVisible(driver, MyWishlistPageUI.ITEM_ROWS_IN_WISHLIST);
		return countElementNumber(driver, MyWishlistPageUI.ITEM_ROWS_IN_WISHLIST);
	}

	public Object getProductNameByRowNumber(int rowNumber) {
		waitElementVisible(driver, MyWishlistPageUI.DYNAMIC_PRODUCT_NAME_BY_ROW_NUMBER,String.valueOf(rowNumber));
		return getElementText(driver, MyWishlistPageUI.DYNAMIC_PRODUCT_NAME_BY_ROW_NUMBER,String.valueOf(rowNumber));
	}

	public ShoppingCartPageObject clickToAddToCartButtonByProduct(String product) {
		waitElementVisible(driver, MyWishlistPageUI.DYNAMIC_ADD_TO_CART_BUTTON_BY_PRODUCT,product);
		clickToElement(driver, MyWishlistPageUI.DYNAMIC_ADD_TO_CART_BUTTON_BY_PRODUCT,product);
		return PageGeneratorManager.getShoppingCartPageObject(driver);
	}

}
