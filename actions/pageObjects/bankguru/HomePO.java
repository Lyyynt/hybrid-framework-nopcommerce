package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class HomePO  extends BasePage{
	private WebDriver driver;
	
	HomePO(WebDriver driver){
		this.driver = driver;
	}

}
