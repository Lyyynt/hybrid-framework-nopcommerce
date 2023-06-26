package commons;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.Reporter;

import factoryBrowser.BrowserList;
import factoryEnvironment.BrowserstackFactory;
import factoryEnvironment.CrossBrowserTestingFactory;
import factoryEnvironment.EnvironmentList;
import factoryEnvironment.GridFactory;
import factoryEnvironment.LambdaFactory;
import factoryEnvironment.LocalFactory;
import factoryEnvironment.SourcelabFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
//	WebDriver driver;
	protected final Log log;
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	public WebDriver getDriverInstance() {
		return this.driver.get();
	}
	
	protected WebDriver getBrowserDriver(String serverName, String runEnvironmentName, String browserName, String browserVersion, String osName, String osVersion, String ipAddress, String portNumber) {
		switch (runEnvironmentName) {
		case "local":
			driver.set(new LocalFactory(browserName).createDriver());
			break;
		case "grid":
			driver.set(new GridFactory(browserName, ipAddress, portNumber).createDriver());
			break;
		case "browserStack":
			driver.set(new BrowserstackFactory(osName, osVersion, browserName, browserVersion).createDriver());
			break;
		case "sourcelab":
			driver.set(new SourcelabFactory(osName, browserName, browserVersion).createDriver());
			break;
		case "crossBrowserTesting":
			driver.set(new CrossBrowserTestingFactory(osName, browserName).createDriver());
			break;
		case "lambda":
			driver.set(new LambdaFactory(osName, browserName).createDriver());
			break;
		default:
			driver.set(new LocalFactory(browserName).createDriver());
			break;
		}
		driver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().get(getEnvironmentUrl(serverName));
		return driver.get();
	}
	
	
	protected WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;
		case "firefox_extension":
			WebDriverManager.firefoxdriver().setup();
			FirefoxProfile profile = new FirefoxProfile();
			File fileFf = new File(GlobalConstants.BROWSER_EXTENSION_PATH_FOLDER + "\\google_translate.xpi");
			profile.addExtension(fileFf);
			FirefoxOptions optionsFirefoxEx = new FirefoxOptions();
			optionsFirefoxEx.setProfile(profile);
			driver.set(new FirefoxDriver());
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		case "chrome_extension":
			WebDriverManager.chromedriver().setup();
			File fileCh = new File(GlobalConstants.BROWSER_EXTENSION_PATH_FOLDER + "\\google_translate.crx");
			ChromeOptions optionsChromeEx = new ChromeOptions();
			optionsChromeEx.addExtensions(fileCh);
			driver.set(new ChromeDriver(optionsChromeEx));
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver.set(new OperaDriver());
			break;
		case "coccoc":
			WebDriverManager.chromedriver().driverVersion("110.0.5481.77").setup();
			ChromeOptions optionsCocCoc = new ChromeOptions();
			optionsCocCoc.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver.set(new ChromeDriver(optionsCocCoc));
			break;
		case "brave":
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionsBrave = new ChromeOptions();
			optionsBrave.setBinary("C:\\Program Files\\Brave\\Browser\\Application\\browser.exe");
			driver.set(new ChromeDriver(optionsBrave));
			break;
		case "h_chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionsChrome = new ChromeOptions();
			optionsChrome.addArguments("-headless");
			optionsChrome.addArguments("window-size=1920x1080");
			driver.set(new ChromeDriver(optionsChrome));
			break;
		case "h_firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionsFirefox = new FirefoxOptions();
			optionsFirefox.addArguments("-headless");
			optionsFirefox.addArguments("window-size=1920x1080");
			driver.set(new FirefoxDriver(optionsFirefox));
			break;
		default:
			throw new RuntimeException("Browser Name Invalid");
		}
		driver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().get(GlobalConstants.PORTAL_DEV_URL);
		return driver.get();
	}
	
	protected WebDriver getBrowserDriver(String browserName, String url) {
		switch (browserName) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;
		case "firefox_extension":
			WebDriverManager.firefoxdriver().setup();
			FirefoxProfile profile = new FirefoxProfile();
			File fileFf = new File(GlobalConstants.BROWSER_EXTENSION_PATH_FOLDER + "\\google_translate.xpi");
			profile.addExtension(fileFf);
			FirefoxOptions optionsFirefoxEx = new FirefoxOptions();
			optionsFirefoxEx.setProfile(profile);
			driver.set(new FirefoxDriver());
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		case "chrome_extension":
			WebDriverManager.chromedriver().setup();
			File fileCh = new File(GlobalConstants.BROWSER_EXTENSION_PATH_FOLDER + "\\google_translate.crx");
			ChromeOptions optionsChromeEx = new ChromeOptions();
			optionsChromeEx.addExtensions(fileCh);
			driver.set(new ChromeDriver(optionsChromeEx));
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver.set(new OperaDriver());
			break;
		case "coccoc":
			WebDriverManager.chromedriver().driverVersion("110.0.5481.77").setup();
			ChromeOptions optionsCocCoc = new ChromeOptions();
			optionsCocCoc.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver.set(new ChromeDriver(optionsCocCoc));
			break;
		case "brave":
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionsBrave = new ChromeOptions();
			optionsBrave.setBinary("C:\\Program Files\\Brave\\Browser\\Application\\browser.exe");
			driver.set(new ChromeDriver(optionsBrave));
			break;
		case "h_chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionsChrome = new ChromeOptions();
			optionsChrome.addArguments("-headless");
			optionsChrome.addArguments("window-size=1920x1080");
			driver.set(new ChromeDriver(optionsChrome));
			break;
		case "h_firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionsFirefox = new FirefoxOptions();
			optionsFirefox.addArguments("-headless");
			optionsFirefox.addArguments("window-size=1920x1080");
			driver.set(new FirefoxDriver(optionsFirefox));
			break;
		default:
			throw new RuntimeException("Browser Name Invalid");
		}
		driver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().get(url);
		return driver.get();
	}
	
	protected WebDriver getBrowserDriverGrid(String browserName, String url, String ipAddress, String portNumber) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		DesiredCapabilities capability = null;
		switch (browser) {
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
				capability.setPlatform(Platform.WINDOWS);

				FirefoxOptions fOptions = new FirefoxOptions();
				fOptions.merge(capability);
				break;
			case CHROME:
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
			driver.set(new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().get(url);
		return driver.get();
	}
	
	protected WebDriver getBrowserDriverWithStackBrowser(String url, String osName, String osVersion, String browserName, String browserVersion) {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("os", osName);
		capability.setCapability("os_version", osVersion);
		capability.setCapability("browser", browserName);
		capability.setCapability("browser_version", browserVersion);
		capability.setCapability("browserstack.debug", "true");
		capability.setCapability("resolution", "1920x1080");
		capability.setCapability("name", "Run on " + osName + " and " + browserName + " with version " + browserVersion);
		try {
			driver.set(new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), capability));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().get(url);
		return driver.get();
	}
	
	protected WebDriver getBrowserDriverWithSourceLab(String url, String osName, String browserName, String browserVersion) {
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
			driver.set(new RemoteWebDriver(new URL(GlobalConstants.SOURCELAB_URL), capability));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().get(url);
		return driver.get();
	}
	
	protected WebDriver getBrowserDriverWithCrossBrowserTesting(String url, String osName, String browserName) {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("browserName", browserName);
		capability.setCapability("platform", osName);
		capability.setCapability("record_video", "true");
		capability.setCapability("name", "Run on " + osName + " and " + browserName + " with the lastest version");
		if(osName.contains("Windows")) {
			capability.setCapability("screenResolution", "1920x1080");
		}else {
			capability.setCapability("screenResolution", "2560x1600");
		}
		capability.setCapability("bitbar_apiKey", GlobalConstants.CROSS_AUTOMATE_KEY);
		try {
			driver.set(new RemoteWebDriver(new URL(GlobalConstants.CROSS_URL), capability));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().get(url);
		return driver.get();
	}
	
	protected WebDriver getBrowserDriverWithLambdaTest(String url, String osName, String browserName) {
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
			driver.set(new RemoteWebDriver(new URL(GlobalConstants.LAMBDA_URL), capability));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().get(url);
		return driver.get();
	}
	
	protected WebDriver getBrowserDriverWithEnvironment(String browserName, String environment) {
		switch (browserName) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;
		case "firefox_extension":
			WebDriverManager.firefoxdriver().setup();
			FirefoxProfile profile = new FirefoxProfile();
			File fileFf = new File(GlobalConstants.BROWSER_EXTENSION_PATH_FOLDER + "\\google_translate.xpi");
			profile.addExtension(fileFf);
			FirefoxOptions optionsFirefoxEx = new FirefoxOptions();
			optionsFirefoxEx.setProfile(profile);
			driver.set(new FirefoxDriver());
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		case "chrome_extension":
			WebDriverManager.chromedriver().setup();
			File fileCh = new File(GlobalConstants.BROWSER_EXTENSION_PATH_FOLDER + "\\google_translate.crx");
			ChromeOptions optionsChromeEx = new ChromeOptions();
			optionsChromeEx.addExtensions(fileCh);
			driver.set(new ChromeDriver(optionsChromeEx));
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver.set(new OperaDriver());
			break;
		case "coccoc":
			WebDriverManager.chromedriver().driverVersion("110.0.5481.77").setup();
			ChromeOptions optionsCocCoc = new ChromeOptions();
			optionsCocCoc.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver.set(new ChromeDriver(optionsCocCoc));
			break;
		case "brave":
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionsBrave = new ChromeOptions();
			optionsBrave.setBinary("C:\\Program Files\\Brave\\Browser\\Application\\browser.exe");
			driver.set(new ChromeDriver(optionsBrave));
			break;
		case "h_chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions optionsChrome = new ChromeOptions();
			optionsChrome.addArguments("-headless");
			optionsChrome.addArguments("window-size=1920x1080");
			driver.set(new ChromeDriver(optionsChrome));
			break;
		case "h_firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions optionsFirefox = new FirefoxOptions();
			optionsFirefox.addArguments("-headless");
			optionsFirefox.addArguments("window-size=1920x1080");
			driver.set(new FirefoxDriver(optionsFirefox));
			break;
		default:
			throw new RuntimeException("Browser Name Invalid");
		}
		driver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().get(getEnvironmentUrl(environment));
		return driver.get();
	}
	
	private String getEnvironmentUrl(String serverName) {
		String url = null;
		EnvironmentList env = EnvironmentList.valueOf(serverName.toUpperCase());
		switch (env) {
		case DEV:
			url = GlobalConstants.PORTAL_DEV_URL;
			break;
		case TEST:
			url = GlobalConstants.PORTAL_TEST_URL;
			break;
		default:
			throw new RuntimeException("Please input correct the environment name!");
		}
		return url;
	}
	
	protected int getRandomNumber() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(99999);
		return randomNumber;
	}
	
	protected void SleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected boolean verifyTrue(boolean condition) {
		boolean isPassed = true;
		try {
			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			isPassed = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return isPassed;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean isPassed = true;
		try {
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			isPassed = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return isPassed;
	}

	protected boolean verifyEquals(String actual, String expected) {
		boolean isPassed = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			isPassed = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return isPassed;
	}
	
	protected void closeBrowserDriver(String envName) {
		if(envName.toLowerCase().contains("local") || envName.toLowerCase().contains("grid")) {
			String cmd = null;
			try {
				String osName = System.getProperty("os.name").toLowerCase();
				log.info("OS name = " + osName);

				String driverInstanceName = driver.toString().toLowerCase();
				log.info("Driver instance name = " + driverInstanceName);

				String browserDriverName = null;

				if (driverInstanceName.contains("chrome")) {
					browserDriverName = "chromedriver";
				} else if (driverInstanceName.contains("internetexplorer")) {
					browserDriverName = "IEDriverServer";
				} else if (driverInstanceName.contains("firefox")) {
					browserDriverName = "geckodriver";
				} else if (driverInstanceName.contains("edge")) {
					browserDriverName = "msedgedriver";
				} else if (driverInstanceName.contains("opera")) {
					browserDriverName = "operadriver";
				} else {
					browserDriverName = "safaridriver";
				}

				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
				} else {
					cmd = "pkill " + browserDriverName;
				}

				if (driver != null) {
					driver.get().manage().deleteAllCookies();
					driver.get().quit();
				}
			} catch (Exception e) {
				log.info(e.getMessage());
			} finally {
				try {
					Process process = Runtime.getRuntime().exec(cmd);
					process.waitFor();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	protected void showBrowserConsoleLogs(WebDriver driver) {
		System.out.println(driver.toString());
		if(driver.toString().contains("chrome") || driver.toString().contains("edge")) {
			LogEntries logs = driver.manage().logs().get("browser");
			List<LogEntry> logList = logs.getAll();
			for (LogEntry logging : logList) {
				if(logging.getLevel().toString().toLowerCase().contains("error")) {
					log.info("----------" + logging.getLevel().toString() + "----------\n" + logging.getMessage());
				}
			}
		}
		
		
		
	}
}
