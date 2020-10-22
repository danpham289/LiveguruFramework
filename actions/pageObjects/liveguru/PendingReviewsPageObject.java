package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.PendingReviewsPageUI;

public class PendingReviewsPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public PendingReviewsPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void inputToSearchTextboxByColumnName(String columnName, String value) {
		waitElementsVisible(driver, PendingReviewsPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME,columnName);
		String columnNumber = String.valueOf(countElementNumber(driver, PendingReviewsPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME,columnName)+1);
		sendKeysToElement(driver, PendingReviewsPageUI.DYNAMIC_SEARCH_TEXTBOX_BY_COLUMN_NUMBER, value, columnNumber);
		
	}

	public void clickToSearchButton() {
		waitElementClickable(driver, PendingReviewsPageUI.SEARCH_BUTTON);
		clickToElement(driver, PendingReviewsPageUI.SEARCH_BUTTON);
	}

	public ReviewDetailsPageObject clickToEditLinkByRowNumber(String rowNumber) {
		waitElementClickable(driver, PendingReviewsPageUI.DYNAMIC_EDIT_LINK_BY_ROW_NUMBER,rowNumber);
		clickToElement(driver, PendingReviewsPageUI.DYNAMIC_EDIT_LINK_BY_ROW_NUMBER,rowNumber);
		return PageGeneratorManager.getReviewDetailsPageObject(driver);
	}

	public boolean isReviewSavedMessageDisplayed() {
		waitElementVisible(driver, PendingReviewsPageUI.REVIEW_SAVED_MESSAGE);
		return isElementDisplayed(driver, PendingReviewsPageUI.REVIEW_SAVED_MESSAGE);
	}

}
