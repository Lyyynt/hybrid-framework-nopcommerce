package pageObjects.jquery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import commons.BasePage;
import jquery.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void paginationByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGING_BUTTON, pageNumber);
		clickToElement(driver, HomePageUI.DYNAMIC_PAGING_BUTTON, pageNumber);
	}

	public boolean isPageSelected(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_SELECTED_PAGING_BUTTON, pageNumber);
		return isElementDisplayed(driver, HomePageUI.DYNAMIC_SELECTED_PAGING_BUTTON, pageNumber);
	}

	public void inputToDynamicTextboxByLabel(String label, String searchValue) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_SEARCH_TEXTBOX_BY_LABEL, label);
		sendkeyToElement(driver, HomePageUI.DYNAMIC_SEARCH_TEXTBOX_BY_LABEL, searchValue, label);
		pressKeyToElement(driver, HomePageUI.DYNAMIC_SEARCH_TEXTBOX_BY_LABEL, Keys.ENTER, label);
	}

	public void clickToLoadDataButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);
	}

	public void inputToCellByLabelAndRowNumber(String columnName, String rowNumber, String value) {
		String columnIndex = String.valueOf(getElementSize(driver, HomePageUI.LABEL_INDEX, columnName) + 1);
		waitForElementVisible(driver, HomePageUI.DYNAMIC_CELL_BY_LABEL_AND_ROW, rowNumber, columnIndex);
		sendkeyToElement(driver, HomePageUI.DYNAMIC_CELL_BY_LABEL_AND_ROW, value, rowNumber, columnIndex);
	}

	public String getValueInCellByLabelAndNumber(String columnName, String rowNumber) {
		String columnIndex = String.valueOf(getElementSize(driver, HomePageUI.LABEL_INDEX, columnName) + 1);
		waitForElementVisible(driver, HomePageUI.DYNAMIC_CELL_BY_LABEL_AND_ROW, rowNumber, columnIndex);
		return getElementAttribute(driver, HomePageUI.DYNAMIC_CELL_BY_LABEL_AND_ROW, "value", rowNumber, columnIndex);
	}

	public void selectNpoCheckboxByLabelAndRowNumber(String columnName, String rowNumber) {
		String columnIndex = String.valueOf(getElementSize(driver, HomePageUI.LABEL_INDEX, columnName) + 1);
		waitForElementVisible(driver, HomePageUI.DYNAMIC_CELL_BY_LABEL_AND_ROW, rowNumber, columnIndex);
		checkToDefaultCheckboxRadio(driver, HomePageUI.DYNAMIC_CELL_BY_LABEL_AND_ROW, rowNumber, columnIndex);
	}

	public boolean isNpoCheckboxSelectedByLabelAndRowNumber(String columnName, String rowNumber) {
		String columnIndex = String.valueOf(getElementSize(driver, HomePageUI.LABEL_INDEX, columnName) + 1);
		waitForElementVisible(driver, HomePageUI.DYNAMIC_CELL_BY_LABEL_AND_ROW, rowNumber, columnIndex);
		return isElementSelected(driver, HomePageUI.DYNAMIC_CELL_BY_LABEL_AND_ROW, rowNumber, columnIndex);
	}

	public void uploadFileInWebPage(String... fileNames) {
		waitForElementPresence(driver, HomePageUI.ADD_FILE_BUTTON);
		uploadMultipleFiles(driver, HomePageUI.ADD_FILE_BUTTON, fileNames);
	}

	public boolean isImageLoadSuccessful(String fileName) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_FILE_NAME_TEXT, fileName);
		return isElementDisplayed(driver, HomePageUI.DYNAMIC_FILE_NAME_TEXT, fileName);
	}

	public void clickToStartUploadByFileName(String fileName) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_START_UPLOAD_FILE_BUTTON, fileName);
		clickToElement(driver, HomePageUI.DYNAMIC_START_UPLOAD_FILE_BUTTON, fileName);
	}

	public boolean isLoadedFileNameDisplay(String fileName) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_FILE_NAME_UPLOADED_TEXT, fileName);
		return isElementDisplayed(driver, HomePageUI.DYNAMIC_FILE_NAME_UPLOADED_TEXT, fileName);
	}

	public boolean isImageLoadedSuccessByFileName(String fileName) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_UPLOADED_FILE, fileName);
		return isImageLoaded(driver, HomePageUI.DYNAMIC_UPLOADED_FILE, fileName);
	}
	

}
