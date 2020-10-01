package pageObjects.zingpoll;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.zingpoll.HomePageUI;

public class HomePageObject extends AbstractPage {

	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver; 
	}

	public void clickToSignInMenu() {
		waitElementClickable(driver, HomePageUI.SIGN_IN_MENU);
		clickToElement(driver, HomePageUI.SIGN_IN_MENU);
		//clickToElementByJS(driver, HomePageUI.SIGN_IN_MENU);		
	}

	public boolean isSignInPopupDislayed() {
		waitElementVisible(driver, HomePageUI.SIGN_IN_POPUP);
		return isElementDisplayed(driver, HomePageUI.SIGN_IN_POPUP);
	}

	public void checkNewUserRadioButton() {
		waitElementClickable(driver, HomePageUI.NEW_USER_RADIO_BUTTON);
		clickToElementByJS(driver, HomePageUI.NEW_USER_RADIO_BUTTON);
		//checkToCheckbox(driver, HomePageUI.NEW_USER_RADIO_BUTTON);
	}

	public void sendKeysToFullNameTextbox(String fullName) {
		waitElementVisible(driver, HomePageUI.FULL_NAME_TEXTBOX);
		sendKeysToElement(driver, HomePageUI.FULL_NAME_TEXTBOX, fullName);
	}

	public void sendKeysToEmailTextbox(String email) {
		waitElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, HomePageUI.EMAIL_TEXTBOX, email);	
	}

	public void sendKeysToPasswordTextbox(String password) {
		waitElementVisible(driver, HomePageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, HomePageUI.PASSWORD_TEXTBOX, password);		
	}

	public void sendKeysToReenterPasswordTextbox(String password) {
		waitElementVisible(driver, HomePageUI.RE_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, HomePageUI.RE_PASSWORD_TEXTBOX, password);	
	}

	public void checkAgreecheckbox() {
		waitElementClickable(driver, HomePageUI.AGREE_TERM_CHECKBOX);
		checkToCheckbox(driver, HomePageUI.AGREE_TERM_CHECKBOX);	
	}

	public void clickToRegisterButton() {
		waitElementClickable(driver, HomePageUI.REGISTER_BUTTON);
		clickToElement(driver, HomePageUI.REGISTER_BUTTON);
	}

	public boolean isActivationLinkMessageDisplayed() {
		waitElementVisible(driver, HomePageUI.ACTIVATION_LINK_MESSAGE);
		return isElementDisplayed(driver, HomePageUI.ACTIVATION_LINK_MESSAGE);
	}

	public void sendKeysToSignInEmailTextbox(String email) {
		waitElementVisible(driver, HomePageUI.SIGN_IN_EMAIL_TEXTBOX);
		sendKeysToElement(driver, HomePageUI.SIGN_IN_EMAIL_TEXTBOX, email);
		
	}

	public void sendKeysToSignInPasswordTextbox(String password) {
		waitElementVisible(driver, HomePageUI.SIGN_IN_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, HomePageUI.SIGN_IN_PASSWORD_TEXTBOX, password);
	}

	public void clickToSignInButton() {
		waitElementClickable(driver, HomePageUI.SIGN_IN_BUTTON);
		clickToElement(driver, HomePageUI.SIGN_IN_BUTTON);
	}

	public boolean isFullNameDisplayed(String fullname) {
		waitElementVisible(driver, HomePageUI.FULL_NAME_TEXT,fullname);
		return isElementDisplayed(driver, HomePageUI.FULL_NAME_TEXT,fullname);
	}
}
