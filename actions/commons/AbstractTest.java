package commons;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {
	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	// private WebDriver driver;
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
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", ".\\downloadedFiles");

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);

			setDriver(new ChromeDriver(options));
		} else if (browser == Browser.CHROMEHEADLESS) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			setDriver(new ChromeDriver(options));
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
			// System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			setDriver(new FirefoxDriver());
		} else if (browser == Browser.CHROME) {
			// System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory", GlobalConstants.DOWNLOAD_FILES_PATH);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);

			setDriver(new ChromeDriver(options));
		} else if (browser == Browser.EDGE) {
			// System.setProperty("webdriver.edge.driver", ".\\browserDrivers\\chromedriver.exe");
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

	public static WebDriver getDriver() {
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
			if (condition == false) {
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

	public static int randomNumber() {
		Random random = new Random();
		return random.nextInt();
	}

	public void sleepInSeconds(int timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void closeBrowserAndDriver(WebDriver driver) {

		try {
			if (driver != null) {
				driver.quit();
			}

			String osName = System.getProperty("os.name").toLowerCase();

			String cmd = null;
			if (driver.toString().toLowerCase().contains("chromedriver")) {
				log.info("Browser Driver is " + driver.toString().toLowerCase());
				if (osName.contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.contains("window")) {
					cmd = "taskkill /F/FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				log.info("Browser Driver is " + driver.toString().toLowerCase());
				if (osName.contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.contains("window")) {
					cmd = "taskkill /F/FI \"IMAGENAME eq geckodriver*\"";
				}
			}

			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			log.info(e.getMessage());
		}
	}
}
