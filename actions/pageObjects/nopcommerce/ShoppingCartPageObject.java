package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIs.nopcommerce.ShoppingCartPageUI;

public class ShoppingCartPageObject extends AbstractPage {
	WebDriver driver;	
	
	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
		
	}

	public boolean isProductNameContainedInList(String productName) {
		boolean flag = false;
		waitElementsVisible(driver, ShoppingCartPageUI.PRODUCT_NAME_LIST);
		for(WebElement element : finds(driver, ShoppingCartPageUI.PRODUCT_NAME_LIST)) {
			if (element.getText().equals(productName)) {
				flag = true;
				break;
			}
		}
		return flag;
	}


}
