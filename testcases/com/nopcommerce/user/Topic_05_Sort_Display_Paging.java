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
		
		homePage.clickToHeaderMenuByLabel("Computers");
		productListPage = homePage.clickToSubmenuInHeaderMenuByLabel("Computers", "Notebooks");
		verifyEquals(productListPage.getCurrentPageTitle(), "Notebooks");
	}
	
	@Test
	public void Sort_01_From_A_To_Z() throws Exception {
		productListPage.selectSortByLabel("Name: A to Z");
		verifyTrue(productListPage.isProductNameWasSortedByLabel("Name: A to Z"));
	}
	
	@Test
	public void Sort_02_From_Z_To_A() throws Exception {
		productListPage.selectSortByLabel("Name: Z to A");
		verifyTrue(productListPage.isProductNameWasSortedByLabel("Name: Z to A"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
