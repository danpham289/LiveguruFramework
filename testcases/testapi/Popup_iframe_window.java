package testapi;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Popup_iframe_window extends AbstractPage {
	WebDriver driver;
	String url;
	JavascriptExecutor jsExecutor;
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		explicitWait = new WebDriverWait(driver, 20);

	}

	public void TC01_Fixed_Popup() throws InterruptedException {
		url = "https://www.zingpoll.com/";
		driver.get(url);

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Loginform")));

		WebElement signInButton = driver.findElement(By.id("Loginform"));
		signInButton.click();

		// jsExecutor = (JavascriptExecutor) driver;
		// jsExecutor.executeScript("arguments[0].click()", signInButton) ;
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-dialog modal_dialog_custom']//div[@class='modal-content']")));
		WebElement signInPopup = driver.findElement(By.xpath("//div[@class='modal-dialog modal_dialog_custom']//div[@class='modal-content']"));
		Assert.assertTrue(signInPopup.isDisplayed());

		if (signInPopup.isDisplayed()) {
			WebElement closeButton = driver.findElement(By.xpath("//div[@class='modal-dialog modal_dialog_custom']//span[contains(text(),'×')]"));
			closeButton.click();
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-dialog modal_dialog_custom']//div[@class='modal-content']")));

		}

		Assert.assertFalse(signInPopup.isDisplayed());
	}

	public void TC02_Fixed_Popup() throws InterruptedException {
		url = "https://bni.vn/";
		driver.get(url);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")));

		WebElement welcomePopup = driver.findElement(By.xpath("//div[@id='sgpb-popup-dialog-main-div']"));
		Assert.assertTrue(welcomePopup.isDisplayed());
		if (welcomePopup.isDisplayed()) {
			driver.findElement(By.xpath("//img[@class='sgpb-popup-close-button-1']")).click();
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='sgpb-popup-dialog-main-div']")));
		}
		Assert.assertFalse(welcomePopup.isDisplayed());
	}

	public void TC03_Random_Popup() throws InterruptedException {
		url = "https://blog.testproject.io/";
		driver.get(url);
		WebElement adPopup = driver.findElement(By.xpath("//div[@class='mailch-wrap rocket-lazyload']"));

		if (isElementDisplayed("//div[@class='mailch-wrap rocket-lazyload']")) {
			driver.findElement(By.xpath("//div[@id='close-mailch']//*[local-name()='svg']")).click();
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='mailch-wrap rocket-lazyload']")));
			System.out.println("popup displays");
		} else {
			System.out.println("popup does not display");
		}

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='search-2']//input[@class='search-field']")));
		WebElement searchTextbox = driver.findElement(By.xpath("//section[@id='search-2']//input[@class='search-field']"));

		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', arguments[1])", searchTextbox, "selenium");

		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='search-2']//span[@class='glass']")));
		WebElement searchIcon = driver.findElement(By.xpath("//section[@id='search-2']//span[@class='glass']"));
		jsExecutor.executeScript("arguments[0].click()", searchIcon);
		// searchIcon.click();

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Search Results for:')]")));

		List<WebElement> searchResulItems = driver.findElements(By.xpath("//h3[@class='post-title']/a"));
		for (WebElement item : searchResulItems) {
			Assert.assertTrue(item.getText().toLowerCase().contains("selenium"));
		}
	}

	public void TC04_iframe() throws InterruptedException {
		url = "https://kyna.vn/";
		driver.get(url);

		if (isElementDisplayed("//div[@class='fancybox-skin']")) {
			System.out.println("popup displays");
			driver.findElement(By.xpath("//div[@class='fancybox-skin']//a[@title='Close']")).click();
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='fancybox-skin']")));

		} else {
			System.out.println("popup does not display");
		}

		WebElement facebookIframe = driver.findElement(By.xpath("//iframe[contains(@src,'facebook')]"));
		Assert.assertTrue(isElementDisplayed("//iframe[contains(@src,'facebook')]"));
		driver.switchTo().frame(facebookIframe);
		Assert.assertTrue(isElementDisplayed("//div[contains(text(),'169K likes')]"));
		driver.switchTo().defaultContent();

		Assert.assertTrue(isElementDisplayed("//iframe[@id='cs_chat_iframe']"));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='cs_chat_iframe']")));
		WebElement webChatTextbox = driver.findElement(By.xpath("//textarea[contains(@class,'textarea')]"));
		webChatTextbox.sendKeys("hello");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Assert.assertTrue(isElementDisplayed("//form[@ng-submit='editUserInfo()']"));
		driver.switchTo().defaultContent();

		driver.findElement(By.id("live-search-bar")).sendKeys("Java");
		driver.findElement(By.cssSelector(".search-button")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='menu-heading']")).getText().contains("Kết quả tìm kiếm từ khóa"));

	}


	public void TC05_window_tab() throws InterruptedException {
		url = "https://automationfc.github.io/basic-form/index.html";
		driver.get(url);
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();

		String parentWindow = driver.getWindowHandle();
		switchToChildWindowByTitle("Google");
		Assert.assertEquals(driver.getTitle(), "Google");
		driver.switchTo().window(parentWindow);

		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
		switchToChildWindowByTitle("Facebook");
		Assert.assertEquals(driver.getTitle(), "facebook.com");
		driver.switchTo().window(parentWindow);

		driver.findElement(By.xpath("//a[text()='TIKI']")).click();
		switchToChildWindowByTitle("Tiki");
		Assert.assertEquals(driver.getTitle(), "tiki.vn");
		// driver.switchTo().window(parentWindow);

		closeAllChildWindows(parentWindow);
		Assert.assertEquals(driver.getTitle(), "SELENIUM WEBDRIVER FORM DEMO");
	}
	
	public void TC06_window_tab() throws InterruptedException {
		url = "https://kyna.vn/";
		driver.get(url);
		String parentWindow = driver.getWindowHandle();
		
		if (isElementDisplayed("//div[@class='fancybox-skin']")) {
			System.out.println("popup displays");
			driver.findElement(By.xpath("//div[@class='fancybox-skin']//a[@title='Close']")).click();
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='fancybox-skin']")));

		} else {
			System.out.println("popup does not display");
		}
		
		WebElement facebookIcon = driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt='facebook']"));
		facebookIcon.click();
		WebElement youtubeIcon = driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt='youtube']"));
		youtubeIcon.click();
		WebElement zaloIcon = driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt='zalo']"));
		zaloIcon.click();
		WebElement androidIcon = driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt='android-app-icon']"));
		androidIcon.click();
		
		WebElement facebookIframe = driver.findElement(By.xpath("//iframe[contains(@src,'facebook')]"));
		driver.switchTo().frame(facebookIframe);
		WebElement facebookKynaLink = driver.findElement(By.xpath("//a[@title='Kyna.vn']"));
		//facebookKynaLink.click();
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click()", facebookKynaLink) ;
		
		switchToChildWindowByURL("facebook.com");
		Assert.assertTrue(driver.getCurrentUrl().contains("facebook.com"));
		switchToChildWindowByURL("youtube.com");
		Assert.assertTrue(driver.getCurrentUrl().contains("youtube.com"));
		switchToChildWindowByURL("zalo.me");
		Assert.assertTrue(driver.getCurrentUrl().contains("zalo.me"));
		switchToChildWindowByURL("play.google.com");
		Assert.assertTrue(driver.getCurrentUrl().contains("play.google.com"));
		
		closeAllChildWindows(parentWindow);
		Assert.assertEquals(driver.getTitle(), "Kyna.vn - Học online cùng chuyên gia");
		
		
		
	}
	
	@Test
	public void TC07_window_tab() throws InterruptedException {
		url = "http://live.demoguru99.com/index.php/";
		driver.get(url);
		String parentWindow = driver.getWindowHandle();
		
		WebElement mobileTab = driver.findElement(By.xpath("//a[text()='Mobile']"));
		mobileTab.click();
		
		driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']")).click();
		driver.findElement(By.xpath("//span[text()='Compare']")).click();
		
		switchToChildWindowByTitle("Products Comparison List - Magento Commerce");
		Assert.assertEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");
		driver.close();
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.xpath("//a[text()='Clear All']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Assert.assertTrue(isElementDisplayed("//span[text()='The comparison list was cleared.']"));
		
	}

	public void switchToChildWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindow : allWindows) {

			driver.switchTo().window(childWindow);
			if (driver.getTitle().contains(url)) {
				break;
			}
		}
	}
	public void switchToChildWindowByURL(String url) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindow : allWindows) {

			driver.switchTo().window(childWindow);
			if (driver.getCurrentUrl().contains(url)) {
				break;
			}
		}
	}
	public void closeAllChildWindows(String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindow : allWindows) {
			if (!childWindow.equals(parentWindow)) {
				driver.switchTo().window(childWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}

	public boolean isElementDisplayed(String locator) {
		try {
			return driver.findElement(By.xpath(locator)).isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
