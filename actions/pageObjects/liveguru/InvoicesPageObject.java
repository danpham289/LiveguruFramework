package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.AbstractPageUI;
import pageUIs.liveguru.InvoicesPageUI;

public class InvoicesPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public InvoicesPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void clickToHeaderByName(String headerName) {
		waitElementClickable(driver, InvoicesPageUI.DYNAMIC_COLUMN_HEADER_BY_NAME, headerName);
		clickToElement(driver, InvoicesPageUI.DYNAMIC_COLUMN_HEADER_BY_NAME, headerName);
		waitElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}

	public boolean isInvoiveNumberSortedByAscending() {
		String columnNumber = String.valueOf(countElementNumber(driver, InvoicesPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME, "Invoice #")+1);
		return isNumberSortedByAscending(driver, getDynamicLocator(InvoicesPageUI.DYNAMIC_DATA_LIST_BY_COLUMN_NUMBER,columnNumber));
	}

	public boolean isInvoiveNumberSortedByDescending() {
		String columnNumber = String.valueOf(countElementNumber(driver, InvoicesPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME, "Invoice #")+1);
		return isNumberSortedByDescending(driver, getDynamicLocator(InvoicesPageUI.DYNAMIC_DATA_LIST_BY_COLUMN_NUMBER,columnNumber));
	}

	public boolean isInvoiveDateSortedByAscending() {
		String columnNumber = String.valueOf(countElementNumber(driver, InvoicesPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME, "Invoice Date")+1);
		return isDateSortedByAscending(driver, getDynamicLocator(InvoicesPageUI.DYNAMIC_DATA_LIST_BY_COLUMN_NUMBER,columnNumber));
	}

	public boolean isInvoiveDateSortedByDescending() {
		String columnNumber = String.valueOf(countElementNumber(driver, InvoicesPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME, "Invoice Date")+1);
		return isDateSortedByDescending(driver, getDynamicLocator(InvoicesPageUI.DYNAMIC_DATA_LIST_BY_COLUMN_NUMBER,columnNumber));
	}

	public boolean isOrderNumberSortedByAscending() {
		String columnNumber = String.valueOf(countElementNumber(driver, InvoicesPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME, "Order #")+1);
		return isTextSortedByAscending(driver, getDynamicLocator(InvoicesPageUI.DYNAMIC_DATA_LIST_BY_COLUMN_NUMBER,columnNumber));
	}

	public boolean isOrderNumberSortedByDescending() {
		String columnNumber = String.valueOf(countElementNumber(driver, InvoicesPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME, "Order #")+1);
		return isTextSortedByDescending(driver, getDynamicLocator(InvoicesPageUI.DYNAMIC_DATA_LIST_BY_COLUMN_NUMBER,columnNumber));
	}

	public boolean isOrderDateSortedByAscending() {
		String columnNumber = String.valueOf(countElementNumber(driver, InvoicesPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME, "Order Date")+1);
		return isDateSortedByAscending(driver, getDynamicLocator(InvoicesPageUI.DYNAMIC_DATA_LIST_BY_COLUMN_NUMBER,columnNumber));
	}

	public boolean isOrderDateSortedByDescending() {
		String columnNumber = String.valueOf(countElementNumber(driver, InvoicesPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME, "Order Date")+1);
		return isDateSortedByDescending(driver, getDynamicLocator(InvoicesPageUI.DYNAMIC_DATA_LIST_BY_COLUMN_NUMBER,columnNumber));
	}

	public boolean isBillToNameSortedByAscending() {
		String columnNumber = String.valueOf(countElementNumber(driver, InvoicesPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME, "Bill to Name")+1);
		return isTextSortedByAscending(driver, getDynamicLocator(InvoicesPageUI.DYNAMIC_DATA_LIST_BY_COLUMN_NUMBER,columnNumber));
	}

	public boolean isBillToNameSortedByDescending() {
		String columnNumber = String.valueOf(countElementNumber(driver, InvoicesPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME, "Bill to Name")+1);
		return isTextSortedByDescending(driver, getDynamicLocator(InvoicesPageUI.DYNAMIC_DATA_LIST_BY_COLUMN_NUMBER,columnNumber));
	}

	public boolean isAmountSortedByAscending() {
		String columnNumber = String.valueOf(countElementNumber(driver, InvoicesPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME, "Amount")+1);
		return isPriceSortedByAscending(driver, getDynamicLocator(InvoicesPageUI.DYNAMIC_DATA_LIST_BY_COLUMN_NUMBER,columnNumber));
	}

	public boolean isAmountSortedByDescending() {
		String columnNumber = String.valueOf(countElementNumber(driver, InvoicesPageUI.DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME, "Amount")+1);
		return isPriceSortedByDescending(driver, getDynamicLocator(InvoicesPageUI.DYNAMIC_DATA_LIST_BY_COLUMN_NUMBER,columnNumber));
	}

	
}
