package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.EndUser;
import com.nopcommerce.ProductData;
import com.nopcommerce.commons.Common_01_Register_User;

import commons.AbstractTest;
import pageObjects.nopcommerce.CustomerInfoPageObject;
import pageObjects.nopcommerce.DesktopsPageObject;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.ShoppingCartPageObject;
import pageObjects.nopcommerce.BuildComputerDetailsPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Order_01_Add_Edit_Remove_Product_From_Cart extends AbstractTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	CustomerInfoPageObject customerInfoPage;
	DesktopsPageObject desktopsPage;
	BuildComputerDetailsPageObject buildComputerDetailsPage;
	ShoppingCartPageObject shoppingCartPage;
	String addToCartSuccessMessage = "The product has been added to your shopping cart";
	String countItemsInShoppingCartMessage = "There are 1 item(s) in your cart.";

	@Parameters({"browser","userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		log.info("Precondition - Step 01: Open NopCommerce user site");
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		
		log.info("Precondition - Step 02: Login by the registered account");
		loginPage = homePage.clickToLogInLink();
		loginPage.inputToEmailTextbox(Common_01_Register_User.email);
		loginPage.inputToPasswordTextbox(EndUser.Register.PASSWORD);
		homePage = loginPage.clickToLogInButton();
	}

	@Test
	public void TC01_Add_Product_To_Cart() {
		log.info("Step 01: Open Computers > Desktops ");
		homePage.openSubMenuPageInNopCommerceByItems(driver, "Computers", "Desktops");
		desktopsPage = PageGeneratorManager.getDesktopsPageObject(driver);
		
		log.info("Step 02: Click 'Build your own computer' product link ");
		desktopsPage.clickToProductDetailsLinkByProductName(ProductData.DesktopsProduct.BuildComputer.NAME);
		buildComputerDetailsPage = PageGeneratorManager.getBuildComputerDetailsPageObject(driver);
		
		log.info("Step 03: Select options of product ");
		buildComputerDetailsPage.selectProcessorDropdown(ProductData.DesktopsProduct.BuildComputer.Processor.OPTION2);
		buildComputerDetailsPage.selectRAMDropdown(ProductData.DesktopsProduct.BuildComputer.RAM.OPTION3);
		buildComputerDetailsPage.clickToHDDRadiobutton(ProductData.DesktopsProduct.BuildComputer.HDD.OPTION2);
		buildComputerDetailsPage.clickToOSRadiobutton(ProductData.DesktopsProduct.BuildComputer.OS.OPTION2);
		buildComputerDetailsPage.checkToSoftwareCheckbox(ProductData.DesktopsProduct.BuildComputer.Software.OPTION1);
		buildComputerDetailsPage.checkToSoftwareCheckbox(ProductData.DesktopsProduct.BuildComputer.Software.OPTION2);
		buildComputerDetailsPage.checkToSoftwareCheckbox(ProductData.DesktopsProduct.BuildComputer.Software.OPTION3);
		
		log.info("Step 04: Click Add To Cart button ");
		buildComputerDetailsPage.clickAddToCartButton();
		
		log.info("VP: 'The product has been added to your shopping cart' message displays ");
		verifyEquals(buildComputerDetailsPage.getNotificationSuccessMessageText(),addToCartSuccessMessage);
		
		log.info("VP: Product is added to cart ");
		buildComputerDetailsPage.hoverMouseToShoppingCartLink();
		verifyTrue(buildComputerDetailsPage.isShoppingCartPopupDisplayed());
		verifyEquals(buildComputerDetailsPage.getCountItemsInShoppingCartMessageText(),countItemsInShoppingCartMessage);
		verifyEquals(buildComputerDetailsPage.getProductUnitPriceInShoppingCartMessageText(),"$1,500.00");
		verifyEquals(buildComputerDetailsPage.getProductQuantityInShoppingCartMessageText(),"1");
		verifyEquals(buildComputerDetailsPage.getSubTotalInShoppingCartMessageText(),"$1,500.00");
		
		
	}

	@AfterClass
	public void afterClass() {
//		closeBrowserAndDriver(driver);
	}

}
