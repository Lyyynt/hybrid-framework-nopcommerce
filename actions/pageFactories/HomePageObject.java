package pageFactories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;
	
	@FindBy(xpath = "//a[@class='ico-account']")
	private WebElement myAccountLink;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickToRegisterLink() {
		waitForElementVisible(driver, registerLink);
		clickToElement(driver, registerLink);
	}
	
	public void clickToLoginLink() {
		waitForElementVisible(driver, loginLink);
		clickToElement(driver, loginLink);
	}
	
	public void clickToMyAccountLink() {
		waitForElementVisible(driver, loginLink);
		clickToElement(driver, loginLink);
	}
	
	public boolean isMyAccountLinkDisplay() {
		return isElementDisplayed(driver, loginLink);
	}

}
