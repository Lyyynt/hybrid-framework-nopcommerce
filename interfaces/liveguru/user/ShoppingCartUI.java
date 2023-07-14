package liveguru.user;

public class ShoppingCartUI {
	public static final String DYNAMIC_PRODUCT_NAME_BY_ROW_NUMBER = "xpath=//table[@id='shopping-cart-table']/tbody/tr[%s]//h2[@class='product-name']";
	public static final String DYNAMIC_PRODUCT_NAME_BY_PRODUCT_NAME = "xpath=//table[@id='shopping-cart-table']/tbody//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_PRICE_BY_ROW_NUMBER = "xpath=//table[@id='shopping-cart-table']/tbody/tr[%s]/td[@class='product-cart-price']//span[@class='price']";
	public static final String PRECEDING_NUMBER_OF_COLUMN_BY_LABEL = "xpath=//table[@id='shopping-cart-table']/thead//th[contains(string(), '%s')]/preceding-sibling::th";
	public static final String DYNAMIC_TEXTBOX_BY_PRODUCT_NAME_AND_COLUMN_INDEX = "xpath=//table[@id='shopping-cart-table']/tbody//a[text()='%s']/../../..//td[%s]/input";
	public static final String DYNAMIC_CEIL_BY_PRODUCT_NAME_AND_COLUMN_INDEX = "xpath=//table[@id='shopping-cart-table']/tbody//a[text()='%s']/../../..//td[%s]";
	public static final String DYNAMIC_DELETE_BUTTON_BY_LABEL = "xpath=//table[@id='shopping-cart-table']/tbody//a[text()='%s']/../../following-sibling::td[contains(@class, 'product-cart-remove')]/a";
	public static final String UPDATE_SHOPPING_CART_BUTTON = "xpath=//button[@title='Update Shopping Cart' and not(contains(@style, 'hidden'))]";
	public static final String DYNAMIC_PRICE_BY_LABEL = "xpath=//table[@id='shopping-cart-totals-table']/tbody//td[contains(text(), '%s')]/following-sibling::td/span";
	public static final String GRAND_TOTAL_PRICE = "xpath=//table[@id='shopping-cart-totals-table']/tfoot//span[@class='price']";
	public static final String EMPTY_CART_MESSAGE = "xpath=//div[@class='page-title']";
	
}
