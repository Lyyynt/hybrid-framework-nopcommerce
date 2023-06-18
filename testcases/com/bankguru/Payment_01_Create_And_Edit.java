package com.bankguru;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.bankguru.EditCustomerPO;
import pageObjects.bankguru.HomePO;
import pageObjects.bankguru.LoginPO;
import pageObjects.bankguru.NewCustomerPO;
import pageObjects.bankguru.PageGeneratorManager;
import utilities.DataHelper;

public class Payment_01_Create_And_Edit extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		customerName = datahelper.getFullName();
		customerAddress = datahelper.getAddress();
		customerCity = datahelper.getCityName();
		customerState = datahelper.getState();
		customerPin = datahelper.getPinNumber();
		customerPhone = "0123123123";
		customerEmail = datahelper.getEmailAddress();
		customerPassword = datahelper.getPassword();

		newCustomerAddress = datahelper.getAddress();
		newCustomerCity = datahelper.getCityName();
		newCustomerState = datahelper.getState();
		newCustomerPin = datahelper.getPinNumber();
		newCustomerPhone = "0456456456";
		newCustomerEmail = datahelper.getEmailAddress();
		
		log.info("Pre-condition- Step 1: Enter user id");
		loginPage.inputToUserIDTextbox(Common_Create_New_Customer.USER_ID);

		log.info("Pre-condition- Step 2: Enter password");
		loginPage.inputToPasswordTextbox(Common_Create_New_Customer.PASSWORD);

		log.info("Pre-condition- Step 3: Click Login button");
		homePage = loginPage.clickLoginButton();

	}

	@Test
	public void Payment_01_Create_New_Customer() {
		log.info("Payment 01 - Step 1: Click New Customer left menu");
		homePage.clickToLeftMenuBankGuru(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);

		log.info("Payment 01 - Step 2: Enter the valid information in all fields");
		newCustomerPage.inputToCustomerName(customerName);
		newCustomerPage.inputDateOfBirth("06/20/2023");
		newCustomerPage.inputToCustomerAddress(customerAddress);
		newCustomerPage.inputToCustomerCity(customerCity);
		newCustomerPage.inputToCustomerState(customerState);
		newCustomerPage.inputToCustomerPin(customerPin);
		newCustomerPage.inputToCustomerPhone(customerPhone);
		newCustomerPage.inputToCustomerEmail(customerEmail);
		newCustomerPage.inputToCustomerPassword(customerPassword);

		log.info("Payment 01 - Step 3: Click Submit button");
		newCustomerPage.clickToSubmitButton();
		customerID = newCustomerPage.getSheetByLabel(driver, "Customer ID");

		log.info("Payment 01 - Step 4: Verify create new customer successfully message displays");
		verifyTrue(newCustomerPage.isCreateSuccessfully());

		log.info("Payment 01 - Step 5: Verify the customer information is correct");
		verifyEquals(newCustomerPage.getSheetByLabel(driver, "Customer Name"), customerName);
		verifyEquals(newCustomerPage.getSheetByLabel(driver, "Birthdate"), "2023-06-20");
		verifyEquals(newCustomerPage.getSheetByLabel(driver, "Address"), customerAddress);
		verifyEquals(newCustomerPage.getSheetByLabel(driver, "City"), customerCity);
		verifyEquals(newCustomerPage.getSheetByLabel(driver, "State"), customerState);
		verifyEquals(newCustomerPage.getSheetByLabel(driver, "Pin"), customerPin);
		verifyEquals(newCustomerPage.getSheetByLabel(driver, "Mobile No."), customerPhone);
		verifyEquals(newCustomerPage.getSheetByLabel(driver, "Email"), customerEmail);
	}

	@Test
	public void Payment_02_Edit_Customer_Information() {
		log.info("Payment 02 - Step 1: Click Edit Customer left menu");
		newCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);

		log.info(String.format("Payment 02 - Step 2: Enter valid value in Customer id fields", customerID));
		editCustomerPage.inputCustomerID(customerID);

		log.info("Payment 02 - Step 3: Click to submit button");
		editCustomerPage.clickSubmitButton();

		log.info("Payment 02 - Step 4: Enter the valid information in all fields");
		editCustomerPage.inputToCustomerAddress(newCustomerAddress);
		editCustomerPage.inputToCustomerCity(newCustomerCity);
		editCustomerPage.inputToCustomerState(newCustomerState);
		editCustomerPage.inputToCustomerPin(newCustomerPin);
		editCustomerPage.inputToCustomerPhone(newCustomerPhone);
		editCustomerPage.inputToCustomerEmail(newCustomerEmail);
		editCustomerPage.clickToSubmitButton();

		verifyTrue(editCustomerPage.isUpdateSuccessfully());
		verifyEquals(editCustomerPage.getSheetByLabel(driver, "Customer Name"), customerName);
		verifyEquals(editCustomerPage.getSheetByLabel(driver, "Birthdate"), "2023-06-20");
		verifyEquals(editCustomerPage.getSheetByLabel(driver, "Address"), newCustomerAddress);
		verifyEquals(editCustomerPage.getSheetByLabel(driver, "City"), newCustomerCity);
		verifyEquals(editCustomerPage.getSheetByLabel(driver, "State"), newCustomerState);
		verifyEquals(editCustomerPage.getSheetByLabel(driver, "Pin"), newCustomerPin);
		verifyEquals(editCustomerPage.getSheetByLabel(driver, "Mobile No."), newCustomerPhone);
		verifyEquals(editCustomerPage.getSheetByLabel(driver, "Email"), newCustomerEmail);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private DataHelper datahelper;
	private LoginPO loginPage;
	private NewCustomerPO newCustomerPage;
	private EditCustomerPO editCustomerPage;
	private HomePO homePage;
	private String customerName, customerAddress, customerCity, customerState, customerPin, customerPhone, customerEmail, customerPassword;
	private String newCustomerAddress, newCustomerCity, newCustomerState, newCustomerPin, newCustomerPhone, newCustomerEmail;
	private String customerID;
}
