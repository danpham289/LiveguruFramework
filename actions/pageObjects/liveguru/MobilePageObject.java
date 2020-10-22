package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import io.qameta.allure.Step;
import pageUIs.liveguru.MobilePageUI;

public class MobilePageObject extends AbstractPage {
	
	WebDriver driver;
	
	public MobilePageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	@Step("get Cost Of Sony On List")
	public String getCostOfSonyOnList() {
		waitElementVisible(driver, MobilePageUI.DYNAMIC_COST_BY_PRODUCT, "Sony Xperia");
		return getElementText(driver, MobilePageUI.DYNAMIC_COST_BY_PRODUCT, "Sony Xperia");
	}
	@Step("click To Sony Detail Link")
	public ProductDetailPageObject clickToSonyDetailLink() {
		waitElementClickable(driver, MobilePageUI.DYNAMIC_PRODUCT_LINK, "Sony Xperia");
		clickToElement(driver, MobilePageUI.DYNAMIC_PRODUCT_LINK, "Sony Xperia");
		return PageGeneratorManager.getProductDetailPageObject(driver);
	}
	
	@Step("click To Iphone Add To Cart Button and navigate to Shopping Cart page")
	public ShoppingCartPageObject clickToIphoneAddToCartButton() {
		waitElementClickable(driver, MobilePageUI.DYNAMIC_ADD_TO_CART_BY_PRODUCT, "IPhone");
		clickToElement(driver, MobilePageUI.DYNAMIC_ADD_TO_CART_BY_PRODUCT, "IPhone");
		return PageGeneratorManager.getShoppingCartPageObject(driver);
	}

	public ShoppingCartPageObject clickToAddToCartButtonByProduct(String product) {
		waitElementClickable(driver, MobilePageUI.DYNAMIC_ADD_TO_CART_BY_PRODUCT, product);
		clickToElement(driver, MobilePageUI.DYNAMIC_ADD_TO_CART_BY_PRODUCT, product);
		return PageGeneratorManager.getShoppingCartPageObject(driver);
	}

	public void clickToAddToCompareByProduct(String product) {
		waitElementClickable(driver, MobilePageUI.DYNAMIC_ADD_TO_COMPARE_BY_PRODUCT, product);
		clickToElement(driver, MobilePageUI.DYNAMIC_ADD_TO_COMPARE_BY_PRODUCT, product);		
	}

	public CompareProductPageObject clickToCompareButton() {
		waitElementClickable(driver, MobilePageUI.COMPARE_BUTTON);
		clickToElement(driver, MobilePageUI.COMPARE_BUTTON);
		swicthToWindowByTitle(driver, "Products Comparison List - Magento Commerce");
		return PageGeneratorManager.getCompareProductPageObject(driver);
	}

	public boolean isProductAddedToComparisonListMsgDisplayed(String product) {
		waitElementVisible(driver, MobilePageUI.DYNAMIC_PRODUCT_ADDED_TO_COMPARE_LIST_MSG, product);
		return isElementDisplayed(driver, MobilePageUI.DYNAMIC_PRODUCT_ADDED_TO_COMPARE_LIST_MSG, product);
	}

	public ProductDetailPageObject clickToProductDetailLinkByProductName(String productName) {
		waitElementClickable(driver, MobilePageUI.DYNAMIC_PRODUCT_LINK, productName);
		clickToElement(driver, MobilePageUI.DYNAMIC_PRODUCT_LINK, productName);
		return PageGeneratorManager.getProductDetailPageObject(driver);
	}

}
