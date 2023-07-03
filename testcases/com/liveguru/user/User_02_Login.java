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
	public void User_TC05_Login_With_Empty_Data() {
		log.info("User 05 - Step 1: Click to My Account footer link");
		homePage.clickToFooterLinkByLabel(driver, "My Account");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("User 05 - Step 2: Click to Login button");
		loginPage.clickToButtonByLabel(driver, "Login");
		
		log.info("User 05 - Step 3: Verify the error message with Email Address field");
		verifyEquals(loginPage.getErrorMessageByFieldLabel(driver, "Email Address"), "This is a required field.");
		
		log.info("User 05 - Step 4: Verify the error message with password field");
		verifyEquals(loginPage.getErrorMessageByFieldLabel(driver, "Password"), "This is a required field.");
		
	}
	
	@Test
	public void User_TC06_Login_With_Incorrect_Password() {
		log.info("User 06 - Step 1: Input to Email Address textbox");
		loginPage.inputToTextboxWithValue(driver, "Email Address", User_01_Register.email);
		
		log.info("User 06 - Step 2: Input to Password textbox with incorrect data");
		loginPage.inputToTextboxWithValue(driver, "Password", "111222");
		
		log.info("User 06 - Step 3: Click to Login button");
		loginPage.clickToButtonByLabel(driver, "Login");
		
		log.info("User 06 - Step 4: Login not successful with message");
		verifyEquals(loginPage.getErrorMessage(driver), "Invalid login or password.");
	}

	@Test
	public void User_TC07_Login_Successful() {
		log.info("User 07 - Step 1: Input to Email Address textbox");
		loginPage.inputToTextboxWithValue(driver, "Email Address", User_01_Register.email);
		
		log.info("User 07 - Step 2: Input to Password textbox");
		loginPage.inputToTextboxWithValue(driver, "Password", User_01_Register.password);
		
		log.info("User 07 - Step 3: Click to Login button");
		loginPage.clickToButtonByLabel(driver, "Login");
		myAccountPage = PageGeneratorManager.getMyDashboardPage(driver);
		
		log.info("User 07 - Step 4: Verify the page title correct");
		verifyEquals(myAccountPage.getPageTitle(driver), "My Account");
		
		log.info("User 07 - Step 5: Verify register successful");
		verifyEquals(myAccountPage.getWelcomeMessage(driver), "Hello, " + User_01_Register.fullName + "!");
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
