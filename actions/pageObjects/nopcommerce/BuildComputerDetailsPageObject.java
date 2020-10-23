package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.BuildComputerDetailsPageUI;
import pageUIs.nopcommerce.HomePageUI;

public class BuildComputerDetailsPageObject extends AbstractPage {
	WebDriver driver;	
	
	public BuildComputerDetailsPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void selectProcessorDropdown(String option) {
		waitElementVisible(driver, BuildComputerDetailsPageUI.PROCESSOR_DROPDOWN);
		selectItemInDropdown(driver, BuildComputerDetailsPageUI.PROCESSOR_DROPDOWN, option);
	}

	public void selectRAMDropdown(String option) {
		waitElementVisible(driver, BuildComputerDetailsPageUI.RAM_DROPDOWN);
		selectItemInDropdown(driver, BuildComputerDetailsPageUI.RAM_DROPDOWN, option);
	}

	public void clickToHDDRadiobutton(String option) {
		waitElementClickable(driver, BuildComputerDetailsPageUI.DYNAMIC_HDD_RADIOBUTTON_BY_TEXT,option);
		clickToElement(driver, BuildComputerDetailsPageUI.DYNAMIC_HDD_RADIOBUTTON_BY_TEXT,option);
	}

	public void clickToOSRadiobutton(String option) {
		waitElementClickable(driver, BuildComputerDetailsPageUI.DYNAMIC_OS_RADIOBUTTON_BY_TEXT,option);
		clickToElement(driver, BuildComputerDetailsPageUI.DYNAMIC_OS_RADIOBUTTON_BY_TEXT,option);
	}

	public void checkToSoftwareCheckbox(String option) {
		waitElementClickable(driver, BuildComputerDetailsPageUI.DYNAMIC_SOFTWARE_CHECKBOX_BY_TEXT,option);
		checkToCheckbox(driver, BuildComputerDetailsPageUI.DYNAMIC_SOFTWARE_CHECKBOX_BY_TEXT,option);
		
	}

	public void clickAddToCartButton() {
		waitElementClickable(driver, BuildComputerDetailsPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, BuildComputerDetailsPageUI.ADD_TO_CART_BUTTON);
	}

	public String getNotificationSuccessMessageText() {
		waitElementVisible(driver, BuildComputerDetailsPageUI.NOTIFICATION_SUCCESS_MESSAGE);
		return getElementText(driver, BuildComputerDetailsPageUI.NOTIFICATION_SUCCESS_MESSAGE);
	}

	public void hoverMouseToShoppingCartLink() {
		waitElementVisible(driver, BuildComputerDetailsPageUI.SHOPPING_CART_LINK);
		hoverMouseToElement(driver, BuildComputerDetailsPageUI.SHOPPING_CART_LINK);
	}

	public boolean isShoppingCartPopupDisplayed() {
		waitElementVisible(driver, BuildComputerDetailsPageUI.SHOPPING_CART_POPUP);
		return isElementDisplayed(driver, BuildComputerDetailsPageUI.SHOPPING_CART_POPUP);
	}

	public String getCountItemsInShoppingCartMessageText() {
		waitElementVisible(driver, BuildComputerDetailsPageUI.COUNT_ITEMS_MESSAGE_IN_SHOPPING_CART);
		return getElementText(driver, BuildComputerDetailsPageUI.COUNT_ITEMS_MESSAGE_IN_SHOPPING_CART).trim();
	}

	public Object getProductUnitPriceInShoppingCartMessageText() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getProductQuantityInShoppingCartMessageText() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getSubTotalInShoppingCartMessageText() {
		// TODO Auto-generated method stub
		return null;
	}


}
