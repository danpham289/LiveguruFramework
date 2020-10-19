package pageObjects.liveguru;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.OrdersPageUI;

public class OrdersPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public OrdersPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void selectItemInStatusDropdown(String itemValue) {
		waitElementVisible(driver, OrdersPageUI.STATUS_DROPDOWN);
		selectItemInDropdown(driver, OrdersPageUI.STATUS_DROPDOWN, itemValue);		
	}

	public void clickToSearchButton() {
		waitElementClickable(driver, OrdersPageUI.SEARCH_BUTTON);
		clickToElement(driver, OrdersPageUI.SEARCH_BUTTON);
		waitElementInvisible(driver, OrdersPageUI.LOADING_ICON);
	}

	public void selectItemInActionsDropdown(String itemValue) {
		waitElementVisible(driver, OrdersPageUI.ACTION_DROPDOWN);
		selectItemInDropdown(driver, OrdersPageUI.ACTION_DROPDOWN, itemValue);	
		
	}

	public void clickToSubmitButton() {
		waitElementClickable(driver, OrdersPageUI.SUBMIT_BUTTON);
		clickToElement(driver, OrdersPageUI.SUBMIT_BUTTON);

	}

	public boolean isNoPrintableDocumentsMessageDisplayed() {
		waitElementVisible(driver, OrdersPageUI.NO_PRINTABLE_DOCUMENTS_MESSAGE);
		return isElementDisplayed(driver, OrdersPageUI.NO_PRINTABLE_DOCUMENTS_MESSAGE);
	}

	public void clickToCheckboxByRowNumber(String rowNumber) {
		waitElementVisible(driver, OrdersPageUI.DYNAMIC_CHECKBOX_BY_ROWNUMBER,rowNumber);
		clickToElement(driver, OrdersPageUI.DYNAMIC_CHECKBOX_BY_ROWNUMBER,rowNumber);
	}

	public boolean isInvoiceFileDownloaded() {
		waitForFileToDownload("Invoice", 3);
		
		return isFileDownloaded("Invoice");
	}

}
