package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	WebDriver driver;
	
	static public HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	static public RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	static public LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	static public MyAccountObject getMyAccountPage(WebDriver driver) {
		return new MyAccountObject(driver);
	}
	
	static public AddProductReviewObject getAddProductReviewPage(WebDriver driver) {
		return new AddProductReviewObject(driver);
	}
	
	static public AddAddressesObject getAddAddressPage(WebDriver driver) {
		return new AddAddressesObject(driver);
	}
	
	static public ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	
	static public CustomerInformationPageObject getCustomerInformationPage(WebDriver driver) {
		return new CustomerInformationPageObject(driver);
	}
	
	static public MyProductReviewObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewObject(driver);
	}
	
	static public ProductDetailObject getProductDetailPage(WebDriver driver) {
		return new ProductDetailObject(driver);
	}
	
	static public SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}
	
	static public SearchResultObject getSearchResultPage(WebDriver driver) {
		return new SearchResultObject(driver);
	}
}
