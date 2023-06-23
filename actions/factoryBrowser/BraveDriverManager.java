package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BraveDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions optionsBrave = new ChromeOptions();
		optionsBrave.setBinary("C:\\Program Files\\Brave\\Browser\\Application\\browser.exe");
		return new ChromeDriver(optionsBrave);
	}

}
