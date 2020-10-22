package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.ReviewDetailsPageUI;

public class ReviewDetailsPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public ReviewDetailsPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void selectItemInStatusDropdown(String itemValue) {
		waitElementVisible(driver, ReviewDetailsPageUI.STATUS_DROPDOWN);
		selectItemInDropdown(driver,  ReviewDetailsPageUI.STATUS_DROPDOWN, itemValue);
	}

	public PendingReviewsPageObject clickToSaveReviewbutton() {
		waitElementClickable(driver, ReviewDetailsPageUI.SAVE_REVIEW_BUTTON);
		clickToElement(driver, ReviewDetailsPageUI.SAVE_REVIEW_BUTTON);
		return PageGeneratorManager.getPendingReviewsPageObject(driver);
	}



}
