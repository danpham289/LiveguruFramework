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

public class WebDriver_Wait {
	WebDriver driver;
	String url;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	public void TC01_Implicit_Wait() {
		url = "http://the-internet.herokuapp.com/dynamic_loading/2";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(url);

		driver.findElement(By.xpath("//*[@id='start']/button")).click();

		String locator = "//div[@id='finish']/h4[text()='Hello World!']";
		Assert.assertTrue(driver.findElement(By.xpath(locator)).isDisplayed());
	}

	public void TC02_Explicit_Wait_Invisible() {
		url = "http://the-internet.herokuapp.com/dynamic_loading/2";
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

		driver.findElement(By.xpath("//*[@id='start']/button")).click();

		WebDriverWait explicitWait = new WebDriverWait(driver, 3);
		// WebElement loadLocator =
		// driver.findElement(By.xpath("//div[@id='loading']"));

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));

		String locator = "//div[@id='finish']/h4[text()='Hello World!']";
		Assert.assertTrue(driver.findElement(By.xpath(locator)).isDisplayed());

	}

	public void TC03_Explicit_Wait_Visible() {
		url = "http://the-internet.herokuapp.com/dynamic_loading/2";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(url);

		driver.findElement(By.xpath("//*[@id='start']/button")).click();

		WebDriverWait explicitWait = new WebDriverWait(driver, 5);
		// WebElement loadLocator =
		// driver.findElement(By.xpath("//div[@id='loading']"));

		explicitWait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")));

		String locator = "//div[@id='finish']/h4[text()='Hello World!']";
		WebElement textLocator = driver.findElement(By.xpath(locator));
		Assert.assertTrue(textLocator.isDisplayed());
	}

	@Test
	public void TC06_Explicit_Wait() throws InterruptedException {
		url = "https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx";
		driver.get(url);

		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
		explicitWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceholder1_RadCalendar1")));

		// String selectedDatelocator =
		// "//span[@id='ctl00_ContentPlaceholder1_Label1']";
		WebElement selectedDate = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']"));

		System.out.println("Date before click: " + selectedDate.getText());
		String date = "29";
		String datelocator = "//tbody/tr[@class='rcRow']/td/a[text()='"+date+"']";
		//datelocator = String.format(datelocator, date);

		driver.findElement(By.xpath(datelocator)).click();
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
				"//div[not (contains(@style,'display:none;'))]/div[@class='raDiv']")));
		
//		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//				"//a[text()='"+date+"']/parent::td[@class='rcSelected']")));
//		
		selectedDate = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']"));
		System.out.println("Date after click: " + selectedDate.getText());

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
