package pageUIs.liveguru;

public class ShoppingCartPageUI {
	public static final String IPHONE_ADDED_TO_CART_SUCCESS_MSG = "//span[text()='IPhone was added to your shopping cart.']";
	public static final String COUPON_CODE_TEXTBOX = "//input[@id='coupon_code']";
	public static final String APLLY_BUTTON = "//span[contains(text(),'Apply')]";
	public static final String DISCOUNT_TEXT = "//td[contains(text(),'Discount (GURU50)')]/following-sibling::td/span[@class='price']";
	public static final String DYNAMIC_QTY_TEXTBOX_BY_PRODUCT = "//a[@title='%s']/parent::td/following-sibling::td[@class='product-cart-actions']/input[@title='Qty']";
	public static final String DYNAMIC_UPDATE_BUTTON_BY_PRODUCT = "//a[@title='%s']/parent::td/following-sibling::td[@class='product-cart-actions']/button[@title='Update']";
	public static final String EMPTY_CART_LINK = "//span[contains(text(),'Empty Cart')]";
	public static final String MAXIMUM_QUANTITY_ERROR_MESSAGE = "//p[@class='item-msg error' and contains(text(),'The maximum quantity allowed for purchase is 500.')]";
	public static final String EMPTY_CART_MESSAGE = "//h1[contains(text(),'Shopping Cart is Empty')]";
	public static final String NO_ITEMS_MESSAGE = "//div[@class='cart-empty']//p[contains(text(),'You have no items in your shopping cart.')]";
	public static final String COUNTRY_DROPDOWN = "//select[@id='country']";
	public static final String STATE_DROPDOWN = "//select[@id='region_id']";
	public static final String ZIP_TEXTBOX = "//input[@id='postcode']";
	public static final String ESTIMATE_BUTTON = "//span[text()='Estimate']";
	public static final String FLAT_RATE_SHIPPING_TEXT = "//label[@for='s_method_flatrate_flatrate']/span[@class='price']";
	public static final String FLAT_RATE_SHIPPING_RADIOBUTTON = "//input[@id='s_method_flatrate_flatrate']";
	public static final String UPDATE_TOTAL_BUTTON = "//span[text()='Update Total']";
	public static final String SUBTOTAL_PRICE_TEXT = "//td[contains(text(),'Subtotal')]/following-sibling::td//span[@class='price']";
	public static final String GRANDTOTAL_PRICE_TEXT = "//strong[contains(text(),'Grand Total')]/parent::td/following-sibling::td//span[@class='price']";
	public static final String PROCEED_TO_CHECKOUT_BUTTON = "//button[@title='Proceed to Checkout']";

}
