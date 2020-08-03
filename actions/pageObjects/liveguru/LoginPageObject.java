package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.LoginPageUI;

public class LoginPageObject extends AbstractPage{
	
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickCreateAccountButton() {
		waitElementClickable(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
		
	}

}
