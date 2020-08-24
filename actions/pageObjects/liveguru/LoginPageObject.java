package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.LoginPageUI;

public class LoginPageObject extends AbstractPage{
	
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver){
		this.driver = driver;
	}
	
	public RegisterPageObject clickCreateAccountButton() {
		waitElementClickable(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public void inputToEmailTextbox(String email) {
		waitElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public MyDashboardPageObject clickToLoginButton() {
		waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashboardPageObject(driver);
	}
	



}
