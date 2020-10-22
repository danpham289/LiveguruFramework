package pageUIs.liveguru;

public class AbstractPageUI {
	public static final String ABOUT_US_LINK = "//div[@class='footer']//a[(text()='About Us')]";
	public static final String ADVANCED_SEARCH_LINK = "//div[@class='footer']//a[(text()='Advanced Search')]";
	public static final String SEARCH_TERM_LINK = "//div[@class='footer']//a[(text()='Search Terms')]";
	public static final String CUSTOMER_SERVICE_LINK = "//div[@class='footer']//a[(text()='Customer Service')]";
	public static final String DYNAMIC_FOOTER_PAGE_LINK = "//div[@class='footer']//a[(text()='%s')]";
	public static final String DYNAMIC_LEFT_MENU_LINK = "//div[@class='block-content']//a[text()='%s']";
	public static final String UPLOAD_FILE_TYPE = "//input[@type='file']";
	public static final String MOBILE_LINK = "//a[text()='Mobile']";
	public static final String TV_LINK = "//a[text()='TV']";
	
	public static final String DYNAMIC_LEVEL1_TOP_MENU_LINK = "//ul[@id='nav']//span[text()='%s']";
	public static final String DYNAMIC_LEVEL2_TOP_MENU_LINK = "//ul[@id='nav']//span[text()='%s']/parent::a/following-sibling::ul//span[text()='%s']";
	public static final String DYNAMIC_LEVEL3_TOP_MENU_LINK = "//ul[@id='nav']//span[text()='%s']/parent::a/following-sibling::ul//span[text()='%s']/parent::a/following-sibling::ul//span[text()='%s']";
	public static final String DYNAMIC_LEVEL4_TOP_MENU_LINK = "//ul[@id='nav']//span[text()='%s']/parent::a/following-sibling::ul//span[text()='%s']/parent::a/following-sibling::ul//span[text()='%s']/parent::a/following-sibling::ul//span[text()='%s']";
	public static final String LOADING_ICON = "//div[@id='loading-mask']";
	

}
