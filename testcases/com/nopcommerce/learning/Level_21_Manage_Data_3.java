package com.nopcommerce.learning;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.user.CustomerData;

import commons.BaseTest;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserCustomerInformationPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserMyAccountObject;

public class Level_21_Manage_Data_3 extends BaseTest{
	/*
	 * Level 3 là chúng ta có thể gom tất cả data test của 1 function/feature vào một chỗ (data test class để quản lý)
	 * phù hợp với dự án 1 tc đi qua nhiều màn hình
	 * dữ liệu tại các màn hình có thể dùng trong trong các tc
	 * Trong các class data test có thể có nhiều class con
	 * các class này thuộc dạng static nên có thể khai báo như dòng 34, 35
	 */
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		newFirstName = CustomerData.EditCustomer.FIRST_NAME;
		newLastName = CustomerData.EditCustomer.LAST_NAME;
		newEmail = "automation" +getRandomNumber() + "@gmail.com";
		companyName = "AutoFC";
		dayOfBirth = "10";
		monthOfBirth = "October";
		yearOfBirth = "1996";
		
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
	
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserMyAccountObject myaccountPage;
	private UserCustomerInformationPageObject customerInformationPage;
	private String newFirstName, newLastName, newEmail, companyName, dayOfBirth, monthOfBirth, yearOfBirth;
}
