package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.HomePageUI;

public class HomePageObject extends AbstractPage {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;

	}

	public LoginUserPageObject clickToMyAccountLink() {
		waitElementClickable(driver,  HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getLoginPageObject(driver);

	}

	public void clickToAccountMenu() {
		waitElementClickable(driver,  HomePageUI.ACCOUNT_MENU);
		clickToElement(driver, HomePageUI.ACCOUNT_MENU);
		
	}

	public RegisterPageObject clickToRegisterLink() {
		waitElementClickable(driver,  HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

}
