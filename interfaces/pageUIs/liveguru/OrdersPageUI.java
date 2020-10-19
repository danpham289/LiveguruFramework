package pageUIs.liveguru;

public class OrdersPageUI {
	public static final String STATUS_DROPDOWN = "//select[@id='sales_order_grid_filter_status']";
	public static final String SEARCH_BUTTON = "//span[contains(text(),'Search')]";
	public static final String ACTION_DROPDOWN = "//select[@id='sales_order_grid_massaction-select']";
	public static final String SUBMIT_BUTTON = "//span[contains(text(),'Submit')]";
	public static final String DYNAMIC_CHECKBOX_BY_ROWNUMBER = "//table[@id='sales_order_grid_table']/tbody/tr[%s]//input[@class='massaction-checkbox']";
	public static final String NO_PRINTABLE_DOCUMENTS_MESSAGE = "//span[text()='There are no printable documents related to selected orders.']";
	public static final String LOADING_ICON = "//div[@id='loading-mask']";
	
}
