package liveguru.user;

public class CommonUI {
	public static final String DYNAMIC_FOOTER_LINK_BY_LABEL = "xpath=//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_BUTTON_BY_LABEL = "xpath=//span[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::div/input";
	public static final String DYNAMIC_ERROR_MESSAGE_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::div/div";
	public static final String SUCCESS_MESSAGE = "xpath=//li[@class='success-msg']";
	public static final String ERROR_MESSAGE = "xpath=//li[@class='error-msg']";
	public static final String WELCOME_MESSAGE = "xpath=//div[@class='welcome-msg']//strong";
}
