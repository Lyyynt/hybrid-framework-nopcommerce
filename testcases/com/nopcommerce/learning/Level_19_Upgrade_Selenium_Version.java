package com.nopcommerce.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_19_Upgrade_Selenium_Version {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

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
	}
	/*
	 * With selenium v2, cannot install testng because it was exist in the selenium v2
	 * Firefox < v48 --> geckgodriver match with Firefox v47
	 * Chrome and Egde lastest
	 * 
	 * With selenium v3
	 * need install testng, need install driver
	 * requires: match with selenium + browser + driver
	 * 
	 * With selenium v4
	 * Request config selenium + browser + driver
	 * firefox, chrome, edge lastest
	 */
	@Test
	public void TC_01() {
		driver.get("https://www.facebook.com/");
	}


	public void SleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//note
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}