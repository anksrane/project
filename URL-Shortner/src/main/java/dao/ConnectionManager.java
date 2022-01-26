package dao;

import java.sql.*;

public class ConnectionManager {
	private String jdbcURL = "jdbc:mysql://localhost:3306/urlshortendb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	
	Connection connection = null;
	/*Create Connection*/
	
	public ConnectionManager() {
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}
	
	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return connection;
	}
	
	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
