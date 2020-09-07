package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.AddNewAddressPageUI;

public class AddNewAddressPageObject extends AbstractPage{
	
	WebDriver driver;
	
	public AddNewAddressPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void inputToTelephoneTextbox(String text) {
		waitElementVisible(driver, AddNewAddressPageUI.TELEPHONE_TEXTBOX);
		sendKeysToElement(driver, AddNewAddressPageUI.TELEPHONE_TEXTBOX, text);
		
	}

	public void inputToStreetAddressTextbox(String text) {
		waitElementVisible(driver, AddNewAddressPageUI.ADDRESS1_TEXTBOX);
		sendKeysToElement(driver, AddNewAddressPageUI.ADDRESS1_TEXTBOX, text);
		
	}

	public void inputToCityTextbox(String text) {
		waitElementVisible(driver, AddNewAddressPageUI.CITY_TEXTBOX);
		sendKeysToElement(driver, AddNewAddressPageUI.CITY_TEXTBOX, text);
		
	}

	public void inputToZipTextbox(String text) {
		waitElementVisible(driver, AddNewAddressPageUI.ZIP_TEXTBOX);
		sendKeysToElement(driver, AddNewAddressPageUI.ZIP_TEXTBOX, text);
		
	}

	public void selectCountryDropDown(String text) {
		waitElementVisible(driver, AddNewAddressPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, AddNewAddressPageUI.COUNTRY_DROPDOWN, text);
		
	}

	public void inputToStateTextbox(String text) {
		waitElementVisible(driver, AddNewAddressPageUI.ZIP_TEXTBOX);
		sendKeysToElement(driver, AddNewAddressPageUI.ZIP_TEXTBOX, text);
		
	}

	public MyAddressBookPageObject clickToSaveAddressButton() {
		waitElementClickable(driver, AddNewAddressPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, AddNewAddressPageUI.SAVE_ADDRESS_BUTTON);
		return PageGeneratorManager.getMyAddressBookPageObject(driver);
	}

}
