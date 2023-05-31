package nopcommerce.user;

public class UserAbstractPageUI {
	public static final String DYNAMIC_PAGE_IN_MY_ACCOUNT_AREA = "xpath=//a[text()='%s']";
	public static final String DYNAMIC_FOOTER_LINK = "xpath=//div[@class='footer-upper']//a[text()='%s']";
	public static final String DYNAMIC_HEADER_LINK_BY_CLASS = "xpath=//a[@class='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String SUCCESS_MESSAGE = "xpath=//div[@class='bar-notification success']/p[@class='content']";
	public static final String CLOSE_SUCESS_MESSAGE = "xpath=//div[@class='bar-notification success']/span[@class='close']";
	public static final String DYNAMIC_BUTTON_BY_LABEL = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_PRODUCT_NAME_IN_TABLE = "xpath=//a[@class='product-name' and text()='%s']";
	public static final String HEADER_MENU_BUTTON = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String SUBMENU_BUTTON = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]/following-sibling::ul[@class='sublist first-level']//a[contains(text(),'%s')]";
	public static final String DYNAMIC_BUTTON_IN_PRODUCT_ITEM_BY_PRODUCT_NAME = "xpath=//div[@class='page category-page']//a[text()='%s']/ancestor-or-self::div[@class='product-item']//button[text()='%s']";
	public static final String TABLE_BODY_DATA = "xpath=//div[@class='%s']//div[@class='page-body']";
	
}
