package com.nopcommerce.user;

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

public class Topic_03_My_Account extends BaseTest{
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
	String reviewTitle, reviewContent;
	
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
		
		// for My_Account_04_Product_Review
		reviewTitle = "Review Title " + getRandomNumber();
		reviewContent = "Review content Review Content" + getRandomNumber();
		
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
		log.info("Pre-condition - Step 6: Click to Login link to clear data");
		loginPage = homePage.clickToLoginLink();
		log.info("Pre-condition - Step 7: Input correct email and correct password");
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
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
		customerInformationPage.sendKeyToFirstNameTextbox(newFirstName);
		customerInformationPage.sendKeyToLastNameTextbox(newLastName);
		customerInformationPage.selectDateOfBirthDropdown(dayOfBirth, monthOfBirth, yearOfBirth);
		customerInformationPage.sendKeyToEmailTextbox(newEmail);
		customerInformationPage.sendKeyToCompanyNameTextbox(companyName);
		customerInformationPage.clickToSaveButton();
		
		log.info("My Account 01 - Step 3: Verify changing the customer information successful");
		verifyEquals(customerInformationPage.getToastMessage(), "The customer info has been updated successfully.");
		verifyTrue(customerInformationPage.isFemaleGender());
		verifyEquals(customerInformationPage.getFirstNameTextboxValue(), newFirstName);
		verifyEquals(customerInformationPage.getLastNameTextboxValue(), newLastName);
		verifyEquals(customerInformationPage.getValueDayOfBirthTextbox(), dayOfBirth);
		verifyEquals(customerInformationPage.getValueMonthOfBirthTextbox(), monthOfBirth);
		verifyEquals(customerInformationPage.getValueYearOfBirthTextbox(), yearOfBirth);
		verifyEquals(customerInformationPage.getEmailTextboxValue(), newEmail);
		verifyEquals(customerInformationPage.getCompanyNameTextboxValue(), companyName);
		log.info("=============================");
	}
	
	@Test
	public void My_Account_02_Add_New_Addresses() {
		log.info("My Account 02 - Step 1: Click to Addresses tab");
		// myaccountPage = homePage.clickToMyAccountLink();
		addressesPage = myaccountPage.clickToAddAddressesTab(driver);
		addressesPage.clickAddNewButton();
		
		log.info("My Account 02 - Step 2: Enter the customer address");
		addressesPage.sendKeyToFirstNameTextbox(newFirstName);
		addressesPage.sendKeyToLastNameTextbox(newLastName);
		addressesPage.sendKeyToEmailTextbox(newEmail);
		addressesPage.sendKeyToCompanyTextbox(companyName);
		addressesPage.selectCountryDropdown(country);
		addressesPage.selectStateDropdown("Other");
		addressesPage.sendKeyToCityTextbox(city);
		addressesPage.sendKeyToAddress1Textbox(address1);
		addressesPage.sendKeyToAddress2Textbox(address2);
		addressesPage.sendKeyToPortalCodeTextbox(portalCode);
		addressesPage.sendKeyToPhoneNumberTextbox(phoneNumber);
		addressesPage.sendKeyToFaxTextbox(faxNumber);
		addressesPage.clickSaveButton();
		
		log.info("My Account 02 - Step 3: Verify add new address process successful");
		verifyEquals(addressesPage.getToastMessage(), "The new address has been added successfully.");
		verifyTrue(addressesPage.getNameTitle().contains(newFirstName + " " + newLastName));
		verifyTrue(addressesPage.getEmailText().contains(newEmail));
		verifyTrue(addressesPage.getPhoneNumberText().contains(phoneNumber));
		verifyTrue(addressesPage.getFaxText().contains(faxNumber));
		verifyTrue(addressesPage.getAddress1Text().contains(address1));
		verifyTrue(addressesPage.getCityAndStateZip().contains(city +", " + portalCode));
		verifyTrue(addressesPage.getCountry().contains(country));
		addressesPage.clickToCloseToastMessageButton();
		log.info("=============================");
	}
	
	@Test
	public void My_Account_03_Change_Password() {
		log.info("My Account 03 - Step 1: Click to Change password tab");
		// myaccountPage = homePage.clickToMyAccountLink();
		changePasswordPage = myaccountPage.clickToChangePasswordTab(driver);
		
		log.info("My Account 03 - Step 2: Enter the old password and new password");
		changePasswordPage.sendKeyToOldPasswordTextbox(password);
		changePasswordPage.sendKeyToNewPasswordTextbox(newPassword);
		changePasswordPage.sendKeyToConfirmNewPasswordTextbox(newPassword);
		changePasswordPage.clickToChangePasswordButton();
		
		log.info("My Account 03 - Step 3: Verify the changing password process successful");
		verifyEquals(changePasswordPage.getToastMessage(), "Password was changed");
		changePasswordPage.clickToCloseToastMessageButton();
		
		log.info("My Account 03 - Step 4: Verify login successful with new account after log out");
		SleepInSecond(2);
		homePage = changePasswordPage.clickToLogOutLink(driver);
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(newEmail);
		loginPage.inputToPasswordTextbox(newPassword);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		log.info("=============================");
	}
	
	@Test
	public void My_Account_04_Product_Review() {
		log.info("My Account 04 - Step 1: Search Product By Product Title");
		homePage.inputKeywordToSearchTextbox("apple");
		productListPage = homePage.clickToSearchButton();
		
		log.info("My Account 04 - Step 2: Open Product Detail Page");
		productDetailPage = productListPage.clickToProductTitle(driver, "Apple MacBook Pro 13-inch");
		
		log.info("My Account 04 - Step 3: Click Add Your Review Link");
		addProductReviewPage = productDetailPage.clickToAddYourReviewLink();
		
		log.info("My Account 04 - Step 4: Enter the new review for the product");
		addProductReviewPage.inputToReviewTitleTextBox(reviewTitle);
		addProductReviewPage.inputToReviewTextTextBox(reviewContent);
		addProductReviewPage.clickToSubmitButton();
		
		log.info("My Account 04 - Step 5: Verify add new review successfully");
		verifyTrue(addProductReviewPage.getAddReviewSuccessMessage().contains("Product review is successfully added."));
		
		log.info("My Account 04 - Step 6: Open My Product Review Page");
		myaccountPage = homePage.clickToMyAccountLink();
		myProductReviewPage = myaccountPage.clickToMyProductReviewTab(driver);
		
		log.info("My Account 04 - Step 7: Verify new review occurs in the list review");
		verifyEquals(myProductReviewPage.getReviewTitle(), reviewTitle);
		verifyEquals(myProductReviewPage.getReviewContent(), reviewContent);
		log.info("=============================");
	}

	public void SleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
