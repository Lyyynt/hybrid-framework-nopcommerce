package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.ProductDetailUI;

public class ProductDetailObject extends BasePage{
	WebDriver driver;

	public ProductDetailObject(WebDriver driver) {
		this.driver = driver;
	}

	public AddProductReviewObject clickToAddYourReviewLink() {
		waitForElementVisible(driver, ProductDetailUI.ADD_YOUR_REVIEWS_LINK);
		clickToElement(driver, ProductDetailUI.ADD_YOUR_REVIEWS_LINK);
		return PageGeneratorManager.getAddProductReviewPage(driver);
	}
	
}
