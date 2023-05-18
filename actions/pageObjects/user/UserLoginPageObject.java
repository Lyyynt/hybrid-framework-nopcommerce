package pageObjects.user;
import org.openqa.selenium.WebDriver;
import commons.BasePage;
import nopcommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

//	public void clickToLoginLink() {
//		waitForElementClickable(driver, LoginPageUI.LOGIN_LINK);
//		clickToElement(driver, LoginPageUI.LOGIN_LINK);
//	}

	public void inputToEmailTextbox(String email) {
		waitForElementClickable(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}
	
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
