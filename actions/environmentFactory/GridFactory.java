package environmentFactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GridFactory {
	WebDriver driver;
	String browserName;
	String ipAddress;
	String portNumber;
	
	public GridFactory(String browserName, String ipAddress, String portNumber) {
		this.browserName = browserName;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
	}

	public WebDriver createDriver() {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		DesiredCapabilities capability = null;
		switch (browser) {
			case FIREFOX_UI:
				WebDriverManager.firefoxdriver().setup();
				capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
				capability.setPlatform(Platform.WINDOWS);

				FirefoxOptions fOptions = new FirefoxOptions();
				fOptions.merge(capability);
				break;
			case CHROME_UI:
				WebDriverManager.chromedriver().setup();
				capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				capability.setPlatform(Platform.WINDOWS);

				ChromeOptions cOptions = new ChromeOptions();
				cOptions.merge(capability);
				break;
			case EDGE_CHROMIUM:
				WebDriverManager.edgedriver().setup();
				capability = DesiredCapabilities.edge();
				capability.setBrowserName("edge");
				capability.setPlatform(Platform.ANY);
				capability.setJavascriptEnabled(true);
				EdgeOptions eOptions = new EdgeOptions();
				eOptions.merge(capability);
				break;
				
			case SAFARI:
				capability = DesiredCapabilities.safari();
				capability.setBrowserName("safari");
				capability.setJavascriptEnabled(true);
				capability.setPlatform(Platform.MAC);
				SafariOptions sOption = new SafariOptions();
				sOption.merge(capability);
			case IE:
				WebDriverManager.iedriver().arch32().setup();
				capability = DesiredCapabilities.internetExplorer();
				capability.setBrowserName("internetexplorer");
				capability.setPlatform(Platform.WINDOWS);
				capability.setJavascriptEnabled(true);
			default :
				throw new RuntimeException("Please input the valid browser name!!!");
		}

		try {
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
