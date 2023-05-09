package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AddressesObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.CustomerInformationPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Topic_04_My_Account_PageObjectModel {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInformationPageObject customerInformationPage;
	AddressesObject addressesPage;
	ChangePasswordPageObject changePasswordPage;
	
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, email, password, confirmPassword, country, city, address1, address2, portalCode, phoneNumber, faxNumber;
	String newFirstName, newLastName, newEmail, companyName, gender, dayOfBirth, monthOfBirth, yearOfBirth, newPassword;
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
		homePage = new HomePageObject(driver);
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
		
		// Pre-condition
		System.out.println("Pre-condition - Step 1: Enter the valid information");
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
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
		registerPage.clickToContinueButton();
		homePage = new HomePageObject(driver);
		System.out.println("Pre-condition - Step 6: Click to Login link to clear data");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		System.out.println("Pre-condition - Step 7: Input correct email and correct password");
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		System.out.println("Pre-condition - Step 8: Click to Login button");
		loginPage.clickToLoginButton();
		System.out.println("Pre-condition - Step 9: Verify the email not found message displays");
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void My_Account_01_Customer_Information() {
		System.out.println("My Account 01 - Step 1: Click to My Account link");
		homePage.clickToMyAccountLink();
		customerInformationPage = new CustomerInformationPageObject(driver);
		
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
		
	}
	
	@Test
	public void My_Account_02_Add_New_Addresses() {
		System.out.println("My Account 02 - Step 1: Click to Addresses tab");
		customerInformationPage.clickToAddressesTab();
		addressesPage = new AddressesObject(driver);
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
	}
	
	@Test
	public void My_Account_03_Change_Password() {
		System.out.println("My Account 03 - Step 1: Click to Change password tab");
		addressesPage.clickToChangePasswordTab();
		changePasswordPage = new ChangePasswordPageObject(driver);
		
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
		changePasswordPage.clickLogOutLink();
		homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(newEmail);
		loginPage.inputToPasswordTextbox(newPassword);
		loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
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
