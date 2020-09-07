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

public class UploadFile extends AbstractPage {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		String url = "https://test.zingpoll.com/";
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Test
	public void TC01() {
		driver.findElement(By.xpath(
				"//div[@class='col-xs-12 button-group form-group-options']/div[1]//span[@class='btn-file span-camera']"))
				.click();
		String path = System.getProperty("user.dir");
		String filePath = path + "\\uploadFiles\\CK.png";
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(filePath);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		

	}

	@AfterClass
	public void afterClass() {
		//driver.close();
	}

}
