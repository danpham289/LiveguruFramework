package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.AdvancedSearchPageUI;

public class AdvancedSearchPageObject extends AbstractPage{
	
	WebDriver driver;
	
	public AdvancedSearchPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void inputToPriceTextbox(String value) {
		waitElementVisible(driver, AdvancedSearchPageUI.PRICE_TEXTBOX);
		sendKeysToElement(driver, AdvancedSearchPageUI.PRICE_TEXTBOX, value);
		
	}

	public void inputToPriceToTextbox(String value) {
		waitElementVisible(driver, AdvancedSearchPageUI.PRICE_TO_TEXTBOX);
		sendKeysToElement(driver, AdvancedSearchPageUI.PRICE_TO_TEXTBOX, value);
	}

	public SearchResultPageObject clickToSearchButton() {
		waitElementClickable(driver, AdvancedSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdvancedSearchPageUI.SEARCH_BUTTON);
		waitForJStoLoad(driver);
		return PageGeneratorManager.getSearchResultPageObject(driver);
	}

}
