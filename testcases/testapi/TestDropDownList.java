package testapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestDropDownList {

	public static void main(String[] args) {

		WebDriver driver;
		String url = "https://automationfc.github.io/basic-form/index.html";
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		Select dropdownlist = new Select(driver.findElement(By.xpath("//select[@id='job2']")));

		Assert.assertTrue(dropdownlist.isMultiple());
		dropdownlist.selectByVisibleText("Automation");
		dropdownlist.selectByVisibleText("Mobile");
		dropdownlist.selectByVisibleText("Desktop");
		Assert.assertEquals(dropdownlist.getAllSelectedOptions().size(), 3);

		List<WebElement> items = dropdownlist.getAllSelectedOptions();
		List<String> arraylist = new ArrayList<String>();
		for (WebElement item : items) {
			arraylist.add(item.getText());
		}
		Assert.assertTrue(arraylist.contains("Automation"));
		Assert.assertTrue(arraylist.contains("Mobile"));
		Assert.assertTrue(arraylist.contains("Desktop"));

		driver.close();
	}

}
