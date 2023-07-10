package pageObjects.liveguru.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import liveguru.user.ProductListUI;

public class ProductListPO extends CommonPO {
	WebDriver driver;
	
	public ProductListPO(WebDriver driver){
		this.driver = driver;
	}

	public void selectAscendingDirection(String ascendingType) {
		waitForElementPresence(driver, ProductListUI.ASCENDING_DIRECTION_ICON);
		String className = getElementAttributeByJS(driver, ProductListUI.ASCENDING_DIRECTION_ICON, "className");
		if(!className.toUpperCase().contains(ascendingType)) {
			clickToElementByJS(driver, ProductListUI.ASCENDING_DIRECTION_ICON);
		}
	}

	public boolean isNameSortedByTypeSort(String sortType) {
		waitForAllElementVisible(driver, ProductListUI.ALL_PRODUCT_NAME);
		List<WebElement> elementList = getWebElements(driver, ProductListUI.ALL_PRODUCT_NAME);
		List<String> productNameList = new ArrayList<>();
		List<String> productNameAfterSortList = new ArrayList<>();
		for (WebElement productElement : elementList) {
			productNameList.add(productElement.getText());
			productNameAfterSortList.add(productElement.getText());
		}
		Collections.sort(productNameAfterSortList);
		if(sortType=="ASC") {
			Collections.reverse(productNameAfterSortList);
		}
		return productNameAfterSortList.equals(productNameList);
	}
	
	public boolean isPriceSortedByTypeSort(String sortType) {
		waitForAllElementVisible(driver, ProductListUI.ALL_PRODUCT_PRICE);
		List<WebElement> elementList = getWebElements(driver, ProductListUI.ALL_PRODUCT_PRICE);
		List<Integer> productPriceList = new ArrayList<>();
		List<Integer> productPriceAfterSortList = new ArrayList<>();
		for (WebElement productElement : elementList) {
			int price = Integer.valueOf(productElement.getText().replace("$", "").replace(".00", ""));
			productPriceList.add(price);
			productPriceAfterSortList.add(price);
		}
		Collections.sort(productPriceAfterSortList);
		if(sortType=="ASC") {
			Collections.reverse(productPriceAfterSortList);
		}
		return productPriceAfterSortList.equals(productPriceList);
	}

	public void selectDropdownInProductListByTitle(String dropdownTitle, String optionLabel) {
		waitForElementVisible(driver, ProductListUI.DYNAMIC_DROPDOWN_BY_TITLE, dropdownTitle);
		selectItemDefaultDropdown(driver, ProductListUI.DYNAMIC_DROPDOWN_BY_TITLE, optionLabel, dropdownTitle);
	}

	public boolean isItemNumberCorrect() {
		waitForAllElementVisible(driver, ProductListUI.ALL_PRODUCT_PRICE);
		waitForElementVisible(driver, ProductListUI.ITEM_NUMBER);
		int actualProductNumber = getWebElements(driver, ProductListUI.ALL_PRODUCT_PRICE).size();
		int itemNumber = Integer.valueOf(getElementText(driver, ProductListUI.ITEM_NUMBER).replace(" Item(s)", ""));
		return actualProductNumber==itemNumber;
	} 

	public void selectViewAsOptionByTitle(String modeViewTitle) {
		if(isElementDisplayed(driver, ProductListUI.NOT_SELECTED_VIEW_AS_OPTION_BY_TITLE, modeViewTitle)) {
			clickToElement(driver, ProductListUI.NOT_SELECTED_VIEW_AS_OPTION_BY_TITLE, modeViewTitle);
		}
		
	}

	public boolean isProductDisplayWithGrid() {
		waitForElementVisible(driver, ProductListUI.PRODUCT_LIST_WITH_GRID);
		return isElementDisplayed(driver, ProductListUI.PRODUCT_LIST_WITH_GRID);
	}

	public boolean isProductDisplayWithList() {
		waitForElementVisible(driver, ProductListUI.PRODUCT_LIST_WITH_LIST);
		return isElementDisplayed(driver, ProductListUI.PRODUCT_LIST_WITH_LIST);
	}

}
