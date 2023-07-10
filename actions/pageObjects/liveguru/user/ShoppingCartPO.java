package pageObjects.liveguru.user;

import org.openqa.selenium.WebDriver;

import liveguru.user.ShoppingCartUI;

public class ShoppingCartPO extends CommonPO {
	WebDriver driver;
	
	public ShoppingCartPO(WebDriver driver){
		this.driver = driver;
	}

	public boolean isProductDisplayInPageWithRowNumber(String rowNumber, String expectedProductName, int expectedProductPrice ) {
		waitForElementVisible(driver, ShoppingCartUI.DYNAMIC_PRODUCT_NAME_BY_ROW_NUMBER, rowNumber);
		waitForElementVisible(driver, ShoppingCartUI.DYNAMIC_PRODUCT_PRICE_BY_ROW_NUMBER, rowNumber);
		String actualProductName = getElementText(driver, ShoppingCartUI.DYNAMIC_PRODUCT_NAME_BY_ROW_NUMBER, rowNumber);
		int actualProductPrice = Integer.valueOf(getElementText(driver, ShoppingCartUI.DYNAMIC_PRODUCT_PRICE_BY_ROW_NUMBER, rowNumber).trim().replace(".00", "").replace("$", ""));
		return (actualProductName == expectedProductName) && (actualProductPrice == expectedProductPrice);
	}

}
