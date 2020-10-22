package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import driverFactory.DriverFactory;
import driverFactory.DriverManager;

public class Register_01_Register_With_Valid_Data extends AbstractTest{
	WebDriver driver;
	DriverManager driverManager;
	
	@Parameters({"browser","userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driverManager = DriverFactory.getManager(browserName);
		driver = driverManager.getDriver();
		driver.get(appUrl);
	}
	
	@Test
	public void TC01_Register_With_Valid_Data() {
		
	}

	@AfterClass
	public void afterClass() {
	}

}
