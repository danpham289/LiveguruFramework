package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.MobilePageUI;

public class MobilePageObject extends AbstractPage {
	
	WebDriver driver;
	
	public MobilePageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public String getCostOfSonyOnList() {
		waitElementVisible(driver, MobilePageUI.DYNAMIC_COST_BY_PRODUCT, "Sony Xperia");
		return getElementText(driver, MobilePageUI.DYNAMIC_COST_BY_PRODUCT, "Sony Xperia");
	}

	public SonyDetailPageObject clickToSonyDetailLink() {
		waitElementClickable(driver, MobilePageUI.DYNAMIC_PRODUCT_LINK, "Sony Xperia");
		clickToElement(driver, MobilePageUI.DYNAMIC_PRODUCT_LINK, "Sony Xperia");
		return PageGeneratorManager.getSonyDetailPageObject(driver);
	}

	public ShoppingCartPageObject clickToIphoneAddToCartButton() {
		waitElementClickable(driver, MobilePageUI.DYNAMIC_ADD_TO_CART_BY_PRODUCT, "IPhone");
		clickToElement(driver, MobilePageUI.DYNAMIC_ADD_TO_CART_BY_PRODUCT, "IPhone");
		return PageGeneratorManager.getShoppingCartPageObject(driver);
	}

}
