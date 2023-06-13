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


public class NewCustomer_01_Name_Address_City extends BaseTest{
	
	
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
	public void NewCustomer_01_Name_Cannot_Be_Empty() {
		log.info("New Customer 01 - Step 1: Do not enter a value in Name fields");
		newCustomerPage.inputToCustomerName("");
		
		log.info("New Customer 01 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheGenderField();
		
		log.info("New Customer 01 - Step 3: Verify message: Customer name must not be blank must be shown");
		verifyEquals(newCustomerPage.getErrorNameMessage(), "Customer name must not be blank");
	}
	
	@Test
	public void NewCustomer_02_Name_Cannot_Be_Numberic() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 02 - Step 1: Enter numberic value: {} in Name fields", "1234"));
		newCustomerPage.inputToCustomerName("1234");
		
		log.info("New Customer 01 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheGenderField();
		
		log.info("New Customer 01 - Step 3: Verify message: Numbers are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorNameMessage(), "Numbers are not allowed");
		
		log.info(String.format("New Customer 02 - Step 4: Enter numberic value: {} in Name fields", "name1234"));
		newCustomerPage.inputToCustomerName("name1234");
		
		log.info("New Customer 01 - Step 5: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheGenderField();
		
		log.info("New Customer 01 - Step 6: Verify message: Numbers are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorNameMessage(), "Numbers are not allowed");
	}
	
	@Test
	public void NewCustomer_03_Name_Cannot_Have_Special_Characters() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 03 - Step 1: Enter character value: {} in Name fields", "name!@#"));
		newCustomerPage.inputToCustomerName("name!@#");
		
		log.info("New Customer 03 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheGenderField();
		
		log.info("New Customer 03 - Step 3: Verify message: Special characters are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorNameMessage(), "Special characters are not allowed");
		
		log.info(String.format("New Customer 03 - Step 4: Enter numberic value: {} in Name fields", "!@#"));
		newCustomerPage.inputToCustomerName("!@#");
		
		log.info("New Customer 03 - Step 5: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheGenderField();
		
		log.info("New Customer 03 - Step 6: Verify message: Special characters are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorNameMessage(), "Special characters are not allowed");
	}
	
	@Test
	public void NewCustomer_04_Name_Cannot_Have_First_Character_As_Blank_Space() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 04 - Step 1: Enter name with first character is blank: {} in Name fields", " Sunny"));
		newCustomerPage.inputToCustomerName("  Sunny");
		
		log.info("New Customer 04 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheGenderField();
		
		log.info("New Customer 04 - Step 3: Verify message: First character can not have space must be shown");
		verifyEquals(newCustomerPage.getErrorNameMessage(), "First character can not have space");
	}
	
	@Test
	public void NewCustomer_05_Address_Cannot_Empty() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 05 - Step 1: Enter address with empty data to Address field", ""));
		newCustomerPage.inputToCustomerAddress("");
		
		log.info("New Customer 05 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheCityField();
		
		log.info("New Customer 05 - Step 3: Verify message: Address Field must not be blank must be shown");
		verifyEquals(newCustomerPage.getErrorAddressMessage(), "Address Field must not be blank");
	}
	
	@Test
	public void NewCustomer_06_Address_Cannot_Have_First_Character_As_Blank_Space() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info(String.format("New Customer 06 - Step 1: Enter address with with first character is blank: {} in Address fields", "  No.01 Tran Dai Nghia Street"));
		newCustomerPage.inputToCustomerAddress("  No.1 Tran Dai Nghia Street");
		
		log.info("New Customer 06 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheCityField();
		
		log.info("New Customer 06 - Step 3: Verify message: First character can not have space must be shown");
		verifyEquals(newCustomerPage.getErrorAddressMessage(), "First character can not have space");
	}
	
	@Test
	public void NewCustomer_07_City_Cannot_Empty() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");
		
		log.info("New Customer 07 - Step 1: Enter city with empty data to city field");
		newCustomerPage.inputToCustomerCity("");
		
		log.info("New Customer 07 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheStateField();
		
		log.info("New Customer 07 - Step 3: Verify message: City Field must not be blank must be shown");
		verifyEquals(newCustomerPage.getErrorCityMessage(), "City Field must not be blank");
	}
	
	@Test
	public void NewCustomer_08_City_Cannot_Be_Numberic() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");

		log.info(String.format("New Customer 08 - Step 1: Enter address with with numberic: {} in Address fields", "city1234"));
		newCustomerPage.inputToCustomerCity("city1234");
		
		log.info("New Customer 08 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheStateField();
		
		log.info("New Customer 08 - Step 3: Verify message: Numbers are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorCityMessage(), "Numbers are not allowed");
		
		log.info(String.format("New Customer 08 - Step 1: Enter address with with numberic: {} in Address fields", "1234"));
		newCustomerPage.inputToCustomerCity("1234");
		
		log.info("New Customer 08 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheStateField();
		
		log.info("New Customer 08 - Step 3: Verify message: Numbers are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorCityMessage(), "Numbers are not allowed");
	}
	
	@Test
	public void NewCustomer_09_City_Cannot_Have_Special_Charater() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");

		log.info(String.format("New Customer 09 - Step 1: Enter address with with special character: {} in Address fields", "city!@#"));
		newCustomerPage.inputToCustomerCity("city!@#");
		
		log.info("New Customer 09 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheStateField();
		
		log.info("New Customer 09 - Step 3: Verify message: Special characters are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorCityMessage(), "Special characters are not allowed");
		
		log.info(String.format("New Customer 09 - Step 4: Enter address with with special character: {} in Address fields", "!@#"));
		newCustomerPage.inputToCustomerCity("!@#");
		
		log.info("New Customer 09 - Step 5: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheStateField();
		
		log.info("New Customer 09 - Step 6: Verify message: Special characters are not allowed must be shown");
		verifyEquals(newCustomerPage.getErrorCityMessage(), "Special characters are not allowed");
	}
	
	@Test
	public void NewCustomer_10_City_Cannot_Have_First_Blank_Space() {
		newCustomerPage.clickToLeftMenuBankGuru(driver, "New Customer");

		log.info(String.format("New Customer 10 - Step 1: Enter address with with first character is blank: {} in Address fields", "  No.01 Tran Dai Nghia Street"));
		newCustomerPage.inputToCustomerCity("   New York");
		
		log.info("New Customer 10 - Step 2: Press Tab and move to next field");
		newCustomerPage.pressTabToMoveTheStateField();
		
		log.info("New Customer 10 - Step 3: Verify message: First character can not have space must be shown");
		verifyEquals(newCustomerPage.getErrorCityMessage(), "First character can not have space");
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
