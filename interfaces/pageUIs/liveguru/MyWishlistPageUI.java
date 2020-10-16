package pageUIs.liveguru;

public class MyWishlistPageUI {
	public static final String DYNAMIC_PRODUCT_ADDED_TO_WISHLIST_MESSAGE = "//span[contains(.,'%s has been added to your wishlist. Click here to continue shopping.')]";
	public static final String DYNAMIC_PRODUCT_NAME_BY_ROW_NUMBER = "//tbody/tr[%s]/td/h3[@class='product-name']/a";
	public static final String DYNAMIC_ADD_TO_CART_BUTTON_BY_PRODUCT = "//a[@title='%s']/parent::td/following-sibling::td[@class='wishlist-cell4 customer-wishlist-item-cart']//span[text()='Add to Cart']";
	public static final String YOUR_WISHLIST_SHARED_MESSAGE = "//span[text()='Your Wishlist has been shared.']";
	public static final String SHARE_WISHLIST_BUTTON = "//span[text()='Share Wishlist']";
	public static final String ITEM_ROWS_IN_WISHLIST = "//tbody/tr";
	
}
