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


public class NewCustomer_03_Phone_Email extends BaseTest{
	
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
	public void NewCustomer_21_Telephone_Cannot_Empty() {
		log.info("New Customer 21 - Step 1: Do not enter a value in Phone fields");
		newCustomerPage.inputToCustomerPhone("");
		
		log.info("New Customer 21 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheEmailField();
		
		log.info("New Customer 21 - Step 3: Verify message: Mobile no must not be blank must be shown");
		verifyEquals(newCustomerPage.getErrorPhoneMessage(), "Mobile no must not be blank");
	}
	
	@Test
	public void NewCustomer_22_Telephone_Cannot_Have_First_Charater_As_Blank_Space() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 22 - Step 1: Enter first charater as blank space value in Phone field: {}", " 01231213123"));
		newCustomerPage.inputToCustomerPhone(" 01231213123");
		
		log.info("New Customer 22 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheEmailField();
		
		log.info("New Customer 22 - Step 3: Verify message: First character can not have space must be shown");
		verifyEquals(newCustomerPage.getErrorPhoneMessage(), "First character can not have space");
	}
	
	@Test
	public void NewCustomer_23_Telephone_Cannot_Have_Spaces() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 23 - Step 1: Enter value contains space charater in Phone field: {}", "0123 123123"));
		newCustomerPage.inputToCustomerPhone("0123 123123");
		
		log.info("New Customer 23 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheEmailField();
		
		log.info("New Customer 23 - Step 3: Verify message: Characters are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorPhoneMessage(), "Characters are not allowed");
	}
	
	@Test
	public void NewCustomer_24_Telephone_Cannot_Have_Special_Character() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 24 - Step 1: Enter special character in telephone field: {}", "0123123!@#"));
		newCustomerPage.inputToCustomerPhone("0123123!@#");
		
		log.info("New Customer 24 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheEmailField();
		
		log.info("New Customer 24 - Step 3: Verify message: Special characters are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorPhoneMessage(), "Special characters are not allowed");
	}
	
	@Test
	public void NewCustomer_25_Email_Cannot_Empty() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info("New Customer 25 - Step 1: Enter empty value in email field: {}");
		newCustomerPage.inputToCustomerEmail("");
		
		log.info("New Customer 25 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMovePasswordField();
		
		log.info("New Customer 25 - Step 3: Verify message: Email-ID must not be blank must be shown");
		verifyEquals(newCustomerPage.getErrorEmailMessage(), "Email-ID must not be blank");
	}
	
	@Test
	public void NewCustomer_26_Email_Must_Be_Incorrect_Format() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 26 - Step 1: Enter incorrect format value in email field: {}", "guru@gmail"));
		newCustomerPage.inputToCustomerEmail("guru@gmail");
		
		log.info("New Customer 26 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMovePasswordField();
		
		log.info("New Customer 26 - Step 3: Verify message: Email-ID is not valid must be shown");
		verifyEquals(newCustomerPage.getErrorEmailMessage(), "Email-ID is not valid");
	}
	
	@Test
	public void NewCustomer_27_Pin_Cannot_Have_Space() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 27 - Step 1: Enter email value contains space charater in email field: {}", "gurug @gmail.com"));
		newCustomerPage.inputToCustomerEmail("gurug @gmail.com");
		
		log.info("New Customer 27 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMovePasswordField();
		
		log.info("New Customer 27 - Step 3: Verify message: Email-ID is not valid must be shown");
		verifyEquals(newCustomerPage.getErrorEmailMessage(), "Email-ID is not valid");
	}
	
	@Test
	public void NewCustomer_28_Check_All_Field_Name_Label() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 28 - Verify field exist by label", "Customer Name"));
		verifyTrue(newCustomerPage.isFieldExistByLabel("Customer Name"));
		
		log.info(String.format("New Customer 28 - Verify field exist by label", "Gender"));
		verifyTrue(newCustomerPage.isFieldExistByLabel("Gender"));
		
		log.info(String.format("New Customer 28 - Verify field exist by label", "Date of Birth"));
		verifyTrue(newCustomerPage.isFieldExistByLabel("Date of Birth"));
		
		log.info(String.format("New Customer 28 - Verify field exist by label", "Address"));
		verifyTrue(newCustomerPage.isFieldExistByLabel("Address"));
		
		log.info(String.format("New Customer 28 - Verify field exist by label", "City"));
		verifyTrue(newCustomerPage.isFieldExistByLabel("City"));
		
		log.info(String.format("New Customer 28 - Verify field exist by label", "State"));
		verifyTrue(newCustomerPage.isFieldExistByLabel("State"));
		
		log.info(String.format("New Customer 28 - Verify field exist by label", "PIN"));
		verifyTrue(newCustomerPage.isFieldExistByLabel("PIN"));
		
		log.info(String.format("New Customer 28 - Verify field exist by label", "Mobile Number"));
		verifyTrue(newCustomerPage.isFieldExistByLabel("Mobile Number"));
		
		log.info(String.format("New Customer 28 - Verify field exist by label", "E-mail"));
		verifyTrue(newCustomerPage.isFieldExistByLabel("E-mail"));
		
		log.info(String.format("New Customer 28 - Verify field exist by label", "Password"));
		verifyTrue(newCustomerPage.isFieldExistByLabel("Password"));
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
