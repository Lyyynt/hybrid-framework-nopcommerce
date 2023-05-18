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

public class Level_10_Data_Table_1 extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Jquery_01_Switch_Page() {
		homePage.paginationByPageNumber("5");
		Assert.assertTrue(homePage.isPageSelected("5"));
		
		homePage.paginationByPageNumber("10");
		Assert.assertTrue(homePage.isPageSelected("10"));
		
		homePage.paginationByPageNumber("22");
		Assert.assertTrue(homePage.isPageSelected("22"));
	}
	
	@Test
	public void Jquery_02_Search() {
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToDynamicTextboxByLabel("Country", "Afghanistan");
		SleepInSecond(2);
		homePage.inputToDynamicTextboxByLabel("Females", "764956");
		SleepInSecond(2);
		homePage.inputToDynamicTextboxByLabel("Males", "276472");
		SleepInSecond(2);
		homePage.inputToDynamicTextboxByLabel("Total", "578961");
		SleepInSecond(2);
	}
	
	@Test
	public void TC_03_Switch_Page_Before_Apply_Dynamic_Xpath() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage.clickToLoadDataButton();
		SleepInSecond(2);
		homePage.inputToCellByLabelAndRowNumber("Contact Person", "2", "Elon Musk");
		Assert.assertEquals(homePage.getValueInCellByLabelAndNumber("Contact Person", "2"), "Elon Musk");
		SleepInSecond(2);
		homePage.inputToCellByLabelAndRowNumber("Company", "7", "SpaceX");
		Assert.assertEquals(homePage.getValueInCellByLabelAndNumber("Company", "7"), "SpaceX");
		SleepInSecond(2);
		homePage.inputToCellByLabelAndRowNumber("Order Placed", "6", "500");
		Assert.assertEquals(homePage.getValueInCellByLabelAndNumber("Order Placed", "6"), "500");
		SleepInSecond(2);
		homePage.selectNpoCheckboxByLabelAndRowNumber("NPO?", "2");
		Assert.assertTrue(homePage.isNpoCheckboxSelectedByLabelAndRowNumber("NPO?", "2"));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}