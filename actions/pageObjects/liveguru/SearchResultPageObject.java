package pageObjects.liveguru;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.SearchResultPageUI;


public class SearchResultPageObject extends AbstractPage {
//	Log log;
	WebDriver driver;
	
	public SearchResultPageObject(WebDriver driver) {
		this.driver = driver;		
//		log = LogFactory.getLog(getClass());
	}
	

	public void printProductNamesAndPrices() {
		sleepInSecond(5);
		waitElementsVisible(driver, SearchResultPageUI.PRODUCTS_NAME_LIST);
		int productsNumber = countElementNumber(driver, SearchResultPageUI.PRODUCTS_NAME_LIST);		
		for (int i=0;i<productsNumber;i++) {
//			System.out.println("Product Name is "+finds(driver,SearchResultPageUI.PRODUCTS_NAME_LIST).get(i).getText()+" with price "+finds(driver,SearchResultPageUI.PRODUCTS_PRICE_LIST).get(i).getText());
			log.info("Product Name is "+finds(driver,SearchResultPageUI.PRODUCTS_NAME_LIST).get(i).getText()+" with price "+finds(driver,SearchResultPageUI.PRODUCTS_PRICE_LIST).get(i).getText());
		}		
	}
}
