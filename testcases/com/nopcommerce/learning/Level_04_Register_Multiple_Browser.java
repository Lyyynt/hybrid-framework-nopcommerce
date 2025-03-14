package com.nopcommerce.learning;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_04_Register_Multiple_Browser extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	String firstName, lastName, email, password, confirmPassword;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = new UserHomePageObject(driver);
		
		firstName = "Elon";
		lastName = "Musk";
		email = "elonmusk" + getRandomNumber() + "@gmail.com";
		password = "Abc13579";
		confirmPassword = "Abc13579";
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register 01 - Step 1: Click to register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);
		
		System.out.println("Register 01 - Step 2: Click to register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register 01 - Step 3: Verify error message displays");
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Register 02 - Step 1: Enter the invalid email");
		registerPage.inputToEmailTextbox("@gmail.com");
		
		System.out.println("Register 02 - Step 2: Click to the register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register 02 - Step 3: Verify the error message is \"Wrong email");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}
	
	@Test
	public void Register_03_Valid_Information() {
		System.out.println("Register 03 - Step 1: Enter the valid information");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		
		System.out.println("Register 03 - Step 2: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register 03 - Step 3: Verify the register success message displays");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Register 03 - Step 4: Back to Home page");
		registerPage.clickToContinueButton();
		homePage = new UserHomePageObject(driver);
	}
	
	@Test
	public void Register_04_Exist_Email() {
		System.out.println("Register 04 - Step 1: Click to register link");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);
		
		System.out.println("Register 04 - Step 2: Enter the valid information with existing email");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		
		System.out.println("Register 04 - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register 04 - Step 4: Verify The specified email already exists message display");
		Assert.assertEquals(registerPage.getExistEmailMessage(), "The specified email already exists");
	}
	
	@Test
	public void Register_05_Password_Length_Less_6() {
		System.out.println("Register 05 - Step 1: Enter the valid information with password length less 6 charactors");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox("abc12");
		registerPage.inputToConfirmPasswordTextbox("abc12");
		
		System.out.println("Register 05 - Step 2: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register 05 - Step 3: Verify existing email message display");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
	}
	
	@Test
	public void Register_06_Confirm_Password_Not_Match_Password() {
		System.out.println("Register 06 - Step 1: Enter the valid information with confirm password not match with password");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox("abc124");
		registerPage.inputToConfirmPasswordTextbox("abc125");
		
		System.out.println("Register 06 - Step 2: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register 06 - Step 3: Verify confirm password error message display");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}
	
	public void SleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getRandomNumber() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(99999);
		return randomNumber;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}