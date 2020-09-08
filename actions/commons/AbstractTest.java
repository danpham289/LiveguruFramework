package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {

	private WebDriver driver;
	private long longTimeOut = 30;

	protected WebDriver openMultiBrowser(String browserName) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());

		if (browser == Browser.FIREFOX) {
//			System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == Browser.CHROME) {
//			System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			throw new RuntimeException("Please input correct browser name.");
		}

		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com");
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		return driver;
	}

	protected WebDriver openMultiBrowser(String browserName, String appURL) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());

		if (browser == Browser.FIREFOX) {
			//System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == Browser.CHROME) {
			//System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == Browser.EDGE) {
			//System.setProperty("webdriver.edge.driver", ".\\browserDrivers\\chromedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please input correct browser name.");
		}

		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}
	

}
