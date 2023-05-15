package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.user.UserMyProductReviewUI;

public class UserMyProductReviewObject extends BasePage{
	WebDriver driver;

	public UserMyProductReviewObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getReviewTitle() {
		waitForElementVisible(driver, UserMyProductReviewUI.REVIEW_TITLE_TEXT);
		return getElementText(driver, UserMyProductReviewUI.REVIEW_TITLE_TEXT);
	}

	public String getReviewContent() {
		waitForElementVisible(driver, UserMyProductReviewUI.REVIEW_CONTENT_TEXT);
		return getElementText(driver, UserMyProductReviewUI.REVIEW_CONTENT_TEXT);
	}
	
}
