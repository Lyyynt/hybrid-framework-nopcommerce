package nomcommerce.admin;

public class AdminCustomerUI {
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id='SearchEmail']";
	public static final String SEARCH_BUTTON = "css=button#search-customers";
	public static final String CUSTOMER_INFOR_ROW_BY_EMAIL_AND_FULLNAME = "xpath=//table[@id='customers-grid']/tbody//td[text()='%s']/parent::tr//td[text()='%s']";
}
