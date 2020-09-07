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

public class CustomDropDownList extends AbstractPage {
	WebDriver driver;
	String url;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void TC01_Jquery() throws InterruptedException {
		url = "https://jqueryui.com/resources/demos/selectmenu/default.html";
		driver.get(url);

		// 1 - Click vào thẻ (cha) để xổ ra tất cả các item con

		// jsExecutor.executeScript("arguments[0].click()", item);
		driver.findElement(By.id("number-button")).click();
		// 2 - Chờ cho tất cả các item con được load ra
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
		explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='number-menu']/li/div")));
		// ul[@id='number-menu']/li/div
		// Đưa tất cả các item trong dropdown vào 1 list để kiểm tra
		List<WebElement> allitems = driver.findElements(By.xpath("//ul[@id='number-menu']/li/div"));
		// 3 - Chạy qua tất cả các giá trị đang có trong list
		for (WebElement item : allitems) {
			System.out.println(item.getText());
			// 4 - Kiểm tra xem text của các giá trị có item nào bằng vs text mong muốn ko
			if (item.getText().contains("19")) {
				// 5 - Scroll xuống đến đúng item này
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				// 6 - Click vào cái item này
				// Thread.sleep(5000);
				// explicitWait.until(ExpectedConditions.visi(item));
				item.click();
				// jsExecutor.executeScript("arguments[0].click()", item);
				break;
			}

		}
		// Thread.sleep(5000);
		// kiểm tra item đã dc chọn thành công
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),
				"19");

	}

	public void TC02_React() {
		url = "https://react.semantic-ui.com/maximize/dropdown-example-selection/";
		driver.get(url);
		String parentLocator = "//*[@id='root']//i[@class='dropdown icon']";
		String childItemLocator = "//div[@style='pointer-events:all']/span";
		String expectedItem = "Matt";

		selectItemInCustomDropdown(driver, parentLocator, childItemLocator, expectedItem);
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@class='divider text' and contains(text(),'" + expectedItem + "')]"))
						.isDisplayed());

	}

	public void TC03_Angular() {
		url = "https://ej2.syncfusion.com/angular/demos/?_ga=2.262049992.437420821.1575083417-524628264.1575083417#/material/drop-down-list/data-binding";
		driver.get(url);
		String parentLocator = "//ejs-dropdownlist[@id='games']/span";
		String childItemLocator = "//ul[@id='games_options']/li";
		String expectedItem = "Football";

		selectItemInCustomDropdown(driver, parentLocator, childItemLocator, expectedItem);

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String text = (String) jsExecutor
				.executeScript("return document.querySelector(\"ejs-dropdownlist[id='games'] option\").textContent");

		Assert.assertEquals(text, expectedItem);
	}
	
	@Test
	public void TC04_Multiple_Select() {
		url = "http://multiple-select.wenzhixin.net.cn/examples#basic.html";
		driver.get(url);
		String iframeXpath = "//div[@class='container mainContainer']//iframe";
		WebElement iframe = driver.findElement(By.xpath(iframeXpath));
		driver.switchTo().frame(iframe);
		String parentLocator = "//div[@id='example']/div/div[2]//button[@class='ms-choice']";
		String childItemLocator = "//div[@id='example']/div/div[2]//div[@class='ms-drop bottom']/ul/li//span";
		String[] expectedItems = {"January","October","April","December"};
		
		selectMultiItemsInCustomDropdown(driver, parentLocator, childItemLocator, expectedItems);
		
		// Verify data selected
		boolean i = false;
		WebElement selectedTextElement = driver.findElement(By.xpath("//div[@id='example']/div/div[2]//button[@class='ms-choice']/span")) ;
		String selectedText = selectedTextElement.getText();

		if (expectedItems.length <= 3) {
			for (String item : expectedItems) {
				if(selectedText.contains(item)) {
					i = true;
					break;
				}
			}
			
		}else {
			i = selectedText.equals(expectedItems.length+" of 12 selected");
		}
		Assert.assertTrue(i);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
