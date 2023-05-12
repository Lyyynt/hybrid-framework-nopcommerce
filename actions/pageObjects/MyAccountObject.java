package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.MyAccountUI;

public class MyAccountObject extends BasePage {
	WebDriver driver;

	public MyAccountObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMyProductReview(String leftMenuName) {
		String leftMenuLocator = MyAccountUI.LEFT_MENU_LINK.replace("****", leftMenuName);
		waitForElementVisible(driver, leftMenuLocator);
		clickToElement(driver, leftMenuLocator);
	}
	
}
