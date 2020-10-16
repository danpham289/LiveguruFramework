package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.ShareYourWishlistPageUI;

public class ShareYourWishlistPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public ShareYourWishlistPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void inputToEmailTextbox(String shareEmail) {
		waitElementVisible(driver, ShareYourWishlistPageUI.EMAIL_TEXTAREA);
		sendKeysToElement(driver, ShareYourWishlistPageUI.EMAIL_TEXTAREA, shareEmail);
		
	}

	public MyWishlistPageObject clickToShareWishlistButton() {
		waitElementClickable(driver, ShareYourWishlistPageUI.SHARE_WISHLIST_BUTTON);
		clickToElement(driver, ShareYourWishlistPageUI.SHARE_WISHLIST_BUTTON);
		return PageGeneratorManager.getMyWishlistPageObject(driver);
	}

}
