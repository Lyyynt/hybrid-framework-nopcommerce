package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.ChangePasswordUI;

public class ChangePasswordPageObject extends BasePage{
	WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeyToOldPasswordTextbox(String oldPassword) {
		waitForElementVisible(driver, ChangePasswordUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}

	public void sendKeyToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, ChangePasswordUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	public void sendKeyToConfirmNewPasswordTextbox(String confirmNewPassword) {
		waitForElementVisible(driver, ChangePasswordUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, ChangePasswordUI.CONFIRM_NEW_PASSWORD_TEXTBOX, confirmNewPassword);
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, ChangePasswordUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordUI.CHANGE_PASSWORD_BUTTON);
	}

	public String getToastMessage() {
		waitForElementVisible(driver, ChangePasswordUI.TOAST_MESSAGE);
		return getElementText(driver, ChangePasswordUI.TOAST_MESSAGE);
	}

	public void clickToCloseToastMessageButton() {
		waitForElementClickable(driver, ChangePasswordUI.CLOSE_TOAST_MESSAGE_BUTTON);
		clickToElement(driver, ChangePasswordUI.CLOSE_TOAST_MESSAGE_BUTTON);
	}

	public HomePageObject clickLogOutLink() {
		waitForElementClickable(driver, ChangePasswordUI.LOGOUT_LINK);
		clickToElement(driver, ChangePasswordUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	
}
