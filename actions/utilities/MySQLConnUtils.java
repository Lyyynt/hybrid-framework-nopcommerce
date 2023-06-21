package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnUtils {
	public static Connection getMySQLConnection() {
		String hostName = "localhost";
		String dbName = "automationfc";
		String userName = "root";
		String password = "admin";
		return getMySQLConnection(hostName, dbName, userName, password);
	}
	private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) {
		Connection conn = null;
		try {
			// Thuc hien tim kiem driver
			Class.forName("com.mysql.jdbc.Driver");
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
			conn = DriverManager.getConnection(connectionURL, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = MySQLConnUtils.getMySQLConnection();
		Statement statement = conn.createStatement();
		String sql = "select Emp.Emp_Id, Emp.First_Name, Emp.Last_Name Emp.Dept_Id from Employee Emp;";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			int empId = rs.getInt(1);
			String empFistName = rs.getString(2);
			String empLastName = rs.getString("Last_Name");
			System.out.println("--------");
			System.out.println("Emp id: " + empId);
			System.out.println("Emp first name: " + empFistName);
			System.out.println("Emp last name: " + empLastName);
		}
		conn.close();
	}
	
}
