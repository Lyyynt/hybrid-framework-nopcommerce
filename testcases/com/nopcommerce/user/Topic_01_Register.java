package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.user.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Topic_01_Register extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
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
	public void Register_01_Empty_Data() {
		log.info("Register 01 - Step 1: Click to register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register 01 - Step 2: Click to register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register 01 - Step 3: Verify error message displays");
		verifyEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		verifyEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		verifyEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		verifyEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		verifyEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		homePage.openRegisterPage();
		
		log.info("Register 02 - Step 1: Enter the invalid email");
		registerPage.inputToEmailTextbox("@gmail.com");
		
		log.info("Register 02 - Step 2: Click to the register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register 02 - Step 3: Verify the error message is \"Wrong email");
		verifyEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}
	
	@Test
	public void Register_03_Valid_Information() {
		homePage.openRegisterPage();
		
		log.info("Register 03 - Step 1: Enter the valid information");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		
		log.info("Register 03 - Step 2: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register 03 - Step 3: Verify the register success message displays");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register 03 - Step 4: Back to Home page");
		homePage = registerPage.clickToContinueButton();
	}
	
	@Test
	public void Register_04_Exist_Email() {
		homePage.openRegisterPage();
		
		log.info("Register 04 - Step 1: Click to register link");
		registerPage =  homePage.clickToRegisterLink();
		
		log.info("Register 04 - Step 2: Enter the valid information with existing email");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		
		log.info("Register 04 - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register 04 - Step 4: Verify The specified email already exists message display");
		verifyEquals(registerPage.getExistEmailMessage(), "The specified email already exists");
	}
	
	@Test
	public void Register_05_Password_Length_Less_6() {
		homePage.openRegisterPage();
		
		log.info("Register 05 - Step 1: Enter the valid information with password length less 6 charactors");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox("abc12");
		registerPage.inputToConfirmPasswordTextbox("abc12");
		
		log.info("Register 05 - Step 2: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register 05 - Step 3: Verify existing email message display");
		verifyEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
	}
	
	@Test
	public void Register_06_Confirm_Password_Not_Match_Password() {
		homePage.openRegisterPage();
		
		log.info("Register 06 - Step 1: Enter the valid information with confirm password not match with password");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox("abc124");
		registerPage.inputToConfirmPasswordTextbox("abc125");
		
		log.info("Register 06 - Step 2: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register 06 - Step 3: Verify confirm password error message display");
		verifyEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver("local");
	}
}