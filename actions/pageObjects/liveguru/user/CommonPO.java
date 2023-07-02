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
	
}
