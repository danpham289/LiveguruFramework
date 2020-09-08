package com.jquery.upload;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import driverFactory.DriverFactory;
import driverFactory.DriverManager;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadPageObject;


@Test
public class Upload_Multiple_Files extends AbstractTest {
	WebDriver driver;
	String imageFile1 = "image1.png";
	String imageFile2 = "image2.png";
	String imageFile3 = "image3.png";
	UploadPageObject uploadPage;
	DriverManager driverManager;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driverManager = DriverFactory.getManager(browserName);
		driver = driverManager.getDriver();
		driver.get(appURL);
		uploadPage = PageGeneratorManager.getUploadPageOject(driver);

	}

	@Test
	public void TC01_Upload_One_File() {
		uploadPage.uploadMultipleFiles(driver, imageFile1);
		uploadPage.sleepInSecond(3);
		uploadPage.uploadMultipleFiles(driver, imageFile2);
		uploadPage.sleepInSecond(3);
		uploadPage.uploadMultipleFiles(driver, imageFile3);
		uploadPage.sleepInSecond(3);

			
		
	}

	public void TC02_Upload_Multiple_Files() {
		uploadPage.uploadMultipleFiles(driver, imageFile1,imageFile2,imageFile3);
		uploadPage.sleepInSecond(3);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}



}
