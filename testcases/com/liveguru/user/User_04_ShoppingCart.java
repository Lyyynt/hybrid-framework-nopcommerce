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
		
	}
	
	@Test
	public void User_17_Update_One_Product_Quantity() {
		
	}
	
	@Test
	public void User_18_Update_Multiple_Product_Quantity() {
		
	}
	
	@Test
	public void User_19_Apply_Discount_In_Shopping_Cart() {
		
	}
	
	@Test
	public void User_20_Continue_Shopping() {
		
	}
	
	@Test
	public void User_21_Delete_Product_From_Cart() {
		
	}
	
	@Test
	public void User_22_Empty_Cart() {
		
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
	private int iphonePrice, samsungPrice, sonyPrice;
}
