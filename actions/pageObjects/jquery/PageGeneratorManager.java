package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static UploadPageObject getUploadPageOject(WebDriver driver) {
		return new UploadPageObject(driver);
	}

	
}
