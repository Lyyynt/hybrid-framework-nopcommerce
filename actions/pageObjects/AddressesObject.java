package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.AddressesUI;

public class AddressesObject extends BasePage{
	WebDriver driver;

	public AddressesObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddNewButton() {
		waitForElementClickable(driver, AddressesUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressesUI.ADD_NEW_BUTTON);
		
	}

	public void sendKeyToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AddressesUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, AddressesUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void sendKeyToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, AddressesUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, AddressesUI.LASTNAME_TEXTBOX, lastName);
	}

	public void sendKeyToEmailTextbox(String email) {
		waitForElementVisible(driver, AddressesUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AddressesUI.EMAIL_TEXTBOX, email);
	}

	public void sendKeyToCompanyTextbox(String companyName) {
		waitForElementVisible(driver, AddressesUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, AddressesUI.COMPANY_TEXTBOX, companyName);
	}

	public void selectCountryDropdown(String countryName) {
		waitForElementVisible(driver, AddressesUI.COUNTRY_DROPDOWN);
		selectItemDefaultDropdown(driver, AddressesUI.COUNTRY_DROPDOWN, countryName);
	}

	public void selectStateDropdown(String state) {
		waitForElementVisible(driver, AddressesUI.STATE_DROPDOWN);
		selectItemDefaultDropdown(driver, AddressesUI.STATE_DROPDOWN, state);
	}

	public void sendKeyToCityTextbox(String cityName) {
		waitForElementVisible(driver, AddressesUI.CITY_TEXTBOX);
		sendkeyToElement(driver, AddressesUI.CITY_TEXTBOX, cityName);
	}

	public void sendKeyToAddress2Textbox(String address) {
		waitForElementVisible(driver, AddressesUI.ADDRESS2_TEXTBOX);
		sendkeyToElement(driver, AddressesUI.ADDRESS2_TEXTBOX, address);
	}

	public void sendKeyToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, AddressesUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AddressesUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void sendKeyToAddress1Textbox(String address) {
		waitForElementVisible(driver, AddressesUI.ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, AddressesUI.ADDRESS1_TEXTBOX, address);
	}

	public void sendKeyToPortalCodeTextbox(String portalCode) {
		waitForElementVisible(driver, AddressesUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, AddressesUI.ZIPCODE_TEXTBOX, portalCode);
	}

	public void sendKeyToFaxTextbox(String faxNumber) {
		waitForElementVisible(driver, AddressesUI.FAX_TEXTBOX);
		sendkeyToElement(driver, AddressesUI.FAX_TEXTBOX, faxNumber);
	}

	public String getNameTitle() {
		waitForElementVisible(driver, AddressesUI.NAME_TEXT);
		return getElementText(driver, AddressesUI.NAME_TEXT);
	}

	public String getToastMessage() {
		waitForElementVisible(driver, AddressesUI.TOAST_MESSAGE);
		return getElementText(driver, AddressesUI.TOAST_MESSAGE);
	}

	public String getEmailText() {
		waitForElementVisible(driver, AddressesUI.EMAIL_TEXT);
		return getElementText(driver, AddressesUI.EMAIL_TEXT);
	}

	public String getPhoneNumberText() {
		waitForElementVisible(driver, AddressesUI.PHONE_NUMBER_TEXT);
		return getElementText(driver, AddressesUI.PHONE_NUMBER_TEXT);
	}

	public String getAddress1Text() {
		waitForElementVisible(driver, AddressesUI.ADDRESS1_TEXT);
		return getElementText(driver, AddressesUI.ADDRESS1_TEXT);
	}

	public String getCityAndStateZip() {
		waitForElementVisible(driver, AddressesUI.CITY_STATE_ZIP_TEXT);
		return getElementText(driver, AddressesUI.CITY_STATE_ZIP_TEXT);
	}

	public String getCountry() {
		waitForElementVisible(driver, AddressesUI.COUNTRY_TEXT);
		return getElementText(driver, AddressesUI.COUNTRY_TEXT);
	}

	public void clickToCloseToastMessageButton() {
		waitForElementClickable(driver, AddressesUI.CLOSE_TOAST_MESSAGE_BUTTON);
		clickToElement(driver, AddressesUI.CLOSE_TOAST_MESSAGE_BUTTON);
		
	}

	public String getFaxText() {
		waitForElementVisible(driver, AddressesUI.FAX_NUMBER_TEXT);
		return getElementText(driver, AddressesUI.FAX_NUMBER_TEXT);
	}

	public void clickToChangePasswordTab() {
		waitForElementClickable(driver, AddressesUI.CHANGE_PASSWORD_TAB);
		clickToElement(driver, AddressesUI.CHANGE_PASSWORD_TAB);
	}
	
	
	
}
