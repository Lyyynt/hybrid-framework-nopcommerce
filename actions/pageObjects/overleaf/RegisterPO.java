package pageObjects.overleaf;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import overleaf.HomeUI;

public class RegisterPO extends CommonPO{
	WebDriver driver;
	
	public RegisterPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAlertDisplayWithLabel(String label) {
		waitForElementVisible(driver, HomeUI.DYNAMIC_ALERT_BY_LABEL, label);
		return isElementDisplayed(driver, HomeUI.DYNAMIC_ALERT_BY_LABEL, label);
	}
}
