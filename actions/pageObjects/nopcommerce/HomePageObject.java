package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.HomePageUI;

public class HomePageObject extends AbstractPage {
	WebDriver driver;	
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public RegisterPageObject clickToRegisterLink() {
		waitElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		waitForJStoLoad(driver);
		sleepInSecond(1);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public LoginPageObject clickToLogInLink() {
		waitElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		waitForJStoLoad(driver);
		sleepInSecond(1);
		return PageGeneratorManager.getLoginPageObject(driver);
	}

	public CustomerInfoPageObject clickToMyAccountLink() {
		waitElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		waitForJStoLoad(driver);
		sleepInSecond(1);
		return PageGeneratorManager.getCustomerInfoPageObject(driver);
	}
}
