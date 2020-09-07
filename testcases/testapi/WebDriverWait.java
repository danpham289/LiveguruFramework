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

public class WebDriverWait {

	public static void main(String[] args) {

		WebDriver driver;
		String url = "http://the-internet.herokuapp.com/dynamic_loading/2";
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		
		driver.findElement(By.xpath("//*[@id='start']/button")).click();
		
		String locator = "//div[@id='finish']/h4[text()='Hello World!']";
		Assert.assertTrue(driver.findElement(By.xpath(locator)).isDisplayed());

		driver.quit();
	}

}
