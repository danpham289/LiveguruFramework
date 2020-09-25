package reportConfig;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import commons.AbstractTest;
import io.qameta.allure.Attachment;

public class AllureTestListener implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// Text attachments for Allure
	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// Text attachments for Allure
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	// HTML attachments for Allure
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}

	@Override
	public void onStart(ITestContext iTestContext) {}


	@Override
	public void onTestFailure(ITestResult iTestResult) {

		// Get driver from BaseTest and assign to local webdriver variable.
		Object testClass = iTestResult.getInstance();
		WebDriver driver = ((AbstractTest) testClass).getDriver();

		// Allure ScreenShotRobot and SaveTestLog
		if (driver instanceof WebDriver) {
			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
			saveScreenshotPNG(driver);
		}

		// Save a log on allure.
		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

}
