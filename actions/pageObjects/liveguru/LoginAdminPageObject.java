package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.LoginAdminPageUI;

public class LoginAdminPageObject extends AbstractPage{
	
	private WebDriver driver;
	
	public LoginAdminPageObject(WebDriver driver){
		this.driver = driver;
	}

	public void inputToUsernameTextbox(String adminUser) {
		waitElementVisible(driver, LoginAdminPageUI.USERNAME_TEXTBOX);
		sendKeysToElement(driver, LoginAdminPageUI.USERNAME_TEXTBOX, adminUser);
		
	}

	public void inputToPasswordTextbox(String adminPassword) {
		waitElementVisible(driver, LoginAdminPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginAdminPageUI.PASSWORD_TEXTBOX, adminPassword);
		
	}

	public ManageCustomersPageObject clickToLoginButton() {
		waitElementClickable(driver, LoginAdminPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginAdminPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getManageCustomersPageObject(driver);
	}
	
	
	



}
