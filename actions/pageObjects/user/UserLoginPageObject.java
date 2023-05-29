package pageObjects.user;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import nopcommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to login button")
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

//	public void clickToLoginLink() {
//		waitForElementClickable(driver, LoginPageUI.LOGIN_LINK);
//		clickToElement(driver, LoginPageUI.LOGIN_LINK);
//	}
	
	@Step("Input email textbox by value: {0}")
	public void inputToEmailTextbox(String email) {
		waitForElementClickable(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}
	
	@Step("Input password textbox by value: {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public String getEmailErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getEmailNotFoundMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_NOT_FOUND_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_NOT_FOUND_MESSAGE);
	}

}
