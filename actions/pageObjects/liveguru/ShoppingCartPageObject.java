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

	public void selectCountryDropdown(String country) {
		waitElementVisible(driver, ShoppingCartPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, ShoppingCartPageUI.COUNTRY_DROPDOWN, country);
	}

	public void selectStateDropdown(String state) {
		waitElementVisible(driver, ShoppingCartPageUI.STATE_DROPDOWN);
		selectItemInDropdown(driver, ShoppingCartPageUI.STATE_DROPDOWN, state);
	}

	public void inputToZipTextbox(String zip) {
		waitElementVisible(driver, ShoppingCartPageUI.ZIP_TEXTBOX);
		sendKeysToElement(driver, ShoppingCartPageUI.ZIP_TEXTBOX, zip);
	}

	public void clickToEstimateButton() {
		waitElementClickable(driver, ShoppingCartPageUI.ESTIMATE_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.ESTIMATE_BUTTON);
		
	}

	public String getFlatRateShippingPrice() {
		waitElementVisible(driver, ShoppingCartPageUI.FLAT_RATE_SHIPPING_TEXT);
		return getElementText(driver, ShoppingCartPageUI.FLAT_RATE_SHIPPING_TEXT);
	}

	public void clickToFlatRateShippingCostRadiobutton() {
		waitElementClickable(driver, ShoppingCartPageUI.FLAT_RATE_SHIPPING_RADIOBUTTON);
		clickToElement(driver, ShoppingCartPageUI.FLAT_RATE_SHIPPING_RADIOBUTTON);
	}

	public void clickToUpdateTotalButton() {
		waitElementClickable(driver, ShoppingCartPageUI.UPDATE_TOTAL_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.UPDATE_TOTAL_BUTTON);
	}

	public String getSubtotalPrice() {
		waitElementVisible(driver, ShoppingCartPageUI.SUBTOTAL_PRICE_TEXT);
		return getElementText(driver, ShoppingCartPageUI.SUBTOTAL_PRICE_TEXT);
	}
	
	public String getGrandtotalPrice() {
		waitElementVisible(driver, ShoppingCartPageUI.GRANDTOTAL_PRICE_TEXT);
		return getElementText(driver, ShoppingCartPageUI.GRANDTOTAL_PRICE_TEXT);
	}
	
	public boolean isShippingCostAddedToTotalCost() {
		double shippingCost = Double.parseDouble(getFlatRateShippingPrice().substring(1));   
		double subtotalPrice = Double.parseDouble(getSubtotalPrice().substring(1));   
		double grandtotalPrice = Double.parseDouble(getGrandtotalPrice().substring(1));   
		return (shippingCost+subtotalPrice==grandtotalPrice);
	}

	public CheckoutPageObject clickToProceedToCheckoutButton() {
		waitElementClickable(driver, ShoppingCartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		return PageGeneratorManager.getCheckoutPageObject(driver);
	}


	
}
