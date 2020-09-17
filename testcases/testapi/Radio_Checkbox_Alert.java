package testapi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Radio_Checkbox_Alert extends AbstractPage {
	WebDriver driver;
	String url;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}


	public void TC01() throws InterruptedException {
		url = "https://material.angular.io/components/radio/examples";
		driver.get(url);
		jsExecutor = (JavascriptExecutor) driver;
		
		WebElement summerRadioButton = driver.findElement(By.xpath("//input[@value='Summer']//preceding-sibling::div[@class='mat-radio-outer-circle']"));
		WebElement checkedSummerRadioButton = driver.findElement(By.xpath("//input[@value='Summer']//ancestor::mat-radio-button"));
		jsExecutor.executeScript("arguments[0].click()", summerRadioButton) ;

		if(!checkedSummerRadioButton.getAttribute("class").contains("mat-radio-checked")) {
			jsExecutor.executeScript("arguments[0].click()", summerRadioButton) ;
		}
		Thread.sleep(5000);
		Assert.assertTrue(checkedSummerRadioButton.getAttribute("class").contains("mat-radio-checked"));

		

	}
	

	public void TC02() throws InterruptedException {
		url = "https://material.angular.io/components/checkbox/examples";
		driver.get(url);
		jsExecutor = (JavascriptExecutor) driver;
		WebElement checkedCheckBox = driver.findElement(By.xpath("//span[contains(text(),'Indeterminate')]"));
		WebElement selectedCheckedCheckBox = driver.findElement(By.xpath("//span[contains(text(),'Indeterminate')]//ancestor::mat-checkbox"));
		jsExecutor.executeScript("arguments[0].click()", checkedCheckBox) ;


		Thread.sleep(5000);
		Assert.assertTrue(selectedCheckedCheckBox.getAttribute("class").contains("mat-checkbox-checked"));
		
		if(selectedCheckedCheckBox.getAttribute("class").contains("mat-checkbox-checked")) {
			jsExecutor.executeScript("arguments[0].click()", checkedCheckBox) ;
		}
		Assert.assertFalse(selectedCheckedCheckBox.getAttribute("class").contains("mat-checkbox-checked"));
		Thread.sleep(5000);
	}
	

	public void TC03() throws InterruptedException {
		url = "http://admin:admin@the-internet.herokuapp.com/basic_auth";
		driver.get(url);
		WebElement msg = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials')]"));
		Assert.assertTrue(msg.isDisplayed());
		Thread.sleep(5000);
	}

	@Test
	public void TC04() throws InterruptedException {
		url = "https://zingpoll.com/";
		driver.get(url);
		
		WebElement signInButton = driver.findElement(By.xpath("//a[@id='Loginform']"));
		signInButton.click();
		//jsExecutor = (JavascriptExecutor) driver;
		//jsExecutor.executeScript("arguments[0].click()", signInButton) ;
		Thread.sleep(5000);
		WebElement signInPopup = driver.findElement(By.xpath("//div[@class='modal-dialog modal_dialog_custom']//div[@class='modal-content']"));
		
		Assert.assertTrue(signInPopup.isDisplayed());
		
		if(signInPopup.isDisplayed()) {
			WebElement closeButton = driver.findElement(By.xpath("//div[@class='modal-dialog modal_dialog_custom']//span[contains(text(),'×')]"));
			closeButton.click();
			
		}
		
		Assert.assertFalse(signInPopup.isDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
