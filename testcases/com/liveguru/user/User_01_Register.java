package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveguru.user.HomePO;
import pageObjects.liveguru.user.LoginPO;
import pageObjects.liveguru.user.MyAccountPO;
import pageObjects.liveguru.user.PageGeneratorManager;
import pageObjects.liveguru.user.RegisterPO;
import utilities.DataHelper;

public class User_01_Register extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		this.url = url;
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		dataHelper = DataHelper.getDataHelper();
		firstName = dataHelper.getFirstName();
		lastName = dataHelper.getLastName();
		fullName = firstName + " " + lastName;
		email = dataHelper.getEmailAddress();
		password = "111111";
		confirmPassword = "111111";
	}
	
	@Test
	public void User_TC01_Require_Field_Not_Empty() {
		log.info("User 01 - Step 1: Click to My Account footer link");
		homePage.clickToFooterLinkByLabel(driver, "My Account");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("User 01 - Step 2: Click to Create an Account button");
		loginPage.clickToButtonByLabel(driver, "Create an Account");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("User 01 - Step 3: Click to Register button");
		registerPage.clickToButtonByLabel(driver, "Register");
		
		log.info("User 01 - Step 4: Verify the error message with first name field");
		verifyEquals(registerPage.getErrorMessageByFieldLabel(driver, "First Name"), "This is a required field.");
		
		log.info("User 01 - Step 4: Verify the error message with first name field");
		verifyEquals(registerPage.getErrorMessageByFieldLabel(driver, "Last Name"), "This is a required field.");
		
		log.info("User 01 - Step 4: Verify the error message with first name field");
		verifyEquals(registerPage.getErrorMessageByFieldLabel(driver, "Email Address"), "This is a required field.");
		
		log.info("User 01 - Step 4: Verify the error message with first name field");
		verifyEquals(registerPage.getErrorMessageByFieldLabel(driver, "Password"), "This is a required field.");
		
		log.info("User 01 - Step 4: Verify the error message with first name field");
		verifyEquals(registerPage.getErrorMessageByFieldLabel(driver, "Confirm Password"), "This is a required field.");
		
	}
	
	@Test
	public void User_TC02_Register_Success() {
		log.info("User 02 - Step 1: Input to First Name textbox");
		registerPage.inputToTextboxWithValue(driver, "First Name", firstName);
		
		log.info("User 02 - Step 2: Input to Last Name textbox");
		registerPage.inputToTextboxWithValue(driver, "Last Name", lastName);
		
		log.info("User 02 - Step 3: Input to Email Address textbox");
		registerPage.inputToTextboxWithValue(driver, "Email Address", email);
		
		log.info("User 02 - Step 4: Input to Password textbox");
		registerPage.inputToTextboxWithValue(driver, "Password", password);
		
		log.info("User 02 - Step 5: Input to Confirm Password textbox");
		registerPage.inputToTextboxWithValue(driver, "Confirm Password", confirmPassword);
		
		log.info("User 02 - Step 6: Click to Register button");
		registerPage.clickToButtonByLabel(driver, "Register");
		myAccountPage = PageGeneratorManager.getMyDashboardPage(driver);
		
		log.info("User 02 - Step 7: Verify register successful");
		verifyEquals(myAccountPage.getSuccessMessage(driver), "Thank you for registering with Main Website Store.");
	}
	
	@Test
	public void User_TC03_Verify_User_Information_Correct() {
		log.info("User 03 - Step 1: Verify user infomation with full name correct");
		verifyTrue(myAccountPage.getUserInformationByLabel("Contact Information").contains(fullName));
		
		log.info("User 03 - Step 2: Verify user infomation with email correct");
		verifyTrue(myAccountPage.getUserInformationByLabel("Contact Information").contains(email));
	}
	
	@Test
	public void User_TC04_Register_With_Exist_Email() {
		log.info("User 04 - Step 1: Open the homepage");
		myAccountPage.openPageUrl(driver, url);
		
		log.info("User 04 - Step 2: Click to My Account footer link");
		homePage.clickToFooterLinkByLabel(driver, "My Account");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("User 04 - Step 3: Click to Create an Account button");
		loginPage.clickToButtonByLabel(driver, "Create an Account");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("User 04 - Step 4: Input to First Name textbox");
		registerPage.inputToTextboxWithValue(driver, "First Name", firstName);
		
		log.info("User 04 - Step 5: Input to Last Name textbox");
		registerPage.inputToTextboxWithValue(driver, "Last Name", lastName);
		
		log.info("User 04 - Step 6: Input to Email Address textbox");
		registerPage.inputToTextboxWithValue(driver, "Email Address", email);
		
		log.info("User 04 - Step 7: Input to Password textbox");
		registerPage.inputToTextboxWithValue(driver, "Password", password);
		
		log.info("User 04 - Step 8: Input to Confirm Password textbox");
		registerPage.inputToTextboxWithValue(driver, "Confirm Password", confirmPassword);
		
		log.info("User 04 - Step 9: Click to Register button");
		registerPage.clickToButtonByLabel(driver, "Register");
		
		log.info("User 04 - Step 10: Register not successful with message");
		verifyEquals(registerPage.getErrorMessage(driver), "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
		
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver("local");
	}

	private WebDriver driver;
	private HomePO homePage;
	private RegisterPO registerPage;
	private LoginPO loginPage;
	private MyAccountPO myAccountPage;
	public static String firstName, lastName, fullName, email, password, confirmPassword;
	private String url;
	private DataHelper dataHelper;
}
