package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopcommerce.HomePageUI;

public class CustomerInfoPageObject extends AbstractPage {
	WebDriver driver;	
	
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
		
	}


}
