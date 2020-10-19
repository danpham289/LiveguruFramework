package pageUIs.liveguru;

public class ManageCustomersPageUI {

	public static final String CLOSE_BUTTON_ON_INCOMING_MESSAGE = "//span[contains(text(),'close')]";
	public static final String DYNAMIC_COLUMN_BY_COLUMN_NAME = "//span[contains(text(),'%s')]//ancestor::th/preceding-sibling::th";
	public static final String DYNAMIC_TEXTBOX_BY_COLUMN_NAME = "//tr[@class='filter']/th[%s]//input";
	public static final String DYNAMIC_RESULT_TEXT_BY_COLUMN_NAME_AT_ROW_NUMBER = "//table[@id='customerGrid_table']//tbody/tr[%s]/td[%s and contains(text(),'%s')]";
	public static final String DYNAMIC_EDIT_LINK_AT_ROW_NUMBER = "//table[@id='customerGrid_table']//tbody/tr[%s]/td/a[text()='Edit']";
	public static final String SEARCH_BUTTON = "//span[contains(text(),'Search')]";
	public static final String NO_RECORDS_TEXT = "//table[@id='customerGrid_table']//tbody//td[contains(text(),'No records found.')]";
	public static final String CUSTOMER_DELETED_MESSAGE = "//span[contains(text(),'The customer has been deleted.')]";

}
