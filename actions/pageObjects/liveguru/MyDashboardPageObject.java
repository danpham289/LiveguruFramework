package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.AbstractPageUI;
import pageUIs.liveguru.MyDashboardPageUI;


public class MyDashboardPageObject extends AbstractPage  {
	private WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver){
		this.driver = driver;
	}

	public HomePageObject clickToLogOutbutton() {
		waitElementClickable(driver, MyDashboardPageUI.ACCOUNT_ICON);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_ICON);
		waitElementClickable(driver, MyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePageObject(driver);
	}



	public String getRegisterSuccessMsg() {
		waitElementVisible(driver, MyDashboardPageUI.REGISTER_SUCCESS_MSG);
		return getElementText(driver, MyDashboardPageUI.REGISTER_SUCCESS_MSG);
	}

	public String getLoginSuccessMsg() {
		waitElementVisible(driver, MyDashboardPageUI.LOGIN_SUCCESS_MSG);
		return getElementText(driver, MyDashboardPageUI.LOGIN_SUCCESS_MSG);
	}

	public AddNewAddressPageObject clickToManageAddressesLink() {
		waitElementClickable(driver, MyDashboardPageUI.MANAGE_ADDRESSES_LINK);
		clickToElement(driver, MyDashboardPageUI.MANAGE_ADDRESSES_LINK);
		return PageGeneratorManager.getAddNewAddressPageObject(driver);
	}

	public boolean isAccountInfoSavedMessageDisplayed() {
		waitElementVisible(driver, MyDashboardPageUI.ACCOUNT_INFO_SAVED_MESSAGE);
		return isElementDisplayed(driver, MyDashboardPageUI.ACCOUNT_INFO_SAVED_MESSAGE);
	}

//	public void clickToMyAccountLink() {
//		waitElementClickable(driver, AbstractPageUI.DYNAMIC_FOOTER_PAGE_LINK, "My Account");
//		clickToElement(driver, AbstractPageUI.DYNAMIC_FOOTER_PAGE_LINK, "My Account");
//		
//	}
//
//	public AccountInformationPageObject clickToAccountInformationLink() {
//		// TODO Auto-generated method stub
//		return PageGeneratorManager.getAccountInformationPageObject(driver);
//	}

}
