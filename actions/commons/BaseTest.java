package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "opera":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\operadriver.exe");
			driver = new OperaDriver();
			break;
		case "coccoc":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "h_chrome":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "h_firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "h_edge":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		default:
			throw new RuntimeException("Browser Name Invalid");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
