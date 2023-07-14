package liveguru.user;

public class ProductListUI {
	private static final String PRODUCT_LIST_AREA = "//div[@class='category-products']/div[@class='toolbar']";
	public static final String DYNAMIC_DROPDOWN_BY_TITLE = "xpath=" + PRODUCT_LIST_AREA + "//select[@title='%s']";
	public static final String ASCENDING_DIRECTION_ICON = "xpath=" + PRODUCT_LIST_AREA + "//a[@class!='list']";
	public static final String DYNAMIC_PRODUCT_NAME_BY_LABEL = "xpath=//a[text()='%s']";
	public static final String DYNAMIC_ADD_TO_CART_BUTTON_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/ancestor::div[@class='product-info']//div[@class='actions']/button";
	public static final String DYNAMIC_PRICE_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/../..//*[@class='regular-price' or @class='special-price']/span[@class='price']";
	public static final String ALL_PRODUCT_NAME = "xpath=//div[@class='category-products']//h2[@class='product-name']/a";
	public static final String ALL_PRODUCT_PRICE = "xpath=//div[@class='category-products']//*[@class='special-price' or @class='regular-price']//span[@class='price']";
	public static final String ITEM_NUMBER = "xpath=" + PRODUCT_LIST_AREA + "//p[contains(@class, 'amount')]/strong";
	public static final String NOT_SELECTED_VIEW_AS_OPTION_BY_TITLE = "xpath=" + PRODUCT_LIST_AREA + "//a[@title='%s']";
	public static final String PRODUCT_LIST_WITH_GRID = "xpath=//div[@class='category-products']/ul[contains(@class, 'products-grid')]";
	public static final String PRODUCT_LIST_WITH_LIST = "xpath=//div[@class='category-products']/ol[contains(@class, 'products-list')]";
	
	
}
