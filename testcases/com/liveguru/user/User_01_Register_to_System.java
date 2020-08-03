package com.liveguru.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class User_01_Register_to_System {
	WebDriver driver;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	}

	@Test
	public void Register_01_Empty_Data() {
		driver.findElement(By.xpath("//button[@title='Register']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-firstname']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-lastname']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email_address']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-password']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-confirmation']")).getText(), "This is a required field.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("dan@111.111");
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email_address']")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void Register_03_Password_Less_Than_6_Chars() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("111");
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-password']")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
		
	}

	@Test
	public void Register_04_Confirm_Password_Not_Matching_Password() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("111111");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-cpassword-confirmation']")).getText(), "Please make sure your passwords match.");
		
	}

	@Test
	public void Register_05_Valid_Data() {
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Dan");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Pham");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("dan"+randomNumber()+"@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "Thank you for registering with Main Website Store.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public int randomNumber() {
		Random num = new Random();
		return num.nextInt();
	}

}
