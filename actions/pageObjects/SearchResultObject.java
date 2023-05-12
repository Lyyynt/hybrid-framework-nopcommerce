package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.SearchResultUI;

public class SearchResultObject extends BasePage{
	WebDriver driver;

	public SearchResultObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToProductTitle(String productTitle) {
		String productTitleLocator = SearchResultUI.PRODUCT_TITLE.replace("****", productTitle);
		waitForElementClickable(driver, productTitleLocator);
		clickToElement(driver, productTitleLocator);
	}
	
}
