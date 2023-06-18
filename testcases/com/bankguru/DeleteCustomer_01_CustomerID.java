package com.bankguru;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.bankguru.DeleteCustomerPO;
import pageObjects.bankguru.HomePO;
import pageObjects.bankguru.LoginPO;
import pageObjects.bankguru.PageGeneratorManager;

public class DeleteCustomer_01_CustomerID extends BaseTest{
	
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
		
		log.info("Pre-condition- Step 4: Click Delete Customer left menu");
		homePage.clickToLeftMenuBankGuru(driver, "Delete Customer");
		deleteCustomerPage = PageGeneratorManager.getDeleteCustomerPage(driver);
		
	}
	
	@Test
	public void DeleteCustomer_01_CustomerID_Cannot_Empty() {
		log.info("Delete Customer 01 - Step 1: Do not enter a value in customer id fields");
		deleteCustomerPage.inputCustomerID("");
		
		log.info("Delete Customer 01 - Step 2: Press Tab to next field");
		deleteCustomerPage.pressTabToMoveNextFields();
		
		log.info("Delete Customer 01 - Step 3: Verify the message: Customer ID is required must be shown");
		verifyEquals(deleteCustomerPage.getErrorCustomerIDMessage(), "Customer ID is required");
	}
	
	@Test
	public void DeleteCustomer_02_CustomerID_Must_Be_Numberic() {
		deleteCustomerPage.clickToLeftMenuBankGuru(driver, "Delete Customer");
		
		log.info(String.format("Delete Customer 02 - Step 1: Enter character value in Customer id fields", "12ACs"));
		deleteCustomerPage.inputCustomerID("12ACs");
		
		log.info("Delete Customer 02 - Step 2: Press Tab to next field");
		deleteCustomerPage.pressTabToMoveNextFields();
		
		log.info("Delete Customer 02 - Step 3: Verify the message: Characters are not allowed must be shown");
		verifyEquals(deleteCustomerPage.getErrorCustomerIDMessage(), "Characters are not allowed");
	}
	
	@Test
	public void DeleteCustomer_03_CustomerID_Cannot_Have_Special_Character() {
		deleteCustomerPage.clickToLeftMenuBankGuru(driver, "Delete Customer");
		
		log.info(String.format("Delete Customer 03 - Step 1: Enter special value in Customer id fields", "123!@#"));
		deleteCustomerPage.inputCustomerID("123!@#");
		
		log.info("Delete Customer 03 - Step 2: Press Tab to next field");
		deleteCustomerPage.pressTabToMoveNextFields();
		
		log.info("Delete Customer 03 - Step 3: Verify the message: Special characters are not allowed must be shown");
		verifyEquals(deleteCustomerPage.getErrorCustomerIDMessage(), "Special characters are not allowed");
	}
	
	@Test
	public void DeleteCustomer_04_CustomerID_Cannot_Have_Blank_Space() {
		deleteCustomerPage.clickToLeftMenuBankGuru(driver, "Delete Customer");
		
		log.info(String.format("Delete Customer 04 - Step 1: Enter blank space value in Customer id fields", "12 1"));
		deleteCustomerPage.inputCustomerID("12 1");
		
		log.info("Delete Customer 04 - Step 2: Press Tab to next field");
		deleteCustomerPage.pressTabToMoveNextFields();
		
		log.info("Delete Customer 04 - Step 3: Verify the message: Characters are not allowed must be shown");
		verifyEquals(deleteCustomerPage.getErrorCustomerIDMessage(), "Characters are not allowed");
	}
	
	@Test
	public void DeleteCustomer_05_CustomerID_First_Character_Cannot_Be_Space() {
		deleteCustomerPage.clickToLeftMenuBankGuru(driver, "Delete Customer");
		
		log.info(String.format("Delete Customer 05 - Step 1: Enter blank space value in Customer id fields", "  11231"));
		deleteCustomerPage.inputCustomerID("  11231");
		
		log.info("Delete Customer 05 - Step 2: Press Tab to next field");
		deleteCustomerPage.pressTabToMoveNextFields();
		
		log.info("Delete Customer 05 - Step 3: Verify the message: First character can not have space must be shown");
		verifyEquals(deleteCustomerPage.getErrorCustomerIDMessage(), "First character can not have space");
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
	
	private WebDriver driver;
	private LoginPO loginPage;
	private HomePO homePage;
	private DeleteCustomerPO deleteCustomerPage;
	
}
