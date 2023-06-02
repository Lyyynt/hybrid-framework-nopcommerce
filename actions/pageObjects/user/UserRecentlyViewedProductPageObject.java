package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserRecentlyViewedProductPageObject extends BasePage {
	WebDriver driver;

	public UserRecentlyViewedProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
