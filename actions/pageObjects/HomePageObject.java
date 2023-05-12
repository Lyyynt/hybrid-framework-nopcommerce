package pageObjects;
import org.openqa.selenium.WebDriver;
import commons.BasePage;
import nopcommerce.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToRegisterLink() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}
	
	public void clickToLoginLink() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}
	
	public void clickToMyAccountLink() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
	}
	
	public boolean isMyAccountLinkDisplay() {
		return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
	}

	public void inputKeywordToSearchTextbox(String keyword) {
		waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, HomePageUI.SEARCH_TEXTBOX, keyword);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, HomePageUI.SEARCH_BUTTON);
		clickToElement(driver, HomePageUI.SEARCH_BUTTON);
	}
}
