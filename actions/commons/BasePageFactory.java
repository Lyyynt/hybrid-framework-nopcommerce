package commons;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	private long longTimeout = 30;
	private long shortTimeout = 5;
	
	static public BasePageFactory getBasePageObject() {
		return new BasePageFactory();
	}
	protected void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	protected String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	protected String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	protected void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}
	
	protected Set<String> getWindowHandles(WebDriver driver){
		return driver.getWindowHandles();
	}
	
	protected void switchToWindowByID(WebDriver driver, String windowId) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(windowId)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	protected void switchToWindowByTitle(WebDriver driver, String tabTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(tabTitle)) {
				break;
			}
		}
	}
	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}
	protected void closeAllTabWindowParent(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}
	
	
	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	protected void sendkeyToElement(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}
	
	protected boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	
	protected boolean isElementEnable(WebDriver driver, WebElement element) {
		return element.isEnabled();
	}
	
	protected boolean isElementSelected(WebDriver driver, WebElement element) {
		return element.isSelected();
	}
	
	protected void switchToFrameIFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	protected void hoverMouseToElement(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}
	
	protected void doubleClickToElement(WebDriver driver, WebElement element) {
		new Actions(driver).doubleClick(element).perform();
	}
	
	protected void rightClickToElement(WebDriver driver, WebElement element) {
		new Actions(driver).contextClick(element).perform();
	}
	
	protected void dragAndDrop(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
		new Actions(driver).dragAndDrop(sourceElement, targetElement).perform();
	}
	
	protected void sendKeyboardToElement(WebDriver driver, WebElement element, String key) {
		new Actions(driver).sendKeys(element, key).perform();
	}

	protected void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void hightlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		SleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	protected void scrollToElementOnDown(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
	}

	protected void removeAttributeInDOM(WebDriver driver, WebElement element, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	protected String getElementValidationMessage(WebDriver driver, WebElement element) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", element);
	}

	protected boolean isImageLoaded(WebDriver driver, WebElement element) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				element);
		return status;
	}

	
	protected boolean isPageLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active ===0);");
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void waitForAllElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void waitForElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	protected void waitForAllElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(element));
	}
	
	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	protected void SleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
