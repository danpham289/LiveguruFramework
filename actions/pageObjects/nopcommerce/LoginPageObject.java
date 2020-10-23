package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.HomePageUI;
import pageUIs.nopcommerce.LoginPageUI;
import pageUIs.nopcommerce.RegisterPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;	
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void inputToEmailTextbox(String email) {
		waitElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);		
	}

	public void inputToPasswordTextbox(String password) {
		waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLogInButton() {
		waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	
}
