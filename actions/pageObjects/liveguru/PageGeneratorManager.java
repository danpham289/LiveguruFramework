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
	public static SonyDetailPageObject getSonyDetailPageObject(WebDriver driver) {
		return new SonyDetailPageObject(driver);
	}
	public static ShoppingCartPageObject getShoppingCartPageObject(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}
}
