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
import pageObjects.user.UserRegisterPageObject;

public class Level_06_Register_Generator_Manager_3 extends BaseTest{
	// Leve 3: về mặt test case ko khác gì level 2, tuy nhiên trong từng hàm thay vì khởi tạo page bởi câu lệnh new Object
	// tất cả các object đc khởi tạo trong PageGeneratorManager -> và khi cần khởi tạo thì gọi đến hàm getPageObject trong này
	// -> che giấu đc việc khởi tạo
	// -> tránh lặp code
	// -> dễ maintain nếu có thay đổi
	
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
		System.out.println("Register 01 - Step 1: Click to register link");
		registerPage = homePage.clickToRegisterLink();
		
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
		homePage = registerPage.clickToContinueButton();
	}
	
	@Test
	public void Register_04_Exist_Email() {
		System.out.println("Register 04 - Step 1: Click to register link");
		registerPage =  homePage.clickToRegisterLink();
		
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
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}