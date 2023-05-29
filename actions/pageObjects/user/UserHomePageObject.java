package pageObjects.user;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import nopcommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to Register link")
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementVisible(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	
	public UserLoginPageObject clickToLoginLink() {
		waitForElementVisible(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	
	public UserMyAccountObject clickToMyAccountLink() {
		waitForElementVisible(driver, UserHomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserMyAccountPage(driver);
	}
	
	@Step("My Dashboard page displayed")
	public boolean isMyAccountLinkDisplayed() {
		return isElementDisplayed(driver, UserHomePageUI.MYACCOUNT_LINK);
	}

	public void inputKeywordToSearchTextbox(String keyword) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, UserHomePageUI.SEARCH_TEXTBOX, keyword);
	}

	public UserProductListPageObject clickToSearchButton() {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getUserProductListPage(driver);
	}

	public void clickToHeaderMenuByLabel(String menuLabel) {
		waitForElementClickable(driver, UserHomePageUI.HEADER_MENU_BUTTON, menuLabel);
		clickToElement(driver, UserHomePageUI.HEADER_MENU_BUTTON, menuLabel);
	}

	public UserProductListPageObject clickToSubmenuInHeaderMenuByLabel(String menuLabel, String submenuLabel) {
		waitForElementClickable(driver, UserHomePageUI.SUBMENU_BUTTON, menuLabel, submenuLabel);
		clickToElement(driver, UserHomePageUI.SUBMENU_BUTTON, menuLabel, submenuLabel);
		return PageGeneratorManager.getUserProductListPage(driver);
	}
	
}
