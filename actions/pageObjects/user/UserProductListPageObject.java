package pageObjects.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import nopcommerce.user.UserProductListUI;

public class UserProductListPageObject extends BasePage{
	WebDriver driver;

	public UserProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserProductDetailObject clickToProductTitle(String productTitle) {
		String productTitleLocator = UserProductListUI.PRODUCT_TITLE.replace("****", productTitle);
		waitForElementClickable(driver, productTitleLocator);
		clickToElement(driver, productTitleLocator);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}

	public Object getCurrentPageTitle() {
		waitForElementVisible(driver, UserProductListUI.PRODUCT_TITLE_PAGE);
		return getElementText(driver, UserProductListUI.PRODUCT_TITLE_PAGE);
	}

	public void selectSortByLabel(String optionLabel) {
		waitForElementVisible(driver, UserProductListUI.PRODUCT_SORT_DROPDOWN);
		selectItemDefaultDropdown(driver, UserProductListUI.PRODUCT_SORT_DROPDOWN, optionLabel);
	}

	public boolean isProductNameWasSortedByLabel(String optionLabel) throws Exception {
		waitForElementVisible(driver, UserProductListUI.ALL_PRODUCT_TITLE);
		SleepInSecond(3);
		List<WebElement> productElementList = getWebElements(driver, UserProductListUI.ALL_PRODUCT_TITLE);
		List<String> productNameList = new ArrayList<>();
		for (WebElement productElement : productElementList) {
			productNameList.add(productElement.getText());
		}
		switch (optionLabel) {
		case "Name: A to Z":
			return isSortFromAToZ(productNameList);
		case "Name: Z to A":
			return isSortFromZToA(productNameList);
		default:
			throw new Exception("You entered the invalid option");
		}
	}
	
	public boolean isProductNameWasSortedByPrice(String optionLabel) throws Exception {
		waitForElementVisible(driver, UserProductListUI.ALL_PRODUCT_PRICE);
		SleepInSecond(3);
		List<WebElement> productElementList = getWebElements(driver, UserProductListUI.ALL_PRODUCT_PRICE);
		List<String> productNameList = new ArrayList<>();
		for (WebElement productElement : productElementList) {
			productNameList.add(productElement.getText());
		}
		switch (optionLabel) {
		case "Price: Low to High":
			return isSortFromAToZ(productNameList);
		case "Price: High to Low":
			return isSortFromZToA(productNameList);
		default:
			throw new Exception("You entered the invalid option");
		}
	}
	
	private boolean isSortFromAToZ(List<String> productNameList) {
		if (productNameList.isEmpty() || productNameList.size() == 1) {
	        return true;
	    }

	    Iterator<String> iter = productNameList.iterator();
	    String current, previous = iter.next();
	    while (iter.hasNext()) {
	        current = iter.next();
	        if (previous.compareTo(current) > 0) {
	            return false;
	        }
	        previous = current;
	    }
	    return true;
	}
	
	private boolean isSortFromZToA(List<String> productNameList) {
		if (productNameList.isEmpty() || productNameList.size() == 1) {
	        return true;
	    }

	    Iterator<String> iter = productNameList.iterator();
	    String current, previous = iter.next();
	    while (iter.hasNext()) {
	        current = iter.next();
	        if (previous.compareTo(current) < 0) {
	            return false;
	        }
	        previous = current;
	    }
	    return true;
	}

	public int getDisplayedProductNumber() {
		waitForElementVisible(driver, UserProductListUI.ALL_PRODUCT_TITLE);
		return getElementSize(driver, UserProductListUI.ALL_PRODUCT_TITLE);
	}


	public String getCurrentPagingNumber() {
		waitForElementVisible(driver, UserProductListUI.DYNAMIC_PAGING_BY_CLASS, "current-page");
		return getElementText(driver, UserProductListUI.DYNAMIC_PAGING_BY_CLASS, "current-page");
	}

	public boolean isPagingButtonDisplayByClass(String className) {
		waitForElementVisible(driver, UserProductListUI.DYNAMIC_PAGING_BY_CLASS, className);
		return isElementDisplayed(driver, UserProductListUI.DYNAMIC_PAGING_BY_CLASS, className);
	}

	public void clickToPagingButtonByID(String className) {
		waitForElementClickable(driver, UserProductListUI.DYNAMIC_PAGING_BY_CLASS, className);
		clickToElement(driver, UserProductListUI.DYNAMIC_PAGING_BY_CLASS, className);
	}

	public boolean isPagingButtonUndisplayed() {
		waitForElementInvisible(driver, UserProductListUI.PAGING_BUTTON);
		return isElementUndisplayed(driver, UserProductListUI.PAGING_BUTTON);
	}
}
