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
import pageObjects.user.UserRegisterPageObject;

public class Level_14_Log_And_ReportNG extends BaseTest{

	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	String firstName, lastName, email, password, confirmPassword;
	
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
	}

	@Test
	public void TC_01_Register_With_Valid_Information() {
		log.info("Register - Step 1: Click to register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 2: Enter the first name");
		registerPage.inputToFirstNameTextbox(firstName);
		
		log.info("Register - Step 3: Enter the last name");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Register - Step 4: Enter the email");
		registerPage.inputToEmailTextbox(email);
		
		log.info("Register - Step 5: Enter the password");
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Register - Step 6: Enter the confirm password");
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		
		log.info("Register - Step 7: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 8: Verify the register success message displays");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register - Step 9: Back to Home page");
		homePage = registerPage.clickToContinueButton();
	}
	
	@Test
	public void TC_02_Login_With_Correct_Data() {
		log.info("Login - Step 1: Click to Login link to clear data");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login - Step 2: Input correct email");
		loginPage.inputToEmailTextbox(email);
		
		log.info("Login - Step 3: Input correct password");
		loginPage.inputToPasswordTextbox(password);
		
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