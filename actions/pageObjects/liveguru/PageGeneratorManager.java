package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomePageOject(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginUserPageObject getLoginPageObject(WebDriver driver) {
		return new LoginUserPageObject(driver);
	}
	
	public static MyAddressBookPageObject getMyAddressBookPageObject(WebDriver driver) {
		return new MyAddressBookPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static MyDashboardPageObject getMyDashboardPageObject(WebDriver driver) {
		return new MyDashboardPageObject(driver);
	}
	public static AboutUsPageObject getAboutUsPageObject(WebDriver driver) {
		return new AboutUsPageObject(driver);
	}
	public static AdvancedSearchPageObject getAdvancedSearchPageObject(WebDriver driver) {
		return new AdvancedSearchPageObject(driver);
	}
	public static SearchTermPageObject getSearchTermPageObject(WebDriver driver) {
		return new SearchTermPageObject(driver);
	}
	public static CustomerServicePageObject getCustomerServicePageObject(WebDriver driver) {
		return new CustomerServicePageObject(driver);
	}
	
	public static ManageCustomersPageObject getManageCustomersPageObject(WebDriver driver) {
		return new ManageCustomersPageObject(driver);
	}
	public static AddNewAddressPageObject getAddNewAddressPageObject(WebDriver driver) {
		return new AddNewAddressPageObject(driver);
	}
	public static LoginAdminPageObject getLoginAdminPageObject(WebDriver driver) {
		return new LoginAdminPageObject(driver);
	}
	public static AccountInformationPageObject getAccountInformationPageObject(WebDriver driver) {
		return new AccountInformationPageObject(driver);
	}
	public static MobilePageObject getMobilePageObject(WebDriver driver) {
		return new MobilePageObject(driver);
	}
	public static ProductDetailPageObject getProductDetailPageObject(WebDriver driver) {
		return new ProductDetailPageObject(driver);
	}
	public static ShoppingCartPageObject getShoppingCartPageObject(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}
	public static CompareProductPageObject getCompareProductPageObject(WebDriver driver) {
		return new CompareProductPageObject(driver);
	}
	public static TVPageObject getTVPageObject(WebDriver driver) {
		return new TVPageObject(driver);
	}
	public static MyWishlistPageObject getMyWishlistPageObject(WebDriver driver) {
		return new MyWishlistPageObject(driver);
	}
	public static ShareYourWishlistPageObject getShareYourWishlistPageObject(WebDriver driver) {
		return new ShareYourWishlistPageObject(driver);
	}
	public static ProductReviewsPageObject getProductReviewsPageObject(WebDriver driver) {
		return new ProductReviewsPageObject(driver);
	}
	public static CheckoutPageObject getCheckoutPageObject(WebDriver driver) {
		return new CheckoutPageObject(driver);
	}
	public static SearchResultPageObject getSearchResultPageObject(WebDriver driver) {
		return new SearchResultPageObject(driver);
	}
	public static CustomerInfomationPageObject getCustomerInfomationPageObject(WebDriver driver) {
		return new CustomerInfomationPageObject(driver);
	}
	public static OrdersPageObject getOrdersPageObject(WebDriver driver) {
		return new OrdersPageObject(driver);
	}
	public static PendingReviewsPageObject getPendingReviewsPageObject(WebDriver driver) {
		return new PendingReviewsPageObject(driver);
	}
	public static ReviewDetailsPageObject getReviewDetailsPageObject(WebDriver driver) {
		return new ReviewDetailsPageObject(driver);
	}
	public static InvoicesPageObject getInvoicesPageObject(WebDriver driver) {
		return new InvoicesPageObject(driver);
	}
}
