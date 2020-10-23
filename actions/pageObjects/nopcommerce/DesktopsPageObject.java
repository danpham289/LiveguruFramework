package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.DesktopsPageUI;
import pageUIs.nopcommerce.HomePageUI;

public class DesktopsPageObject extends AbstractPage {
	WebDriver driver;	
	
	public DesktopsPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void clickToProductDetailsLinkByProductName(String productName) {
		waitElementVisible(driver, DesktopsPageUI.DYNAMIC_PRODUCT_LINK_BY_NAME,productName);
		clickToElement(driver, DesktopsPageUI.DYNAMIC_PRODUCT_LINK_BY_NAME,productName);
	}




}
