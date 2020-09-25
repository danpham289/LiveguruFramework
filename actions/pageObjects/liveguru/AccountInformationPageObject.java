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

}
