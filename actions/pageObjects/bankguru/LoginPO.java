package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import bankguru.LoginUI;
import commons.BasePage;

public class LoginPO extends BasePage{
	private WebDriver driver;
	
	LoginPO(WebDriver driver){
		this.driver = driver;
	}

	public void inputToUserIDTextbox(String userId) {
		waitForElementVisible(driver, LoginUI.USERID_TEXTBOX);
		sendkeyToElement(driver, LoginUI.USERID_TEXTBOX, userId);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginUI.PASSWORD_TEXTBOX, password);
	}

	public HomePO clickLoginButton() {
		waitForElementClickable(driver, LoginUI.LOGIN_BUTTON);
		clickToElement(driver, LoginUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
