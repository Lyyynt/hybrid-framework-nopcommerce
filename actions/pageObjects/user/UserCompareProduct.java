package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.user.UserCompareProductUI;

public class UserCompareProduct extends BasePage {
	WebDriver driver;

	public UserCompareProduct(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isClearListButtonDipslay() {
		waitForElementVisible(driver, UserCompareProductUI.CLEAR_LIST_BUTTON);
		return isElementDisplayed(driver, UserCompareProductUI.CLEAR_LIST_BUTTON);
	}

	public boolean isSheetTextDisplayByRowClassAndColumnIndex(String rowClassName, String columnIndex, String expectedValue) {
		waitForElementVisible(driver, UserCompareProductUI.DYNAMIC_SHEET_BY_ROW_CLASS_AND_COLUMN_INDEX_AND_PRODUCT_NAME, rowClassName, columnIndex, expectedValue);
		return isElementDisplayed(driver, UserCompareProductUI.DYNAMIC_SHEET_BY_ROW_CLASS_AND_COLUMN_INDEX_AND_PRODUCT_NAME, rowClassName, columnIndex, expectedValue);
	}

	public boolean isSheetTextUndisplayByRowClassAndColumnIndex(String rowClassName, String columnIndex, String expectedValue) {
		waitForElementInvisible(driver, UserCompareProductUI.DYNAMIC_SHEET_BY_ROW_CLASS_AND_COLUMN_INDEX_AND_PRODUCT_NAME, rowClassName, columnIndex, expectedValue);
		return isElementUndisplayed(driver, UserCompareProductUI.DYNAMIC_SHEET_BY_ROW_CLASS_AND_COLUMN_INDEX_AND_PRODUCT_NAME, rowClassName, columnIndex, expectedValue);
	}

	public void clickClearListButton() {
		waitForElementClickable(driver, UserCompareProductUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, UserCompareProductUI.CLEAR_LIST_BUTTON);
	}

}
