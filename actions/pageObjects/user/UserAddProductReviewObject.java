package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.user.UserAddProductReviewUI;

public class UserAddProductReviewObject extends BasePage{
	WebDriver driver;

	public UserAddProductReviewObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToReviewTitleTextBox(String reviewTitle) {
		waitForElementVisible(driver, UserAddProductReviewUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, UserAddProductReviewUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void inputToReviewTextTextBox(String reviewContent) {
		waitForElementVisible(driver, UserAddProductReviewUI.REVIEW_CONTENT_TEXTBOX);
		sendkeyToElement(driver, UserAddProductReviewUI.REVIEW_CONTENT_TEXTBOX, reviewContent);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, UserAddProductReviewUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, UserAddProductReviewUI.SUBMIT_REVIEW_BUTTON);
	}

	public String getAddReviewSuccessMessage() {
		waitForElementVisible(driver, UserAddProductReviewUI.ADD_REVIEW_SUCCESS_MESSAGE);
		return getElementText(driver, UserAddProductReviewUI.ADD_REVIEW_SUCCESS_MESSAGE);
	}
	
}
