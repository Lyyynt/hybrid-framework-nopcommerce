package com.nopcommerce.learning;

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

public class Level_17_Custom_Close_Browser extends BaseTest{
	// When run with cookie the class Common Register New Account always run in the first
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		// giả lập trường hợp fail before test
		Assert.assertTrue(false);
	}
	
	@Test
	public void TC_02_Login_With_Correct_Data() {
		log.info("Login - Step 1: Click to Login link to clear data");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 2: Input correct email");
		loginPage.inputToEmailTextbox(Common_Register_NewAccount.EMAIL);
		
		log.info("Login - Step 3: Input correct password");
		loginPage.inputToPasswordTextbox(Common_Register_NewAccount.PASSWORD);
		
		log.info("Login - Step 4: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("Login - Step 5: Verify the my account page is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}