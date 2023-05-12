package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.MyProductReviewUI;

public class MyProductReviewObject extends BasePage{
	WebDriver driver;

	public MyProductReviewObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getReviewTitle() {
		waitForElementVisible(driver, MyProductReviewUI.REVIEW_TITLE_TEXT);
		return getElementText(driver, MyProductReviewUI.REVIEW_TITLE_TEXT);
	}

	public String getReviewContent() {
		waitForElementVisible(driver, MyProductReviewUI.REVIEW_CONTENT_TEXT);
		return getElementText(driver, MyProductReviewUI.REVIEW_CONTENT_TEXT);
	}
	
}
