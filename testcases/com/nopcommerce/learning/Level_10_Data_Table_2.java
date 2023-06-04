package com.nopcommerce.learning;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.admin.AdminCustomerPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserRegisterPageObject;

public class Level_10_Data_Table_2 extends BaseTest{
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminCustomerPageObject adminCustomerPage;
	
	private String firstName, lastName, email, password, confirmPassword;
	private String adminEmail, adminPassword;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Elon";
		lastName = "Musk";
		email = "elonmusk" + getRandomNumber() + "@gmail.com";
		password = "Abc13579";
		confirmPassword = "Abc13579";
		adminEmail = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void DataTable_01_Register_New_Customer() {
		System.out.println("Register 01 - Step 1: Click to register link");
		registerPage = homePage.clickToRegisterLink();
		
		System.out.println("Register 01 - Step 3: Enter the valid information");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		
		System.out.println("Register 01 - Step 4: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register 01 - Step 5: Verify the register success message displays");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Register 01 - Step 6: Back to Home page");
		homePage = registerPage.clickToContinueButton();
	}
	
	@Test
	public void DataTable_02_Customer_Displays_In_Customer_List() {
		System.out.println("Swith To Admin Page - Step 1: Open admin page");
		homePage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL);
		adminLoginPage = pageObjects.admin.PageGeneratorManager.getAdminLoginPage(driver);
		
		System.out.println("Swith To Admin Page - Step 2: Login with admin account"); 
		adminDashboardPage = adminLoginPage.loginWithAdminAccount(adminEmail, adminPassword);
		
		System.out.println("Swith To Admin Page - Step 3: Verify the dashboard page is displayed");
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
		
		adminDashboardPage.clickToLeftMenuByLabel(driver, "Customers");
		Assert.assertTrue(adminDashboardPage.isSelectedLeftMenuByLabel(driver, "Customers"));
		
		adminDashboardPage.clickToSubLeftMenuByLabel(driver, "Customers");
		adminCustomerPage = pageObjects.admin.PageGeneratorManager.getAdminCustomerPage(driver);
		adminCustomerPage.inputToTextboxById(driver, email, "SearchEmail");
		SleepInSecond(2);
		adminCustomerPage.clickToSearchButton();
		adminCustomerPage.scrollToBottomPage(driver);
		Assert.assertTrue(adminCustomerPage.isCustomerInformationDisplayWithEmailAndName(email, firstName + " " + lastName));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}