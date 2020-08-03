package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {

	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clicTokRegisterButton() {
		waitElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public String getRequiredErrorMsgAtFirstName() {
		waitElementVisible(driver, RegisterPageUI.REQUIRED_ERROR_MSG_AT_FIRST_NAME);
		return getElementText(driver, RegisterPageUI.REQUIRED_ERROR_MSG_AT_FIRST_NAME);
	}

	public String getRequiredErrorMsgAtLastName() {
		waitElementVisible(driver, RegisterPageUI.REQUIRED_ERROR_MSG_AT_LAST_NAME);
		return getElementText(driver, RegisterPageUI.REQUIRED_ERROR_MSG_AT_LAST_NAME);
	}

	public String getRequiredErrorMsgAtEmail() {
		waitElementVisible(driver, RegisterPageUI.REQUIRED_ERROR_MSG_AT_EMAIL);
		return getElementText(driver, RegisterPageUI.REQUIRED_ERROR_MSG_AT_EMAIL);
	}

	public String getRequiredErrorMsgAtPassword() {
		waitElementVisible(driver, RegisterPageUI.REQUIRED_ERROR_MSG_AT_PASSWORD);
		return getElementText(driver, RegisterPageUI.REQUIRED_ERROR_MSG_AT_PASSWORD);
	}

	public String getRequiredErrorMsgAtConfirmPassword() {
		waitElementVisible(driver, RegisterPageUI.REQUIRED_ERROR_MSG_AT_CONFIRM_PASSWORD);
		return getElementText(driver, RegisterPageUI.REQUIRED_ERROR_MSG_AT_CONFIRM_PASSWORD);
	}

	public String getAdviceValidateErrorMsgAtEmail() {
		waitElementVisible(driver, RegisterPageUI.VALIDATE_ERROR_MSG_AT_EMAIL);
		return getElementText(driver, RegisterPageUI.VALIDATE_ERROR_MSG_AT_EMAIL);
	}


	public String getAdviceValidateErrorMsgAtPassword() {
		waitElementVisible(driver, RegisterPageUI.VALIDATE_ERROR_MSG_AT_PASSWORD);
		return getElementText(driver, RegisterPageUI.VALIDATE_ERROR_MSG_AT_PASSWORD);
	}

	public String getAdviceValidateErrorMsgAtConfirmPassword() {
		waitElementVisible(driver, RegisterPageUI.VALIDATE_ERROR_MSG_AT_CONFIRM_PASSWORD);
		return getElementText(driver, RegisterPageUI.VALIDATE_ERROR_MSG_AT_CONFIRM_PASSWORD);
	}

	public void inputToFirstnameTextbox(String string) {
		waitElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, string);

	}

	public void inputToLastnameTextbox(String string) {
		waitElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, string);
	}
	
	public void inputToEmailTextbox(String string) {
		waitElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, string);
	}

	public void inputToConfirmPasswordTextbox(String string) {
		waitElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, string);
	}
	
	public void inputToPasswordTextbox(String string) {
		waitElementVisible(driver, RegisterPageUI.PASWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.PASWORD_TEXTBOX, string);
	}
}
