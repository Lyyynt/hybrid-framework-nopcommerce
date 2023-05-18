package com.nopcommerce.learning;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Level_11_Upload_Mutiple_Files extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	String duckFile = "duck.jpg";
	String mountainFile = "mountain.jpg";
	String treeFile = "tree.jpg";
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Jquery_01_Switch_Page() {
		homePage.uploadFileInWebPage(duckFile, mountainFile, treeFile);
		SleepInSecond(2);
		
		Assert.assertTrue(homePage.isImageLoadSuccessful(duckFile));
		Assert.assertTrue(homePage.isImageLoadSuccessful(mountainFile));
		Assert.assertTrue(homePage.isImageLoadSuccessful(treeFile));
		
		homePage.clickToStartUploadByFileName(duckFile);
		SleepInSecond(4);
		homePage.clickToStartUploadByFileName(mountainFile);
		SleepInSecond(4);
		homePage.clickToStartUploadByFileName(treeFile);
		SleepInSecond(4);
		
		Assert.assertTrue(homePage.isLoadedFileNameDisplay(duckFile));
		Assert.assertTrue(homePage.isLoadedFileNameDisplay(mountainFile));
		Assert.assertTrue(homePage.isLoadedFileNameDisplay(treeFile));
		Assert.assertTrue(homePage.isImageLoadedSuccessByFileName(treeFile));
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}