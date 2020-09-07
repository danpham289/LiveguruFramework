package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.LoginUserPageUI;

public class LoginUserPageObject extends AbstractPage{
	
	private WebDriver driver;
	
	public LoginUserPageObject(WebDriver driver){
		this.driver = driver;
	}
	
	public RegisterPageObject clickCreateAccountButton() {
		waitElementClickable(driver, LoginUserPageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, LoginUserPageUI.CREATE_ACCOUNT_BUTTON);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public void inputToEmailTextbox(String email) {
		waitElementVisible(driver, LoginUserPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginUserPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitElementVisible(driver, LoginUserPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginUserPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public MyDashboardPageObject clickToLoginButton() {
		waitElementClickable(driver, LoginUserPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginUserPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashboardPageObject(driver);
	}
	



}
