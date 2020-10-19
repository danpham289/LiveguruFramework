package com.liveguru.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.liveguru.LoginAdminPageObject;
import pageObjects.liveguru.ManageCustomersPageObject;
import pageObjects.liveguru.OrdersPageObject;
import pageObjects.liveguru.PageGeneratorManager;

public class TS02_Invoice_Printed extends AbstractTest{
	WebDriver driver;
	LoginAdminPageObject loginAdminPage;
	ManageCustomersPageObject manageCustomersPage; 
	OrdersPageObject ordersPage;
	
	
	@Parameters({"browser","adminUrl"})
	@Test
	public void TC02_Invoice_Printed(String browserName, String adminUrl) {
		
		log.info("Step: Open LiveGuru99 admin site");
		driver = getBrowserDriver(browserName, adminUrl);
		loginAdminPage = PageGeneratorManager.getLoginAdminPageObject(driver);
		
		log.info("Step: Input admin username & password");
		loginAdminPage.inputToUsernameTextbox(GlobalConstants.ADMIN_USER);
		loginAdminPage.inputToPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
		
		log.info("Step: Click Login button");
		manageCustomersPage = loginAdminPage.clickToLoginButton();
		
		log.info("Step: Close Incoming Message Popup");
		manageCustomersPage.closeIncomingMessagePopUp();
		
		log.info("Step: Hover 'Sales' item then click Orders item on top menu");
		manageCustomersPage.openSubMenuPageInAdminByItems(driver, "Sales", "Orders");
		ordersPage = PageGeneratorManager.getOrdersPageObject(driver);
		
		log.info("Step: Select 'Canceled' in Status dropdown");
		ordersPage.selectItemInStatusDropdown("Canceled");
		
		log.info("Step: Click Search button");
		ordersPage.clickToSearchButton();
		
		log.info("Step: Select the checkbox of the 1st row");
		ordersPage.clickToCheckboxByRowNumber("1");
		
		log.info("Step: Select 'Print Voices' in Actions dropdown");
		ordersPage.selectItemInActionsDropdown("Print Invoices");
		
		log.info("Step: Click Submit button");
		ordersPage.clickToSubmitButton();
		
		log.info("VP: No Printable Documents Error message displays");
		verifyTrue(ordersPage.isNoPrintableDocumentsMessageDisplayed());
		
		log.info("Step: Select 'Completed' in Status dropdown");
		ordersPage.selectItemInStatusDropdown("Complete");
		
		log.info("Step: Click Search button");
		ordersPage.clickToSearchButton();
		
		log.info("Step: Select the checkbox of the 1st row");
		ordersPage.clickToCheckboxByRowNumber("1");
		
		log.info("Step: Select 'Print Voices' in Actions dropdown");
		ordersPage.selectItemInActionsDropdown("Print Invoices");
		
		log.info("Step: Click Submit button");
		ordersPage.clickToSubmitButton();
		
		log.info("VP: Invoice file is downloaded");
		verifyTrue(ordersPage.isInvoiceFileDownloaded());
	}
		
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
