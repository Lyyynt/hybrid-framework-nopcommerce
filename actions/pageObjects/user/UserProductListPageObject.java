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
}
