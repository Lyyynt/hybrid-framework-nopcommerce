package pageObjects.user;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
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
	
	public boolean isMyAccountLinkDisplayed() {
		return isElementDisplayed(driver, UserHomePageUI.MYACCOUNT_LINK);
	}

	public void inputKeywordToSearchTextbox(String keyword) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, UserHomePageUI.SEARCH_TEXTBOX, keyword);
	}

	public UserSearchResultObject clickToSearchButton() {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getUserSearchResultPage(driver);
	}
	
}
