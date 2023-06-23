package environmentFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class LambdaFactory {
	WebDriver driver;
	String osName;
	String browserName;
	
	public LambdaFactory(String osName, String browserName) {
		this.osName = osName;
		this.browserName = browserName;
	}
	
	public WebDriver createDriver() {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("browserName", browserName);
		capability.setCapability("platform", osName);
		capability.setCapability("version", "lastest");
		capability.setCapability("video", true);
		capability.setCapability("visual", true);
		capability.setCapability("name", "Run on " + osName + " and " + browserName + " with the lastest version");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "thuylinh2409nguyen");
		ltOptions.put("accessKey", "ZxdiJKMv9lAWrlUf0XIjMk87yKtAMRVJcj1EB3Hollb3QfX6I9");
		capability.setCapability("LT:Options", ltOptions);
		
		if(osName.contains("Windows")) {
			capability.setCapability("screenResolution", "1920x1080");
		}else {
			capability.setCapability("screenResolution", "2560x1600");
		}
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.LAMBDA_URL), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
