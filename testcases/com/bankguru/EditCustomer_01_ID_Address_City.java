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
import pageObjects.bankguru.PageGeneratorManager;

public class EditCustomer_01_ID_Address_City extends BaseTest{
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Pre-condition- Step 1: Enter user id");
		loginPage.inputToUserIDTextbox(Common_Create_New_Customer.USER_ID);
		
		log.info("Pre-condition- Step 2: Enter password");
		loginPage.inputToPasswordTextbox(Common_Create_New_Customer.PASSWORD);
		
		log.info("Pre-condition- Step 3: Click Login button");
		homePage = loginPage.clickLoginButton();
		
		log.info("Pre-condition- Step 4: Click Edit Customer left menu");
		homePage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);
		
	}
	
	@Test
	public void EditCustomer_01_CustomerID_Cannot_Empty() {
		log.info("Edit Customer 01 - Step 1: Do not enter a value in customer id fields");
		editCustomerPage.inputCustomerID("");
		
		log.info("Edit Customer 01 - Step 2: Press Tab to next field");
		editCustomerPage.pressTabToMoveNextFields();
		
		log.info("Edit Customer 01 - Step 3: Verify the message: Customer ID is required must be shown");
		verifyEquals(editCustomerPage.getErrorCustomerIDMessage(), "Customer ID is required");
	}
	
	@Test
	public void EditCustomer_02_CustomerID_Must_Be_Numberic() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info(String.format("Edit Customer 02 - Step 1: Enter character value in Customer id fields", "12ACs"));
		editCustomerPage.inputCustomerID("12ACs");
		
		log.info("Edit Customer 02 - Step 2: Press Tab to next field");
		editCustomerPage.pressTabToMoveNextFields();
		
		log.info("Edit Customer 02 - Step 3: Verify the message: Characters are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorCustomerIDMessage(), "Characters are not allowed");
	}
	
	@Test
	public void EditCustomer_03_CustomerID_Cannot_Have_Special_Character() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info(String.format("Edit Customer 03 - Step 1: Enter special value in Customer id fields", "123!@#"));
		editCustomerPage.inputCustomerID("123!@#");
		
		log.info("Edit Customer 03 - Step 2: Press Tab to next field");
		editCustomerPage.pressTabToMoveNextFields();
		
		log.info("Edit Customer 03 - Step 3: Verify the message: Special characters are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorCustomerIDMessage(), "Special characters are not allowed");
	}
	
	@Test
	public void EditCustomer_04_Valid_CustomerID() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info(String.format("Edit Customer 04 - Step 1: Enter valid value in Customer id fields", Common_Create_New_Customer.CUSTOMER_ID));
		editCustomerPage.inputCustomerID(Common_Create_New_Customer.CUSTOMER_ID);
		
		log.info("Edit Customer 04 - Step 2: Click to submit button");
		editCustomerPage.clickSubmitButton();

		log.info("Edit Customer 04 - Step 3: Verify direct to Edit Customer Page");
		verifyEquals(editCustomerPage.getPageTitle(driver), "Guru99 Bank Edit Customer Entry Page");
	}
	
	@Test
	public void EditCustomer_05_Address_Cannot_Empty() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info(String.format("Edit Customer 05 - Step 1: Enter address with empty data to Address field", ""));
		editCustomerPage.inputToCustomerAddress("");
		
		log.info("Edit Customer 05 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveTheCityField();
		
		log.info("Edit Customer 05 - Step 3: Verify message: Address Field must not be blank must be shown");
		verifyEquals(editCustomerPage.getErrorAddressMessage(), "Address Field must not be blank");
	}
	
	@Test
	public void EditCustomer_06_City_Cannot_Empty() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info("Edit Customer 06 - Step 1: Enter city with empty data to city field");
		editCustomerPage.inputToCustomerCity("");
		
		log.info("Edit Customer 06 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveTheStateField();
		
		log.info("Edit Customer 06 - Step 3: Verify message: City Field must not be blank must be shown");
		verifyEquals(editCustomerPage.getErrorCityMessage(), "City Field must not be blank");
	}
	
	@Test
	public void EditCustomer_07_City_Cannot_Be_Numberic() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");

		log.info(String.format("Edit Customer 07 - Step 1: Enter address with with numberic: {} in Address fields", "city1234"));
		editCustomerPage.inputToCustomerCity("city1234");
		
		log.info("Edit Customer 07 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveTheStateField();
		
		log.info("Edit Customer 07 - Step 3: Verify message: Numbers are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorCityMessage(), "Numbers are not allowed");
		
		log.info(String.format("Edit Customer 07 - Step 1: Enter address with with numberic: {} in Address fields", "1234"));
		editCustomerPage.inputToCustomerCity("1234");
		
		log.info("Edit Customer 07 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveTheStateField();
		
		log.info("Edit Customer 07 - Step 3: Verify message: Numbers are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorCityMessage(), "Numbers are not allowed");
	}
	
	@Test
	public void EditCustomer_08_City_Cannot_Have_Special_Charater() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");

		log.info(String.format("Edit Customer 08 - Step 1: Enter address with with special character: {} in Address fields", "city!@#"));
		editCustomerPage.inputToCustomerCity("city!@#");
		
		log.info("Edit Customer 08 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveTheStateField();
		
		log.info("Edit Customer 08 - Step 3: Verify message: Special characters are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorCityMessage(), "Special characters are not allowed");
		
		log.info(String.format("Edit Customer 08 - Step 4: Enter address with with special character: {} in Address fields", "!@#"));
		editCustomerPage.inputToCustomerCity("!@#");
		
		log.info("Edit Customer 08 - Step 5: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveTheStateField();
		
		log.info("Edit Customer 08 - Step 6: Verify message: Special characters are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorCityMessage(), "Special characters are not allowed");
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
	
	private WebDriver driver;
	private LoginPO loginPage;
	private HomePO homePage;
	private EditCustomerPO editCustomerPage;
	
}
