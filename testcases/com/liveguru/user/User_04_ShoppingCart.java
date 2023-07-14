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
import pageObjects.liveguru.user.ProductDetailPO;
import pageObjects.liveguru.user.ProductListPO;
import pageObjects.liveguru.user.ShoppingCartPO;

public class User_04_ShoppingCart extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-Condition - Step 1: Click to My Account footer link");
		homePage.clickToFooterLinkByLabel(driver, "My Account");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Pre-Condition - Step 2: Input to Email Address textbox");
		loginPage.inputToTextboxWithValue(driver, "Email Address", "thuylinhnguyen.hust1@gmail.com");
		
		log.info("Pre-Condition - Step 3: Input to Password textbox");
		loginPage.inputToTextboxWithValue(driver, "Password", "111111");
		
		log.info("Pre-Condition - Step 4: Click to Login button");
		loginPage.clickToButtonByLabel(driver, "Login");
		myAccountPage = PageGeneratorManager.getMyDashboardPage(driver);
		
		log.info("Pre-Condition - Step 5: Click to Mobile header navigation");
		myAccountPage.clickToHeaderNavigationByLabel(driver, "Mobile");
		productListPage = PageGeneratorManager.getProductListPage(driver);
		
		log.info("Pre-Condition - Step 6: Get price of all product and store in the variable");
		iphonePrice = productListPage.getPriceByProductName("IPhone");
		samsungPrice = productListPage.getPriceByProductName("Samsung Galaxy");
		sonyPrice = productListPage.getPriceByProductName("Sony Xperia");
		coupon = "GURU50";
	}
	
	@Test
	public void User_15_Add_Product_From_Product_List() {
		log.info("User 15 - Step 1: Click add to cart button with product name: IPhone");
		shoppingCartPage = productListPage.addProductToShoppingCartByProductName("IPhone");
		
		log.info("User 15 - Step 2: Verify success message is: IPhone was added to your shopping cart.");
		verifyEquals(shoppingCartPage.getSuccessMessage(driver), "IPhone was added to your shopping cart.");
		
		log.info("User 15 - Step 3: Verify the current page is Shopping Cart");
		verifyEquals(shoppingCartPage.getPageUrl(driver), "Shopping Cart");
		
		log.info("User 15 - Step 4: Verify the product display in the first row of product list");
		verifyTrue(shoppingCartPage.isProductDisplayInPageWithRowNumber("1", "IPhone", iphonePrice));
	}
	
	@Test
	public void User_16_Add_Product_From_Product_Detail() {
		log.info("User 16 - Step 1: Open Product List page");
		shoppingCartPage.clickToHeaderNavigationByLabel(driver, "Mobile");
		productListPage = PageGeneratorManager.getProductListPage(driver);
		
		log.info("User 16 - Step 2: Open Product Detail page");
		productDetailPage = productListPage.openProductDetailByProductName("Samsung Galaxy");
		
		log.info("User 16 - Step 3: Click add to cart button");
		productDetailPage.clickToButtonByLabel(driver, "Add to Cart");
		
		log.info("User 16 - Step 4: Verify success message is: Samsung Galaxy was added to your shopping cart.");
		verifyEquals(shoppingCartPage.getSuccessMessage(driver), "Samsung Galaxy was added to your shopping cart.");
		
		log.info("User 16 - Step 5: Verify the current page is Shopping Cart");
		verifyEquals(shoppingCartPage.getPageUrl(driver), "Shopping Cart");
		
		log.info("User 16 - Step 6: Verify the product display in the first row of product list");
		verifyTrue(shoppingCartPage.isProductDisplayInPageWithRowNumber("1", "Samsung Galaxy", samsungPrice));
	}
	
	@Test
	public void User_17_Update_One_Product_Quantity() {
		log.info("User 17 - Step 1: Input new quantity for product");
		shoppingCartPage.inputToTextboxByProductNameAndColumnName("2", "IPhone", "Qty");
		
		log.info("User 17 - Step 2: Click to Update button");
		shoppingCartPage.clickToButtonByLabel(driver, "Update");
		
		log.info("User 17 - Step 2: Verify the sub-total price is corrected");
		verifyEquals(shoppingCartPage.getProductInformationOfProductNameAndColumnName("IPhone", "Subtotal"), iphonePrice*2);
	}
	
	@Test
	public void User_18_Update_Multiple_Product_Quantity() {
		log.info("User 18 - Step 1: Input new quantity for IPhone");
		shoppingCartPage.inputToTextboxByProductNameAndColumnName("4", "IPhone", "Qty");
		
		log.info("User 18 - Step 2: Input new quantity for Samsung Galaxy");
		shoppingCartPage.inputToTextboxByProductNameAndColumnName("4", "Samsung Galaxy", "Qty");
		
		log.info("User 18 - Step 3: Click Update Shopping Cart button");
		shoppingCartPage.clickToUpdateShoppingCartButton();
		
		log.info("User 18 - Step 4: Verify the sub-total price of IPhone is corrected");
		verifyEquals(shoppingCartPage.getProductInformationOfProductNameAndColumnName("IPhone", "Subtotal"), iphonePrice*4);
		
		log.info("User 18 - Step 5: Verify the sub-total price of Samsung Galaxy is corrected");
		verifyEquals(shoppingCartPage.getProductInformationOfProductNameAndColumnName("Samsung Galaxy", "Subtotal"), samsungPrice*4);
		
		log.info("User 18 - Step 6: Verify the total price is corrected");
		verifyEquals(shoppingCartPage.getGrandTotalPrice(), (iphonePrice + samsungPrice)*4);
	}
	
	@Test
	public void User_19_Apply_Discount_In_Shopping_Cart() {
		log.info("User 19 - Step 1: Input coupon to Discount Codes textbox");
		shoppingCartPage.inputToTextboxWithValue(driver, "Discount Codes", coupon);
		
		log.info("User 19 - Step 2: Click to Apply button");
		shoppingCartPage.clickToButtonByLabel(driver, "Apply");
		
		log.info("User 19 - Step 3: Verify the success message display: Coupon code GURU50 was applied.");
		verifyEquals(shoppingCartPage.getSuccessMessage(driver), "Coupon code \"" + coupon + "\" was applied.");
		
		log.info("User 19 - Step 4: Verify the discount price is corrected");
		verifyEquals(shoppingCartPage.getPriceByLabel("Discount"), (iphonePrice + samsungPrice)*4*0.05);
		
		log.info("User 19 - Step 5: Verify the grand total price is corrected");
		verifyEquals(shoppingCartPage.getGrandTotalPrice(), (iphonePrice + samsungPrice)*4*0.95);
	}
	
	@Test
	public void User_20_Continue_Shopping() {
		log.info("User 20 - Step 1: Click Continue Shopping link");
		shoppingCartPage.clickToButtonByLabel(driver, "Continue Shopping");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("User 20 - Step 2: Verify the title of current page is Home page");
		verifyEquals(homePage.getPageTitle(driver), "Home page");
		
	}
	
	@Test
	public void User_21_Delete_Product_From_Cart() {
		log.info("User 21 - Step 1: Click To cart button");
		homePage.clickToSkipLinkByLabel(driver, "Cart");
		
		log.info("User 21 - Step 2: Click to View Shopping Cart button in mini cart");
		homePage.clickButtonInMiniCart(driver, "View Shopping Cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("User 21 - Step 3: Click to Delete icon for IPhone product");
		shoppingCartPage.clickToDeleteIconByProductLabel("Samsung Galaxy");
		
		log.info("User 21 - Step 4: Verify the product is NOT display");
		verifyTrue(shoppingCartPage.isProductUndisplayByLabel("Samsung Galaxy"));
	}
	
	@Test
	public void User_22_Empty_Cart() {
		log.info("User 22 - Step 1: Click to Empty Cart button");
		shoppingCartPage.clickToButtonByLabel(driver, "Empty Cart");
		
		log.info("User 22 - Step 2: Get cart empty message");
		verifyEquals(shoppingCartPage.getEmptyCart(), "Shopping Cart is Empty");
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
	private ShoppingCartPO shoppingCartPage;
	private ProductDetailPO productDetailPage;
	private String coupon;
	private int iphonePrice, samsungPrice, sonyPrice;
}
