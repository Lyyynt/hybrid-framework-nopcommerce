package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserProductDetailObject;
import pageObjects.user.UserProductListPageObject;
import pageObjects.user.UserShoppingCartPageObject;

public class Topic_07_Order extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserProductListPageObject productListPage;
	UserProductDetailObject productDetailPage;
	UserShoppingCartPageObject shoppingCartPage;
	
	String buildPCProductName, processor1, processor2, ram1, ram2, hdd1, hdd2, os1, os2, software1, software2, software3, unitPrice1, unitPrice2, quantity, subPrice1, subPrice2;
	String lenovoPCName;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		buildPCProductName = "Build your own computer";
		lenovoPCName = "Lenovo IdeaCentre 600 All-in-One PC";
		
		processor1 = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
		ram1 = "8GB [+$60.00]";
		hdd1 = "400 GB [+$100.00]";
		os1 = "Vista Premium [+$60.00]";
		software1 = "Microsoft Office [+$50.00]";
		software2 = "Acrobat Reader [+$10.00]";
		software3 = "Total Commander [+$5.00]";
		unitPrice1 = "$1,500.00";
		quantity = "1";
		subPrice1 = "$1,500.00";
		
		processor2 = "2.2 GHz Intel Pentium Dual-Core E2200";
		ram2 = "4GB [+$20.00]";
		hdd2 = "320 GB";
		os2 = "Vista Home [+$50.00]";
		unitPrice2 = "$1,320.00";
		subPrice2 = "$1,320.00";
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		log.info("Pre-condition - Step 1: Click to Login link to clear data");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Pre-condition - Step 2: Input correct email");
		loginPage.inputToEmailTextbox(Common_Register_NewAccount.EMAIL);
		
		log.info("Pre-condition - Step 3: Input correct password");
		loginPage.inputToPasswordTextbox(Common_Register_NewAccount.PASSWORD);
		
		log.info("Pre-condition - Step 4: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("Pre-condition - Step 5: Verify the my account page is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
		
	}
	
	@Test
	public void Order_01_Add_Product_To_Cart(){
		log.info("Order 01 - Step 1: Hover on Coputer menu");
		homePage.hoverToMenuItemByLabel(driver, "Computers");
		
		log.info("Order 01 - Step 2: Click on Desktop submenu");
		productListPage = homePage.clickToSubmenuInHeaderMenuByLabel(driver, "Computers", "Desktops");
		
		log.info("Order 01 - Step 3: Verify the current page is Desktops");
		verifyEquals(productListPage.getCurrentPageTitle(driver), "Desktops");
		
		log.info("Order 01 - Step 4: Click to Build your own computer");
		productDetailPage = productListPage.clickToProductTitle(driver, buildPCProductName);
		
		log.info("Order 01 - Step 5: Select option for your computer");
		productDetailPage.selectDropdownByName(driver, "product_attribute_1", processor1);
		productDetailPage.selectDropdownByName(driver, "product_attribute_2", ram1);
		productDetailPage.checkToCheckboxRadioButtonByLabel(driver, hdd1);
		productDetailPage.checkToCheckboxRadioButtonByLabel(driver, os1);
		productDetailPage.checkToCheckboxRadioButtonByLabel(driver, software1);
		productDetailPage.checkToCheckboxRadioButtonByLabel(driver, software2);
		productDetailPage.checkToCheckboxRadioButtonByLabel(driver, software3);
		
		log.info("Order 01 - Step 6: Click Add to cart button");
		productDetailPage.clickButtonByLabel(driver, "Add to cart");
		
		log.info("Order 01 - Step 7: Verify the add to cart success message display");
		verifyEquals(productDetailPage.getSuccessMessage(driver), "The product has been added to your shopping cart");
		
		log.info("Order 01 - Step 8: Click to close button");
		productDetailPage.clickToCloseSuccessMessageButton(driver);
		
		log.info("Order 01 - Step 9: Hover the Shopping Cart header menu");
		productDetailPage.hoverToHeaderLinkByClass(driver, "ico-cart");
		
		log.info("Order 01 - Step 10: Verify the product was added");
		verifyTrue(productDetailPage.isMiniShoppingCartDisplay(driver));
		verifyEquals(productDetailPage.getAddProductMessageDisplay(driver), "There are 1 item(s) in your cart.");
		verifyEquals(productDetailPage.getProductNameInMiniCart(driver), buildPCProductName);
		verifyEquals(productDetailPage.getAttributeOfProduct(driver), "Processor: " + processor1 + "\nRAM: " + ram1 + "\nHDD: " + hdd1 + "\nOS: " + os1 + "\nSoftware: " + software1 + "\nSoftware: " + software2 + "\nSoftware: " + software3);
		verifyEquals(productDetailPage.getProductUnitPrice(driver), unitPrice1);
		verifyEquals(productDetailPage.getProductQuantity(driver), quantity);
		verifyEquals(productDetailPage.getSubPrice(driver), subPrice1);
	}
	
	@Test
	public void Order_02_Edit_Product_In_Shopping_Cart(){
		log.info("Order 02 - Step 1: Click to Shopping cart header link");
		productDetailPage.clickToHeaderLinkByClass(driver, "ico-cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("Order 02 - Step 2: Verify the current page is Shopping cart");
		verifyEquals(shoppingCartPage.getCurrentPageTitle(driver), "Shopping cart");
		
		log.info("Order 02 - Step 3: Click to Edit button");
		productDetailPage = shoppingCartPage.clickEditButtonByProductName(buildPCProductName);
		
		log.info("Order 02 - Step 4: Select option for your computer");
		productDetailPage.selectDropdownByName(driver, "product_attribute_1", processor2);
		productDetailPage.selectDropdownByName(driver, "product_attribute_2", ram2);
		productDetailPage.checkToCheckboxRadioButtonByLabel(driver, hdd2);
		productDetailPage.checkToCheckboxRadioButtonByLabel(driver, os2);
		productDetailPage.checkToCheckboxRadioButtonByLabel(driver, software1);
		productDetailPage.uncheckToCheckboxButtonByLabel(driver, software2);
		productDetailPage.uncheckToCheckboxButtonByLabel(driver, software3);
		
		log.info("Order 02 - Step 5: Click Update button");
		productDetailPage.clickButtonByLabel(driver, "Update");
		
		log.info("Order 02 - Step 6: Verify the add to cart success message display");
		verifyEquals(productDetailPage.getSuccessMessage(driver), "The product has been added to your shopping cart");
		
		log.info("Order 01 - Step 7: Click to close button");
		productDetailPage.clickToCloseSuccessMessageButton(driver);
		
		log.info("Order 02 - Step 8: Hover the Shopping Cart header menu");
		productDetailPage.hoverToHeaderLinkByClass(driver, "ico-cart");
		
		log.info("Order 02 - Step 9: Verify the product was updated with correct data");
		verifyTrue(productDetailPage.isMiniShoppingCartDisplay(driver));
		verifyEquals(productDetailPage.getAddProductMessageDisplay(driver), "There are 1 item(s) in your cart.");
		verifyEquals(productDetailPage.getProductNameInMiniCart(driver), buildPCProductName);
		verifyEquals(productDetailPage.getAttributeOfProduct(driver), "Processor: " + processor2 + "\nRAM: " + ram2 + "\nHDD: " + hdd2 + "\nOS: " + os2 + "\nSoftware: " + software1);
		verifyEquals(productDetailPage.getProductUnitPrice(driver), unitPrice2);
		verifyEquals(productDetailPage.getProductQuantity(driver), quantity);
		verifyEquals(productDetailPage.getSubPrice(driver), subPrice2);
	}
	
	@Test
	public void Order_03_Remove_Product_In_Shopping_Cart(){
		log.info("Order 03 - Step 1: Click to Shopping cart header link");
		productDetailPage.clickToHeaderLinkByClass(driver, "ico-cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("Order 03 - Step 2: Verify the current page is Shopping cart");
		verifyEquals(shoppingCartPage.getCurrentPageTitle(driver), "Shopping cart");
		
		log.info("Order 03 - Step 3: Click to Remove button");
		shoppingCartPage.clickRemoveButtonByProductName(buildPCProductName);
		
		log.info("Order 03 - Step 4: Verify the Product not exist in the Shopping Cart page");
		verifyTrue(shoppingCartPage.isProductNotExistInTableByProductName(driver, buildPCProductName));
		
		log.info("Order 03 - Step 5: Verify body table displays with message: Your Shopping Cart is empty!");
		verifyEquals(shoppingCartPage.getBodyTableData(driver, "page shopping-cart-page"), "Your Shopping Cart is empty!");
	}
	
	@Test
	public void Order_04_Update_Shopping_Cart(){
		log.info("Order 04 - Step 1: Hover on Coputer menu");
		shoppingCartPage.hoverToMenuItemByLabel(driver, "Computers");
		
		log.info("Order 04 - Step 2: Click on Desktop submenu");
		productListPage = shoppingCartPage.clickToSubmenuInHeaderMenuByLabel(driver, "Computers", "Desktops");
		
		log.info("Order 04 - Step 3: Verify the current page is Desktops");
		verifyEquals(productListPage.getCurrentPageTitle(driver), "Desktops");
		
		log.info("Order 04 - Step 4: Click to Lenovo IdedPC");
		productDetailPage = productListPage.clickToProductTitle(driver, lenovoPCName);
		
		log.info("Order 04 - Step 5: Click Add to cart button");
		productDetailPage.clickButtonByLabel(driver, "Add to cart");
		
		log.info("Order 04 - Step 6: Verify the add to cart success message display");
		verifyEquals(productDetailPage.getSuccessMessage(driver), "The product has been added to your shopping cart");
		
		log.info("Order 04 - Step 7: Click to close button");
		productDetailPage.clickToCloseSuccessMessageButton(driver);
		
		log.info("Order 04 - Step 8: Click to Shopping cart header link");
		productDetailPage.clickToHeaderLinkByClass(driver, "ico-cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("Order 04 - Step 9: Verify the product exist in the Shopping Cart page");
		verifyTrue(shoppingCartPage.isProductExistInTableByProductName(driver, lenovoPCName));
		
		log.info("Order 04 - Step 10: Change product quantity");
		shoppingCartPage.changeProductQuantityByProductName("5", lenovoPCName);
		
		log.info("Order 04 - Step 11: Click update shopping cart button");
		shoppingCartPage.clickButtonByLabel(driver, "Update shopping cart");
		
		log.info("Order 04 - Step 12: Verify the total price is correct");
		verifyEquals(shoppingCartPage.getSubTotalPriceByProductName(lenovoPCName), "$2,500.00");
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}