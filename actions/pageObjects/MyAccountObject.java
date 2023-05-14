package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.MyAccountUI;

public class MyAccountObject extends BasePage {
	WebDriver driver;

	public MyAccountObject(WebDriver driver) {
		this.driver = driver;
	}

	private void clickToLeftMenuTabByLabel(String leftMenuName) {
		String leftMenuLocator = MyAccountUI.LEFT_MENU_LINK.replace("****", leftMenuName);
		waitForElementVisible(driver, leftMenuLocator);
		clickToElement(driver, leftMenuLocator);
	}

	public CustomerInformationPageObject clickToCustomerInfoTab() {
		clickToLeftMenuTabByLabel("Customer info");
		return PageGeneratorManager.getCustomerInformationPage(driver);
	}

	public AddAddressesObject clickToAddAddressesTab() {
		clickToLeftMenuTabByLabel("Addresses");
		return PageGeneratorManager.getAddAddressPage(driver);
	}

	public ChangePasswordPageObject clickToChangePasswordTab() {
		clickToLeftMenuTabByLabel("Change password");
		return PageGeneratorManager.getChangePasswordPage(driver);
	}

	public MyProductReviewObject clickToMyProductReviewTab() {
		clickToLeftMenuTabByLabel("My product reviews");
		return PageGeneratorManager.getMyProductReviewPage(driver);
	}
	
}
