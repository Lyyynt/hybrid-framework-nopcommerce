package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.user.UserAddressesUI;

public class UserAddAddressesObject extends BasePage{
	WebDriver driver;

	public UserAddAddressesObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddNewButton() {
		waitForElementClickable(driver, UserAddressesUI.ADD_NEW_BUTTON);
		clickToElement(driver, UserAddressesUI.ADD_NEW_BUTTON);
		
	}

	public void sendKeyToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserAddressesUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserAddressesUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void sendKeyToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserAddressesUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserAddressesUI.LASTNAME_TEXTBOX, lastName);
	}

	public void sendKeyToEmailTextbox(String email) {
		waitForElementVisible(driver, UserAddressesUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserAddressesUI.EMAIL_TEXTBOX, email);
	}

	public void sendKeyToCompanyTextbox(String companyName) {
		waitForElementVisible(driver, UserAddressesUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserAddressesUI.COMPANY_TEXTBOX, companyName);
	}

	public void selectCountryDropdown(String countryName) {
		waitForElementVisible(driver, UserAddressesUI.COUNTRY_DROPDOWN);
		selectItemDefaultDropdown(driver, UserAddressesUI.COUNTRY_DROPDOWN, countryName);
	}

	public void selectStateDropdown(String state) {
		waitForElementVisible(driver, UserAddressesUI.STATE_DROPDOWN);
		selectItemDefaultDropdown(driver, UserAddressesUI.STATE_DROPDOWN, state);
	}

	public void sendKeyToCityTextbox(String cityName) {
		waitForElementVisible(driver, UserAddressesUI.CITY_TEXTBOX);
		sendkeyToElement(driver, UserAddressesUI.CITY_TEXTBOX, cityName);
	}

	public void sendKeyToAddress2Textbox(String address) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS2_TEXTBOX);
		sendkeyToElement(driver, UserAddressesUI.ADDRESS2_TEXTBOX, address);
	}

	public void sendKeyToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, UserAddressesUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, UserAddressesUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void sendKeyToAddress1Textbox(String address) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, UserAddressesUI.ADDRESS1_TEXTBOX, address);
	}

	public void sendKeyToPortalCodeTextbox(String portalCode) {
		waitForElementVisible(driver, UserAddressesUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, UserAddressesUI.ZIPCODE_TEXTBOX, portalCode);
	}

	public void sendKeyToFaxTextbox(String faxNumber) {
		waitForElementVisible(driver, UserAddressesUI.FAX_TEXTBOX);
		sendkeyToElement(driver, UserAddressesUI.FAX_TEXTBOX, faxNumber);
	}

	public String getNameTitle() {
		waitForElementVisible(driver, UserAddressesUI.NAME_TEXT);
		return getElementText(driver, UserAddressesUI.NAME_TEXT);
	}

	public String getToastMessage() {
		waitForElementVisible(driver, UserAddressesUI.TOAST_MESSAGE);
		return getElementText(driver, UserAddressesUI.TOAST_MESSAGE);
	}

	public String getEmailText() {
		waitForElementVisible(driver, UserAddressesUI.EMAIL_TEXT);
		return getElementText(driver, UserAddressesUI.EMAIL_TEXT);
	}

	public String getPhoneNumberText() {
		waitForElementVisible(driver, UserAddressesUI.PHONE_NUMBER_TEXT);
		return getElementText(driver, UserAddressesUI.PHONE_NUMBER_TEXT);
	}

	public String getAddress1Text() {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS1_TEXT);
		return getElementText(driver, UserAddressesUI.ADDRESS1_TEXT);
	}

	public String getCityAndStateZip() {
		waitForElementVisible(driver, UserAddressesUI.CITY_STATE_ZIP_TEXT);
		return getElementText(driver, UserAddressesUI.CITY_STATE_ZIP_TEXT);
	}

	public String getCountry() {
		waitForElementVisible(driver, UserAddressesUI.COUNTRY_TEXT);
		return getElementText(driver, UserAddressesUI.COUNTRY_TEXT);
	}

	public void clickToCloseToastMessageButton() {
		waitForElementClickable(driver, UserAddressesUI.CLOSE_TOAST_MESSAGE_BUTTON);
		clickToElement(driver, UserAddressesUI.CLOSE_TOAST_MESSAGE_BUTTON);
		
	}

	public String getFaxText() {
		waitForElementVisible(driver, UserAddressesUI.FAX_NUMBER_TEXT);
		return getElementText(driver, UserAddressesUI.FAX_NUMBER_TEXT);
	}

	public void clickSaveButton() {
		waitForElementClickable(driver, UserAddressesUI.SAVE_BUTTON);
		clickToElement(driver, UserAddressesUI.SAVE_BUTTON);
	}
	
	
	
}
