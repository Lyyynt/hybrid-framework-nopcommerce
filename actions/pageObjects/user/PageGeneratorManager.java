package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminCustomerPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class PageGeneratorManager {
	WebDriver driver;
	
	static public UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	static public UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	static public UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	static public UserMyAccountObject getUserMyAccountPage(WebDriver driver) {
		return new UserMyAccountObject(driver);
	}
	
	static public UserAddProductReviewObject getUserAddProductReviewPage(WebDriver driver) {
		return new UserAddProductReviewObject(driver);
	}
	
	static public UserAddAddressesObject getUserAddAddressPage(WebDriver driver) {
		return new UserAddAddressesObject(driver);
	}
	
	static public UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}
	
	static public UserCustomerInformationPageObject getUserCustomerInformationPage(WebDriver driver) {
		return new UserCustomerInformationPageObject(driver);
	}
	
	static public UserMyProductReviewObject getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewObject(driver);
	}
	
	static public UserProductDetailObject getUserProductDetailPage(WebDriver driver) {
		return new UserProductDetailObject(driver);
	}
	
	static public UserSearchPageObject getUserSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}
	
	static public UserSearchResultObject getUserSearchResultPage(WebDriver driver) {
		return new UserSearchResultObject(driver);
	}
	
	static public AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	static public AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	
	static public AdminCustomerPageObject getAdminCustomerPage(WebDriver driver) {
		return new AdminCustomerPageObject(driver);
	}
	
}
