package jquery;

public class HomePageUI {
	//handle data table
	public static final String DYNAMIC_PAGING_BUTTON = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String DYNAMIC_SELECTED_PAGING_BUTTON = "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String DYNAMIC_SEARCH_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String LOAD_BUTTON = "css=button#load";
	public static final String LABEL_INDEX = "xpath=//table[@id='tblAppendGrid']/thead//th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_CELL_BY_LABEL_AND_ROW = "xpath=//table[@id='tblAppendGrid']/tbody/tr[%s]//td[%s]//input";

	//handle upload mutiple files
	public static final String ADD_FILE_BUTTON = "css=input[type='file']";
	public static final String DYNAMIC_FILE_NAME_TEXT = "xpath=//table[@class='table table-striped']//tr//p[text()='%s']";
	public static final String DYNAMIC_START_UPLOAD_FILE_BUTTON = "xpath=//p[text()='%s']/parent::td/parent::tr//button[@class='btn btn-primary start']";
	public static final String DYNAMIC_FILE_NAME_UPLOADED_TEXT = "xpath=//a[text()='%s']";
	public static final String DYNAMIC_UPLOADED_FILE = "xpath=//img[contains(@src,'%s')]";
}
