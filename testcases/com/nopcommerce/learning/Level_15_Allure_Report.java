package com.nopcommerce.learning;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;

@Epic("Regrestion Tests")
@Feature("Register and login")
public class Level_15_Allure_Report extends BaseTest{

	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	String firstName, lastName, email, password, confirmPassword;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Elon";
		lastName = "Musk";
		email = "elonmusk" + getRandomNumber() + "@gmail.com";
		password = "Abc13579";
		confirmPassword = "Abc13579";
	}

	@Description("Register with valid information")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Register_With_Valid_Information(Method method) {

		registerPage = homePage.clickToRegisterLink();
		
		registerPage.inputToFirstNameTextbox(firstName);
		
		registerPage.inputToLastNameTextbox(lastName);
		
		registerPage.inputToEmailTextbox(email);
		
		registerPage.inputToPasswordTextbox(password);
		
		registerPage.inputToConfirmPasswordTextbox(confirmPassword);
		
		registerPage.clickToRegisterButton();
		
		homePage = registerPage.clickToContinueButton();
	}
	
	@Description("Login with correct data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_02_Login_With_Correct_Data(Method method) {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(email);
		
		loginPage.inputToPasswordTextbox(password);
		
		loginPage.clickToLoginButton();
		
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}