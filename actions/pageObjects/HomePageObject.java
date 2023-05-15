package pageObjects;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public RegisterPageObject clickToRegisterLink() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	
	public LoginPageObject clickToLoginLink() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}
	
	public MyAccountObject clickToMyAccountLink() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}
	
	public boolean isMyAccountLinkDisplay() {
		return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
	}

	public void inputKeywordToSearchTextbox(String keyword) {
		waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, HomePageUI.SEARCH_TEXTBOX, keyword);
	}

	public SearchResultObject clickToSearchButton() {
		waitForElementClickable(driver, HomePageUI.SEARCH_BUTTON);
		clickToElement(driver, HomePageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getSearchResultPage(driver);
	}
	
}
