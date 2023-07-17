package com.overleaf;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.overleaf.HomePO;
import pageObjects.overleaf.PageGeneratorManager;
import pageObjects.overleaf.RegisterPO;

public class Overleaf_01_Register extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	@Test
	public void Overleaf_01_Register_With_Empty_Data() {
		log.info("Overleaf - 01: Step 1: Click to header link by label");
		homePage.clickToHeaderLinkByLabel(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("Overleaf - 01: Step 2: Input empty to email field");
		registerPage.inputToDynamicTextboxByID(driver, "email", "");
		
		log.info("Overleaf - 01: Step 3: Input empty to password field");
		registerPage.inputToDynamicTextboxByID(driver, "passwordField", "");
		
		log.info("Overleaf - 01: Step 4: Click to Register button");
		registerPage.clickToDynamicButtonByLabel(driver, "Register using your email");
		
		log.info("Overleaf - 01: Step 5: Verify error message in email field");
		verifyEquals(registerPage.getErrorMessageByFieldID(driver, "email"), "Please fill out this field.");
		
		log.info("Overleaf - 01: Step 6: Verify error message in password field");
		verifyEquals(registerPage.getErrorMessageByFieldID(driver, "passwordField"), "Please fill out this field.");
		
	}
	
	@Test
	public void Overleaf_02_Register_With_Wrong_Email() {
		log.info("Overleaf - 02: Step 1: Click to header link by label");
		homePage.clickToHeaderLinkByLabel(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("Overleaf - 02: Step 2: Input Elon to email field");
		registerPage.inputToDynamicTextboxByID(driver, "email", "Elon");
		
		log.info("Overleaf - 02: Step 3: Input empty to password field");
		registerPage.inputToDynamicTextboxByID(driver, "passwordField", "");
		
		log.info("Overleaf - 02: Step 4: Click to Register button");
		registerPage.clickToDynamicButtonByLabel(driver, "Register using your email");
		
		log.info("Overleaf - 02: Step 5: Verify error message in email field");
		verifyEquals(registerPage.getErrorMessageByFieldID(driver, "email"), "Please include an '@' in the email address. 'Elon' is missing an '@'.");
		
		log.info("Overleaf - 02: Step 6: Verify error message in password field");
		verifyEquals(registerPage.getErrorMessageByFieldID(driver, "passwordField"), "Please fill out this field.");
		
	}
	
	@Test
	public void Overleaf_03_Register_With_Incomplete_Email() {
		log.info("Overleaf - 03: Step 1: Click to header link by label");
		homePage.clickToHeaderLinkByLabel(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("Overleaf - 03: Step 2: Input Elon to email field");
		registerPage.inputToDynamicTextboxByID(driver, "email", "Elon@");
		
		log.info("Overleaf - 03: Step 3: Input empty to password field");
		registerPage.inputToDynamicTextboxByID(driver, "passwordField", "");
		
		log.info("Overleaf - 03: Step 4: Click to Register button");
		registerPage.clickToDynamicButtonByLabel(driver, "Register using your email");
		
		log.info("Overleaf - 03: Step 5: Verify error message in email field");
		verifyEquals(registerPage.getErrorMessageByFieldID(driver, "email"), "Please enter a part following '@'. 'Elon@' is incomplete.");
		
		log.info("Overleaf - 03: Step 6: Verify error message in password field");
		verifyEquals(registerPage.getErrorMessageByFieldID(driver, "passwordField"), "Please fill out this field.");
		
	}
	
	@Test
	public void Overleaf_04_Register_With_Exist_Email() {
		log.info("Overleaf - 04: Step 1: Click to header link by label");
		homePage.clickToHeaderLinkByLabel(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("Overleaf - 04: Step 2: Input Elon to email field");
		registerPage.inputToDynamicTextboxByID(driver, "email", "thuylinh2409nguyen@gmail.com");
		
		log.info("Overleaf - 04: Step 3: Input empty to password field");
		registerPage.inputToDynamicTextboxByID(driver, "passwordField", "Abc13579");
		
		log.info("Overleaf - 04: Step 4: Click to Register button");
		registerPage.clickToDynamicButtonByLabel(driver, "Register using your email");
		
		log.info("Overleaf - 04: Step 5: Verify alert display with message");
		verifyTrue(registerPage.isAlertDisplayWithLabel("This email is already registered"));
		
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver("local");
	}

	private WebDriver driver;
	private HomePO homePage;
	private RegisterPO registerPage;
}
