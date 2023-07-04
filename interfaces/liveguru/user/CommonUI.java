package liveguru.user;

public class CommonUI {
	public static final String DYNAMIC_FOOTER_LINK_BY_LABEL = "xpath=//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_BUTTON_BY_LABEL = "xpath=//span[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::div/input";
	public static final String DYNAMIC_ERROR_MESSAGE_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::div/div";
	public static final String SUCCESS_MESSAGE = "xpath=//li[@class='success-msg']";
	public static final String ERROR_MESSAGE = "xpath=//li[@class='error-msg']";
	public static final String WELCOME_MESSAGE = "xpath=//div[@class='welcome-msg']//strong";
	public static final String DYNAMIC_SKIP_LINK_BY_LABEL = "xpath=//div[@class='account-cart-wrapper']//span[@class='label' and text()='%s']";
	public static final String DYNAMIC_HEADER_NAV_BY_LABEL = "xpath=//div[@id='header-nav']//a[text()='%s']";
	public static final String DYNAMIC_OPTION_BY_LABEL = "xpath=//div[@id='header-account']//a[text()='%s']";
	public static final String LOGOUT_MESSAGE = "xpath=//ht[text()='You are now logged out']";
}
