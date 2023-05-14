package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;


public class Topic_00_Template_TestCase extends BaseTest{
	// This template is always up-to-date according to the latest knowledge
	// Now is OOP and Mutiple Browser
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("");
	}
	
	@Test
	public void TC_01() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
