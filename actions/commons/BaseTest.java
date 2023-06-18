package commons;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	protected final Log log;
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	public WebDriver getDriverInstance() {
		return this.driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
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
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GlobalConstants.PORTAL_DEV_URL);
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String url) {
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
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	private String getEnvironmentUrl(String environmentName) {
		String url = null;
		switch (environmentName) {
		case "DEV":
			url = GlobalConstants.PORTAL_DEV_URL;
			break;
		case "TEST":
			url = GlobalConstants.PORTAL_TEST_URL;
			break;
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
	
	protected void closeBrowserDriver() {
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
				driver.manage().deleteAllCookies();
				driver.quit();
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
