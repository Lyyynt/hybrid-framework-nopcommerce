package pageObjects.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguru.DeleteCustomerUI;
import commons.BasePage;

public class DeleteCustomerPO extends BasePage{
	private WebDriver driver;
	
	DeleteCustomerPO(WebDriver driver){
		this.driver = driver;
	}

	public void inputCustomerID(String customerId) {
		waitForElementVisible(driver, DeleteCustomerUI.CUSTOMER_ID_TEXTBOX);
		sendkeyToElement(driver, DeleteCustomerUI.CUSTOMER_ID_TEXTBOX, customerId);
	}

	public void clickSubmitButton() {
		waitForElementClickable(driver, DeleteCustomerUI.SUBMIT_BUTTON);
		clickToElement(driver, DeleteCustomerUI.SUBMIT_BUTTON);
	}

	public void pressTabToMoveNextFields() {
		pressKeyToElement(driver, DeleteCustomerUI.CUSTOMER_ID_TEXTBOX, Keys.TAB);
		SleepInSecond(2);
	}
	
	public String getErrorCustomerIDMessage() {
		waitForElementVisible(driver, DeleteCustomerUI.CUSTOMER_ID_ERROR_MESSAGE);
		return getElementText(driver, DeleteCustomerUI.CUSTOMER_ID_ERROR_MESSAGE);
	}

}
