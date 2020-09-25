package testapi;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascript_Executor extends AbstractPage {
	WebDriver driver;
	String url;
	JavascriptExecutor jsExecutor;
	WebDriverWait explicitWait;
	String uid = "mngr285247";
	String password = "atahehY";
	String name = "Dan";
	String firstname = "Dan";
	String lastname = "Pham";
	String dob = "09/28/1984";
	String address = "101 Hoang Van Thu";
	String city = "Da nang";
	String state = "Hai Chau";
	String pin = "123456";
	String mobileNumber = "0905123456";
	String email = "dan"+randomNumber()+"@gmail.com";
	String customerPassword = "111111";


	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	

	public void TC01() throws InterruptedException {
		url = "http://live.demoguru99.com/";
		driver.get(url);

		jsExecutor = (JavascriptExecutor) driver;
		String domainPage = (String) jsExecutor.executeScript("return document.domain") ;
		Assert.assertEquals(domainPage, "live.demoguru99.com");
		
		String urlPage = (String) jsExecutor.executeScript("return document.URL") ;
		Assert.assertEquals(urlPage, "http://live.demoguru99.com/");
		
		WebElement mobileTab = driver.findElement(By.xpath("//a[text()='Mobile']"));
		jsExecutor.executeScript("arguments[0].click()", mobileTab) ;
		
		WebElement samsungAddToCartButton = driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/following-sibling::div//button[@title='Add to Cart']"));
		jsExecutor.executeScript("arguments[0].click()", samsungAddToCartButton) ;
		//WebElement successMsgText = driver.findElement(By.xpath("//li[@class='success-msg']//span"));
		String innerTextOfPage = (String) jsExecutor.executeScript("return document.documentElement.innerText") ;
		Assert.assertTrue(innerTextOfPage.contains("Samsung Galaxy was added to your shopping cart."));
		
		WebElement customerServiceLink = driver.findElement(By.xpath("//a[(text()='Customer Service')]"));
		jsExecutor.executeScript("arguments[0].click()", customerServiceLink) ;
		
		String titlePage = (String) jsExecutor.executeScript("return document.title") ;
		Assert.assertEquals(titlePage, "Customer Service");
		
		WebElement newletterTextbox = driver.findElement(By.xpath("//input[@id='newsletter']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true)", newletterTextbox) ;
		
		innerTextOfPage = (String) jsExecutor.executeScript("return document.documentElement.innerText") ;
		Assert.assertTrue(innerTextOfPage.contains("Praesent ipsum libero, auctor ac, tempus nec, tempor nec, justo."));
	}
	
	public void TC02_Remove_Attribute() throws InterruptedException {
		url = "http://demo.guru99.com/v4/";
		driver.get(url);
		
		sendKeysToElement(driver, "//input[@name='uid']", uid);
		sendKeysToElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");
		clickToElement(driver, "//a[text()='New Customer']");
		
		sendKeysToElement(driver, "//input[@name='name']", name);
		
		WebElement dobTextbox = driver.findElement(By.xpath("//input[@id='dob']"));
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('type')",dobTextbox) ;

		sendKeysToElement(driver, "//input[@id='dob']", dob);
		sendKeysToElement(driver, "//textarea[@name='addr']", address);
		sendKeysToElement(driver, "//input[@name='city']", city);
		sendKeysToElement(driver, "//input[@name='state']", state);
		sendKeysToElement(driver, "//input[@name='pinno']", pin);
		sendKeysToElement(driver, "//input[@name='telephoneno']", mobileNumber);
		sendKeysToElement(driver, "//input[@name='emailid']", email);
		sendKeysToElement(driver, "//input[@name='password']", customerPassword);
		clickToElement(driver, "//input[@name='sub']");
		Thread.sleep(5000);
		
		Assert.assertTrue(isElementDisplayed("//p[text()='Customer Registered Successfully!!!']"));
		
	}

	@Test
	public void TC03_Create_An_Account() throws InterruptedException {

		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location='http://live.demoguru99.com/'") ;
		
		WebElement myAccountlink = driver.findElement(By.xpath("//div[@id='header-account']//a[contains(text(),'My Account')]"));
		jsExecutor.executeScript("arguments[0].click()", myAccountlink) ;
		WebElement createAccountButton = driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]"));
		jsExecutor.executeScript("arguments[0].click()", createAccountButton) ;
		WebElement firstNameTextbox = driver.findElement(By.xpath("//input[@id='firstname']"));
		jsExecutor.executeScript("arguments[0].setAttribute('value','"+firstname+"')", firstNameTextbox) ;
		WebElement lastNameTextbox = driver.findElement(By.xpath("//input[@id='lastname']"));
		jsExecutor.executeScript("arguments[0].setAttribute('value','"+lastname+"')", lastNameTextbox) ;
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='email_address']"));
		jsExecutor.executeScript("arguments[0].setAttribute('value','"+email+"')", emailTextbox) ;
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@id='password']"));
		jsExecutor.executeScript("arguments[0].setAttribute('value','"+password+"')", passwordTextbox) ;
		WebElement confirmPasswordTextbox = driver.findElement(By.xpath("//input[@id='confirmation']"));
		jsExecutor.executeScript("arguments[0].setAttribute('value','"+password+"')", confirmPasswordTextbox) ;
		WebElement registerButton = driver.findElement(By.xpath("//div[@id='header-account']//a[contains(text(),'My Account')]"));
		jsExecutor.executeScript("arguments[0].click()", registerButton) ;
		
		
		String innerText = (String) jsExecutor.executeScript("return document.documentElement.innerText") ;
		
		Assert.assertTrue(innerText.contains("Thank you for registering with Main Website Store."));
		Thread.sleep(5000);
	}

	public boolean isElementDisplayed(String locator) {
		try {
			return driver.findElement(By.xpath(locator)).isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
	
	public int randomNumber() {
		Random num = new Random();
		return num.nextInt();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
