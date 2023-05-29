package com.nopcommerce.learning;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserCustomerInformationPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserMyAccountObject;
import pageObjects.user.UserRegisterPageObject;

public class Level_16_Share_Class_State extends BaseTest{
	// When run with cookie the class Common Register New Account always run in the first
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserMyAccountObject myaccountPage;
	UserCustomerInformationPageObject customerInformationPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
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
		driver.quit();
	}
}