package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Users;

public class UsersDAO {
	ConnectionManager connectionManager = new ConnectionManager();
	private static final String INSERT_USERS_SQL = "INSERT INTO users"
			+ "  (longUrlVisitor,shortUrlVisitor, ipAddress, visitedDate,visitedTime) VALUES " + "(?,?,?,?,?);";
	private static final String SELECT_ALL_VISITORS = "select * from users order by ipAddress;";
	
	// Insert Visitor into Visitor Table
	public void insertUser(Users newUser) {
		Connection connection = connectionManager.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, newUser.getLongUrlVisitor());
			preparedStatement.setString(2, newUser.getShortUrlVisitor());
			preparedStatement.setString(3, newUser.getIpAddress());
			preparedStatement.setString(4, newUser.getVisitedDate());
			preparedStatement.setString(5, newUser.getVisitedTime());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//List with Search
	public List<Users> selectAllUsers() {
		List<Users> users = new ArrayList<>();
		Connection connection = connectionManager.getConnection();
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(SELECT_ALL_VISITORS);
				ResultSet rs = preparedStatement.executeQuery();
				System.out.println(rs);
				while(rs.next()) {
					Users user=new Users();
					int id=rs.getInt("uid");
					String longUrlVisitor=rs.getString("longUrlVisitor");
					String shortUrlVisitor=rs.getString("shortUrlVisitor");
					String ipAddress=rs.getString("ipAddress");
					String visitedDate=rs.getString("visitedDate");
					String visitedTime=rs.getString("visitedTime");
					users.add(new Users(id,longUrlVisitor,shortUrlVisitor,ipAddress,visitedDate,visitedTime));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return users;
	}
}
