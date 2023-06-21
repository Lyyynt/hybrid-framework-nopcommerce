package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerConnUtils {
	public static Connection getSQLServerConnection() {
		String hostName = "localhost";
		String sqlInstanceName = "SQLExpress";
		String dbName = "automationtest";
		String userName = "sa";
		String password = "123456";
		return getSQLServerConnection(hostName,sqlInstanceName, dbName, userName, password);
	}
	private static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database, String userName, String password) {
		Connection conn = null;
		try {
			String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" + ";instance=" + sqlInstanceName + ";databaseName=" + database;
			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = SQLServerConnUtils.getSQLServerConnection();
		Statement statement = conn.createStatement();
		String sql = "select * from [automationtest].[dbo].[Product_Type];";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			int empFistName = rs.getInt(1);
			String empLastName = rs.getString("NAME");
			System.out.println("--------");
			System.out.println("Emp first name: " + empFistName);
			System.out.println("Emp last name: " + empLastName);
		}
		conn.close();
	}
	
}
