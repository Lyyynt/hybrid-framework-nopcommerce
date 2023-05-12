package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.AddProductReviewUI;

public class AddProductReviewObject extends BasePage{
	WebDriver driver;

	public AddProductReviewObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToReviewTitleTextBox(String reviewTitle) {
		waitForElementVisible(driver, AddProductReviewUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, AddProductReviewUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void inputToReviewTextTextBox(String reviewContent) {
		waitForElementVisible(driver, AddProductReviewUI.REVIEW_CONTENT_TEXTBOX);
		sendkeyToElement(driver, AddProductReviewUI.REVIEW_CONTENT_TEXTBOX, reviewContent);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, AddProductReviewUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, AddProductReviewUI.SUBMIT_REVIEW_BUTTON);
	}

	public String getAddReviewSuccessMessage() {
		waitForElementVisible(driver, AddProductReviewUI.ADD_REVIEW_SUCCESS_MESSAGE);
		return getElementText(driver, AddProductReviewUI.ADD_REVIEW_SUCCESS_MESSAGE);
	}
	
}
