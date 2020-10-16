package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.ProductReviewsPageUI;
import pageUIs.liveguru.TVPageUI;

public class ProductReviewsPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public ProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void clickToSubmitReviewButton() {
		waitElementClickable(driver, ProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
		
	}

	public boolean isRequiredValidateMessageOfThoughtTextareaDisplayed() {
		waitElementVisible(driver, ProductReviewsPageUI.REQUIRED_VALIDATE_MSG_OF_THOUGHT_TEXTAREA);
		return isElementDisplayed(driver, ProductReviewsPageUI.REQUIRED_VALIDATE_MSG_OF_THOUGHT_TEXTAREA);
	}

	public boolean isRequiredValidateMessageOfReviewTextboxDisplayed() {
		waitElementVisible(driver, ProductReviewsPageUI.REQUIRED_VALIDATE_MSG_OF_REVIEW_TEXTBOX);
		return isElementDisplayed(driver, ProductReviewsPageUI.REQUIRED_VALIDATE_MSG_OF_REVIEW_TEXTBOX);
	}

	public boolean isRequiredValidateMessageOfNickNameTextboxDisplayed() {
		waitElementVisible(driver, ProductReviewsPageUI.REQUIRED_VALIDATE_MSG_OF_NICKNAME_TEXTBOX);
		return isElementDisplayed(driver, ProductReviewsPageUI.REQUIRED_VALIDATE_MSG_OF_NICKNAME_TEXTBOX);
	}

	public void inputToThoughtTextarea(String thought) {
		waitElementVisible(driver, ProductReviewsPageUI.THOUGHT_TEXTAREA);
		sendKeysToElement(driver, ProductReviewsPageUI.THOUGHT_TEXTAREA, thought);
	}

	public void inputToReviewTextarea(String review) {
		waitElementVisible(driver, ProductReviewsPageUI.REVIEW_TEXTBOX);
		sendKeysToElement(driver, ProductReviewsPageUI.REVIEW_TEXTBOX, review);
	}

	public void inputToNicknameTextarea(String nickname) {
		waitElementVisible(driver, ProductReviewsPageUI.NICKNAME_TEXTBOX);
		sendKeysToElement(driver, ProductReviewsPageUI.NICKNAME_TEXTBOX, nickname);
	}

	public boolean isReviewAcceptedMessageDisplayed() {
		waitElementVisible(driver, ProductReviewsPageUI.REVIEW_ACCEPTED_MESSAGE);
		return isElementDisplayed(driver, ProductReviewsPageUI.REVIEW_ACCEPTED_MESSAGE);
	}

}
