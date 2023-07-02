package com.nopcommerce.learning;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.user.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;

public class Level_16_Share_Cookie extends BaseTest{
	// When run with cookie the class Common Register New Account always run in the first
	// 1. register new account -> get cookie
	// 2. add cookie to the page and reload page
	WebDriver driver;
	UserHomePageObject homePage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}
	
	@Test
	public void TC_02_Login_With_Correct_Data() {
		homePage.setCookieAndReloadPage(driver, Common_Register_NewAccount.ALLCookies);
		
		log.info("Login - Step 5: Verify the my account page is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}