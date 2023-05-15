package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.user.UserChangePasswordUI;

public class UserChangePasswordPageObject extends BasePage{
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeyToOldPasswordTextbox(String oldPassword) {
		waitForElementVisible(driver, UserChangePasswordUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}

	public void sendKeyToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, UserChangePasswordUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	public void sendKeyToConfirmNewPasswordTextbox(String confirmNewPassword) {
		waitForElementVisible(driver, UserChangePasswordUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordUI.CONFIRM_NEW_PASSWORD_TEXTBOX, confirmNewPassword);
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, UserChangePasswordUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordUI.CHANGE_PASSWORD_BUTTON);
	}

	public String getToastMessage() {
		waitForElementVisible(driver, UserChangePasswordUI.TOAST_MESSAGE);
		return getElementText(driver, UserChangePasswordUI.TOAST_MESSAGE);
	}

	public void clickToCloseToastMessageButton() {
		waitForElementClickable(driver, UserChangePasswordUI.CLOSE_TOAST_MESSAGE_BUTTON);
		clickToElement(driver, UserChangePasswordUI.CLOSE_TOAST_MESSAGE_BUTTON);
	}
	
}
