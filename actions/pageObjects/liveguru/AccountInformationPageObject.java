package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.AccountInformationPageUI;

public class AccountInformationPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public AccountInformationPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public String getFirstName() {
		waitElementVisible(driver, AccountInformationPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, AccountInformationPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getLastName() {
		waitElementVisible(driver, AccountInformationPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, AccountInformationPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getEmail() {
		waitElementVisible(driver, AccountInformationPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, AccountInformationPageUI.EMAIL_TEXTBOX, "value");
	}

	public void inputToFirstNameTextbox(String value) {
		waitElementVisible(driver, AccountInformationPageUI.FIRST_NAME_TEXTBOX);
		sendKeysToElement(driver, AccountInformationPageUI.FIRST_NAME_TEXTBOX, value);
	}

	public void inputToLastNameTextbox(String value) {
		waitElementVisible(driver, AccountInformationPageUI.LAST_NAME_TEXTBOX);
		sendKeysToElement(driver, AccountInformationPageUI.LAST_NAME_TEXTBOX, value);
	}

	public void inputToEmailTextbox(String value) {
		waitElementVisible(driver, AccountInformationPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, AccountInformationPageUI.EMAIL_TEXTBOX, value);
	}

	public void inputToConfirmPasswordTextbox(String value) {
		waitElementVisible(driver, AccountInformationPageUI.CURRENT_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, AccountInformationPageUI.CURRENT_PASSWORD_TEXTBOX, value);
	}

	public MyDashboardPageObject clickToSaveButton() {
		waitElementClickable(driver, AccountInformationPageUI.SAVE_BUTTON);
		clickToElement(driver, AccountInformationPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getMyDashboardPageObject(driver);
	}

}
