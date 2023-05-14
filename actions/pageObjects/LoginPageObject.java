package pageObjects;
import org.openqa.selenium.WebDriver;
import commons.BasePage;
import nopcommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

//	public void clickToLoginLink() {
//		waitForElementClickable(driver, LoginPageUI.LOGIN_LINK);
//		clickToElement(driver, LoginPageUI.LOGIN_LINK);
//	}

	public void inputToEmailTextbox(String email) {
		waitForElementClickable(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public String getEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getEmailNotFoundMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_NOT_FOUND_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_NOT_FOUND_MESSAGE);
	}

}
