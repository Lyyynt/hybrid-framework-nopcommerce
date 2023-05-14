package pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextbox;
	
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextbox;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;
	
	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;
	
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;
	
	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;
	
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;
	
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	private WebElement existingEmailMessage;
	
	@FindBy(xpath = "//a[contains(@class, 'register-continue-button')]")
	private WebElement continueButton;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
	}
	
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}
	
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}
	
	public void clickToContinueButton() {
		waitForElementClickable(driver, continueButton);
		clickToElement(driver, continueButton);
	}

	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}


	public String getExistEmailMessage() {
		waitForElementVisible(driver, existingEmailMessage);
		return getElementText(driver, existingEmailMessage);
	}

}
