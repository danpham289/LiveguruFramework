package pageUIs.nopcommerce;

public class AbstractPageUI {
	public static final String DYNAMIC_LEVEL1_TOP_MENU_LINK = "//ul[@class='top-menu notmobile']/li/a[text()='%s ']";
	public static final String DYNAMIC_LEVEL2_TOP_MENU_LINK = "//ul[@class='top-menu notmobile']/li/a[text()='%s ']//following-sibling::ul/li/a[text()='%s ']";
	
	public static final String LOGIN_LINK = "//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
	
}
