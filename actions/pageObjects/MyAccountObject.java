package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MyAccountObject extends BasePage {
	WebDriver driver;

	public MyAccountObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
