package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserCompareProduct;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserProductDetailObject;
import pageObjects.user.UserProductListPageObject;
import pageObjects.user.UserShoppingCartPageObject;
import pageObjects.user.UserWishlistPageObject;

public class Topic_06_Wishlist_Compare_RecentView extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserProductListPageObject productListPage;
	UserProductDetailObject productDetailPage;
	UserWishlistPageObject wishlistPage;
	UserShoppingCartPageObject shoppingCartPage;
	UserCompareProduct compareProductPage;
	
	String macbookAppleProduct, asusLaptopProduct;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		macbookAppleProduct = "Apple MacBook Pro 13-inch";
		asusLaptopProduct = "Asus N551JK-XO076H Laptop";
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
		homePage.hoverToMenuItemByLabel(driver, "Computers");
		
		log.info("Pre-condition - Step 7: Click to Notebooks submenu in Computers menu");
		productListPage = homePage.clickToSubmenuInHeaderMenuByLabel(driver, "Computers", "Notebooks");
		
		log.info("Pre-condition - Step 8: Verify current page is Notebooks");
		verifyEquals(productListPage.getCurrentPageTitle(driver), "Notebooks");
		
		log.info("Pre-condition - Step 9: Click to product name");
		productDetailPage = productListPage.clickToProductTitle(macbookAppleProduct);
	}
	
	@Test
	public void WishlistCompareRecent_01_Add_Product_To_Wishlist(){
		log.info("Wishlist 01 - Step 1: Click Add to wishlist button");
		productDetailPage.clickToButtonByTextAndProductName("Add to wishlist");
		
		log.info("Wishlist 01 - Step 2: Verify add success message display");
		verifyEquals(productDetailPage.getSuccessMessage(driver), "The product has been added to your wishlist");
		
		log.info("Wishlist 01 - Step 3: Click close toast message button");
		productDetailPage.clickToCloseSuccessMessageButton(driver);
		
		log.info("Wishlist 01 - Step 4: Click to Wishlist header link");
		productDetailPage.clickToHeaderLinkByClass(driver, "ico-wishlist");
		wishlistPage = PageGeneratorManager.getUserWishlistPage(driver);
		
		log.info("Wishlist 01 - Step 5: Verify product name is exist in table");
		verifyTrue(wishlistPage.isProductExistInTableByProductName(driver, macbookAppleProduct));
		
		log.info("Wishlist 01 - Step 6: Click share information link");
		wishlistPage.clickToShareInformationLink();
		
		log.info("Wishlist 01 - Step 7: Verify the wishlist of user was shared");
		verifyEquals(wishlistPage.getCurrentPageTitle(driver), "Wishlist of " + Common_Register_NewAccount.FIRSTNAME + " " + Common_Register_NewAccount.LASTNAME);
	}
	
	@Test
	public void WishlistCompareRecent_02_Add_Product_To_Cart_From_Wishlist(){
		log.info("Wishlist 02 - Step 1: Back to my wishlist page");
		wishlistPage.backToPage(driver);
		
		log.info("Wishlist 02 - Step 2: Verify current page is Wishlist");
		verifyEquals(productListPage.getCurrentPageTitle(driver), "Wishlist");
		
		log.info("Wishlist 02 - Step 3: Select checkbox by product name");
		wishlistPage.clickToCheckboxByProductName(macbookAppleProduct);
		
		log.info("Wishlist 02 - Step 4: Click Add to cart button");
		wishlistPage.clickButtonByLabel(driver, "Add to cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("Wishlist 02 - Step 5: Verify current page is Shopping cart");
		verifyEquals(shoppingCartPage.getCurrentPageTitle(driver), "Shopping cart");
		
		log.info("Wishlist 02 - Step 6: Veridy product name is exist in table");
		verifyTrue(shoppingCartPage.isProductExistInTableByProductName(driver, macbookAppleProduct));
		
		log.info("Wishlist 02 - Step 7: Click to Wishlist header link");
		shoppingCartPage.clickToHeaderLinkByClass(driver, "ico-wishlist");
		wishlistPage = PageGeneratorManager.getUserWishlistPage(driver);
		
		log.info("Wishlist 02 - Step 8: Veridy product name is NOT exist in table");
		verifyTrue(shoppingCartPage.isProductNotExistInTableByProductName(driver, macbookAppleProduct));
	}
	
	@Test
	public void WishlistCompareRecent_03_Remove_Product_From_Wishlist(){
		log.info("Wishlist 03 - Step 1: Add product to Wishlist");
		shoppingCartPage.hoverToMenuItemByLabel(driver, "Computers");
		productListPage = shoppingCartPage.clickToSubmenuInHeaderMenuByLabel(driver, "Computers", "Notebooks");
		productDetailPage = productListPage.clickToProductTitle(macbookAppleProduct);
		productDetailPage.clickToButtonByTextAndProductName("Add to wishlist");
		verifyEquals(productDetailPage.getSuccessMessage(driver), "The product has been added to your wishlist");
		productDetailPage.clickToCloseSuccessMessageButton(driver);
		productDetailPage.clickToHeaderLinkByClass(driver, "ico-wishlist");
		wishlistPage = PageGeneratorManager.getUserWishlistPage(driver);
		verifyTrue(wishlistPage.isProductExistInTableByProductName(driver, macbookAppleProduct));
		
		log.info("Wishlist 03 - Step 2: Click remove button by product name");
		wishlistPage.clickToRemoveButtonByProductName(macbookAppleProduct);
		
		log.info("Wishlist 03 - Step 3: Verify product is NOT exist in table");
		verifyTrue(shoppingCartPage.isProductNotExistInTableByProductName(driver, macbookAppleProduct));
		
		log.info("Wishlist 03 - Step 3: Verify body table displays with message: The wishlis is empty!");
		verifyEquals(wishlistPage.getBodyTableData(driver, "page wishlist-page"), "The wishlist is empty!");
	}
	
	@Test
	public void WishlistCompareRecent_04_Add_Product_To_Compare(){
		log.info("Compare 01 - Step 1: Go to product list page");
		wishlistPage.hoverToMenuItemByLabel(driver, "Computers");
		productListPage = wishlistPage.clickToSubmenuInHeaderMenuByLabel(driver, "Computers", "Notebooks");
		
		log.info("Compare 01 - Step 2: Click add to compare list with macbook product");
		productListPage.clickToButtonInProductItemByProductName(driver, macbookAppleProduct, "Add to compare list");
		
		log.info("Compare 01 - Step 3: Verify add success message display");
		verifyEquals(productDetailPage.getSuccessMessage(driver), "The product has been added to your wishlist");
		
		log.info("Compare 01 - Step 4: Click close toast message button");
		productDetailPage.clickToCloseSuccessMessageButton(driver);
		
		log.info("Compare 01 - Step 6: Click add to compare list with asus product");
		productListPage.clickToButtonInProductItemByProductName(driver, asusLaptopProduct, "Add to compare list");
		
		log.info("Wishlist 01 - Step 7: Verify add success message display");
		verifyEquals(productDetailPage.getSuccessMessage(driver), "The product has been added to your wishlist");
		
		log.info("Wishlist 01 - Step 8: Click close toast message button");
		productDetailPage.clickToCloseSuccessMessageButton(driver);
		
		productDetailPage.clickToFooterLink(driver, "Compare products list");
		compareProductPage = PageGeneratorManager.getCompareProductPage(driver);
		
//		verifyTrue(compareProductPage.isSheetTextDisplayByRowClassAndColumnIndex("remove-product", "2", "Remove"));
//		verifyTrue(compareProductPage.isSheetTextDisplayByRowClassAndColumnIndex("remove-product", "3", "Remove"));
		verifyTrue(compareProductPage.isSheetTextDisplayByRowClassAndColumnIndex("product-name", "3", macbookAppleProduct));
		verifyTrue(compareProductPage.isSheetTextDisplayByRowClassAndColumnIndex("product-name", "2", asusLaptopProduct));
//		verifyTrue(compareProductPage.isSheetTextDisplayByRowClassAndColumnIndex("product-price", "3", "$1,500.00"));
//		verifyTrue(compareProductPage.isSheetTextDisplayByRowClassAndColumnIndex("product-price", "2", "$1,800.00"));
		verifyTrue(compareProductPage.isClearListButtonDipslay());
		
		compareProductPage.clickClearListButton();
		verifyEquals(compareProductPage.getBodyTableData(driver, "page compare-products-page"), "You have no items to compare.");
		verifyTrue(compareProductPage.isSheetTextUndisplayByRowClassAndColumnIndex("product-name", "3", macbookAppleProduct));
		verifyTrue(compareProductPage.isSheetTextUndisplayByRowClassAndColumnIndex("product-name", "2", asusLaptopProduct));
		
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}