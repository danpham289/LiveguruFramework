package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.SearchResultPageUI;


public class SearchResultPageObject extends AbstractPage {
	WebDriver driver;
	
	public SearchResultPageObject(WebDriver driver) {
		this.driver = driver;		
	}
	
	public void printProductNamesAndPrices() {
		waitElementsVisible(driver, SearchResultPageUI.PRODUCTS_NAME_LIST);
		int productsNumber = countElementNumber(driver, SearchResultPageUI.PRODUCTS_NAME_LIST);		
		for (int i=0;i<productsNumber;i++) {
			log.info("Product Name is "+finds(driver,SearchResultPageUI.PRODUCTS_NAME_LIST).get(i).getText()+" with price "+finds(driver,SearchResultPageUI.PRODUCTS_PRICE_LIST).get(i).getText());
		}		
	}
}
