package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.MyAccountUI;

public class MyAccountObject extends BasePage {
	WebDriver driver;

	public MyAccountObject(WebDriver driver) {
		this.driver = driver;
	}

}
