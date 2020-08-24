package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class SearchTermPageObject extends AbstractPage{
	
	WebDriver driver;
	
	public SearchTermPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

}
