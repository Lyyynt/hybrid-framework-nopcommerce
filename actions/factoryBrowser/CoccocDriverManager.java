package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CoccocDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.chromedriver().driverVersion("110.0.5481.77").setup();
		ChromeOptions optionsCocCoc = new ChromeOptions();
		optionsCocCoc.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
		return new ChromeDriver(optionsCocCoc);
	}

}
