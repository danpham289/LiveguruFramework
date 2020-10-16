package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.CheckoutPageUI;

public class CheckoutPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void clickToBillingContinueButton() {
		waitElementClickable(driver, CheckoutPageUI.BILLING_CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPageUI.BILLING_CONTINUE_BUTTON);
		waitElementInvisible(driver, CheckoutPageUI.BILLING_LOADING_ICON);
	}

	public void clickToShippingContinueButton() {
		waitElementClickable(driver, CheckoutPageUI.SHIPPING_CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPageUI.SHIPPING_CONTINUE_BUTTON);
		waitElementInvisible(driver, CheckoutPageUI.SHIPPING_LOADING_ICON);
	}

	public void clickToCheckMoneyOrderRadiobutton() {
		waitElementClickable(driver, CheckoutPageUI.CHECK_MONEY_ORDER_RADIOBUTTON);
		clickToElement(driver, CheckoutPageUI.CHECK_MONEY_ORDER_RADIOBUTTON);
	}

	public void clickToPaymentContinueButton() {
		waitElementClickable(driver, CheckoutPageUI.PAYMENT_CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPageUI.PAYMENT_CONTINUE_BUTTON);
		waitElementInvisible(driver, CheckoutPageUI.PAYMENT_LOADING_ICON);
	}

	public void clickPlaceOrderButton() {
		waitElementClickable(driver, CheckoutPageUI.PLACE_ORDER_BUTTON);
		clickToElement(driver, CheckoutPageUI.PLACE_ORDER_BUTTON);
		waitElementInvisible(driver, CheckoutPageUI.REVIEW_LOADING_ICON);
	}

	public boolean isYourOrderTextDisplayed() {
		waitElementVisible(driver, CheckoutPageUI.YOUR_ORDER_TEXT);
		return isElementDisplayed(driver, CheckoutPageUI.YOUR_ORDER_TEXT);
	}

	public String getOrderNumberText() {
		waitElementVisible(driver, CheckoutPageUI.YOUR_ORDER_TEXT);
		return getElementText(driver, CheckoutPageUI.YOUR_ORDER_TEXT);
	}

	public void inputToBillingAddressTextbox(String address) {
		waitElementVisible(driver, CheckoutPageUI.BILING_ADDRESS_TEXTBOX);
		sendKeysToElement(driver, CheckoutPageUI.BILING_ADDRESS_TEXTBOX, address);
	}

	public void inputToBillingCityTextbox(String city) {
		waitElementVisible(driver, CheckoutPageUI.BILING_CITY_TEXTBOX);
		sendKeysToElement(driver, CheckoutPageUI.BILING_CITY_TEXTBOX, city);
	}

	public void selectBillingStateDropdown(String state) {
		waitElementVisible(driver, CheckoutPageUI.BILLING_STATE_DROPDOWN);
		selectItemInDropdown(driver, CheckoutPageUI.BILLING_STATE_DROPDOWN, state);
		
	}

	public void inputToBillingZipTextbox(String zip) {
		waitElementVisible(driver, CheckoutPageUI.BILING_ZIP_TEXTBOX);
		sendKeysToElement(driver, CheckoutPageUI.BILING_ZIP_TEXTBOX, zip);
		
	}

	public void inputToBillingTelephoneTextbox(String telephone) {
		waitElementVisible(driver, CheckoutPageUI.BILING_TELEPHONE_TEXTBOX);
		sendKeysToElement(driver, CheckoutPageUI.BILING_TELEPHONE_TEXTBOX, telephone);
	}



}
