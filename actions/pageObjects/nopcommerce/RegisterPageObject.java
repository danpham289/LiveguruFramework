package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;	
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);	
	}

	public void inputToEmailTextbox(String email) {
		waitElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);	
	}

	public void inputToCompanyTextbox(String company) {
		waitElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, company);		
	}

	public void inputToPasswordTextbox(String password) {
		waitElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);	
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public Object getResultMessageText() {
		waitElementVisible(driver, RegisterPageUI.RESULT_MESSAGE);
		return getElementText(driver, RegisterPageUI.RESULT_MESSAGE);
	}

	public void clickToRegisterButton() {
		waitElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElementByJS(driver, RegisterPageUI.REGISTER_BUTTON);
	}
}
