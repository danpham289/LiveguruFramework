package pageObjects.liveguru;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.AbstractPageUI;
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
		waitElementInvisible(driver, AbstractPageUI.LOADING_ICON);
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
		waitForDownloadFileContainsNameCompleted(downloadedInvoiceFileName);
		return (countFilesInDirectory() == 1)&&(isFileContain(downloadedInvoiceFileName));
	}

	public void selectItemInViewPerPageDropdown(String itemValue) {
		waitElementVisible(driver, OrdersPageUI.VIEW_PER_PAGE_DROPDOWN);
		selectItemInDropdown(driver, OrdersPageUI.VIEW_PER_PAGE_DROPDOWN, itemValue);
		waitElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}

	public int countItemsInView() {
		waitElementVisible(driver, OrdersPageUI.ROWS_IN_TABLE);
		return countElementNumber(driver, OrdersPageUI.ROWS_IN_TABLE);
	}

	public void clickToSelectVisibleLink() {
		waitElementVisible(driver, OrdersPageUI.SELECT_VISIBLE_LINK);
		clickToElement(driver, OrdersPageUI.SELECT_VISIBLE_LINK);
	}

	public boolean isCheckboxesInTableSelected(int checkboxesNumber) {
		boolean flag = false;
		for(int i = 1;i<=checkboxesNumber;i++) {
			flag = isElementSelected(driver, OrdersPageUI.DYNAMIC_CHECKBOX_BY_ROWNUMBER,String.valueOf(i));
			if(flag==false) {
				break;
			}
		}
		return flag;
	}

	public void clickToUnselectVisibleLink() {
		waitElementVisible(driver, OrdersPageUI.UNSELECT_VISIBLE_LINK);
		clickToElement(driver, OrdersPageUI.UNSELECT_VISIBLE_LINK);		
	}

	public boolean isItemsSelectedMessageByNumberDisplayed(String number) {
		waitElementVisible(driver, OrdersPageUI.DYNAMIC_SELECTED_ITEMS_MESSAGE,number);
		return isElementDisplayed(driver, OrdersPageUI.DYNAMIC_SELECTED_ITEMS_MESSAGE,number);
	}

	private String downloadedInvoiceFileName = "invoice";
	int longTimeOut = 5;
}
