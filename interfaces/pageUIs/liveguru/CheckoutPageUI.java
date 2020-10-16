package pageUIs.liveguru;

public class CheckoutPageUI {
	
	public static final String SHIPPING_CONTINUE_BUTTON = "//div[@id='shipping-method-buttons-container']//span[text()='Continue']";
	public static final String BILLING_CONTINUE_BUTTON = "//div[@id='billing-buttons-container']//span[text()='Continue']";
	public static final String PAYMENT_CONTINUE_BUTTON = "//div[@id='payment-buttons-container']//span[text()='Continue']";
	public static final String PLACE_ORDER_BUTTON = "//div[@id='review-buttons-container']//span[text()='Place Order']";
	public static final String CHECK_MONEY_ORDER_RADIOBUTTON = "//input[@id='p_method_checkmo']";
	public static final String YOUR_ORDER_TEXT = "//p[contains(.,'Your order # is: ')]";
	public static final String BILING_ADDRESS_TEXTBOX = "//input[@id='billing:street1']";
	public static final String BILING_CITY_TEXTBOX = "//input[@id='billing:city']";
	public static final String BILING_ZIP_TEXTBOX = "//input[@id='billing:postcode']";
	public static final String BILING_TELEPHONE_TEXTBOX = "//input[@id='billing:telephone']";
	public static final String YOUR_ORDER_NUMBER = "//p[contains(.,'Your order # is: ')]/a";
	public static final String BILLING_STATE_DROPDOWN = "//select[@id='billing:region_id']";
	public static final String SHIPPING_LOADING_ICON = "//span[@id='shipping-method-please-wait']";
	public static final String BILLING_LOADING_ICON = "//span[@id='billing-please-wait']";
	public static final String PAYMENT_LOADING_ICON = "//span[@id='payment-please-wait']";
	public static final String REVIEW_LOADING_ICON = "//span[@id='review-please-wait']";
	
}
