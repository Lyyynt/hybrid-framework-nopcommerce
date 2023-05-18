package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nomcommerce.admin.AdminCustomerUI;

public class AdminCustomerPageObject extends BasePage{
	WebDriver driver;
	
	public AdminCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, AdminCustomerUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminCustomerUI.EMAIL_TEXTBOX, email);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminCustomerUI.SEARCH_BUTTON);
		clickToElement(driver, AdminCustomerUI.SEARCH_BUTTON);
	}

	public boolean isCustomerInformationDisplayWithEmailAndName(String email, String fullName) {
		waitForElementVisible(driver, AdminCustomerUI.CUSTOMER_INFOR_ROW_BY_EMAIL_AND_FULLNAME, email, fullName);
		return isElementDisplayed(driver, AdminCustomerUI.CUSTOMER_INFOR_ROW_BY_EMAIL_AND_FULLNAME, email, fullName);
	}
	
}
