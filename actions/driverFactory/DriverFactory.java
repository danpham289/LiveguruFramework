package driverFactory;

import commons.Browser;


public class DriverFactory {
	public static DriverManager getManager(String browserName) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		DriverManager driverManager = null;
		if (browser == Browser.CHROME) {
			driverManager = new ChromeDriverManager();
		} else if (browser == Browser.FIREFOX) {
			driverManager = new FirefoxDriverManager();
		} else if (browser == Browser.CHROMEHEADLESS) {
			driverManager = new ChromeHeadlessDriverManager();
		}  else {
			throw new RuntimeException("Please input correct browser name.");
		}
		return driverManager;
	}
}
