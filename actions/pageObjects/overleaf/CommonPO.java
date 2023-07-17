package pageObjects.overleaf;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import overleaf.CommonUI;

public class CommonPO extends BasePage{
	
	public void clickToHeaderLinkByLabel(WebDriver driver, String label) {
		waitForElementClickable(driver, CommonUI.DYNAMIC_HEADER_LINK_BY_LABEL, label);
		clickToElement(driver, CommonUI.DYNAMIC_HEADER_LINK_BY_LABEL, label);
	}

	public void inputToDynamicTextboxByID(WebDriver driver, String label, String value) {
		waitForElementVisible(driver, CommonUI.DYNAMIC_TEXTBOX_BY_LABEL, label);
		sendkeyToElement(driver, CommonUI.DYNAMIC_TEXTBOX_BY_LABEL, value, label);
	}

	public void clickToDynamicButtonByLabel(WebDriver driver, String label) {
		waitForElementClickable(driver, CommonUI.DYNAMIC_BUTTON_BY_LABEL, label);
		clickToElement(driver, CommonUI.DYNAMIC_BUTTON_BY_LABEL, label);
	}

	public String getErrorMessageByFieldID(WebDriver driver, String fieldID) {
		waitForElementVisible(driver, CommonUI.DYNAMIC_ERROR_MESSAGE_BY_TEXTBOX_LABEL, fieldID);
		return getElementText(driver, CommonUI.DYNAMIC_ERROR_MESSAGE_BY_TEXTBOX_LABEL, fieldID);
	}


}
