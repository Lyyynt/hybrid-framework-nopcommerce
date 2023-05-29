package nopcommerce.user;

public class UserHomePageUI {
	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String MYACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String SEARCH_TEXTBOX = "xpath=//input[@id='small-searchterms']";
	public static final String SEARCH_BUTTON = "xpath=//button[text()='Search']";
	public static final String HEADER_MENU_BUTTON = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String SUBMENU_BUTTON = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]/following-sibling::ul[@class='sublist first-level']//a[contains(text(),'%s')]";
	
}
