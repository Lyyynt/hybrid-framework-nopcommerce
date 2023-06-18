package com.bankguru;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.bankguru.HomePO;
import pageObjects.bankguru.LoginPO;
import pageObjects.bankguru.NewCustomerPO;
import pageObjects.bankguru.PageGeneratorManager;
import utilities.DataHelper;

public class Common_Create_New_Customer extends BaseTest{
	
	@Parameters({"browser", "url"})
	@BeforeTest
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		datahelper = DataHelper.getDataHelper();
		
		USER_ID = "mngr508569";
		PASSWORD = "ejeseda";
		customerName = datahelper.getFullName();
		customerAddress = datahelper.getAddress();
		customerCity = datahelper.getCityName();
		customerState = datahelper.getState();
		customerPin = datahelper.getPinNumber();
		customerPhone = "0123123123";
		customerEmail = datahelper.getEmailAddress();
		customerPassword = datahelper.getPassword();
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Pre-condition- Step 1: Enter user id");
		loginPage.inputToUserIDTextbox(USER_ID);
		
		log.info("Pre-condition- Step 2: Enter password");
		loginPage.inputToPasswordTextbox(PASSWORD);
		
		log.info("Pre-condition- Step 3: Click Login button");
		homePage = loginPage.clickLoginButton();
		
		log.info("Pre-condition- Step 4: Click New Customer left menu");
		homePage.clickToLeftMenuBankGuru(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
		
		log.info("Pre-condition- Step 5: Enter the valid information in all fields");
		newCustomerPage.inputToCustomerName(customerName);
		newCustomerPage.inputDateOfBirth("06/20/2023");
		newCustomerPage.inputToCustomerAddress(customerAddress);
		newCustomerPage.inputToCustomerCity(customerCity);
		newCustomerPage.inputToCustomerState(customerState);
		newCustomerPage.inputToCustomerPin(customerPin);
		newCustomerPage.inputToCustomerPhone(customerPhone);
		newCustomerPage.inputToCustomerEmail(customerEmail);
		newCustomerPage.inputToCustomerPassword(customerPassword);
		newCustomerPage.clickToSubmitButton();
		CUSTOMER_ID = newCustomerPage.getSheetByLabel(driver, "Customer ID");
		closeBrowserDriver();
	}
	
	private WebDriver driver;
	private DataHelper datahelper;
	private LoginPO loginPage;
	private HomePO homePage;
	private NewCustomerPO newCustomerPage;
	private String customerName, customerAddress, customerCity, customerState, customerPin, customerPhone, customerEmail, customerPassword;
	public static String USER_ID, PASSWORD, CUSTOMER_ID;
	
}
