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

public class User_02_Login extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_TC03_Login_Successful() {
		log.info("User 03 - Step 1: Click to My Account footer link");
		homePage.clickToFooterLinkByLabel(driver, "My Account");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("User 03 - Step 2: Input to Email Address textbox");
		loginPage.inputToTextboxWithValue(driver, "Email Address", User_01_Register.email);
		
		log.info("User 03 - Step 3: Input to Password textbox");
		loginPage.inputToTextboxWithValue(driver, "Password", User_01_Register.password);
		
		log.info("User 03 - Step 4: Click to Login button");
		loginPage.clickToButtonByLabel(driver, "Login");
		myAccountPage = PageGeneratorManager.getMyDashboardPage(driver);
		
		log.info("User 03 - Step 6: Verify the page title correct");
		verifyEquals(myAccountPage.getPageTitle(driver), "My Account");
		
		log.info("User 03 - Step 5: Verify register successful");
		verifyEquals(myAccountPage.getWelcomeMessage(), "Hello, " + User_01_Register.fullName + "!");
	}
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver("local");
	}

	private WebDriver driver;
	private HomePO homePage;
	private LoginPO loginPage;
	private MyAccountPO myAccountPage;
}
