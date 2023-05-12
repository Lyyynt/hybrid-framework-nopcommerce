package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.SearchPageUI;

public class SearchPageObject extends BasePage {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToSearchKeywordTextbox(String keyword) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, keyword);
	}

	public void checkToAdvancedSearchCheckbox() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_ADVANCED_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, SearchPageUI.SEARCH_ADVANCED_CHECKBOX);
	}
	
	public void uncheckToAdvancedSearchCheckbox() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_ADVANCED_CHECKBOX);
		uncheckToDefaultCheckbox(driver, SearchPageUI.SEARCH_ADVANCED_CHECKBOX);
	}

	public void selectCategory(String categoryName) {
		waitForElementVisible(driver, SearchPageUI.CATEGORY_DROPDOWN);
		selectItemDefaultDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN, categoryName);
	}

	public void checkToAutoSearchSubCategoryCheckbox() {
		waitForElementVisible(driver, SearchPageUI.AUTO_SEARCH_SUB_CATEGORY_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, SearchPageUI.AUTO_SEARCH_SUB_CATEGORY_CHECKBOX);
	}
	
	public void uncheckToAutoSearchSubCategoryCheckbox() {
		waitForElementVisible(driver, SearchPageUI.AUTO_SEARCH_SUB_CATEGORY_CHECKBOX);
		uncheckToDefaultCheckbox(driver, SearchPageUI.AUTO_SEARCH_SUB_CATEGORY_CHECKBOX);
	}

	public void selectManufacturer(String manufacturerName) {
		waitForElementVisible(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
		selectItemDefaultDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, manufacturerName);
	}

	public void clickToSearchInProductDescriptionCheckbox() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_IN_PRODUCT_DESCRIPTION_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, SearchPageUI.SEARCH_IN_PRODUCT_DESCRIPTION_CHECKBOX);
	}

	public void clickToSearchButton() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public String getWarningMessage() {
		waitForElementVisible(driver, SearchPageUI.WARNING_MESSAGE);
		return getElementText(driver, SearchPageUI.WARNING_MESSAGE);
	}

	public int getResultItemCount() {
		waitForElementVisible(driver, SearchPageUI.PRODUCT_ITEM);
		return getElementSize(driver, SearchPageUI.PRODUCT_ITEM);
	}

	public boolean isProductNameDisplay(String productName) {
		String productLocator = SearchPageUI.PRODUCT_TITLE.replace("****", productName);
		return isElementDisplayed(driver, productLocator);
	}
	
}
