package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
import pageObjects.user.UserSearchResultObject;

public class Topic_03_My_Account extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserMyAccountObject myaccountPage;
	UserCustomerInformationPageObject customerInformationPage;
	UserAddAddressesObject addressesPage;
	UserChangePasswordPageObject changePasswordPage;
	UserSearchResultObject searchResultPage;
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
		System.out.println("Pre-condition - Step 1: Enter the valid information");
		registerPage = homePage.clickToRegisterLink();
		System.out.println("Pre-condition - Step 2: Enter the valid information");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		System.out.println("Pre-condition - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Pre-condition - Step 4: Verify the register success message displays");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		System.out.println("Pre-condition - Step 5: Back to Home page");
		homePage = registerPage.clickToContinueButton();
		System.out.println("Pre-condition - Step 6: Click to Login link to clear data");
		loginPage = homePage.clickToLoginLink();
		System.out.println("Pre-condition - Step 7: Input correct email and correct password");
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		System.out.println("Pre-condition - Step 8: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		System.out.println("Pre-condition - Step 9: Verify the home page displays");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		System.out.println("=============================");
	}
	
	@Test
	public void My_Account_01_Customer_Information() {
		System.out.println("My Account 01 - Step 1: Click to My Account link");
		myaccountPage = homePage.clickToMyAccountLink();
		customerInformationPage = myaccountPage.clickToCustomerInfoTab(driver);
		
		System.out.println("My Account 01 - Step 2: Change the customer information and click save button");
		customerInformationPage.clickToGenderRadio();
		customerInformationPage.sendKeyToFirstNameTextbox(newFirstName);
		customerInformationPage.sendKeyToLastNameTextbox(newLastName);
		customerInformationPage.selectDateOfBirthDropdown(dayOfBirth, monthOfBirth, yearOfBirth);
		customerInformationPage.sendKeyToEmailTextbox(newEmail);
		customerInformationPage.sendKeyToCompanyNameTextbox(companyName);
		customerInformationPage.clickToSaveButton();
		
		System.out.println("My Account 01 - Step 3: Verify changing the customer information successful");
		Assert.assertEquals(customerInformationPage.getToastMessage(), "The customer info has been updated successfully.");
		Assert.assertTrue(customerInformationPage.isFemaleGender());
		Assert.assertEquals(customerInformationPage.getFirstNameTextboxValue(), newFirstName);
		Assert.assertEquals(customerInformationPage.getLastNameTextboxValue(), newLastName);
		Assert.assertEquals(customerInformationPage.getValueDayOfBirthTextbox(), dayOfBirth);
		Assert.assertEquals(customerInformationPage.getValueMonthOfBirthTextbox(), monthOfBirth);
		Assert.assertEquals(customerInformationPage.getValueYearOfBirthTextbox(), yearOfBirth);
		Assert.assertEquals(customerInformationPage.getEmailTextboxValue(), newEmail);
		Assert.assertEquals(customerInformationPage.getCompanyNameTextboxValue(), companyName);
		System.out.println("=============================");
	}
	
	@Test
	public void My_Account_02_Add_New_Addresses() {
		System.out.println("My Account 02 - Step 1: Click to Addresses tab");
		// myaccountPage = homePage.clickToMyAccountLink();
		addressesPage = myaccountPage.clickToAddAddressesTab(driver);
		addressesPage.clickAddNewButton();
		
		System.out.println("My Account 02 - Step 2: Enter the customer address");
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
		
		System.out.println("My Account 02 - Step 3: Verify add new address process successful");
		Assert.assertEquals(addressesPage.getToastMessage(), "The new address has been added successfully.");
		Assert.assertTrue(addressesPage.getNameTitle().contains(newFirstName + " " + newLastName));
		Assert.assertTrue(addressesPage.getEmailText().contains(newEmail));
		Assert.assertTrue(addressesPage.getPhoneNumberText().contains(phoneNumber));
		Assert.assertTrue(addressesPage.getFaxText().contains(faxNumber));
		Assert.assertTrue(addressesPage.getAddress1Text().contains(address1));
		Assert.assertTrue(addressesPage.getCityAndStateZip().contains(city +", " + portalCode));
		Assert.assertTrue(addressesPage.getCountry().contains(country));
		addressesPage.clickToCloseToastMessageButton();
		System.out.println("=============================");
	}
	
	@Test
	public void My_Account_03_Change_Password() {
		System.out.println("My Account 03 - Step 1: Click to Change password tab");
		// myaccountPage = homePage.clickToMyAccountLink();
		changePasswordPage = myaccountPage.clickToChangePasswordTab(driver);
		
		System.out.println("My Account 03 - Step 2: Enter the old password and new password");
		changePasswordPage.sendKeyToOldPasswordTextbox(password);
		changePasswordPage.sendKeyToNewPasswordTextbox(newPassword);
		changePasswordPage.sendKeyToConfirmNewPasswordTextbox(newPassword);
		changePasswordPage.clickToChangePasswordButton();
		
		System.out.println("My Account 03 - Step 3: Verify the changing password process successful");
		Assert.assertEquals(changePasswordPage.getToastMessage(), "Password was changed");
		changePasswordPage.clickToCloseToastMessageButton();
		
		System.out.println("My Account 03 - Step 4: Verify login successful with new account after log out");
		SleepInSecond(2);
		homePage = changePasswordPage.clickToLogOutLink(driver);
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(newEmail);
		loginPage.inputToPasswordTextbox(newPassword);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		System.out.println("=============================");
	}
	
	@Test
	public void My_Account_04_Product_Review() {
		System.out.println("My Account 04 - Step 1: Search Product By Product Title");
		homePage.inputKeywordToSearchTextbox("apple");
		searchResultPage = homePage.clickToSearchButton();
		
		System.out.println("My Account 04 - Step 2: Open Product Detail Page");
		productDetailPage = searchResultPage.clickToProductTitle("Apple MacBook Pro 13-inch");
		
		System.out.println("My Account 04 - Step 3: Click Add Your Review Link");
		addProductReviewPage = productDetailPage.clickToAddYourReviewLink();
		
		System.out.println("My Account 04 - Step 4: Enter the new review for the product");
		addProductReviewPage.inputToReviewTitleTextBox(reviewTitle);
		addProductReviewPage.inputToReviewTextTextBox(reviewContent);
		addProductReviewPage.clickToSubmitButton();
		
		System.out.println("My Account 04 - Step 5: Verify add new review successfully");
		Assert.assertTrue(addProductReviewPage.getAddReviewSuccessMessage().contains("Product review is successfully added."));
		
		System.out.println("My Account 04 - Step 6: Open My Product Review Page");
		myaccountPage = homePage.clickToMyAccountLink();
		myProductReviewPage = myaccountPage.clickToMyProductReviewTab(driver);
		
		System.out.println("My Account 04 - Step 7: Verify new review occurs in the list review");
		Assert.assertEquals(myProductReviewPage.getReviewTitle(), reviewTitle);
		Assert.assertEquals(myProductReviewPage.getReviewContent(), reviewContent);
		System.out.println("=============================");
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
		driver.quit();
	}
}
