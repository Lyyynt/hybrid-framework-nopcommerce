package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.user.UserSearchResultUI;

public class UserSearchResultObject extends BasePage{
	WebDriver driver;

	public UserSearchResultObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserProductDetailObject clickToProductTitle(String productTitle) {
		String productTitleLocator = UserSearchResultUI.PRODUCT_TITLE.replace("****", productTitle);
		waitForElementClickable(driver, productTitleLocator);
		clickToElement(driver, productTitleLocator);
		return PageGeneratorManager.getUserProductDetailPage(driver);
	}
	
}
