package commons;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pageObjects.liveguru.AboutUsPageObject;
import pageObjects.liveguru.AdvancedSearchPageObject;
import pageObjects.liveguru.CustomerServicePageObject;
import pageObjects.liveguru.MobilePageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.SearchTermPageObject;
import pageObjects.liveguru.TVPageObject;
import pageUIs.liveguru.AbstractPageUI;

public abstract class AbstractPage {

	protected final Log log;

	protected AbstractPage() {
		log = LogFactory.getLog(getClass());
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getAlertText(WebDriver driver) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendKeysToAlertText(WebDriver driver, String text) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	public void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.alertIsPresent());

	}

	public void swicthToWindowById(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void swicthToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public WebElement find(WebDriver driver, String xpathValue) {
		return driver.findElement(byXpath(xpathValue));
	}

	public List<WebElement> finds(WebDriver driver, String xpathValue) {
		return driver.findElements(byXpath(xpathValue));
	}

	public By byXpath(String xpathValue) {
		return By.xpath(xpathValue);
	}

	public void clickToElement(WebDriver driver, String xpathValue) {
		find(driver, xpathValue).click();
	}

	public String getDynamicLocator(String value, String... dynamicValue) {
		return String.format(value, (Object[]) dynamicValue);
	}

	public void clickToElement(WebDriver driver, String locator, String... dynamicValue) {
		find(driver, getDynamicLocator(locator, dynamicValue)).click();
	}

	public void sendKeysToElement(WebDriver driver, String xpathValue, String text) {
		element = find(driver, xpathValue);
		element.clear();
		element.sendKeys(text);
	}

	public void sendKeysToElement(WebDriver driver, String locator, String text, String... dynamicValue) {
		element = find(driver, getDynamicLocator(locator, dynamicValue));
		element.clear();
		element.sendKeys(text);
	}

	public void selectItemInDropdown(WebDriver driver, String xpathValue, String itemValue) {
		select = new Select(find(driver, xpathValue));
		select.selectByVisibleText(itemValue);
	}

	public String getSelectedItemTextInDropdown(WebDriver driver, String xpathValue, String itemValue) {
		select = new Select(find(driver, xpathValue));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathValue) {
		select = new Select(find(driver, xpathValue));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		// 1 - Click vào thẻ (cha) để xổ ra tất cả các item con
		find(driver, parentLocator).click();
		sleepInSecond(1);

		// 2 - Chờ cho tất cả các item con được load ra
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));

		// Đưa tất cả các item trong dropdown vào 1 list để kiểm tra
		elements = finds(driver, childItemLocator);

		// 3 - Chạy qua tất cả các giá trị đang có trong list
		for (WebElement item : elements) {
			// 4 - Kiểm tra xem text của các giá trị có item nào bằng vs text mong muốn ko
			if (item.getText().equals(expectedItem)) {
				// 5 - Scroll xuống đến đúng item này
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				// 6 - Click vào cái item này
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public void selectMultiItemsInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String[] expectedItems) {
		// 1 - Click vào thẻ (cha) để xổ ra tất cả các item con
		find(driver, parentLocator).click();
		sleepInSecond(1);

		// 2 - Chờ cho tất cả các item con được load ra
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));

		// Đưa tất cả các item trong dropdown vào 1 list để kiểm tra
		elements = finds(driver, childItemLocator);

		// 3 - Chạy qua tất cả các giá trị đang có trong list
		int i = 0;
		for (WebElement item : elements) {
			// 3a -Chạy qua các giá trị expectedItems
			for (String expectedItem : expectedItems) {
				// 4 - Kiểm tra xem text của các giá trị có item nào bằng vs text mong muốn ko
				if (item.getText().equals(expectedItem)) {
					// 5 - Scroll xuống đến đúng item này
					jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
					sleepInSecond(1);

					// 6 - Click vào cái item này
					item.click();
					sleepInSecond(1);
					i++;
				}
				// 7 - Check số items được select = số expected items

				if (i == expectedItems.length) {
					break;
				}
			}
		}
	}

	public String getElementAttribute(WebDriver driver, String xpathValue, String attributename) {
		return find(driver, xpathValue).getAttribute(attributename);
	}

	public String getElementText(WebDriver driver, String locator, String... dynamicValue) {
		return find(driver, getDynamicLocator(locator, dynamicValue)).getText();
	}

	public String getElementText(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).getText();
	}

	public int countElementNumber(WebDriver driver, String xpathValue) {
		return finds(driver, xpathValue).size();

	}

	public int countElementNumber(WebDriver driver, String locator, String... dynamicValue) {
		return finds(driver, getDynamicLocator(locator, dynamicValue)).size();

	}

	public void checkToCheckbox(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		if (!element.isSelected()) {
			element.click();
		}
	}
	public void checkToCheckbox(WebDriver driver, String locator, String... dynamicValue) {
		element = find(driver, getDynamicLocator(locator, dynamicValue));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... dynamicValue) {
		return find(driver, getDynamicLocator(locator, dynamicValue)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locator, String... dynamicValue) {
		return find(driver, getDynamicLocator(locator, dynamicValue)).isSelected();
	}

	public void switchToFrame(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		driver.switchTo().frame(element);

	}

	public void switchToDefaultContent(WebDriver driver, String xpathValue) {
		driver.switchTo().defaultContent();
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void doubleClickToElement(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locator, String... dynamicValue) {
		element = find(driver, getDynamicLocator(locator, dynamicValue));
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void rightClickToElement(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void drapAndDrop(WebDriver driver, String xpathValueSoure, String xpathValueTarget) {
		element = find(driver, xpathValueSoure);
		element1 = find(driver, xpathValueTarget);
		action = new Actions(driver);
		action.dragAndDrop(element, element1).build().perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String xpathValue, Keys key) {
		element = find(driver, xpathValue);
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}

	public Object executeJavascriptToBrowser(WebDriver driver, String javaSript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaSript);

	}

	public Object executeJavascriptToElement(WebDriver driver, String javaSript, String xpathValue) {
		element = find(driver, xpathValue);
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaSript, element);

	}

	public void scrollToBottomPage(WebDriver driver) {
		executeJavascriptToBrowser(driver, "window.scrollBy(0,document.body.scrollHeight)");

	}

	public void scrollToElement(WebDriver driver, String xpathValue) {
		executeJavascriptToElement(driver, "arguments[0].scrollIntoView(true);", xpathValue);

	}

	public void highlightElement(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");

	}

	public void clickToElementByJS(WebDriver driver, String xpathValue) {
		executeJavascriptToElement(driver, "arguments[0].click();", xpathValue);
	}

	public void clickToElementByJS(WebDriver driver, String locator, String... dynamicValue) {
		executeJavascriptToElement(driver, "arguments[0].click();", getDynamicLocator(locator, dynamicValue));
	}

	public void sendkeyToElementByJS(WebDriver driver, String xpathValue, String value) {
		executeJavascriptToElement(driver, "arguments[0].setAttribute('value', '" + value + "')", xpathValue);
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathValue, String attributeRemove) {
		executeJavascriptToElement(driver, "arguments[0].removeAttribute('" + attributeRemove + "');", xpathValue);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) executeJavascriptToBrowser(driver, "return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public boolean isImageLoaded(WebDriver driver, String xpathValue) {
		return (Boolean) executeJavascriptToElement(driver, "return arguments[0].complete && typeof argument[0].naturalWidth!=\"undefine\" && argument[0].naturalWidth > 0", xpathValue);
	}

	public void waitElementPresence(WebDriver driver, String xpathValue) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(byXpath(xpathValue)));

	}

	public void waitElementVisible(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitElementVisible(WebDriver driver, String locator, String... dynamicValue) {
		element = find(driver, getDynamicLocator(locator, dynamicValue));
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitElementsVisible(WebDriver driver, String xpathValue) {
		elements = finds(driver, xpathValue);
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));

	}

	public void waitElementsVisible(WebDriver driver, String locator, String... dynamicValue) {
		elements = finds(driver, getDynamicLocator(locator, dynamicValue));
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));

	}

	public void waitElementClickable(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitElementClickable(WebDriver driver, String locator, String... dynamicValue) {
		element = find(driver, getDynamicLocator(locator, dynamicValue));
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitElementInvisible(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));

	}

	public void setImplicitWait(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

	}

	public boolean waitForJStoLoad(WebDriver driver) {

		explicitWait = new WebDriverWait(driver, 30);
		jsExecutor = (JavascriptExecutor) driver;

		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	@Step("Click Mobile menu")
	public MobilePageObject clickToMobileMenu(WebDriver driver) {
		waitElementClickable(driver, AbstractPageUI.MOBILE_LINK);
		clickToElement(driver, AbstractPageUI.MOBILE_LINK);
		return PageGeneratorManager.getMobilePageObject(driver);

	}

	@Step("Click TV menu")
	public TVPageObject clickToTVMenu(WebDriver driver) {
		waitElementClickable(driver, AbstractPageUI.TV_LINK);
		clickToElement(driver, AbstractPageUI.TV_LINK);
		return PageGeneratorManager.getTVPageObject(driver);

	}

	public AboutUsPageObject openAboutUsPage(WebDriver driver) {
		waitElementClickable(driver, AbstractPageUI.ABOUT_US_LINK);
		clickToElement(driver, AbstractPageUI.ABOUT_US_LINK);
		return PageGeneratorManager.getAboutUsPageObject(driver);

	}

	public AdvancedSearchPageObject openAdvancedSearchPage(WebDriver driver) {
		waitElementClickable(driver, AbstractPageUI.ADVANCED_SEARCH_LINK);
		clickToElement(driver, AbstractPageUI.ADVANCED_SEARCH_LINK);
		return PageGeneratorManager.getAdvancedSearchPageObject(driver);

	}

	public SearchTermPageObject openSearchTermPage(WebDriver driver) {
		waitElementClickable(driver, AbstractPageUI.SEARCH_TERM_LINK);
		clickToElement(driver, AbstractPageUI.SEARCH_TERM_LINK);
		return PageGeneratorManager.getSearchTermPageObject(driver);

	}

	public CustomerServicePageObject openCustomerServicePage(WebDriver driver) {
		waitElementClickable(driver, AbstractPageUI.CUSTOMER_SERVICE_LINK);
		clickToElement(driver, AbstractPageUI.CUSTOMER_SERVICE_LINK);
		return PageGeneratorManager.getCustomerServicePageObject(driver);

	}

	public void openFooterPageByName(WebDriver driver, String pageName) {
		waitElementClickable(driver, AbstractPageUI.DYNAMIC_FOOTER_PAGE_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_FOOTER_PAGE_LINK, pageName);
	}

	public void openLeftMenuPageByName(WebDriver driver, String pageName) {
		waitElementClickable(driver, AbstractPageUI.DYNAMIC_LEFT_MENU_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LEFT_MENU_LINK, pageName);
	}

	public void openSubMenuPageInAdminByItems(WebDriver driver, String level1Item, String level2Item) {
		waitElementVisible(driver, AbstractPageUI.DYNAMIC_LEVEL1_TOP_MENU_LINK, level1Item);
		hoverMouseToElement(driver, AbstractPageUI.DYNAMIC_LEVEL1_TOP_MENU_LINK, level1Item);
		waitElementClickable(driver, AbstractPageUI.DYNAMIC_LEVEL2_TOP_MENU_LINK, level1Item, level2Item);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LEVEL2_TOP_MENU_LINK, level1Item, level2Item);
	}

	public void openSubMenuPageInAdminByItems(WebDriver driver, String level1Item, String level2Item, String level3Item) {
		waitElementVisible(driver, AbstractPageUI.DYNAMIC_LEVEL1_TOP_MENU_LINK, level1Item);
		hoverMouseToElement(driver, AbstractPageUI.DYNAMIC_LEVEL1_TOP_MENU_LINK, level1Item);
		waitElementVisible(driver, AbstractPageUI.DYNAMIC_LEVEL2_TOP_MENU_LINK, level1Item, level2Item);
		hoverMouseToElement(driver, AbstractPageUI.DYNAMIC_LEVEL2_TOP_MENU_LINK, level1Item, level2Item);
		waitElementClickable(driver, AbstractPageUI.DYNAMIC_LEVEL3_TOP_MENU_LINK, level1Item, level2Item, level3Item);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LEVEL3_TOP_MENU_LINK, level1Item, level2Item, level3Item);
	}

	public void openSubMenuPageInAdminByItems(WebDriver driver, String level1Item, String level2Item, String level3Item, String level4Item) {
		waitElementVisible(driver, AbstractPageUI.DYNAMIC_LEVEL1_TOP_MENU_LINK, level1Item);
		hoverMouseToElement(driver, AbstractPageUI.DYNAMIC_LEVEL1_TOP_MENU_LINK, level1Item);
		waitElementVisible(driver, AbstractPageUI.DYNAMIC_LEVEL2_TOP_MENU_LINK, level1Item, level2Item);
		hoverMouseToElement(driver, AbstractPageUI.DYNAMIC_LEVEL2_TOP_MENU_LINK, level1Item, level2Item);
		waitElementVisible(driver, AbstractPageUI.DYNAMIC_LEVEL3_TOP_MENU_LINK, level1Item, level2Item, level3Item);
		hoverMouseToElement(driver, AbstractPageUI.DYNAMIC_LEVEL3_TOP_MENU_LINK, level1Item, level2Item, level3Item);
		waitElementClickable(driver, AbstractPageUI.DYNAMIC_LEVEL4_TOP_MENU_LINK, level1Item, level2Item, level3Item, level4Item);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LEVEL4_TOP_MENU_LINK, level1Item, level2Item, level3Item, level4Item);
	}
	
	public void openSubMenuPageInNopCommerceByItems(WebDriver driver, String level1Item, String level2Item) {
		waitElementVisible(driver, pageUIs.nopcommerce.AbstractPageUI.DYNAMIC_LEVEL1_TOP_MENU_LINK, level1Item);
		hoverMouseToElement(driver, pageUIs.nopcommerce.AbstractPageUI.DYNAMIC_LEVEL1_TOP_MENU_LINK, level1Item);
		waitElementClickable(driver, pageUIs.nopcommerce.AbstractPageUI.DYNAMIC_LEVEL2_TOP_MENU_LINK, level1Item, level2Item);
		clickToElement(driver, pageUIs.nopcommerce.AbstractPageUI.DYNAMIC_LEVEL2_TOP_MENU_LINK, level1Item, level2Item);
	}
	
	public void uploadMultipleFiles(WebDriver driver, String... filenames) {
		String filePath = System.getProperty("user.dir") + getDirectorySlash("uploadFiles");
		String fileFullPath = "";
		for (String filename : filenames) {
			fileFullPath = fileFullPath + filePath + filename + "\n";
		}
		fileFullPath = fileFullPath.trim();
		// waitElementVisible(driver, AbstractPageUI.UPLOAD_FILE_TYPE);
		sendKeysToElement(driver, AbstractPageUI.UPLOAD_FILE_TYPE, fileFullPath);

	}

	public void waitForDownloadFileContainsNameCompleted(String fileName) {
		int i = 0;
		while (i < 30) {
			boolean exist = isFileContain(fileName);
			if (exist == true) {
				i = 30;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i = i + 1;
		}
	}

	public boolean isFileContain(String fileName) {
		try {
			boolean flag = false;
			File dir = new File(GlobalConstants.DOWNLOAD_FILES_PATH);
			File[] files = dir.listFiles();
			if (files == null || files.length == 0) {
				flag = false;
			}

			for (int i = 0; i < files.length; i++) {
				System.out.println("file name is " + files[i].getName());
				if (files[i].getName().contains(fileName)) {
					flag = true;
				}
			}
			return flag;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	public void deleteAllFileInFolder() {
		try {
			File file = new File(GlobalConstants.DOWNLOAD_FILES_PATH);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public int countFilesInDirectory() {
		File file = new File(GlobalConstants.DOWNLOAD_FILES_PATH);
		int i = 0;
		for (File listOfFiles : file.listFiles()) {
			if (listOfFiles.isFile()) {
				i++;
			}
		}
		System.out.println("files number in folder is " + i);
		return i;
	}

	public String getDirectorySlash(String folderName) {
		if (isMac()) {
			return "/" + folderName + "/";
		} else {
			return "\\" + folderName + "\\";
		}
	}

	public boolean isWindows() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	public boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	public int randomNumber(WebDriver driver) {
		Random num = new Random();
		return num.nextInt();
	}

	public boolean isPriceSortedByDescending(WebDriver driver, String xpathValue) {

		ArrayList<Float> arraylist = new ArrayList<Float>();

		elements = finds(driver, xpathValue);

		for (WebElement element : elements) {
			arraylist.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
		}
		System.out.println("--- Price not sorted ----");
		for (Float number : arraylist) {

			System.out.println(number);
		}
		ArrayList<Float> sortedlist = new ArrayList<Float>();
		for (Float child : arraylist) {
			sortedlist.add(child);
		}
		Collections.sort(sortedlist);
		Collections.reverse(sortedlist);

		System.out.println("--- Price sorted----");
		for (Float number : sortedlist) {

			System.out.println(number);
		}
		return arraylist.equals(sortedlist);
	}

	public boolean isPriceSortedByAscending(WebDriver driver, String xpathValue) {

		ArrayList<Float> arraylist = new ArrayList<Float>();

		elements = finds(driver, xpathValue);

		for (WebElement element : elements) {
			arraylist.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
		}
		System.out.println("--- Price not sorted ----");
		for (Float number : arraylist) {

			System.out.println(number);
		}
		ArrayList<Float> sortedlist = new ArrayList<Float>();
		for (Float child : arraylist) {
			sortedlist.add(child);
		}
		Collections.sort(sortedlist);

		System.out.println("--- Price sorted----");
		for (Float number : sortedlist) {

			System.out.println(number);
		}
		return arraylist.equals(sortedlist);
	}

	public boolean isNumberSortedByDescending(WebDriver driver, String xpathValue) {

		ArrayList<Long> arraylist = new ArrayList<Long>();

		elements = finds(driver, xpathValue);

		for (WebElement element : elements) {
			arraylist.add(Long.parseLong(element.getText()));
		}
		System.out.println("--- Number not sorted ----");
		for (Long number : arraylist) {

			System.out.println(number);
		}
		ArrayList<Long> sortedlist = new ArrayList<Long>();
		for (Long child : arraylist) {
			sortedlist.add(child);
		}
		Collections.sort(sortedlist);
		Collections.reverse(sortedlist);

		System.out.println("--- Number sorted----");
		for (Long number : sortedlist) {

			System.out.println(number);
		}
		return arraylist.equals(sortedlist);
	}

	public boolean isNumberSortedByAscending(WebDriver driver, String xpathValue) {

		ArrayList<Long> arraylist = new ArrayList<Long>();

		elements = finds(driver, xpathValue);

		for (WebElement element : elements) {
			arraylist.add(Long.parseLong(element.getText()));
		}
		System.out.println("--- Number not sorted ----");
		for (Long number : arraylist) {

			System.out.println(number);
		}
		ArrayList<Long> sortedlist = new ArrayList<Long>();
		for (Long child : arraylist) {
			sortedlist.add(child);
		}
		Collections.sort(sortedlist);

		System.out.println("--- Number sorted----");
		for (Long number : sortedlist) {

			System.out.println(number);
		}
		return arraylist.equals(sortedlist);
	}

	public boolean isTextSortedByAscending(WebDriver driver, String xpathValue) {

		ArrayList<String> arraylist = new ArrayList<>();

		elements = finds(driver, xpathValue);

		for (WebElement element : elements) {
			arraylist.add(element.getText().toLowerCase());
		}
		System.out.println("--- Text not sorted ----");
		for (String text : arraylist) {
			System.out.println(text);
		}
		ArrayList<String> sortedlist = new ArrayList<>();
		for (String child : arraylist) {
			sortedlist.add(child);
		}
		Collections.sort(sortedlist);

		System.out.println("--- Text sorted----");
		for (String text : sortedlist) {

			System.out.println(text);
		}
		return arraylist.equals(sortedlist);
	}

	public boolean isTextSortedByDescending(WebDriver driver, String xpathValue) {

		ArrayList<String> arraylist = new ArrayList<String>();

		elements = finds(driver, xpathValue);

		for (WebElement element : elements) {
			arraylist.add(element.getText().toLowerCase());
		}
		System.out.println("--- Text not sorted ----");
		for (String text : arraylist) {

			System.out.println(text);
		}
		ArrayList<String> sortedlist = new ArrayList<String>();
		for (String child : arraylist) {
			sortedlist.add(child);
		}
		Collections.sort(sortedlist);
		Collections.reverse(sortedlist);
		System.out.println("--- Text sorted----");
		for (String text : sortedlist) {

			System.out.println(text);
		}
		return arraylist.equals(sortedlist);
	}

	public boolean isDateSortedByDescending(WebDriver driver, String xpathValue) {

		ArrayList<Date> arraylist = new ArrayList<Date>();

		elements = finds(driver, xpathValue);

		for (WebElement element : elements) {
			arraylist.add(convertStringToDate(element.getText()));
		}
		System.out.println("--- Date not sort----");
		for (Date date : arraylist) {

			System.out.println(date);
		}
		ArrayList<Date> sortedlist = new ArrayList<Date>();
		for (Date child : arraylist) {
			sortedlist.add(child);
		}
		Collections.sort(sortedlist);
		Collections.reverse(sortedlist);

		System.out.println("--- Date sorted----");
		for (Date date : sortedlist) {

			System.out.println(date);
		}
		return arraylist.equals(sortedlist);
	}

	public boolean isDateSortedByAscending(WebDriver driver, String xpathValue) {

		ArrayList<Date> arraylist = new ArrayList<Date>();

		elements = finds(driver, xpathValue);

		for (WebElement element : elements) {
			arraylist.add(convertStringToDate(element.getText()));
		}
		System.out.println("--- Date not sort----");
		for (Date date : arraylist) {

			System.out.println(date);
		}
		ArrayList<Date> sortedlist = new ArrayList<Date>();
		for (Date child : arraylist) {
			sortedlist.add(child);
		}
		Collections.sort(sortedlist);

		System.out.println("--- Date sorted----");
		for (Date date : sortedlist) {

			System.out.println(date);
		}
		return arraylist.equals(sortedlist);
	}

	public Date convertStringToDate(String dateInString) {
		System.out.println("Date in String is: " + dateInString);
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
		Date date = null;
		try {
			date = formatter.parse(dateInString);
			System.out.println("Date in Date format is: " + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public Date getCurrentDateTimeInApp() {
		Date date = new Date();
		date = DateUtils.addHours(date, -11);
		date = DateUtils.addSeconds(date, -1);
		return date;
	}

	public String getDownloadedInvoiceFilename() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = getCurrentDateTimeInApp();
		String dateInString = "";
		try {
			dateInString = formatter.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "invoice" + dateInString.replace(" ", "_") + ".pdf";
	}


	
	private long longTimeOut = 30;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private Alert alert;
	private List<WebElement> elements;
	private WebElement element;
	private WebElement element1;
	private Select select;
	private Actions action;
	private String osName = System.getProperty("os.name");
}
