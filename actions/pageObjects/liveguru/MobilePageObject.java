package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MobilePageObject extends AbstractPage {
	
	WebDriver driver;
	
	public MobilePageObject(WebDriver driver) {
		this.driver = driver;
		
	}

}
