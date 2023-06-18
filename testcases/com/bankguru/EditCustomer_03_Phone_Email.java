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

public class EditCustomer_03_Phone_Email extends BaseTest{
	
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
	public void EditCustomer_16_Telephone_Cannot_Empty() {
		log.info("Edit Customer 16 - Step 1: Do not enter a value in Phone fields");
		editCustomerPage.inputToCustomerPhone("");
		
		log.info("Edit Customer 16 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveTheEmailField();
		
		log.info("Edit Customer 16 - Step 3: Verify message: Mobile no must not be blank must be shown");
		verifyEquals(editCustomerPage.getErrorPhoneMessage(), "Mobile no must not be blank");
	}
	
	@Test
	public void EditCustomer_17_Telephone_Cannot_Have_Special_Character() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info(String.format("Edit Customer 17 - Step 1: Enter special character in telephone field: {}", "0123123!@#"));
		editCustomerPage.inputToCustomerPhone("0123123!@#");
		
		log.info("Edit Customer 17 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveTheEmailField();
		
		log.info("Edit Customer 17 - Step 3: Verify message: Special characters are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorPhoneMessage(), "Special characters are not allowed");
	}
	
	@Test
	public void EditCustomer_18_Email_Cannot_Empty() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info("Edit Customer 18 - Step 1: Enter empty value in email field: {}");
		editCustomerPage.inputToCustomerEmail("");
		
		log.info("Edit Customer 18 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMovePasswordField();
		
		log.info("Edit Customer 18 - Step 3: Verify message: Email-ID must not be blank must be shown");
		verifyEquals(editCustomerPage.getErrorEmailMessage(), "Email-ID must not be blank");
	}
	
	@Test
	public void EditCustomer_19_Email_Must_Be_Incorrect_Format() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info(String.format("Edit Customer 19 - Step 1: Enter incorrect format value in email field: {}", "guru@gmail"));
		editCustomerPage.inputToCustomerEmail("guru@gmail");
		
		log.info("Edit Customer 19 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMovePasswordField();
		
		log.info("Edit Customer 19 - Step 3: Verify message: Email-ID is not valid must be shown");
		verifyEquals(editCustomerPage.getErrorEmailMessage(), "Email-ID is not valid");
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
