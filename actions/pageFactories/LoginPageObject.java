package pageFactories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import commons.BasePageFactory;
import nopcommerce.user.UserLoginPageUI;

public class LoginPageObject extends BasePageFactory {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath="//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath="//div[contains(@class, 'validation-summary-errors')]")
	private WebElement emailNotFoundMessage;
	
	@FindBy(xpath="//button[contains(@class, 'login-button')]")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[@class='ico-login']")
	private WebElement loginLink;
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver,emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}
	
	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getEmailNotFoundMessage() {
		waitForElementVisible(driver, emailNotFoundMessage);
		return getElementText(driver, emailNotFoundMessage);
	}

}
