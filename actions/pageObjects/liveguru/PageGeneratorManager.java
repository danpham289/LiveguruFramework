package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomePageOject(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
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
	
}
