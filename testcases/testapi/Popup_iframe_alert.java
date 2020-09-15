package testapi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Popup_iframe_alert extends AbstractPage {
	WebDriver driver;
	String url;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}


	
	public void TC01_Fixed_Popup() throws InterruptedException {
		url = "https://www.zingpoll.com/";
		driver.get(url);
		
		Thread.sleep(2000);
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		//explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Loginform")));
		
		WebElement signInButton = driver.findElement(By.id("Loginform"));		
		signInButton.click();


		//jsExecutor = (JavascriptExecutor) driver;
		//jsExecutor.executeScript("arguments[0].click()", signInButton) ;
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-dialog modal_dialog_custom']//div[@class='modal-content']")));
		WebElement signInPopup = driver.findElement(By.xpath("//div[@class='modal-dialog modal_dialog_custom']//div[@class='modal-content']"));
		Assert.assertTrue(signInPopup.isDisplayed());
		
		if(signInPopup.isDisplayed()) {
			WebElement closeButton = driver.findElement(By.xpath("//div[@class='modal-dialog modal_dialog_custom']//span[contains(text(),'×')]"));
			closeButton.click();
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-dialog modal_dialog_custom']//div[@class='modal-content']")));
			
		}
		
		Assert.assertFalse(signInPopup.isDisplayed());
	}
	
	@Test
	public void TC03_Random_Popup() throws InterruptedException {
		url = "https://blog.testproject.io/";
		driver.get(url);
		Thread.sleep(10000);
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		WebElement adPopup = driver.findElement(By.xpath("//div[@class='mailch-wrap rocket-lazyload']"));
		
		if(isElementDisplayed("//div[@class='mailch-wrap rocket-lazyload']")) {
			driver.findElement(By.xpath("//div[@id='close-mailch']//*[local-name()='svg']")).click();
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='mailch-wrap rocket-lazyload']")));
		}
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='search-2']//input[@class='search-field']")));
		WebElement searchTextbox = driver.findElement(By.xpath("//section[@id='search-2']//input[@class='search-field']"));

		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', arguments[1])", searchTextbox,"selenium") ;
		Thread.sleep(5000);
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='search-2']//span[@class='glass']")));
		WebElement searchIcon =driver.findElement(By.xpath("//section[@id='search-2']//span[@class='glass']"));
		//jsExecutor.executeScript("arguments[0].click()", searchIcon) ;
		searchIcon.click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//span[@class='glass']")).click();
		
		List<WebElement> searchResulItems = driver.findElements(By.xpath("//h3[@class='post-title']/a"));
			for (WebElement item : searchResulItems) {
				Assert.assertTrue(item.getText().toLowerCase().contains("selenium"));
			}
		}
	
	public boolean isElementDisplayed(String locator) {
		try {
			return driver.findElement(By.xpath(locator)).isDisplayed();
		}catch (NoSuchElementException ex) {
			return false;
		}
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
