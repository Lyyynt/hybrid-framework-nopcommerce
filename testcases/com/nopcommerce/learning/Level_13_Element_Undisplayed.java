package com.nopcommerce.learning;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;

@Listeners(commons.MethodListener.class)
public class Level_13_Element_Undisplayed extends BaseTest {
	/* Knowledge
	 * // Have 2 ways to verify the text box is NOT displayed  
	 * 1.
	 * verifyFalse(homePage.isElementDisplay()) -> this way is pretty bad because
	 * this case will fail with exception NoSuchElement (Element not in DOM)
	 * So, cannot find element -> cannot throw status of element display 
	 * 2.
	 * verifyTrue(homePage.isElementUndisplay())
	 * We need to create isElementUndisplay in BasePage and this function will return true if NoSuchElement 
	 * or (Exist Element and element is NOT displayed) 
	 * This way is better than the first way because this case will not fail 
	 * but, if NoSuchElement situation occurs, we need to spend the time to wait the find element process. 
	 * -> not save resource // So, we need to custom isElementUndisplay and in this function, 
	 * the implicit wait timeout will be overridden before and after the find element process
	 */	
	WebDriver driver;
	HomePageObject homePage;
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Facebook_01_Element_Display() {
		verifyTrue(homePage.isCreateNewAccountButtonDisplayed());
	}
	
	@Test
	public void Facebook_02_Element_Not_Display_But_In_DOM() {
		homePage.clickToCreateNewAccountButton();
		homePage.inputKeyToTextboxByLabel("elonmusk123@gmail.com", "Mobile number or email address");
		verifyTrue(homePage.isTextboxByLabelDisplay("Re-enter email address"));
	}
	
	@Test
	public void Facebook_03_Element_Not_Display_And_Not_In_DOM() {
		homePage.inputKeyToTextboxByLabel("", "Mobile number or email address");
		verifyTrue(homePage.isTextboxByLabelUndisplay("Re-enter email address"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}