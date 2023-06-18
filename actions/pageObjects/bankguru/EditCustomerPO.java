package pageObjects.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguru.EditCustomerUI;
import commons.BasePage;

public class EditCustomerPO extends BasePage{
	private WebDriver driver;
	
	EditCustomerPO(WebDriver driver){
		this.driver = driver;
	}

	public void inputCustomerID(String customerId) {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_ID_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.CUSTOMER_ID_TEXTBOX, customerId);
	}

	public void clickSubmitButton() {
		waitForElementClickable(driver, EditCustomerUI.SUBMIT_BUTTON);
		clickToElement(driver, EditCustomerUI.SUBMIT_BUTTON);
	}

	public void pressTabToMoveNextFields() {
		pressKeyToElement(driver, EditCustomerUI.CUSTOMER_ID_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}

	public String getErrorCustomerIDMessage() {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_ID_ERROR_MESSAGE);
		return getElementText(driver, EditCustomerUI.CUSTOMER_ID_ERROR_MESSAGE);
	}
	
	public void inputToCustomerAddress(String address) {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.CUSTOMER_ADDRESS_TEXTBOX, address);
	}

	public String getErrorAddressMessage() {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_ADDRESS_ERROR_MESSAGE);
		return getElementText(driver, EditCustomerUI.CUSTOMER_ADDRESS_ERROR_MESSAGE);
	}
	
	public void pressTabToMoveTheCityField() {
		pressKeyToElement(driver, EditCustomerUI.CUSTOMER_ADDRESS_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}
	
	public void inputToCustomerCity(String city) {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_CITY_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.CUSTOMER_CITY_TEXTBOX, city);
	}

	public String getErrorCityMessage() {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_CITY_ERROR_MESSAGE);
		return getElementText(driver, EditCustomerUI.CUSTOMER_CITY_ERROR_MESSAGE);
	}
	
	public void pressTabToMoveTheStateField() {
		pressKeyToElement(driver, EditCustomerUI.CUSTOMER_CITY_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}
	
	public void inputToCustomerState(String state) {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_STATE_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.CUSTOMER_STATE_TEXTBOX, state);
	}
	
	public String getErrorStateMessage() {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_STATE_ERROR_MESSAGE);
		return getElementText(driver, EditCustomerUI.CUSTOMER_STATE_ERROR_MESSAGE);
	}

	public void inputToCustomerPin(String pinNumber) {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_PIN_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.CUSTOMER_PIN_TEXTBOX, pinNumber);
	}

	public void pressTabToMoveTheMobilePhoneField() {
		pressKeyToElement(driver, EditCustomerUI.CUSTOMER_PIN_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}

	public String getErrorPinMessage() {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_PIN_ERROR_MESSAGE);
		return getElementText(driver, EditCustomerUI.CUSTOMER_PIN_ERROR_MESSAGE);
	}
	
	public void pressTabToMoveThePinField() {
		pressKeyToElement(driver, EditCustomerUI.CUSTOMER_STATE_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}
	
	public void inputToCustomerPhone(String phoneNumber) {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_PHONE_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.CUSTOMER_PHONE_TEXTBOX, phoneNumber);
	}

	public void pressTabToMoveTheEmailField() {
		pressKeyToElement(driver, EditCustomerUI.CUSTOMER_PHONE_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}

	public String getErrorPhoneMessage() {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_PHONE_ERROR_MESSAGE);
		return getElementText(driver, EditCustomerUI.CUSTOMER_PHONE_ERROR_MESSAGE);
	}

	public void inputToCustomerEmail(String email) {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_EMAIL_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.CUSTOMER_EMAIL_TEXTBOX, email);
	}

	public void pressTabToMovePasswordField() {
		pressKeyToElement(driver, EditCustomerUI.CUSTOMER_EMAIL_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}

	public String getErrorEmailMessage() {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, EditCustomerUI.CUSTOMER_EMAIL_ERROR_MESSAGE);
	}
	
	public void inputToCustomerName(String customerName) {
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_NAME_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.CUSTOMER_NAME_TEXTBOX, customerName);
	}
	
	public void inputDateOfBirth(String dateOfBirth) {
		removeAttributeInDOM(driver, EditCustomerUI.CUSTOMER_DATE_OF_BIRTH_TEXTBOX, "type");
		SleepInSecond(2);
		waitForElementVisible(driver, EditCustomerUI.CUSTOMER_DATE_OF_BIRTH_TEXTBOX);
		sendkeyToElement(driver, EditCustomerUI.CUSTOMER_DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
	}
	
	public void clickToSubmitButton() {
		waitForElementClickable(driver, EditCustomerUI.SUBMIT_BUTTON);
		clickToElement(driver, EditCustomerUI.SUBMIT_BUTTON);
	}

	public boolean isUpdateSuccessfully() {
		waitForElementVisible(driver, EditCustomerUI.UPDATE_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, EditCustomerUI.UPDATE_SUCCESS_MESSAGE);
	}
}
