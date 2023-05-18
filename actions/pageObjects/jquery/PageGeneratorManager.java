package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	WebDriver driver;
	
	static public HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
}
