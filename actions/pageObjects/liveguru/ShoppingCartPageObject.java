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

	
}
