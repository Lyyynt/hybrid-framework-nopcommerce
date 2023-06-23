package environmentFactory;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaDriver;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory {
	WebDriver driver;
	String browserName;
	
	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}
	
	public WebDriver createDriver() {
		switch (browserName) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "firefox_extension":
			WebDriverManager.firefoxdriver().setup();
			FirefoxProfile profile = new FirefoxProfile();
			File fileFf = new File(GlobalConstants.BROWSER_EXTENSION_PATH_FOLDER + "\\google_translate.xpi");
			profile.addExtension(fileFf);
			FirefoxOptions optionsFirefoxEx = new FirefoxOptions();
			optionsFirefoxEx.setProfile(profile);
			driver = new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "chrome_extension":
			WebDriverManager.chromedriver().setup();
			File fileCh = new File(GlobalConstants.BROWSER_EXTENSION_PATH_FOLDER + "\\google_translate.crx");
			ChromeOptions optionsChromeEx = new ChromeOptions();
			optionsChromeEx.addExtensions(fileCh);
			driver = new ChromeDriver(optionsChromeEx);
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		case "coccoc":
			WebDriverManager.chromedriver().driverVersion("110.0.5481.77").setup();
			ChromeOptions optionsCocCoc = new ChromeOptions();
			optionsCocCoc.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(optionsCocCoc);
			break;
		case "brave":
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionsBrave = new ChromeOptions();
			optionsBrave.setBinary("C:\\Program Files\\Brave\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(optionsBrave);
			break;
		case "h_chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionsChrome = new ChromeOptions();
			optionsChrome.addArguments("-headless");
			optionsChrome.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(optionsChrome);
			break;
		case "h_firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionsFirefox = new FirefoxOptions();
			optionsFirefox.addArguments("-headless");
			optionsFirefox.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(optionsFirefox);
			break;
		default:
			throw new RuntimeException("Browser Name Invalid");
		}
		return driver;
	}
}
