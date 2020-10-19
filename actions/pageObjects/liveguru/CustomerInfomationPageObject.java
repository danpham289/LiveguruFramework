package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.CustomerInformationPageUI;

public class CustomerInfomationPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public CustomerInfomationPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void clickToDeleteCustomerButton() {
		waitElementVisible(driver, CustomerInformationPageUI.DELETE_CUSTOMER_BUTTON);
		clickToElement(driver, CustomerInformationPageUI.DELETE_CUSTOMER_BUTTON);
	}

	public ManageCustomersPageObject acceptDeleteCustomerConfirmAlert() {
		acceptAlert(driver);
		return PageGeneratorManager.getManageCustomersPageObject(driver);
	}

}
