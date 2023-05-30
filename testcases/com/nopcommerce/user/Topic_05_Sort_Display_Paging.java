package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserProductListPageObject;


public class Topic_05_Sort_Display_Paging extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserProductListPageObject productListPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		homePage.hoverToMenuItemByLabel("Computers");
		productListPage = homePage.clickToSubmenuInHeaderMenuByLabel("Computers", "Notebooks");
		verifyEquals(productListPage.getCurrentPageTitle(), "Notebooks");
	}
	
	@Test
	public void Sort_01_Name_From_A_To_Z() throws Exception {
		productListPage.selectDropdownByName(driver, "Name: A to Z", "products-orderby");
		verifyTrue(productListPage.isProductNameWasSortedByLabel("Name: A to Z"));
	}
	
	@Test
	public void Sort_02_Name_From_Z_To_A() throws Exception {
		productListPage.selectDropdownByName(driver, "Name: Z to A", "products-orderby");
		verifyTrue(productListPage.isProductNameWasSortedByLabel("Name: Z to A"));
	}
	
	@Test
	public void Sort_03_Price_Low_To_High() throws Exception {
		productListPage.selectDropdownByName(driver, "Price: Low to High", "products-orderby");
		verifyTrue(productListPage.isProductNameWasSortedByPrice("Price: Low to High"));
	}
	
	@Test
	public void Sort_04_Price_High_To_Low() throws Exception {
		productListPage.selectDropdownByName(driver, "Price: High to Low", "products-orderby");
		verifyTrue(productListPage.isProductNameWasSortedByPrice("Price: High to Low"));
	}
	
	@Test
	public void Sort_05_Display_With_3_Items() throws Exception {
		productListPage.selectDropdownByName(driver, "3", "products-pagesize");
		verifyTrue(productListPage.getDisplayedProductNumber() <= 3);
		verifyEquals(productListPage.getCurrentPagingNumber(), "1");
		verifyTrue(productListPage.isPagingButtonDisplayByClass("next-page"));
		
		productListPage.clickToPagingButtonByID("individual-page");
		verifyEquals(productListPage.getCurrentPagingNumber(), "2");
		verifyTrue(productListPage.isPagingButtonDisplayByClass("previous-page"));
	}
	
	@Test
	public void Sort_06_Display_With_6_Items() throws Exception {
		productListPage.selectDropdownByName(driver, "6", "products-pagesize");
		verifyTrue(productListPage.getDisplayedProductNumber() <= 6);
		verifyTrue(productListPage.isPagingButtonUndisplayed());
	}
	
	@Test
	public void Sort_07_Display_With_9_Items() throws Exception {
		productListPage.selectDropdownByName(driver, "9", "products-pagesize");
		verifyTrue(productListPage.getDisplayedProductNumber() <= 9);
		verifyTrue(productListPage.isPagingButtonUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
