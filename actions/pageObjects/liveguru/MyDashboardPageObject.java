package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.MyDashboardPageUI;


public class MyDashboardPageObject extends AbstractPage  {
	private WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver){
		this.driver = driver;
	}

	public String getSuccessMsg() {
		waitElementVisible(driver, MyDashboardPageUI.SUCCESS_MSG);
		return getElementText(driver, MyDashboardPageUI.SUCCESS_MSG);
	}

}
