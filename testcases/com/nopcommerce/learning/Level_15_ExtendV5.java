package com.nopcommerce.learning;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import reportConfig.ExtentTestManagerV5;

public class Level_15_ExtendV5 extends BaseTest{

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
	public void TC_01_Register_With_Valid_Information(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");

		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 2: Enter the first name");
		registerPage.inputToFirstNameTextbox(firstName);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 3: Enter the last name");
		registerPage.inputToLastNameTextbox(lastName);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 4: Enter the email");
		registerPage.inputToEmailTextbox(email);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 5: Enter the password");
		registerPage.inputToPasswordTextbox(password);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 6: Enter the confirm password");
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 7: Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 8: Verify the register success message displays");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 9: Back to Home page");
		homePage = registerPage.clickToContinueButton();
	}
	
	@Test
	public void TC_02_Login_With_Correct_Data(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "TC_01_Register_With_Valid_Information");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 1: Click to Login link to clear data");
		loginPage = homePage.clickToLoginLink();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 2: Input correct email");
		loginPage.inputToEmailTextbox(email);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 3: Input correct password");
		loginPage.inputToPasswordTextbox(password);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 4: Click to Login button");
		loginPage.clickToLoginButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 5: Verify the my account page is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}