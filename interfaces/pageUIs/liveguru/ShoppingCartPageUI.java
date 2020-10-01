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

}
