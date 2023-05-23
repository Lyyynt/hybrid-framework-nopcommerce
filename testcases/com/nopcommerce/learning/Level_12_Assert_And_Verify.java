package com.nopcommerce.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

@Listeners(commons.MethodListener.class)
public class Level_12_Assert_And_Verify extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		verifyEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
		verifyEquals(driver.getTitle(), "Facebook – log in or sign up");
		Assert.assertFalse(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}