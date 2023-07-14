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
		int actualProductPrice = convertToPriceNumber(getElementText(driver, ShoppingCartUI.DYNAMIC_PRODUCT_PRICE_BY_ROW_NUMBER, rowNumber));
		return (actualProductName == expectedProductName) && (actualProductPrice == expectedProductPrice);
	}

	public void inputToTextboxByProductNameAndColumnName(String value, String productName, String columnName) {
		waitForAllElementPresence(driver, ShoppingCartUI.PRECEDING_NUMBER_OF_COLUMN_BY_LABEL, columnName);
		int columnIndex = getElementSize(driver, ShoppingCartUI.PRECEDING_NUMBER_OF_COLUMN_BY_LABEL, columnName) + 1;
		waitForElementVisible(driver, ShoppingCartUI.DYNAMIC_TEXTBOX_BY_PRODUCT_NAME_AND_COLUMN_INDEX, productName, String.valueOf(columnIndex));
		clickToElement(driver, ShoppingCartUI.DYNAMIC_TEXTBOX_BY_PRODUCT_NAME_AND_COLUMN_INDEX, productName, String.valueOf(columnIndex));
		sendkeyToElement(driver, ShoppingCartUI.DYNAMIC_TEXTBOX_BY_PRODUCT_NAME_AND_COLUMN_INDEX, value, productName, String.valueOf(columnIndex));
	}

	public int getProductInformationOfProductNameAndColumnName(String productName, String columnName) {
		waitForAllElementPresence(driver, ShoppingCartUI.PRECEDING_NUMBER_OF_COLUMN_BY_LABEL, columnName);
		int columnIndex = getElementSize(driver, ShoppingCartUI.PRECEDING_NUMBER_OF_COLUMN_BY_LABEL, columnName) + 1;
		waitForElementVisible(driver, ShoppingCartUI.DYNAMIC_CEIL_BY_PRODUCT_NAME_AND_COLUMN_INDEX, productName, String.valueOf(columnIndex));
		return convertToPriceNumber(getElementText(driver, ShoppingCartUI.DYNAMIC_CEIL_BY_PRODUCT_NAME_AND_COLUMN_INDEX, productName, String.valueOf(columnIndex)));
	}

	public void clickToUpdateShoppingCartButton() {
		waitForElementVisible(driver, ShoppingCartUI.UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(driver, ShoppingCartUI.UPDATE_SHOPPING_CART_BUTTON);
	}

	public int getGrandTotalPrice() {
		waitForElementVisible(driver, ShoppingCartUI.GRAND_TOTAL_PRICE);
		return convertToPriceNumber(getElementText(driver, ShoppingCartUI.GRAND_TOTAL_PRICE));
	}

	public Object getPriceByLabel(String priceLabel) {
		waitForElementVisible(driver, ShoppingCartUI.DYNAMIC_PRICE_BY_LABEL, priceLabel);
		return convertToPriceNumber(getElementText(driver, ShoppingCartUI.DYNAMIC_PRICE_BY_LABEL, priceLabel));
	}

	public String getEmptyCart() {
		waitForElementVisible(driver, ShoppingCartUI.EMPTY_CART_MESSAGE);
		return getElementText(driver, ShoppingCartUI.EMPTY_CART_MESSAGE);
	}

	public void clickToDeleteIconByProductLabel(String productName) {
		waitForElementVisible(driver, ShoppingCartUI.DYNAMIC_DELETE_BUTTON_BY_LABEL, productName);
		clickToElement(driver, ShoppingCartUI.DYNAMIC_DELETE_BUTTON_BY_LABEL, productName);
	}

	public boolean isProductUndisplayByLabel(String productLabel) {
		waitForElementInvisible(driver, ShoppingCartUI.DYNAMIC_PRODUCT_NAME_BY_PRODUCT_NAME, productLabel);
		return isElementUndisplayed(driver, ShoppingCartUI.DYNAMIC_PRODUCT_NAME_BY_PRODUCT_NAME, productLabel);
	}


}
