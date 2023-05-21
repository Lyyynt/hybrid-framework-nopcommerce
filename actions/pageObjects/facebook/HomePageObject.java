package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import facebook.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCreateNewAccountButtonDisplayed() {
		waitForElementVisible(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
		return isElementDisplayed(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public void inputKeyToTextboxByLabel(String key, String label) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX, label);
		sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX, key, label);
		
	}

	public boolean isTextboxByLabelDisplay(String label) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX, label);
		return isElementDisplayed(driver, HomePageUI.DYNAMIC_TEXTBOX, label);
	}

	public boolean isTextboxByLabelUndisplay(String label) {
		waitForElementInvisible(driver, HomePageUI.DYNAMIC_TEXTBOX, label);
		return isElementUndisplayed(driver, HomePageUI.DYNAMIC_TEXTBOX, label);
	}
}
