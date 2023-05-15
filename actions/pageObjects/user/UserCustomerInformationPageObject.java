package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.user.UserCustomerInformationUI;

public class UserCustomerInformationPageObject extends BasePage{
	WebDriver driver;

	public UserCustomerInformationPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderRadio() {
		waitForElementVisible(driver, UserCustomerInformationUI.FEMALE_GENDER_RADIO_BUTTON);
		clickToElement(driver, UserCustomerInformationUI.FEMALE_GENDER_RADIO_BUTTON);
	}
	
	public void sendKeyToFirstNameTextbox(String newFirstName) {
		waitForElementVisible(driver, UserCustomerInformationUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInformationUI.FIRSTNAME_TEXTBOX, newFirstName);
	}
	
	public void sendKeyToLastNameTextbox(String newLastName) {
		waitForElementVisible(driver, UserCustomerInformationUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInformationUI.LASTNAME_TEXTBOX, newLastName);
	}
	
	public void selectDayOfBirth(String dayOfBirth) {
		waitForElementVisible(driver, UserCustomerInformationUI.DAY_OF_BIRTH_DROPDOWN);
		selectItemDefaultDropdown(driver, UserCustomerInformationUI.DAY_OF_BIRTH_DROPDOWN, dayOfBirth);
	}
	
	public void selectMonthOfBirth(String monthOfBirth) {
		waitForElementVisible(driver, UserCustomerInformationUI.MONTH_OF_BIRTH_DROPDOWN);
		selectItemDefaultDropdown(driver, UserCustomerInformationUI.MONTH_OF_BIRTH_DROPDOWN, monthOfBirth);
	}
	
	public void selectYearOfBirth(String yearOfBirth) {
		waitForElementVisible(driver, UserCustomerInformationUI.YEAR_OF_BIRTH_DROPDOWN);
		selectItemDefaultDropdown(driver, UserCustomerInformationUI.YEAR_OF_BIRTH_DROPDOWN, yearOfBirth);
	}

	public void selectDateOfBirthDropdown(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
		selectDayOfBirth(dayOfBirth);
		selectMonthOfBirth(monthOfBirth);
		selectYearOfBirth(yearOfBirth);
	}

	public void sendKeyToEmailTextbox(String newEmail) {
		waitForElementVisible(driver, UserCustomerInformationUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInformationUI.EMAIL_TEXTBOX, newEmail);
	}

	public void sendKeyToCompanyNameTextbox(String companyName) {
		waitForElementVisible(driver, UserCustomerInformationUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInformationUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	public void clickToSaveButton() {
		waitForElementVisible(driver, UserCustomerInformationUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInformationUI.SAVE_BUTTON);
	}

	public String getToastMessage() {
		waitForElementVisible(driver, UserCustomerInformationUI.TOAST_MESSAGE);
		return getElementText(driver, UserCustomerInformationUI.TOAST_MESSAGE);
	}

	public boolean isFemaleGender() {
		waitForElementVisible(driver, UserCustomerInformationUI.FEMALE_GENDER_RADIO_BUTTON);
		return isElementSelected(driver, UserCustomerInformationUI.FEMALE_GENDER_RADIO_BUTTON);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, UserCustomerInformationUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInformationUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, UserCustomerInformationUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInformationUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, UserCustomerInformationUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInformationUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyNameTextboxValue() {
		waitForElementVisible(driver, UserCustomerInformationUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInformationUI.COMPANY_NAME_TEXTBOX, "value");
	}

	public String getValueDayOfBirthTextbox() {
		waitForElementVisible(driver, UserCustomerInformationUI.DAY_OF_BIRTH_DROPDOWN);
		return getSelectedItemDefaultDropdown(driver, UserCustomerInformationUI.DAY_OF_BIRTH_DROPDOWN);
	}

	public String getValueMonthOfBirthTextbox() {
		waitForElementVisible(driver, UserCustomerInformationUI.MONTH_OF_BIRTH_DROPDOWN);
		return getSelectedItemDefaultDropdown(driver, UserCustomerInformationUI.MONTH_OF_BIRTH_DROPDOWN);
	}

	public String getValueYearOfBirthTextbox() {
		waitForElementVisible(driver, UserCustomerInformationUI.YEAR_OF_BIRTH_DROPDOWN);
		return getSelectedItemDefaultDropdown(driver, UserCustomerInformationUI.YEAR_OF_BIRTH_DROPDOWN);
	}

	
	
}
