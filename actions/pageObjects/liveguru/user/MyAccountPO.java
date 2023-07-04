package pageObjects.liveguru.user;

import org.openqa.selenium.WebDriver;

import liveguru.user.MyAccountUI;

public class MyAccountPO extends CommonPO {
	WebDriver driver;
	
	public MyAccountPO(WebDriver driver){
		this.driver = driver;
	}

	public String getUserInformationByLabel(String label) {
		waitForElementVisible(driver, MyAccountUI.DYNAMIC_INFORMATION_TEXT_BY_LABEL, label);
		return getElementText(driver, MyAccountUI.DYNAMIC_INFORMATION_TEXT_BY_LABEL, label);
	}



}
