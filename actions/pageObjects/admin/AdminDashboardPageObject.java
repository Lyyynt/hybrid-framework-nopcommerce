package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nomcommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage{
	WebDriver driver;
	
	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isDashboardHeaderDisplayed() {
		waitForElementVisible(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}

	public void clickToLeftMenuByLabel(String label) {
		waitForElementClickable(driver, AdminDashboardPageUI.DYNAMIC_LEFT_MENU_LINK_BY_LABEL, label);
		clickToElement(driver, AdminDashboardPageUI.DYNAMIC_LEFT_MENU_LINK_BY_LABEL, label);
	}

	public boolean isSelectedLeftMenuByLabel(String label) {
		waitForElementVisible(driver, AdminDashboardPageUI.DYNAMIC_SELECTED_LEFT_MENU_LINK_BY_LABEL, label);
		return isElementDisplayed(driver, AdminDashboardPageUI.DYNAMIC_SELECTED_LEFT_MENU_LINK_BY_LABEL, label);
	}

	public void clickToSubLeftMenuByLabel(String label) {
		waitForElementClickable(driver, AdminDashboardPageUI.DYNAMIC_SUB_MENU_LINK_BY_LABEL, label);
		clickToElement(driver, AdminDashboardPageUI.DYNAMIC_SUB_MENU_LINK_BY_LABEL, label);
	}
}
