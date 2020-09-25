package commons;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {
	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	//private WebDriver driver;
	private long longTimeOut = 30;
	
	protected final Log log;
	
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());

		if (browser == Browser.FIREFOX) {
//			System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			setDriver(new FirefoxDriver());
		} else if (browser == Browser.CHROME) {
//			System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			setDriver(new ChromeDriver());
		} else {
			throw new RuntimeException("Please input correct browser name.");
		}

		getDriver().manage().window().maximize();
		getDriver().get("http://live.demoguru99.com");
		getDriver().manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		return getDriver();
	}

	protected WebDriver getBrowserDriver(String browserName, String appURL) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());

		if (browser == Browser.FIREFOX) {
			//System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			setDriver(new FirefoxDriver());
		} else if (browser == Browser.CHROME) {
			//System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			setDriver(new ChromeDriver());
		} else if (browser == Browser.EDGE) {
			//System.setProperty("webdriver.edge.driver", ".\\browserDrivers\\chromedriver.exe");
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());
		} else {
			throw new RuntimeException("Please input correct browser name.");
		}

		getDriver().manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().get(appURL);
		return getDriver();
	}
	
	protected void removeDriver() {
		getDriver().quit();
		threadLocalDriver.remove();
	}
	
	public WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	private void setDriver(WebDriver driver) {
		threadLocalDriver.set(driver);
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

}
