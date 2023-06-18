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

public class EditCustomer_02_State_Pin extends BaseTest{
	
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
	public void EditCustomer_09_State_Cannot_Empty() {
		log.info("Edit Customer 09 - Step 1: Do not enter a value in State fields");
		editCustomerPage.inputToCustomerState("");
		
		log.info("Edit Customer 09 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveThePinField();
		
		log.info("Edit Customer 09 - Step 3: Verify message: Customer state must not be blank must be shown");
		verifyEquals(editCustomerPage.getErrorStateMessage(), "State must not be blank");
	}
	
	@Test
	public void EditCustomer_10_State_Cannot_Numberic() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info(String.format("Edit Customer 10 - Step 1: Enter numberic value in state field: {}", "State123"));
		editCustomerPage.inputToCustomerState("State123");
		
		log.info("Edit Customer 10 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveThePinField();
		
		log.info("Edit Customer 10 - Step 3: Verify message: Numbers are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorStateMessage(), "Numbers are not allowed");
		
		log.info(String.format("Edit Customer 10 - Step 4: Enter numberic value in state field: {}", "123"));
		editCustomerPage.inputToCustomerState("123");
		
		log.info("Edit Customer 10 - Step 5: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveThePinField();
		
		log.info("Edit Customer 10 - Step 6: Verify message: Numbers are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorStateMessage(), "Numbers are not allowed");
	}
	
	@Test
	public void EditCustomer_11_State_Cannot_Have_Special_Character() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info(String.format("Edit Customer 11 - Step 1: Enter special character value in state field: {}", "!@#"));
		editCustomerPage.inputToCustomerState("!@#");
		
		log.info("Edit Customer 11 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveThePinField();
		
		log.info("Edit Customer 11 - Step 3: Verify message: Special characters are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorStateMessage(), "Special characters are not allowed");
		
		log.info(String.format("Edit Customer 11 - Step 4: Enter special character value in state field: {}", "!@#"));
		editCustomerPage.inputToCustomerState("!@#");
		
		log.info("Edit Customer 11 - Step 5: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveThePinField();
		
		log.info("Edit Customer 11 - Step 6: Verify message: Special characters are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorStateMessage(), "Special characters are not allowed");
	}
	
	@Test
	public void EditCustomer_12_Pin_Must_Be_Numberic() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info(String.format("Edit Customer 12 - Step 1: Enter character value in Pin field: {}", "123PIN"));
		editCustomerPage.inputToCustomerPin("123PIN");
		
		log.info("Edit Customer 12 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveTheMobilePhoneField();
		
		log.info("Edit Customer 12 - Step 3: Verify message: Characters are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorPinMessage(), "Characters are not allowed");
	}
	
	@Test
	public void EditCustomer_13_Pin_Cannot_Empty() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info(" Customer 13 - Step 1: Enter empty value in Pin field: {}");
		editCustomerPage.inputToCustomerPin("");
		
		log.info("Edit Customer 13 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveTheMobilePhoneField();
		
		log.info("Edit Customer 13 - Step 3: Verify message: PIN Code must not be blank must be shown");
		verifyEquals(editCustomerPage.getErrorPinMessage(), "PIN Code must not be blank");
	}
	
	@Test
	public void EditCustomer_14_Pin_Must_Have_6_Digits() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info(String.format("Edit Customer 14 - Step 1: Enter more than 6 ligit in Pin field: {}", "1231"));
		editCustomerPage.inputToCustomerPin("1231");
		
		log.info("Edit Customer 14 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveTheMobilePhoneField();
		
		log.info("Edit Customer 14 - Step 3: Verify message: PIN Code must have 6 Digits must be shown");
		verifyEquals(editCustomerPage.getErrorPinMessage(), "PIN Code must have 6 Digits");
	}
	
	@Test
	public void EditCustomer_15_Pin_Cannot_Have_Special_Character() {
		editCustomerPage.clickToLeftMenuBankGuru(driver, "Edit Customer");
		
		log.info(String.format("Edit Customer 15 - Step 1: Enter character value in Pin field: {}", "!@#"));
		editCustomerPage.inputToCustomerPin("!@#");
		
		log.info("Edit Customer 15 - Step 2: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveTheMobilePhoneField();
		
		log.info("Edit Customer 15 - Step 3: Verify message: Special characters are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorPinMessage(), "Special characters are not allowed");
		
		log.info(String.format("Edit Customer 15 - Step 4: Enter character value in Pin field: {}", "123!@#"));
		editCustomerPage.inputToCustomerPin("123!@#");
		
		log.info("Edit Customer 15 - Step 5: Press Tab and move to next field");
		editCustomerPage.pressTabToMoveTheMobilePhoneField();
		
		log.info("Edit Customer 15 - Step 6: Verify message: Special characters are not allowed must be shown");
		verifyEquals(editCustomerPage.getErrorPinMessage(), "Special characters are not allowed");
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
