package bankguru;

public class EditCustomerUI {
	public static final String CUSTOMER_NAME_TEXTBOX = "xpath=//td[text()='Customer Name']/following-sibling::td/input";
	public static final String CUSTOMER_ID_TEXTBOX = "xpath=//td[text()='Customer ID']/following-sibling::td/input";
	public static final String CUSTOMER_ID_ERROR_MESSAGE = "xpath=//td[text()='Customer ID']/following-sibling::td/label";
	public static final String SUBMIT_BUTTON = "xpath=//input[@name='AccSubmit']";
	public static final String CUSTOMER_ADDRESS_TEXTBOX = "xpath=//td[text()='Address']/following-sibling::td/textarea";
	public static final String CUSTOMER_ADDRESS_ERROR_MESSAGE = "xpath=//td[text()='Address']/following-sibling::td/label";
	public static final String CUSTOMER_CITY_TEXTBOX = "xpath=//td[text()='City']/following-sibling::td/input";
	public static final String CUSTOMER_CITY_ERROR_MESSAGE = "xpath=//td[text()='City']/following-sibling::td/label";
	public static final String CUSTOMER_STATE_TEXTBOX = "xpath=//td[text()='State']/following-sibling::td/input";
	public static final String CUSTOMER_STATE_ERROR_MESSAGE = "xpath=//td[text()='State']/following-sibling::td/label";
	public static final String CUSTOMER_PIN_TEXTBOX = "xpath=//td[text()='PIN']/following-sibling::td/input";
	public static final String CUSTOMER_PIN_ERROR_MESSAGE = "xpath=//td[text()='PIN']/following-sibling::td/label";
	public static final String CUSTOMER_PHONE_TEXTBOX = "xpath=//td[text()='Mobile Number']/following-sibling::td/input";
	public static final String CUSTOMER_PHONE_ERROR_MESSAGE = "xpath=//td[text()='Mobile Number']/following-sibling::td/label";
	public static final String CUSTOMER_EMAIL_TEXTBOX = "xpath=//td[text()='E-mail']/following-sibling::td/input";
	public static final String CUSTOMER_EMAIL_ERROR_MESSAGE = "xpath=//td[text()='E-mail']/following-sibling::td/input";
	public static final String CUSTOMER_DATE_OF_BIRTH_TEXTBOX = "xpath=//td[text()='Date of Birth']/following-sibling::td/input";
	public static final String UPDATE_SUCCESS_MESSAGE = "xpath=//table[@id='customer']//p[text()='Customer Registered Successfully!!!']";
}
