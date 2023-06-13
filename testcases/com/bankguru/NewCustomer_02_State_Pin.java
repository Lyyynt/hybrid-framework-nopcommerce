package com.bankguru;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.bankguru.HomePO;
import pageObjects.bankguru.LoginPO;
import pageObjects.bankguru.NewCustomerPO;
import pageObjects.bankguru.PageGeneratorManager;


public class NewCustomer_02_State_Pin extends BaseTest{
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		userId = "mngr508569";
		password = "ejeseda";
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Pre-condition- Step 1: Enter user id");
		loginPage.inputToUserIDTextbox(userId);
		
		log.info("Pre-condition- Step 2: Enter password");
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Pre-condition- Step 3: Click Login button");
		homePage = loginPage.clickLoginButton();
		
		log.info("Pre-condition- Step 4: Click New Customer left menu");
		homePage.clickToLeftMenuBankGuru(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
		
	}
	
	@Test
	public void NewCustomer_11_State_Cannot_Empty() {
		log.info("New Customer 11 - Step 1: Do not enter a value in State fields");
		newCustomerPage.inputToCustomerState("");
		
		log.info("New Customer 11 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveThePinField();
		
		log.info("New Customer 11 - Step 3: Verify message: Customer state must not be blank must be shown");
		verifyEquals(newCustomerPage.getErrorStateMessage(), "State must not be blank");
	}
	
	@Test
	public void NewCustomer_12_State_Cannot_Numberic() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 12 - Step 1: Enter numberic value in state field: {}", "State123"));
		newCustomerPage.inputToCustomerState("State123");
		
		log.info("New Customer 12 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveThePinField();
		
		log.info("New Customer 12 - Step 3: Verify message: Numbers are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorStateMessage(), "Numbers are not allowed");
		
		log.info(String.format("New Customer 12 - Step 4: Enter numberic value in state field: {}", "123"));
		newCustomerPage.inputToCustomerState("123");
		
		log.info("New Customer 12 - Step 5: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveThePinField();
		
		log.info("New Customer 12 - Step 6: Verify message: Numbers are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorStateMessage(), "Numbers are not allowed");
	}
	
	@Test
	public void NewCustomer_13_State_Cannot_Have_Special_Character() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 13 - Step 1: Enter special character value in state field: {}", "!@#"));
		newCustomerPage.inputToCustomerState("!@#");
		
		log.info("New Customer 13 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveThePinField();
		
		log.info("New Customer 13 - Step 3: Verify message: Special characters are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorStateMessage(), "Special characters are not allowed");
		
		log.info(String.format("New Customer 13 - Step 4: Enter special character value in state field: {}", "!@#"));
		newCustomerPage.inputToCustomerState("!@#");
		
		log.info("New Customer 13 - Step 5: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveThePinField();
		
		log.info("New Customer 13 - Step 6: Verify message: Special characters are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorStateMessage(), "Special characters are not allowed");
	}
	
	@Test
	public void NewCustomer_14_State_Cannot_Have_First_Blank_Space() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 14 - Step 1: Enter first character blank space value in state field: {}", "   State"));
		newCustomerPage.inputToCustomerState("   Space");
		
		log.info("New Customer 14 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveThePinField();
		
		log.info("New Customer 14 - Step 3: Verify message: First character can not have space must be shown");
		verifyEquals(newCustomerPage.getErrorStateMessage(), "First character can not have space");
	}
	
	@Test
	public void NewCustomer_15_Pin_Must_Be_Numberic() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 15 - Step 1: Enter character value in Pin field: {}", "123PIN"));
		newCustomerPage.inputToCustomerPin("123PIN");
		
		log.info("New Customer 15 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheMobilePhoneField();
		
		log.info("New Customer 15 - Step 3: Verify message: Characters are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorPinMessage(), "Characters are not allowed");
	}
	
	@Test
	public void NewCustomer_16_Pin_Cannot_Empty() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info("New Customer 16 - Step 1: Enter empty value in Pin field: {}");
		newCustomerPage.inputToCustomerPin("");
		
		log.info("New Customer 16 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheMobilePhoneField();
		
		log.info("New Customer 16 - Step 3: Verify message: PIN Code must not be blank must be shown");
		verifyEquals(newCustomerPage.getErrorPinMessage(), "PIN Code must not be blank");
	}
	
	@Test
	public void NewCustomer_17_Pin_Must_Have_6_Digits() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 17 - Step 1: Enter more than 6 ligit in Pin field: {}", "1231"));
		newCustomerPage.inputToCustomerPin("1231");
		
		log.info("New Customer 17 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheMobilePhoneField();
		
		log.info("New Customer 17 - Step 3: Verify message: PIN Code must have 6 Digits must be shown");
		verifyEquals(newCustomerPage.getErrorPinMessage(), "PIN Code must have 6 Digits");
	}
	
	@Test
	public void NewCustomer_18_Pin_Cannot_Have_Special_Character() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 18 - Step 1: Enter character value in Pin field: {}", "!@#"));
		newCustomerPage.inputToCustomerPin("!@#");
		
		log.info("New Customer 18 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheMobilePhoneField();
		
		log.info("New Customer 18 - Step 3: Verify message: Special characters are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorPinMessage(), "Special characters are not allowed");
		
		log.info(String.format("New Customer 18 - Step 4: Enter character value in Pin field: {}", "123!@#"));
		newCustomerPage.inputToCustomerPin("123!@#");
		
		log.info("New Customer 18 - Step 5: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheMobilePhoneField();
		
		log.info("New Customer 18 - Step 6: Verify message: Special characters are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorPinMessage(), "Special characters are not allowed");
	}

	@Test
	public void NewCustomer_19_Pin_Have_First_Character_As_Blank_Space() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 19 - Step 1: Enter the first blank space in Pin field: {}", "  12"));
		newCustomerPage.inputToCustomerPin("  12");
		
		log.info("New Customer 19 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheMobilePhoneField();
		
		log.info("New Customer 19 - Step 3: Verify message: First character can not have space must be shown");
		verifyEquals(newCustomerPage.getErrorPinMessage(), "First character can not have space");
	}
	
	@Test
	public void NewCustomer_20_Pin_Contains_Space() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 20 - Step 1: Enter the first blank space in Pin field: {}", "11 2"));
		newCustomerPage.inputToCustomerPin("11 2");
		
		log.info("New Customer 20 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheMobilePhoneField();
		
		log.info("New Customer 20 - Step 3: Verify message: Characters are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorPinMessage(), "Characters are not allowed");
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
	
	private WebDriver driver;
	private LoginPO loginPage;
	private HomePO homePage;
	private NewCustomerPO newCustomerPage;
	private String userId, password;
}
