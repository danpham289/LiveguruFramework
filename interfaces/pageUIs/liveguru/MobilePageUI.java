package pageUIs.liveguru;

public class MobilePageUI {
	public static final String DYNAMIC_COST_BY_PRODUCT = "//a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']//span[@class='price']";
	public static final String DYNAMIC_PRODUCT_LINK = "//a[text()='%s']";
	public static final String DYNAMIC_ADD_TO_CART_BY_PRODUCT = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']";
	public static final String DYNAMIC_ADD_TO_COMPARE_BY_PRODUCT = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']";
	public static final String COMPARE_BUTTON = "//button[@class='button']//span[contains(text(),'Compare')]";
	
	public static final String DYNAMIC_PRODUCT_ADDED_TO_COMPARE_LIST_MSG = "//li[@class='success-msg']//ul//li/span[text()='The product %s has been added to comparison list.']";
}
