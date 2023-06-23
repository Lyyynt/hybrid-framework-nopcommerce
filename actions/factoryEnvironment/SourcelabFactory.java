package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class SourcelabFactory {
	WebDriver driver;
	String osName;
	String browserName;
	String browserVersion;
	
	public SourcelabFactory(String osName, String browserName, String browserVersion) {
		this.osName = osName;
		this.browserName = browserName;
		this.browserVersion = browserVersion;
	}
	
	public WebDriver createDriver() {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", osName);
		capability.setCapability("browserName", browserName);
		capability.setCapability("browserVersion", browserVersion);
		capability.setCapability("name", "Run on " + osName + " and " + browserName + " with version " + browserVersion);
		Map<String, Object> sauceOptions = new HashMap<>();
		if(osName.contains("Windows")) {
			sauceOptions.put("screenResolution", "1920x1080");
		}else {
			sauceOptions.put("screenResolution", "1920x1440");
		}
		capability.setCapability("sauce:options", sauceOptions);
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.SOURCELAB_URL), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
