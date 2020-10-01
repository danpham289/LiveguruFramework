package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.ShoppingCartPageUI;

public class ShoppingCartPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public boolean isIphoneAddedToCartSuccessMsgDisplay() {
		waitElementVisible(driver, ShoppingCartPageUI.IPHONE_ADDED_TO_CART_SUCCESS_MSG);
		return isElementDisplayed(driver, ShoppingCartPageUI.IPHONE_ADDED_TO_CART_SUCCESS_MSG);
	}

	public void sendKeysToDiscountCodesTextbox(String couponCode) {
		waitElementVisible(driver,ShoppingCartPageUI.COUPON_CODE_TEXTBOX);
		sendKeysToElement(driver, ShoppingCartPageUI.COUPON_CODE_TEXTBOX, couponCode);
		
	}

	public String getDiscountText() {
		waitElementVisible(driver,ShoppingCartPageUI.DISCOUNT_TEXT);
		return getElementText(driver, ShoppingCartPageUI.DISCOUNT_TEXT);
	}

	public void clickToApplyButton() {
		waitElementClickable(driver, ShoppingCartPageUI.APLLY_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.APLLY_BUTTON);
		
	}

	public void sendKeysToQTYTextboxByProduct(String product,String quantity) {
		waitElementVisible(driver, ShoppingCartPageUI.DYNAMIC_QTY_TEXTBOX_BY_PRODUCT, product);
		sendKeysToElement(driver, ShoppingCartPageUI.DYNAMIC_QTY_TEXTBOX_BY_PRODUCT, quantity, product);
		
	}

	public void clickToUpdateButtonByProduct(String product) {
		waitElementClickable(driver, ShoppingCartPageUI.DYNAMIC_UPDATE_BUTTON_BY_PRODUCT, product);
		clickToElement(driver, ShoppingCartPageUI.DYNAMIC_UPDATE_BUTTON_BY_PRODUCT, product);
	}

	public boolean isMaximunQuantityErrorMessageDisplayed() {
		waitElementVisible(driver, ShoppingCartPageUI.MAXIMUM_QUANTITY_ERROR_MESSAGE);
		return isElementDisplayed(driver, ShoppingCartPageUI.MAXIMUM_QUANTITY_ERROR_MESSAGE);
	}

	public void clickToEmptyCartLink() {
		waitElementClickable(driver, ShoppingCartPageUI.EMPTY_CART_LINK);
		clickToElement(driver, ShoppingCartPageUI.EMPTY_CART_LINK);		
	}

	public boolean isEmptyCartMessageDisplayed() {
		waitElementVisible(driver, ShoppingCartPageUI.EMPTY_CART_MESSAGE);
		return isElementDisplayed(driver, ShoppingCartPageUI.EMPTY_CART_MESSAGE);
	}

	public boolean isNoItemMessageDisplayed() {
		waitElementVisible(driver, ShoppingCartPageUI.NO_ITEMS_MESSAGE);
		return isElementDisplayed(driver, ShoppingCartPageUI.NO_ITEMS_MESSAGE);
	}


	
}
