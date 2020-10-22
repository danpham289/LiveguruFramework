package pageUIs.liveguru;

public class InvoicesPageUI {
	public static final String DYNAMIC_COLUMN_HEADER_BY_NAME = "//table[@id='sales_invoice_grid_table']//tr[@class='headings']//span[text()='%s']";
	public static final String DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME = "//table[@id='sales_invoice_grid_table']//tr[@class='headings']//span[text()='%s']//ancestor::th/preceding-sibling::th";
	public static final String DYNAMIC_DATA_LIST_BY_COLUMN_NUMBER = "//table[@id='sales_invoice_grid_table']/tbody//td[%s]";
	

}
