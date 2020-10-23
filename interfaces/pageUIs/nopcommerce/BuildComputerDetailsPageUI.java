package pageUIs.nopcommerce;

public class BuildComputerDetailsPageUI {
	public static final String PROCESSOR_DROPDOWN = "//select[@id='product_attribute_1']";
	public static final String RAM_DROPDOWN = "//select[@id='product_attribute_2']";
	public static final String DYNAMIC_HDD_RADIOBUTTON_BY_TEXT = "//label[contains(@for,'product_attribute_3') and text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_OS_RADIOBUTTON_BY_TEXT = "//label[contains(@for,'product_attribute_4') and text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_SOFTWARE_CHECKBOX_BY_TEXT = "//label[contains(@for,'product_attribute_5') and text()='%s']/preceding-sibling::input";
	public static final String ADD_TO_CART_BUTTON = "//input[@id='add-to-cart-button-1']";
	public static final String NOTIFICATION_SUCCESS_MESSAGE = "//div[@class='bar-notification success']/p";
	public static final String SHOPPING_CART_LINK = "//a[@class='ico-cart']";
	public static final String SHOPPING_CART_POPUP = "//div[@id='flyout-cart']/div[@class='mini-shopping-cart']";
	public static final String COUNT_ITEMS_MESSAGE_IN_SHOPPING_CART = "//div[@class='mini-shopping-cart']//div[@class='count']";
	public static final String PRODUCT_NAME_IN_SHOPPING_CART = "//div[@class='mini-shopping-cart']//div[@class='product']/div[@class='name']";
	public static final String PRODUCT_ATTRIBUTES_IN_SHOPPING_CART = "//div[@class='mini-shopping-cart']//div[@class='attributes']";
	public static final String PRODUCT_UNIT_PRICE_IN_SHOPPING_CART = "//div[@class='mini-shopping-cart']//div[@class='price']/span";
	public static final String PRODUCT_SUB_TOTAL_IN_SHOPPING_CART = "//div[@class='mini-shopping-cart']//div[@class='totals']/strong";

}
