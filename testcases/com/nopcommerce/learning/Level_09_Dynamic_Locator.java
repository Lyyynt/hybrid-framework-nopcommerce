package com.nopcommerce.learning;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInformationPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserMyAccountObject;
import pageObjects.user.UserMyProductReviewObject;
import pageObjects.user.UserRegisterPageObject;

public class Level_09_Dynamic_Locator extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserMyAccountObject myAccountPage;
	UserCustomerInformationPageObject customerInforPage;
	UserMyProductReviewObject myProductReviewPage;
	UserChangePasswordPageObject changePasswordPage;
	
	String firstName, lastName, email, password, confirmPassword;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Elon";
		lastName = "Musk";
		email = "elonmusk" + getRandomNumber() + "@gmail.com";
		password = "Abc13579";
		confirmPassword = "Abc13579";
	}

	@Test
	public void TC_01_Register_With_Valid_Information() {
		System.out.println("Register - Step 1: Click to register link");
		registerPage = homePage.clickToRegisterLink();
		
		System.out.println("Register - Step 2: Enter the valid information");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		
		System.out.println("Register - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register - Step 4: Verify the register success message displays");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Register - Step 5: Back to Home page");
		homePage = registerPage.clickToContinueButton();
	}
	
	@Test
	public void TC_02_Login_With_Correct_Data() {
		System.out.println("Login - Step 1: Click to Login link to clear data");
		loginPage = homePage.clickToLoginLink();
		
		System.out.println("Login - Step 2: Input correct email and correct password");
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		
		System.out.println("Login - Step 3: Click to Login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Login - Step 4: Verify the my account page is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void TC_03_Switch_Page_Before_Apply_Dynamic_Xpath() {
		System.out.println("Switch Page - Step 1: Go to my account page");
		myAccountPage = homePage.clickToMyAccountLink();
		
		System.out.println("Switch Page - Step 2: Go to my product review page");
		myProductReviewPage = myAccountPage.clickToMyProductReviewTab(driver);
		
		System.out.println("Switch Page - Step 3: Go to change password page");
		changePasswordPage = myProductReviewPage.clickToChangePasswordTab(driver);
		
		System.out.println("Switch Page - Step 4: Go to customer information page");
		customerInforPage = changePasswordPage.clickToCustomerInfoTab(driver);
	}
	
	@Test
	public void TC_04_Switch_Page_After_Apply_Dynamic_Xpath_1() {
		System.out.println("Switch Page - Step 1: Customer Infor -> My product review");
		myProductReviewPage = (UserMyProductReviewObject) customerInforPage.openPageInMyAccountArea(driver, "My product reviews");
		
		System.out.println("Switch Page - Step 2: My product review -> Change Password");
		changePasswordPage = (UserChangePasswordPageObject) myProductReviewPage.openPageInMyAccountArea(driver, "Change password");
		
		System.out.println("Switch Page - Step 3: Change Password -> Customer Infor");
		customerInforPage = (UserCustomerInformationPageObject) changePasswordPage.openPageInMyAccountArea(driver, "Customer info");
		
		System.out.println("Switch Page - Step 3: Customer Infor -> My product review");
		myProductReviewPage = (UserMyProductReviewObject) customerInforPage.openPageInMyAccountArea(driver, "My product reviews");
	}
	
	@Test
	public void TC_05_Switch_Page_After_Apply_Dynamic_Xpath_2() {
		// With many page -> can not using switch case to return page -> init page object in test case level
		System.out.println("Switch Page - Step 1: Customer Infor -> My product review");
		customerInforPage.openPageInMyAccountArea(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		System.out.println("Switch Page - Step 2: My product review -> Change Password");
		myProductReviewPage.openPageInMyAccountArea(driver, "Change password");
		changePasswordPage = PageGeneratorManager.getUserChangePasswordPage(driver);
		
		System.out.println("Switch Page - Step 3: Change Password -> Customer Infor");
		changePasswordPage.openPageInMyAccountArea(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getUserCustomerInformationPage(driver);
		
		System.out.println("Switch Page - Step 3: Customer Infor -> My product review");
		customerInforPage.openPageInMyAccountArea(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}