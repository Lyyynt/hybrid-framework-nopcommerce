package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	WebDriver driver;
	
	static public NewCustomerPO getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPO(driver);
	}
	
	static public LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}
	
	static public HomePO getHomePage(WebDriver driver) {
		return new HomePO(driver);
	}
	
	
	static public EditCustomerPO getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPO(driver);
	}
	
	static public DeleteCustomerPO getDeleteCustomerPage(WebDriver driver) {
		return new DeleteCustomerPO(driver);
	}
	
}