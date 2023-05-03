package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.CustomerInformationUI;

public class CustomerInformationPageObject extends BasePage{
	WebDriver driver;

	public CustomerInformationPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderRadio() {
		waitForElementVisible(driver, CustomerInformationUI.FEMALE_GENDER_RADIO_BUTTON);
		clickToElement(driver, CustomerInformationUI.FEMALE_GENDER_RADIO_BUTTON);
	}
	
	public void sendKeyToFirstNameTextbox(String newFirstName) {
		waitForElementVisible(driver, CustomerInformationUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInformationUI.FIRSTNAME_TEXTBOX, newFirstName);
	}
	
	public void sendKeyToLastNameTextbox(String newLastName) {
		waitForElementVisible(driver, CustomerInformationUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInformationUI.LASTNAME_TEXTBOX, newLastName);
	}
	
	public void selectDayOfBirth(String dayOfBirth) {
		waitForElementVisible(driver, CustomerInformationUI.DAY_OF_BIRTH_DROPDOWN);
		selectItemDefaultDropdown(driver, CustomerInformationUI.DAY_OF_BIRTH_DROPDOWN, dayOfBirth);
	}
	
	public void selectMonthOfBirth(String monthOfBirth) {
		waitForElementVisible(driver, CustomerInformationUI.MONTH_OF_BIRTH_DROPDOWN);
		selectItemDefaultDropdown(driver, CustomerInformationUI.MONTH_OF_BIRTH_DROPDOWN, monthOfBirth);
	}
	
	public void selectYearOfBirth(String yearOfBirth) {
		waitForElementVisible(driver, CustomerInformationUI.YEAR_OF_BIRTH_DROPDOWN);
		selectItemDefaultDropdown(driver, CustomerInformationUI.YEAR_OF_BIRTH_DROPDOWN, yearOfBirth);
	}

	public void selectDateOfBirthDropdown(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
		selectDayOfBirth(dayOfBirth);
		selectMonthOfBirth(monthOfBirth);
		selectYearOfBirth(yearOfBirth);
	}

	public void sendKeyToEmailTextbox(String newEmail) {
		waitForElementVisible(driver, CustomerInformationUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CustomerInformationUI.EMAIL_TEXTBOX, newEmail);
	}

	public void sendKeyToCompanyNameTextbox(String companyName) {
		waitForElementVisible(driver, CustomerInformationUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInformationUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	public void clickToSaveButton() {
		waitForElementVisible(driver, CustomerInformationUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInformationUI.SAVE_BUTTON);
	}

	public String getToastMessage() {
		waitForElementVisible(driver, CustomerInformationUI.TOAST_MESSAGE);
		return getElementText(driver, CustomerInformationUI.TOAST_MESSAGE);
	}

	public boolean isFemaleGender() {
		waitForElementVisible(driver, CustomerInformationUI.FEMALE_GENDER_RADIO_BUTTON);
		return isElementSelected(driver, CustomerInformationUI.FEMALE_GENDER_RADIO_BUTTON);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, CustomerInformationUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInformationUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, CustomerInformationUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInformationUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, CustomerInformationUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerInformationUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyNameTextboxValue() {
		waitForElementVisible(driver, CustomerInformationUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInformationUI.COMPANY_NAME_TEXTBOX, "value");
	}

	public void clickToAddressesTab() {
		waitForElementVisible(driver, CustomerInformationUI.ADDRESSES_TAB);
		clickToElement(driver, CustomerInformationUI.ADDRESSES_TAB);
	}

	public String getValueDayOfBirthTextbox() {
		waitForElementVisible(driver, CustomerInformationUI.DAY_OF_BIRTH_DROPDOWN);
		return getSelectedItemDefaultDropdown(driver, CustomerInformationUI.COMPANY_NAME_TEXTBOX);
	}

	public String getValueMonthOfBirthTextbox() {
		waitForElementVisible(driver, CustomerInformationUI.MONTH_OF_BIRTH_DROPDOWN);
		return getSelectedItemDefaultDropdown(driver, CustomerInformationUI.MONTH_OF_BIRTH_DROPDOWN);
	}

	public String getValueYearOfBirthTextbox() {
		waitForElementVisible(driver, CustomerInformationUI.YEAR_OF_BIRTH_DROPDOWN);
		return getSelectedItemDefaultDropdown(driver, CustomerInformationUI.YEAR_OF_BIRTH_DROPDOWN);
	}

	
	
}
