package nomcommerce.admin;

public class AdminDashboardPageUI {
	public static final String DASHBOARD_HEADER = "xpath=//p[contains(text(),' Dashboard')]";
	public static final String DYNAMIC_LEFT_MENU_LINK_BY_LABEL = "xpath=//li[@class='nav-item has-treeview']/a//p[contains(text(),'%s')]/i";
	public static final String DYNAMIC_SELECTED_LEFT_MENU_LINK_BY_LABEL = "xpath=//li[@class='nav-item has-treeview menu-is-opening menu-open']/a//p[contains(text(),'%s')]";
	public static final String DYNAMIC_SUB_MENU_LINK_BY_LABEL = "xpath=//li[@class='nav-item has-treeview menu-is-opening menu-open']//ul[@class='nav nav-treeview']//p[contains(text(), 'Customers')]";
}
