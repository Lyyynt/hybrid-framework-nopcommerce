package factoryEnvironment;


import org.openqa.selenium.WebDriver;

import factoryBrowser.BraveDriverManager;
import factoryBrowser.BrowserList;
import factoryBrowser.ChromeDriverManager;
import factoryBrowser.CoccocDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import factoryBrowser.HeadlessChromeDriverManager;
import factoryBrowser.HeadlessFirefoxDriverManager;
import factoryBrowser.OperaDriverManager;

public class LocalFactory {
	WebDriver driver;
	String browserName;
	
	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}
	
	public WebDriver createDriver() {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX:
			driver = new FirefoxDriverManager().getBrowserDriver();
			break;
		case CHROME:
			driver = new ChromeDriverManager().getBrowserDriver();
			break;
		case EDGE_CHROMIUM:
			driver = new EdgeDriverManager().getBrowserDriver();
			break;
		case OPERA:
			driver = new OperaDriverManager().getBrowserDriver();
			break;
		case COCCOC:
			driver = new CoccocDriverManager().getBrowserDriver();
			break;
		case BRAVE:
			driver = new BraveDriverManager().getBrowserDriver();
			break;
		case H_CHROME:
			driver = new HeadlessChromeDriverManager().getBrowserDriver();
			break;
		case H_FIREFOX:
			driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
			break;
		default:
			throw new RuntimeException("Browser Name Invalid");
		}
		return driver;
	}
}
