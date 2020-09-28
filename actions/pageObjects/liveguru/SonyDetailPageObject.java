package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.MobilePageUI;
import pageUIs.liveguru.SonyDetailPageUI;

public class SonyDetailPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public SonyDetailPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public String getCostOfSonyOnDetail() {
		waitElementVisible(driver, SonyDetailPageUI.SONY_COST_TEXT);
		return getElementText(driver, SonyDetailPageUI.SONY_COST_TEXT);
	}

}
