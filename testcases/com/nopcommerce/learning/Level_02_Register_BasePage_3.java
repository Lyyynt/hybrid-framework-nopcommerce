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

public class Level_02_Register_BasePage_3 extends BasePage {
	WebDriver driver;
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
		openPageUrl(driver, "https://demo.nopcommerce.com/");
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		// Verify error message displays
		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	}

	@Test
	public void TC_02_Register_With_Invalid_Email() {
		// Go to register page and enter invalid email -> click register button
		openPageUrl(driver, "https://demo.nopcommerce.com/");
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", "@gmail.com");
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		
		// Verify register message displays. (With email field, the message is "Wrong email")
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}
	
	@Test
	public void TC_03_Register_With_Valid_Information() {
		// Go to register page and enter valid information
		openPageUrl(driver, "https://demo.nopcommerce.com/");
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		waitForElementVisible(driver, "//input[@id='FirstName']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		waitForElementVisible(driver, "//input[@id='LastName']");
		sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", email);
		waitForElementVisible(driver, "//input[@id='Password']");
		sendkeyToElement(driver, "//input[@id='Password']", password);
		waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", confirmPassword);
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		// Verify register successful
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
	}
	
	@Test
	public void TC_04_Register_With_Exist_Email() {
		// Go to register page and enter email which was exist
		openPageUrl(driver, "https://demo.nopcommerce.com/");
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		waitForElementVisible(driver, "//input[@id='FirstName']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		waitForElementVisible(driver, "//input[@id='LastName']");
		sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", email);
		waitForElementVisible(driver, "//input[@id='Password']");
		sendkeyToElement(driver, "//input[@id='Password']", password);
		waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", confirmPassword);
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		// Verify "The specified email already exists" message display
		Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"), "The specified email already exists");
	}
	
	@Test
	public void TC_05_Register_With_Password_Length_Less_6() {
		// Go to register page and enter password with length password less 6 charactors
		openPageUrl(driver, "https://demo.nopcommerce.com/");
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		waitForElementVisible(driver, "//input[@id='FirstName']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		waitForElementVisible(driver, "//input[@id='LastName']");
		sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", email);
		waitForElementVisible(driver, "//input[@id='Password']");
		sendkeyToElement(driver, "//input[@id='Password']", "abc12");
		waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "abc12");
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		// Verify "Password must meet the following rules: \nmust have at least 6 characters" message display
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
	}
	
	@Test
	public void TC_06_Register_With_Confirm_Password_Not_Match_Password() {
		// Go to register page and enter confirm password not match with password
		openPageUrl(driver, "https://demo.nopcommerce.com/");
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		waitForElementVisible(driver, "//input[@id='FirstName']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		waitForElementVisible(driver, "//input[@id='LastName']");
		sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", email);
		waitForElementVisible(driver, "//input[@id='Password']");
		sendkeyToElement(driver, "//input[@id='Password']", "abc124");
		waitForElementVisible(driver, "//input[@id='ConfirmPassword']");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "abc125");
		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		// Verify "The password and confirmation password do not match." message display
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
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