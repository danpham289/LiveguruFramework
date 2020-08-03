package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.HomePageUI;

public class HomePageObject extends AbstractPage {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;

	}

	public void clickToMyAccountLink() {
		waitElementClickable(driver,  HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);

	}

}
