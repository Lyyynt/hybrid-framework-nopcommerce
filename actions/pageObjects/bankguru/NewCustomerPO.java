package pageObjects.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguru.NewCustomerUI;
import commons.BasePage;

public class NewCustomerPO  extends BasePage{
	private WebDriver driver;
	
	NewCustomerPO(WebDriver driver){
		this.driver = driver;
	}

	public void inputToCustomerName(String customerName) {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_NAME_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.CUSTOMER_NAME_TEXTBOX, customerName);
	}

	public void pressTabToMoveTheGenderField() {
		pressKeyToElement(driver, NewCustomerUI.CUSTOMER_NAME_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}
	public void pressTabToMoveTheCityField() {
		pressKeyToElement(driver, NewCustomerUI.CUSTOMER_ADDRESS_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}
	public void pressTabToMoveTheStateField() {
		pressKeyToElement(driver, NewCustomerUI.CUSTOMER_CITY_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}
	
	public void pressTabToMoveThePinField() {
		pressKeyToElement(driver, NewCustomerUI.CUSTOMER_STATE_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}
	
	public String getErrorNameMessage() {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_NAME_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerUI.CUSTOMER_NAME_ERROR_MESSAGE);
	}

	public void inputToCustomerAddress(String address) {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.CUSTOMER_ADDRESS_TEXTBOX, address);
	}

	public String getErrorAddressMessage() {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_ADDRESS_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerUI.CUSTOMER_ADDRESS_ERROR_MESSAGE);
	}

	public void inputToCustomerCity(String city) {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_CITY_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.CUSTOMER_CITY_TEXTBOX, city);
	}

	public String getErrorCityMessage() {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_CITY_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerUI.CUSTOMER_CITY_ERROR_MESSAGE);
	}

	public void inputToCustomerState(String state) {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_STATE_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.CUSTOMER_STATE_TEXTBOX, state);
	}
	
	public String getErrorStateMessage() {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_STATE_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerUI.CUSTOMER_STATE_ERROR_MESSAGE);
	}

	public void inputToCustomerPin(String pinNumber) {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_PIN_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.CUSTOMER_PIN_TEXTBOX, pinNumber);
	}

	public void pressTabToMoveTheMobilePhoneField() {
		pressKeyToElement(driver, NewCustomerUI.CUSTOMER_PIN_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}

	public String getErrorPinMessage() {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_PIN_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerUI.CUSTOMER_PIN_ERROR_MESSAGE);
	}

	public void inputToCustomerPhone(String phoneNumber) {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_PHONE_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.CUSTOMER_PHONE_TEXTBOX, phoneNumber);
	}

	public void pressTabToMoveTheEmailField() {
		pressKeyToElement(driver, NewCustomerUI.CUSTOMER_PHONE_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}

	public String getErrorPhoneMessage() {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_PHONE_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerUI.CUSTOMER_PHONE_ERROR_MESSAGE);
	}

	public void inputToCustomerEmail(String email) {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_EMAIL_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.CUSTOMER_EMAIL_TEXTBOX, email);
	}

	public void pressTabToMovePasswordField() {
		pressKeyToElement(driver, NewCustomerUI.CUSTOMER_EMAIL_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}

	public String getErrorEmailMessage() {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, NewCustomerUI.CUSTOMER_EMAIL_ERROR_MESSAGE);
	}

	public boolean isFieldExistByLabel(String fieldLabel) {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_FIELD_LABEL, fieldLabel);
		return isElementDisplayed(driver, NewCustomerUI.CUSTOMER_FIELD_LABEL, fieldLabel);
	}

	public void inputDateOfBirth(String dateOfBirth) {
		removeAttributeInDOM(driver, NewCustomerUI.CUSTOMER_DATE_OF_BIRTH_TEXTBOX, "type");
		SleepInSecond(2);
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_DATE_OF_BIRTH_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.CUSTOMER_DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, NewCustomerUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerUI.SUBMIT_BUTTON);
	}

	public void inputToCustomerPassword(String password) {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.CUSTOMER_PASSWORD_TEXTBOX, password);
	}

	public boolean isCreateSuccessfully() {
		waitForElementVisible(driver, NewCustomerUI.CREATE_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, NewCustomerUI.CREATE_SUCCESS_MESSAGE);
	}

	
}
