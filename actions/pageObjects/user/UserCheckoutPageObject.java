package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.user.UserCheckoutPageUI;

public class UserCheckoutPageObject extends BasePage {
	WebDriver driver;

	public UserCheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getPaymentInfomation() {
		waitForElementVisible(driver, UserCheckoutPageUI.PAYMENT_INFORMATION);
		return getElementText(driver, UserCheckoutPageUI.PAYMENT_INFORMATION);
	}


}
