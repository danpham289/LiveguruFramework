package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.AddNewAddressPageUI;
import pageUIs.liveguru.LoginUserPageUI;
import pageUIs.liveguru.ManageCustomersPageUI;
import testapi.InputDataIntoTextBoxInTable;

public class ManageCustomersPageObject extends AbstractPage {

	private WebDriver driver;

	public ManageCustomersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closeIncomingMessagePopUp() {
		waitElementClickable(driver, ManageCustomersPageUI.CLOSE_BUTTON_ON_INCOMING_MESSAGE);
		clickToElement(driver, ManageCustomersPageUI.CLOSE_BUTTON_ON_INCOMING_MESSAGE);

	}

	public void InputToSearchTextboxByColumnName(String columnName, String value) {
		waitElementVisible(driver, ManageCustomersPageUI.DYNAMIC_COLUMN_BY_COLUMN_NAME, columnName);
		String columnNumber = String.valueOf(
				countElementNumber(driver, ManageCustomersPageUI.DYNAMIC_COLUMN_BY_COLUMN_NAME, columnName) + 1);
		sendKeysToElement(driver, ManageCustomersPageUI.DYNAMIC_TEXTBOX_BY_COLUMN_NAME, value, columnNumber);

	}

	public void clickToSearchButton() {
		waitElementClickable(driver, ManageCustomersPageUI.SEARCH_BUTTON);
		clickToElement(driver, ManageCustomersPageUI.SEARCH_BUTTON);

	}

	public boolean isValueDisplayedAtColumnNameByRowNumber(String columnName, String rowNumber, String value) {
		waitElementVisible(driver, ManageCustomersPageUI.DYNAMIC_COLUMN_BY_COLUMN_NAME, columnName);
		String columnNumber = String.valueOf(
				countElementNumber(driver, ManageCustomersPageUI.DYNAMIC_COLUMN_BY_COLUMN_NAME, columnName) + 1);

		return isElementDisplayed(driver, ManageCustomersPageUI.DYNAMIC_RESULT_TEXT_BY_COLUMN_NAME_AT_ROW_NUMBER,
				rowNumber, columnNumber, value);

	}

	public boolean isNoRecordsTextDisplayed() {
		waitElementVisible(driver, ManageCustomersPageUI.NO_RECORDS_TEXT);
		return isElementDisplayed(driver,  ManageCustomersPageUI.NO_RECORDS_TEXT);
	}

	public CustomerInfomationPageObject clickToEditLinkByRowNumber(String rowNumber) {
		waitElementVisible(driver, ManageCustomersPageUI.DYNAMIC_EDIT_LINK_AT_ROW_NUMBER,rowNumber);
		clickToElement(driver, ManageCustomersPageUI.DYNAMIC_EDIT_LINK_AT_ROW_NUMBER,rowNumber);
		return PageGeneratorManager.getCustomerInfomationPageObject(driver);
	}

	public boolean isCustomerDeletedSuccessMessageDisplayed() {
		waitElementVisible(driver, ManageCustomersPageUI.CUSTOMER_DELETED_MESSAGE);
		return isElementDisplayed(driver, ManageCustomersPageUI.CUSTOMER_DELETED_MESSAGE);
	}

	public void hoverMouseToSalesItem() {
		// TODO Auto-generated method stub
		
	}

	public OrdersPageObject clickToOrdersItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
