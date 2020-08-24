package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class CustomerServicePageObject extends AbstractPage{
	
	WebDriver driver;
	
	public CustomerServicePageObject(WebDriver driver) {
		this.driver = driver;
		
	}

}
