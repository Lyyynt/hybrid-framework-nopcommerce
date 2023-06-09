package com.nopcommerce.learning;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserAddAddressesObject;
import pageObjects.user.UserAddProductReviewObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInformationPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserMyAccountObject;
import pageObjects.user.UserMyProductReviewObject;
import pageObjects.user.UserProductDetailObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserProductListPageObject;

public class Level_18_Pattern_Object extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserMyAccountObject myaccountPage;
	UserCustomerInformationPageObject customerInformationPage;
	UserAddAddressesObject addressesPage;
	UserChangePasswordPageObject changePasswordPage;
	UserProductListPageObject productListPage;
	UserProductDetailObject productDetailPage;
	UserAddProductReviewObject addProductReviewPage;
	UserMyProductReviewObject myProductReviewPage;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, email, password, confirmPassword, country, city, address1, address2, portalCode, phoneNumber, faxNumber;
	String newFirstName, newLastName, newEmail, companyName, gender, dayOfBirth, monthOfBirth, yearOfBirth, newPassword;
	
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
		country = "Viet Nam";
		city = "Ha Noi";
		address1 = "No.1 Pham Van Bach Street";
		address2 = "No.10 Duy Tan Street";
		portalCode = "550000";
		phoneNumber = "0123456789";
		faxNumber = "0123456789";
		
		newFirstName = "Automation";
		newLastName = "FC";
		newEmail = "automation" +getRandomNumber() + "@gmail.com";
		companyName = "AutoFC";
		gender = "Female";
		dayOfBirth = "10";
		monthOfBirth = "October";
		yearOfBirth = "1996";
		newPassword = "111111";
		
		loginPage = homePage.clickToLoginLink();
		log.info("Pre-condition - Step 7: Input correct email and correct password");
		loginPage.inputToTextboxById(driver, Common_Register_NewAccount.EMAIL, "Email");
		loginPage.inputToTextboxById(driver, Common_Register_NewAccount.PASSWORD, "Password");
		log.info("Pre-condition - Step 8: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		log.info("Pre-condition - Step 9: Verify the home page displays");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		log.info("=============================");
	}
	
	@Test
	public void My_Account_01_Customer_Information() {
		log.info("My Account 01 - Step 1: Click to My Account link");
		myaccountPage = homePage.clickToMyAccountLink();
		customerInformationPage = myaccountPage.clickToCustomerInfoTab(driver);
		
		log.info("My Account 01 - Step 2: Change the customer information and click save button");
		customerInformationPage.clickToGenderRadio();
		customerInformationPage.inputToTextboxById(driver, newFirstName, "FirstName");
		customerInformationPage.inputToTextboxById(driver, newLastName, "LastName");
		customerInformationPage.selectDropdownByName(driver, dayOfBirth, "DateOfBirthDay");
		customerInformationPage.selectDropdownByName(driver, monthOfBirth, "DateOfBirthMonth");
		customerInformationPage.selectDropdownByName(driver, yearOfBirth, "DateOfBirthYear");
		customerInformationPage.inputToTextboxById(driver, newEmail, "Email");
		customerInformationPage.inputToTextboxById(driver, companyName, "Company");
		customerInformationPage.clickToSaveButton();
		
		log.info("My Account 01 - Step 3: Verify changing the customer information successful");
		verifyEquals(customerInformationPage.getToastMessage(), "The customer info has been updated successfully.");
		verifyTrue(customerInformationPage.isFemaleGender());
		verifyEquals(customerInformationPage.getValueAttributFromTextboxByID(driver, "FirstName"), newFirstName);
		verifyEquals(customerInformationPage.getValueAttributFromTextboxByID(driver, "LastName"), newLastName);
		verifyEquals(customerInformationPage.getValueAttributFromTextboxByID(driver, "Email"), newEmail);
		verifyEquals(customerInformationPage.getValueAttributFromTextboxByID(driver, "Company"), companyName);
		verifyEquals(customerInformationPage.getSelectedItemFromDropdownByName(driver, "DateOfBirthDay"), dayOfBirth);
		verifyEquals(customerInformationPage.getSelectedItemFromDropdownByName(driver, "DateOfBirthMonth"), monthOfBirth);
		verifyEquals(customerInformationPage.getSelectedItemFromDropdownByName(driver, "DateOfBirthYear"), yearOfBirth);
		verifyEquals(customerInformationPage.getValueAttributFromTextboxByID(driver, "Email"), newEmail);
		verifyEquals(customerInformationPage.getValueAttributFromTextboxByID(driver, "Company"), companyName);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
