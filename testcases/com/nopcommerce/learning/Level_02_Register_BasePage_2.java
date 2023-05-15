package com.nopcommerce.learning;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_BasePage_2 {
	WebDriver driver;
	BasePage basePage;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, email, password, confirmPassword;
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		basePage = BasePage.getBasePageObject();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		firstName = "Elon";
		lastName = "Musk";
		email = "elonmusk" + getRandomNumber() + "@gmail.com";
		password = "Abc13579";
		confirmPassword = "Abc13579";
	}

	@Test
	public void TC_01_Register_With_Empty_Data() {
		// Go to register page and click register button
		basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		// Verify error message displays
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	}

	@Test
	public void TC_02_Register_With_Invalid_Email() {
		// Go to register page and enter invalid email -> click register button
		basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.waitForElementVisible(driver, "//input[@id='Email']");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", "@gmail.com");
		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		
		// Verify register message displays. (With email field, the message is "Wrong email")
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}
	
	@Test
	public void TC_03_Register_With_Valid_Information() {
		// Go to register page and enter valid information
		basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.waitForElementVisible(driver, "//input[@id='FirstName']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		basePage.waitForElementVisible(driver, "//input[@id='LastName']");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		basePage.waitForElementVisible(driver, "//input[@id='Email']");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", email);
		basePage.waitForElementVisible(driver, "//input[@id='Password']");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", password);
		basePage.waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", confirmPassword);
		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		// Verify register successful
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
	}
	
	@Test
	public void TC_04_Register_With_Exist_Email() {
		// Go to register page and enter email which was exist
		basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.waitForElementVisible(driver, "//input[@id='FirstName']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		basePage.waitForElementVisible(driver, "//input[@id='LastName']");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		basePage.waitForElementVisible(driver, "//input[@id='Email']");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", email);
		basePage.waitForElementVisible(driver, "//input[@id='Password']");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", password);
		basePage.waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", confirmPassword);
		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		// Verify "The specified email already exists" message display
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='message-error validation-summary-errors']"), "The specified email already exists");
	}
	
	@Test
	public void TC_05_Register_With_Password_Length_Less_6() {
		// Go to register page and enter password with length password less 6 charactors
		basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.waitForElementVisible(driver, "//input[@id='FirstName']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		basePage.waitForElementVisible(driver, "//input[@id='LastName']");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		basePage.waitForElementVisible(driver, "//input[@id='Email']");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", email);
		basePage.waitForElementVisible(driver, "//input[@id='Password']");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "abc12");
		basePage.waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "abc12");
		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		// Verify "Password must meet the following rules: \nmust have at least 6 characters" message display
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
	}
	
	@Test
	public void TC_06_Register_With_Confirm_Password_Not_Match_Password() {
		// Go to register page and enter confirm password not match with password
		basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.waitForElementVisible(driver, "//input[@id='FirstName']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		basePage.waitForElementVisible(driver, "//input[@id='LastName']");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		basePage.waitForElementVisible(driver, "//input[@id='Email']");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", email);
		basePage.waitForElementVisible(driver, "//input[@id='Password']");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "abc124");
		basePage.waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "abc125");
		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		// Verify "The password and confirmation password do not match." message display
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
	}
	
	public void SleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getRandomNumber() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(99999);
		return randomNumber;
	}

	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}