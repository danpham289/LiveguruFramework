package com.liveguru.user;

import commons.AbstractTest;

public class User_01_Rest_Parameters extends AbstractTest {
	
	
	public static final String DYNAMIC_FOOTER_LINK = "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_LINK = "//div[@class='%s']//a[text()='%s']";

	
	public static void clickToElement(String locator, String... values){
		String xpathLink = String.format(locator,(Object[]) values);
		System.out.println(xpathLink);
	}
	
	public static void main(String[] args)  {
		clickToElement(DYNAMIC_FOOTER_LINK,"Search Terms");
		clickToElement(DYNAMIC_LINK,"footer","Search Terms");
		
	
		
	
		
		
	}
	
	
}
