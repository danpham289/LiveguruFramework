package pageObjects.liveguru;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.SearchResultPageUI;


public class SearchResultPageObject extends AbstractPage {
	Log log;
	WebDriver driver;
	
	public SearchResultPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public void printProductNamesAndPrices() {
		sleepInSecond(5);
		waitElementVisible(driver, SearchResultPageUI.PRODUCTS_NAME_LIST);
//		int productsNumber = 0;
//		productsNumber = finds(driver, SearchResultPageUI.PRODUCTS_LIST).size();
//		log.info(productsNumber);
//		for (int i=0;i<productsNumber;i++) {
//			log.info("Product Name is "+finds(driver,SearchResultPageUI.PRODUCTS_NAME_LIST).get(i).getText()+" with price "+finds(driver,SearchResultPageUI.PRODUCTS_PRICE_LIST).get(i).getText()+"\n");
//		}
		
		log.info("Product Name is "+getElementText(driver, SearchResultPageUI.PRODUCTS_NAME_LIST)+" with price "+getElementText(driver, SearchResultPageUI.PRODUCTS_PRICE_LIST));
	}

	

}
