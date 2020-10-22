package com.liveguru.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.GlobalConstants;
import pageObjects.liveguru.InvoicesPageObject;
import pageObjects.liveguru.LoginAdminPageObject;
import pageObjects.liveguru.ManageCustomersPageObject;
import pageObjects.liveguru.OrdersPageObject;
import pageObjects.liveguru.PageGeneratorManager;

public class TS04_Invoices_Sorting extends AbstractTest{
	WebDriver driver;
	LoginAdminPageObject loginAdminPage;
	ManageCustomersPageObject manageCustomersPage; 
	InvoicesPageObject invoicesPage;
	OrdersPageObject ordersPage;

	@Parameters({"browser","adminUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		log.info("Precondition: Open LiveGuru99 admin site");
		driver = getBrowserDriver(browserName, appURL);
		loginAdminPage = PageGeneratorManager.getLoginAdminPageObject(driver);
		log.info("Step: Input admin username & password");
		loginAdminPage.inputToUsernameTextbox(GlobalConstants.ADMIN_USER);
		loginAdminPage.inputToPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
		
		log.info("Step: Click Login button");
		manageCustomersPage = loginAdminPage.clickToLoginButton();
		
		log.info("Step: Close Incoming Message Popup");
		manageCustomersPage.closeIncomingMessagePopUp();
	}
	
	
	
	@Test
	public void TC04_Invoices_Sorting_Working() {		
		
		log.info("Step: Go to 'Sales' > 'Invoices' item on top menu");
		manageCustomersPage.openSubMenuPageInAdminByItems(driver, "Sales", "Invoices");
		invoicesPage = PageGeneratorManager.getInvoicesPageObject(driver);
		
		log.info("Step: Click 'Invoice #' header");
		invoicesPage.clickToHeaderByName("Invoice #");
		
		log.info("VP: 'Invoice #' items are sorted by ascending");
		verifyTrue(invoicesPage.isInvoiveNumberSortedByAscending());
		
		log.info("Step: Click 'Invoice #' header");
		invoicesPage.clickToHeaderByName("Invoice #");
		
		log.info("VP: 'Invoice #' items are sorted by descending");
		verifyTrue(invoicesPage.isInvoiveNumberSortedByDescending());
		
		log.info("Step: Click 'Invoice Date' header");
		invoicesPage.clickToHeaderByName("Invoice Date");
		
		log.info("VP: 'Invoice Date' items are sorted by ascending");
		verifyTrue(invoicesPage.isInvoiveDateSortedByAscending());
		
		log.info("Step: Click 'Invoice Date' header");
		invoicesPage.clickToHeaderByName("Invoice Date");
		
		log.info("VP: 'Invoice Date' items are sorted by descending");
		verifyTrue(invoicesPage.isInvoiveDateSortedByDescending());
		
		log.info("Step: Click 'Order #' header");
		invoicesPage.clickToHeaderByName("Order #");
		
		log.info("VP: 'Order #' items are sorted by ascending");
		verifyTrue(invoicesPage.isOrderNumberSortedByAscending());
		
		log.info("Step: Click 'Order #' header");
		invoicesPage.clickToHeaderByName("Order #");
		
		log.info("VP: 'Order #' items are sorted by descending");
		verifyTrue(invoicesPage.isOrderNumberSortedByDescending());		
		
		log.info("Step: Click 'Order Date' header");
		invoicesPage.clickToHeaderByName("Order Date");
		
		log.info("VP: 'Order Date' items are sorted by ascending");
		verifyTrue(invoicesPage.isOrderDateSortedByAscending());
		
		log.info("Step: Click 'Order Date' header");
		invoicesPage.clickToHeaderByName("Order Date");
		
		log.info("VP: 'Order Date' items are sorted by descending");
		verifyTrue(invoicesPage.isOrderDateSortedByDescending());
		
		log.info("Step: Click 'Bill to Name' header");
		invoicesPage.clickToHeaderByName("Bill to Name");
		
		log.info("VP: 'Bill to Name' items are sorted by ascending");
		verifyTrue(invoicesPage.isBillToNameSortedByAscending());
		
		log.info("Step: Click 'Bill to Name' header");
		invoicesPage.clickToHeaderByName("Bill to Name");
		
		log.info("VP: 'Bill to Name' items are sorted by descending");
		verifyTrue(invoicesPage.isBillToNameSortedByDescending());
		
		log.info("Step: Click 'Amount' header");
		invoicesPage.clickToHeaderByName("Amount");
		
		log.info("VP: 'Amount' items are sorted by ascending");
		verifyTrue(invoicesPage.isAmountSortedByAscending());
		
		log.info("Step: Click 'Amount' header");
		invoicesPage.clickToHeaderByName("Amount");
		
		log.info("VP: 'Amount' items are sorted by descending");
		verifyTrue(invoicesPage.isAmountSortedByDescending());
	}
	
	@Test
	public void TC05_Pagination() {
		log.info("Step: Go to 'Sales' > 'Orders' item on top menu");
		manageCustomersPage.openSubMenuPageInAdminByItems(driver, "Sales", "Orders");
		ordersPage = PageGeneratorManager.getOrdersPageObject(driver);
		
		log.info("Step: Select 20 in View .. per page dropdown");
		ordersPage.selectItemInViewPerPageDropdown("20");
		
		log.info("VP: Verify there are 20 items in view");
		verifyEquals(ordersPage.countItemsInView(),20);

		log.info("Step: Select 20 in View .. per page dropdown");
		ordersPage.selectItemInViewPerPageDropdown("30");
		
		log.info("VP: Verify there are 20 items in view");
		verifyEquals(ordersPage.countItemsInView(),30);
		
		log.info("Step: Select 20 in View .. per page dropdown");
		ordersPage.selectItemInViewPerPageDropdown("50");
		
		log.info("VP: Verify there are 20 items in view");
		verifyEquals(ordersPage.countItemsInView(),50);
		
		log.info("Step: Select 20 in View .. per page dropdown");
		ordersPage.selectItemInViewPerPageDropdown("100");
		
		log.info("VP: Verify there are 20 items in view");
		verifyEquals(ordersPage.countItemsInView(),100);
		
		log.info("Step: Select 20 in View .. per page dropdown");
		ordersPage.selectItemInViewPerPageDropdown("200");
		
		log.info("VP: Verify there are 20 items in view");
		verifyEquals(ordersPage.countItemsInView(),200);
	}
	
	@Test
	public void TC06_Select_Checkbox_Functionality() {
		int viewItemsNumber = 20;
		log.info("Step: Go to 'Sales' > 'Orders' item on top menu");
		manageCustomersPage.openSubMenuPageInAdminByItems(driver, "Sales", "Orders");
		ordersPage = PageGeneratorManager.getOrdersPageObject(driver);
		
		log.info("Step: Select 20 in View .. per page dropdown");
		ordersPage.selectItemInViewPerPageDropdown(String.valueOf(viewItemsNumber));
		
		log.info("Step: Click 'Select Visible' link");
		ordersPage.clickToSelectVisibleLink();
		
		log.info("VP: '20 items selected' message displays");
		verifyTrue(ordersPage.isItemsSelectedMessageByNumberDisplayed(String.valueOf(viewItemsNumber)));
		
		log.info("VP: 20 checkboxes are checked in table");
		verifyTrue(ordersPage.isCheckboxesInTableSelected(viewItemsNumber));
		
		log.info("Step: Click 'unselect Visible' link");
		ordersPage.clickToUnselectVisibleLink();
		
		log.info("VP: '20 items selected' message displays");
		verifyTrue(ordersPage.isItemsSelectedMessageByNumberDisplayed("0"));
		
		log.info("VP: 20 checkboxes are unchecked in table");
		verifyFalse(ordersPage.isCheckboxesInTableSelected(viewItemsNumber));
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
