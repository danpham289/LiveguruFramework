package pageUIs.liveguru;

public class PendingReviewsPageUI {
	public static final String DYNAMIC_SEARCH_TEXTBOX_BY_COLUMN_NUMBER="//table[@id='reviwGrid_table']//tr[@class='filter']/th[%s]//input";
	public static final String DYNAMIC_COLUMNS_BEFORE_COLUMN_NAME="//table[@id='reviwGrid_table']//tr[@class='headings']//span[text()='%s']//ancestor::th/preceding-sibling::th";
	public static final String SEARCH_BUTTON="//span[contains(text(),'Search')]";
	public static final String DYNAMIC_EDIT_LINK_BY_ROW_NUMBER="//table[@id='reviwGrid_table']/tbody/tr[%s]//a[text()='Edit']";
	public static final String REVIEW_SAVED_MESSAGE="//span[text()='The review has been saved.']";

}
