package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.CompareProductPageUI;

public class CompareProductPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public CompareProductPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public boolean isCompareProductHeadingDisplayed() {
		waitElementVisible(driver, CompareProductPageUI.COMPARE_HEADER);
		return isElementDisplayed(driver, CompareProductPageUI.COMPARE_HEADER);
	}

	public boolean isSelectedProductDisplayed(String product) {
		waitElementVisible(driver, CompareProductPageUI.DYNAMIC_PRODUCT_LINK,product);
		return isElementDisplayed(driver, CompareProductPageUI.DYNAMIC_PRODUCT_LINK,product);
	}

}
