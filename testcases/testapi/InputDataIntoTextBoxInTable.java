package testapi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class InputDataIntoTextBoxInTable extends AbstractPage {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		String url = "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/";
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	public void TC01()  {
		sendKeysToTextBoxByColumnNameAtRowNumber("Company",1,"Axon");
		sendKeysToTextBoxByColumnNameAtRowNumber("Contact Person",2,"Hoang Van Thu");
		sendKeysToTextBoxByColumnNameAtRowNumber("Order Placed",3,"Da nang");

	}

	public void sendKeysToTextBoxByColumnNameAtRowNumber(String columnName, int rowNumber, String value) {
		List<WebElement> columnsAheadofColumnName = driver
				.findElements(By.xpath("//tr/th[text()='" + columnName + "']/preceding-sibling::th"));
		int columnNumber = columnsAheadofColumnName.size() + 1;
		String xpathTextboxAtColumnName = "//tr["+rowNumber+"]/td["+columnNumber+"]/input";
		sendKeysToElement(driver, xpathTextboxAtColumnName, value);

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
