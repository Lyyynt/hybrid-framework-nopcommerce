package pageObjects.liveguru.user;


import org.openqa.selenium.WebDriver;

import commons.BasePage;
import liveguru.user.CommonUI;

public class CommonPO extends BasePage{
	
	public void clickToFooterLinkByLabel(WebDriver driver, String footerLabel) {
		scrollToBottomPage(driver);
		waitForElementClickable(driver, CommonUI.DYNAMIC_FOOTER_LINK_BY_LABEL, footerLabel);
		clickToElement(driver, CommonUI.DYNAMIC_FOOTER_LINK_BY_LABEL, footerLabel);
	}
	
	public void clickToButtonByLabel(WebDriver driver, String buttonLabel) {
		waitForElementClickable(driver, CommonUI.DYNAMIC_BUTTON_BY_LABEL, buttonLabel);
		clickToElement(driver, CommonUI.DYNAMIC_BUTTON_BY_LABEL, buttonLabel);
	}
	
	public void inputToTextboxWithValue(WebDriver driver, String textboxLabel, String value) {
		waitForElementVisible(driver, CommonUI.DYNAMIC_TEXTBOX_BY_LABEL, textboxLabel);
		sendkeyToElement(driver, CommonUI.DYNAMIC_TEXTBOX_BY_LABEL, value, textboxLabel);
	}
	
	public String getErrorMessageByFieldLabel(WebDriver driver, String fieldLabel) {
		waitForElementVisible(driver, CommonUI.DYNAMIC_ERROR_MESSAGE_BY_LABEL, fieldLabel);
		return getElementText(driver, CommonUI.DYNAMIC_ERROR_MESSAGE_BY_LABEL, fieldLabel);
	}
	
	public String getSuccessMessage(WebDriver driver) {
		waitForElementVisible(driver, CommonUI.SUCCESS_MESSAGE);
		return getElementText(driver, CommonUI.SUCCESS_MESSAGE);
	}

	public String getWelcomeMessage(WebDriver driver) {
		waitForElementVisible(driver, CommonUI.WELCOME_MESSAGE);
		return getElementText(driver, CommonUI.WELCOME_MESSAGE);
	}
	
	public String getErrorMessage(WebDriver driver) {
		waitForElementVisible(driver, CommonUI.ERROR_MESSAGE);
		return getElementText(driver, CommonUI.ERROR_MESSAGE);
	}
	
	public void clickToSkipLinkByLabel(WebDriver driver, String menuLabel) {
		waitForElementClickable(driver, CommonUI.DYNAMIC_SKIP_LINK_BY_LABEL, menuLabel);
		clickToElement(driver, CommonUI.DYNAMIC_SKIP_LINK_BY_LABEL, menuLabel);
	}
	
	public void clickToHeaderNavigationByLabel(WebDriver driver, String menuLabel) {
		waitForElementClickable(driver, CommonUI.DYNAMIC_HEADER_NAV_BY_LABEL, menuLabel);
		clickToElement(driver, CommonUI.DYNAMIC_HEADER_NAV_BY_LABEL, menuLabel);
	}

	public void clickToAccountBottomOptionInSkipLink(WebDriver driver, String optionLabel) {
		waitForElementClickable(driver, CommonUI.DYNAMIC_OPTION_BY_LABEL, optionLabel);
		clickToElement(driver, CommonUI.DYNAMIC_OPTION_BY_LABEL, optionLabel);
	}
	
	public boolean isLogOutMessageUndisplayed(WebDriver driver) {
		waitForElementInvisible(driver, CommonUI.LOGOUT_MESSAGE);
		return isElementUndisplayed(driver, CommonUI.LOGOUT_MESSAGE);
	}
}
