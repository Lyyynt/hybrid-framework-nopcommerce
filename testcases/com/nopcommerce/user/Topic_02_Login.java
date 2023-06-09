package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;

public class Topic_02_Login extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	String firstName, lastName, email, password, confirmPassword, incorrectPassword;
	
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
		incorrectPassword = "123123123";
		
		// Pre-condition
		log.info("Pre-condition - Step 1: Enter the valid information");
		registerPage = homePage.clickToRegisterLink();
		log.info("Pre-condition - Step 2: Enter the valid information");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		log.info("Pre-condition - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Pre-condition - Step 4: Verify the register success message displays");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		log.info("Pre-condition - Step 5: Back to Home page");
		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void Login_01_Empty_Data() {
		log.info("Login 01 - Step 1: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login 01 - Step 2: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("Login 01 - Step 3: Verify the email error message displays");
		verifyEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.openLoginPage();
	
		log.info("Login 02 - Step 1: Click to Login link to clear data");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login 02 - Step 2: Input invalid email to email textbox");
		loginPage.inputToEmailTextbox("@gmail.com");
		
		log.info("Login 02 - Step 3: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("Login 02 - Step 4: Verify the email error message displays");
		verifyEquals(loginPage.getEmailErrorMessage(), "Wrong email");
		
	}
	
	@Test
	public void Login_03_Email_Not_Register() {
		homePage.openLoginPage();
		
		log.info("Login 03 - Step 1: Click to Login link to clear data");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login 03 - Step 2: Input email which was not registered in textbox");
		loginPage.inputToEmailTextbox("elonmusk" + getRandomNumber() + "@gmail.com");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login 03 - Step 3: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("Login 03 - Step 4: Verify the email not found message displays");
		verifyEquals(loginPage.getEmailNotFoundMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_04_Correct_Email_And_No_Password() {
		homePage.openLoginPage();
		
		log.info("Login 04 - Step 1: Click to Login link to clear data");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login 04 - Step 2: Input correct email and keep the password field is empty");
		loginPage.inputToEmailTextbox(email);
		
		log.info("Login 04 - Step 3: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("Login 04 - Step 4: Verify the email not found message displays");
		verifyEquals(loginPage.getEmailNotFoundMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_Correct_Email_And_Incorrect_Password() {
		homePage.openLoginPage();
		
		log.info("Login 05 - Step 1: Click to Login link to clear data");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login 05 - Step 2: Input correct email and incorrect password");
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		
		log.info("Login 05 - Step 3: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("Login 05 - Step 4: Verify the email not found message displays");
		verifyEquals(loginPage.getEmailNotFoundMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_06_Correct_Email_And_Correct_Password() {
		homePage.openLoginPage();
		
		log.info("Login 06 - Step 1: Click to Login link to clear data");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login 06 - Step 2: Input correct email and correct password");
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login 06 - Step 3: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("Login 06 - Step 4: Verify the email not found message displays");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}