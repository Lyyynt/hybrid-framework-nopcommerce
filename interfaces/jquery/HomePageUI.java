package jquery;

public class HomePageUI {
	public static final String DYNAMIC_PAGING_BUTTON = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String DYNAMIC_SELECTED_PAGING_BUTTON = "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String DYNAMIC_SEARCH_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String LOAD_BUTTON = "css=button#load";
	public static final String LABEL_INDEX = "xpath=//table[@id='tblAppendGrid']/thead//th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_CELL_BY_LABEL_AND_ROW = "xpath=//table[@id='tblAppendGrid']/tbody/tr[%s]//td[%s]//input";
}
