package pageObjects.liveguru.user;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePO getHomePage(WebDriver driver){
		return new HomePO(driver);
	}
	public static MyAccountPO getMyDashboardPage(WebDriver driver){
		return new MyAccountPO(driver);
	}
	public static RegisterPO getRegisterPage(WebDriver driver){
		return new RegisterPO(driver);
	}
	public static LoginPO getLoginPage(WebDriver driver){
		return new LoginPO(driver);
	}
	public static ProductListPO getProductListPage(WebDriver driver){
		return new ProductListPO(driver);
	}
	public static ShoppingCartPO getShoppingCartPage(WebDriver driver){
		return new ShoppingCartPO(driver);
	}
}
