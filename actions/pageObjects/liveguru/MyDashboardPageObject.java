package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
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
		return PageGeneratorManager.getHomePageOject(driver);
	}



	public String getRegisterSuccessMsg() {
		waitElementClickable(driver, MyDashboardPageUI.REGISTER_SUCCESS_MSG);
		return getElementText(driver, MyDashboardPageUI.REGISTER_SUCCESS_MSG);
	}

	public String getLoginSuccessMsg() {
		waitElementClickable(driver, MyDashboardPageUI.LOGIN_SUCCESS_MSG);
		return getElementText(driver, MyDashboardPageUI.LOGIN_SUCCESS_MSG);
	}

}
