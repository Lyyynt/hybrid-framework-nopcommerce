package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import nopcommerce.AbstractPageUI;
import nopcommerce.HomePageUI;
import pageObjects.AddAddressesObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.CustomerInformationPageObject;
import pageObjects.HomePageObject;
import pageObjects.MyProductReviewObject;
import pageObjects.PageGeneratorManager;
import pageObjects.SearchPageObject;

public class BasePage {
	private long longTimeout = 30;
	private long shortTimeout = 5;
	
	static public BasePage getBasePageObject() {
		return new BasePage();
	}
	
	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}
	
	public Set<String> getWindowHandles(WebDriver driver){
		return driver.getWindowHandles();
	}
	
	public void switchToWindowByID(WebDriver driver, String windowId) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(windowId)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver, String tabTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(tabTitle)) {
				break;
			}
		}
	}
	
	public void closeAllTabWindowParent(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}
	
	private By getByLocator(String locator) {
		By by = null;
		if(locator.startsWith("id") || locator.startsWith("Id") || locator.startsWith("ID")) {
			by =By.id(locator.substring(3));
		}else if(locator.startsWith("name") || locator.startsWith("Name") || locator.startsWith("NAME")) {
			by =By.name(locator.substring(5));
		}else if(locator.startsWith("class") || locator.startsWith("Class") || locator.startsWith("CLASS")) {
			by =By.className(locator.substring(6));
		}else if(locator.startsWith("css") || locator.startsWith("Css") || locator.startsWith("CSS")) {
			by =By.cssSelector(locator.substring(4));
		}else if(locator.startsWith("xpath") || locator.startsWith("XPath") || locator.startsWith("XPATH")) {
			by =By.xpath(locator.substring(6));
		}else {
			throw new RuntimeException("Locator type is not supported!");
		}
		return by;
	}
	
	private WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}
	
	private List<WebElement> getWebElements(WebDriver driver, String locator){
		return driver.findElements(getByLocator(locator));
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String textValue) {
		WebElement element = getWebElement(driver, locator);
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void selectItemDefaultDropdown(WebDriver driver, String locator, String textItem) {
		Select select = new Select(getWebElement(driver, locator));
		select.selectByVisibleText(textItem);
	}
	
	public String getSelectedItemDefaultDropdown(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem) {
		getWebElement(driver, parentXpath).click();
		SleepInSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		List<WebElement> speedDropdownItems = driver.findElements(getByLocator(childXpath));
		for (WebElement item : speedDropdownItems) {
			if(item.getText().trim().equals(expectedTextItem)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
				SleepInSecond(1);
				item.click();
				break;
			}
		}
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}
	
	public String getElementCSSValue(WebDriver driver, String locator, String propertyName) {
		return getWebElement(driver, locator).getCssValue(propertyName);
	}
	
	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(WebDriver driver, String locator) {
		return getWebElements(driver, locator).size();
	}
	
	public void checkToDefaultCheckboxRadio(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if(!isElementSelected(driver, locator)) {
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckbox(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if(isElementSelected(driver, locator)) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementEnable(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}
	
	public void switchToFrameIFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locator) {
		new Actions(driver).moveToElement(getWebElement(driver, locator)).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		new Actions(driver).doubleClick(getWebElement(driver, locator)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String locator) {
		new Actions(driver).contextClick(getWebElement(driver, locator)).perform();
	}
	
	public void dragAndDrop(WebDriver driver, String sourceXpath, String targetXpath) {
		new Actions(driver).dragAndDrop(getWebElement(driver, sourceXpath), getWebElement(driver, targetXpath)).perform();
	}
	
	public void sendKeyboardToElement(WebDriver driver, String locator, String key) {
		new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void hightlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		SleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		return status;
	}

	
	public boolean isPageLoadedSuccess(WebDriver driver) {
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
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForAllElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElement(driver, locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}
	
	public void waitForElementPresence(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForAllElementPresence(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
	}
	
	public void SleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void clickToLeftMenuTab(WebDriver driver, String leftMenuName) {
		String leftMenuLocator = String.format(AbstractPageUI.LEFT_MENU_LINK, leftMenuName);
		waitForElementVisible(driver, leftMenuLocator);
		clickToElement(driver, leftMenuLocator);
	}
	
	public CustomerInformationPageObject clickToCustomerInfoTab(WebDriver driver) {
		clickToLeftMenuTab(driver, "Customer info");
		return PageGeneratorManager.getCustomerInformationPage(driver);
	}

	public AddAddressesObject clickToAddAddressesTab(WebDriver driver) {
		clickToLeftMenuTab(driver, "Addresses");
		return PageGeneratorManager.getAddAddressPage(driver);
	}

	public ChangePasswordPageObject clickToChangePasswordTab(WebDriver driver) {
		clickToLeftMenuTab(driver, "Change password");
		return PageGeneratorManager.getChangePasswordPage(driver);
	}

	public MyProductReviewObject clickToMyProductReviewTab(WebDriver driver) {
		clickToLeftMenuTab(driver, "My product reviews");
		return PageGeneratorManager.getMyProductReviewPage(driver);
	}
	
	private void clickToFooterLink(WebDriver driver, String footerLink) {
		String footerLinkLocator = String.format(AbstractPageUI.FOOTER_LINK, footerLink);
		scrollToBottomPage(driver);
		waitForElementVisible(driver, footerLinkLocator);
		clickToElement(driver, footerLinkLocator);
	}

	public SearchPageObject clickToSearchFooterLink(WebDriver driver) {
		clickToFooterLink(driver, "Search");
		return PageGeneratorManager.getSearchPage(driver);
	}
	
	public HomePageObject clickToLogOutLink(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.LOGOUT_LINK);
		clickToElement(driver, AbstractPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
}
