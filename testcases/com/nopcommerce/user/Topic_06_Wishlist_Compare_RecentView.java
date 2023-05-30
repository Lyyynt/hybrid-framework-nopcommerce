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

public class Topic_06_Wishlist_Compare_RecentView extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserProductListPageObject productListPage;
	UserProductDetailObject productDetailPage;
	String productName;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		productName = "Apple MacBook Pro 13-inch";
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
		
		log.info("Pre-condition - Step 6: Hover to Computers menu");
		homePage.hoverToMenuItemByLabel("Computers");
		
		log.info("Pre-condition - Step 7: Click to Notebooks submenu in Computers menu");
		productListPage = homePage.clickToSubmenuInHeaderMenuByLabel("Computers", "Notebooks");
		
		log.info("Pre-condition - Step 8: Verify current page is Notebooks");
		verifyEquals(productListPage.getCurrentPageTitle(), "Notebooks");
		
		productDetailPage = productListPage.clickToProductTitle(productName);
	}
	
	@Test
	public void Wishlist_01_Add_Product_To_Wishlist(){
		productDetailPage.clickToButtonByTextAndProductName("Add to wishlist");
		verifyEquals(productDetailPage.getSuccessMessage(driver), "The product has been added to your wishlist");
		productDetailPage.clickToCloseSuccessMessageButton(driver);
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}