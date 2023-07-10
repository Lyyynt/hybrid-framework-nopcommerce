package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveguru.user.HomePO;
import pageObjects.liveguru.user.LoginPO;
import pageObjects.liveguru.user.MyAccountPO;
import pageObjects.liveguru.user.PageGeneratorManager;
import pageObjects.liveguru.user.ProductListPO;

public class User_03_ProductList extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-Condition - Step 1: Click to My Account footer link");
		homePage.clickToFooterLinkByLabel(driver, "My Account");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Pre-Condition - Step 2: Input to Email Address textbox");
		loginPage.inputToTextboxWithValue(driver, "Email Address", User_01_Register.email);
		
		log.info("Pre-Condition - Step 3: Input to Password textbox");
		loginPage.inputToTextboxWithValue(driver, "Password", User_01_Register.password);
		
		log.info("Pre-Condition - Step 4: Click to Login button");
		loginPage.clickToButtonByLabel(driver, "Login");
		myAccountPage = PageGeneratorManager.getMyDashboardPage(driver);
		
		log.info("Pre-Condition - Step 5: Click to Mobile header navigation");
		myAccountPage.clickToHeaderNavigationByLabel(driver, "Mobile");
		productListPage = PageGeneratorManager.getProductListPage(driver);
		
	}
	
	@Test
	public void User_TC08_Sort_With_Name_And_DESC() {
		log.info("TC08 - Step 1: Click to Mobile header navigation");
		productListPage.clickToHeaderNavigationByLabel(driver, "Mobile");
		
		log.info("TC08 - Step 2: Select sort by name");
		productListPage.selectDropdownInProductListByTitle("Sort By", "Name");
		
		log.info("TC08 - Step 3: Select ascending direction is DESC");
		productListPage.selectAscendingDirection("DESC");
		
		log.info("TC08 - Step 4: Verify sort successful");
		verifyTrue(productListPage.isNameSortedByTypeSort("DESC"));
	}
	
	@Test
	public void User_TC09_Sort_With_Name_ASC() {
		log.info("TC09 - Step 1: Click to Mobile header navigation");
		productListPage.clickToHeaderNavigationByLabel(driver, "Mobile");
		
		log.info("TC09 - Step 2: Select sort by price");
		productListPage.selectDropdownInProductListByTitle("Sort By", "Name");
		
		log.info("TC09 - Step 3: Select ascending direction is ASC");
		productListPage.selectAscendingDirection("ASC");
		
		log.info("TC09 - Step 4: Verify sort successful");
		verifyTrue(productListPage.isNameSortedByTypeSort("ASC"));
	}
	
	@Test
	public void User_TC10_Sort_With_Price_And_DESC() {
		log.info("TC10 - Step 1: Click to Mobile header navigation");
		productListPage.clickToHeaderNavigationByLabel(driver, "Mobile");
		
		log.info("TC10 - Step 2: Select sort by price");
		productListPage.selectDropdownInProductListByTitle("Sort By", "Price");
		
		log.info("TC10 - Step 3: Select ascending direction is DESC");
		productListPage.selectAscendingDirection("DESC");
		
		log.info("TC10 - Step 4: Verify sort successful");
		verifyTrue(productListPage.isPriceSortedByTypeSort("DESC"));
	}
	
	
	@Test
	public void User_TC11_Sort_With_Price_ASC() {
		log.info("TC11 - Step 1: Click to Mobile header navigation");
		productListPage.clickToHeaderNavigationByLabel(driver, "Mobile");
		
		log.info("TC11 - Step 2: Select sort by price");
		productListPage.selectDropdownInProductListByTitle("Sort By", "Price");
		
		log.info("TC11 - Step 3: Select ascending direction is ASC");
		productListPage.selectAscendingDirection("ASC");
		
		log.info("TC11 - Step 4: Verify sort successful");
		verifyTrue(productListPage.isPriceSortedByTypeSort("ASC"));
	}
	
	@Test
	public void User_TC12_Verify_Item_Number() {
		log.info("TC12 - Step 1: Click to Mobile header navigation");
		productListPage.clickToHeaderNavigationByLabel(driver, "Mobile");
		
		log.info("TC12 - Step 2: Verify the item number displayed correct");
		verifyTrue(productListPage.isItemNumberCorrect());
	}
	
	@Test
	public void User_TC13_View_As_List() {
		log.info("TC13 - Step 1: Click to Mobile header navigation");
		productListPage.clickToHeaderNavigationByLabel(driver, "Mobile");
		
		log.info("TC13 - Step 2: Select view as grid option");
		productListPage.selectViewAsOptionByTitle("List");
		
		log.info("TC13 - Step 3: The product displays with list mode");
		verifyTrue(productListPage.isProductDisplayWithList());
	}
	
	@Test
	public void User_TC14_View_As_Grid() {
		log.info("TC14 - Step 1: Click to Mobile header navigation");
		productListPage.clickToHeaderNavigationByLabel(driver, "Mobile");
		
		log.info("TC14 - Step 2: Select view as grid option");
		productListPage.selectViewAsOptionByTitle("Grid");
		
		log.info("TC14 - Step 3: The product displays with grid mode");
		verifyTrue(productListPage.isProductDisplayWithGrid());
	}
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver("local");
	}

	private WebDriver driver;
	private HomePO homePage;
	private LoginPO loginPage;
	private MyAccountPO myAccountPage;
	private ProductListPO productListPage;
}
