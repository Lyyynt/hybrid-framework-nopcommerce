package com.nopcommerce.learning;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;

public class Level_08_Switch_Role extends BaseTest{
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	
	private String userFirstName, userLastName, userEmail, userPassword, userConfirmPassword;
	private String adminEmail, adminPassword;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userFirstName = "Elon";
		userLastName = "Musk";
		userEmail = "elonmusk" + getRandomNumber() + "@gmail.com";
		userPassword = "Abc13579";
		userConfirmPassword = "Abc13579";
		adminEmail = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void TC_01_Register_With_Valid_Information() {
		System.out.println("Register - Step 1: Click to register link");
		userRegisterPage = userHomePage.clickToRegisterLink();
		
		System.out.println("Register - Step 2: Enter the valid information");
		userRegisterPage.inputToFirstNameTextbox(userFirstName);
		userRegisterPage.inputToLastNameTextbox(userLastName);
		userRegisterPage.inputToEmailTextbox(userEmail);
		userRegisterPage.inputToPasswordTextbox(userPassword);
		userRegisterPage.inputToConfirmPasswordTextbox(userConfirmPassword);
		
		System.out.println("Register - Step 3: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		System.out.println("Register - Step 4: Verify the register success message displays");
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Register - Step 5: Back to Home page");
		userHomePage = userRegisterPage.clickToContinueButton();
	}
	
	@Test
	public void TC_02_Login_With_Correct_Data() {
		System.out.println("Login - Step 1: Click to Login link to clear data");
		userLoginPage = userHomePage.clickToLoginLink();
		
		System.out.println("Login - Step 2: Input correct email and correct password");
		userLoginPage.inputToEmailTextbox(userEmail);
		userLoginPage.inputToPasswordTextbox(userPassword);
		
		System.out.println("Login - Step 3: Click to Login button");
		userLoginPage.clickToLoginButton();
		
		System.out.println("Login - Step 4: Verify the my account page is displayed");
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void TC_03_Switch_Admin_Page_With_Admin_Role() {
		System.out.println("Swith To Admin Page - Step 1: Open admin page");
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL);
		adminLoginPage = pageObjects.admin.PageGeneratorManager.getAdminLoginPage(driver);
		
		System.out.println("Swith To Admin Page - Step 2: Login with admin account"); 
		adminDashboardPage = adminLoginPage.loginWithAdminAccount(adminEmail, adminPassword);
		
		System.out.println("Swith To Admin Page - Step 3: Verify the dashboard page is displayed");
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}