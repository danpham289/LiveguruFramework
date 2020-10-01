package com.zingpoll.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driverFactory.DriverFactory;
import driverFactory.DriverManager;
import pageObjects.zingpoll.HomePageObject;
import pageObjects.zingpoll.PageGeneratorManager;

public class TS03_Create_Poll {
	private WebDriver driver;
	DriverManager driverManager;
	HomePageObject homePage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driverManager = DriverFactory.getManager(browser);
		driver = driverManager.getDriver();
		driver.get(url);
		homePage = PageGeneratorManager.getHomePageObject(driver); 
		
	}

	@Test
	public void TC01_Create_Poll_For_Anonymous_User() {
		//Input question content 
		
		//Input answer options
		
		//Input your email
		
		//Click Create Poll button
		
		//Verify the Poll is created successfully message
	}
	
	

	@AfterClass
	public void afterClass() {
	}

}
